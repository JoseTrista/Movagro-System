/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.futuresoft.sistemamovagro_presentacion;

import PDF.PdfReporte;
import PDF.reporte;
import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.DetalleCompra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import com.futuresoft.sistemamovagro_dominio.Secretaria;
import com.futuresoft.sistemamovagro_negocio.FachadaNegocio;
import com.futuresoft.sistemamovagro_negocio.INegocio;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jctri
 */
public class FrmRegistrarCompra extends javax.swing.JFrame {

    INegocio negocio;
    private List<Proveedor> listaProveedores;
    private List<reporte> pdf;

    /**
     * Creates new form FrmAdministrarCompra
     *
     * @param proveedor
     */
    public FrmRegistrarCompra(List<Proveedor> proveedor) {
        negocio = new FachadaNegocio();
        initComponents();
        this.listaProveedores = proveedor;
        despliegaDatosRecuperados(proveedor);
        despliegaDatosMaterial();
        cbProovedor1.setEnabled(true);
        pdf = new ArrayList<>();
    }

    /**
     * Método que valida de manera que solo permite letras y espacio
     *
     * @param evento evt
     */
    public void validarMarca(java.awt.event.KeyEvent evento) {
        if (evento.getKeyChar() >= 33 && evento.getKeyChar() <= 64
                || evento.getKeyChar() >= 91 && evento.getKeyChar() <= 96
                || evento.getKeyChar() >= 123 && evento.getKeyChar() <= 127) {

            evento.consume();
        }
    }

    public void despliegaDatosRecuperados(List<Proveedor> proveedor) {
        System.out.println(proveedor);
        for (Proveedor p : proveedor) {

            cbProovedor1.addItem(p);
        }
    }

    public void despliegaDatosMaterial() {
        cbMaterial.removeAllItems();
        Proveedor proveedor = (Proveedor) cbProovedor1.getSelectedItem();
        List<Material> materiales = proveedor.getMateriales();
        for (Material m : materiales) {

            cbMaterial.addItem(m);
        }
    }

    public Proveedor obtenerProveedorPorNombre(String nombreProveedor) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getNombre().equals(nombreProveedor)) {
                return proveedor;
            }
        }
        return null;
    }

    public void llenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
        String proveedor = cbProovedor1.getSelectedItem().toString();
        String material = cbMaterial.getSelectedItem().toString();
        String costo = txtCosto.getText();
        String ejemplares = txtCantidad.getText();
        String unidadmedida = txtUnidadMedida.getText();

        // Crear un nuevo objeto reporte y establecer sus atributos
        reporte r = new reporte();
        r.setEjemplares(ejemplares);
        r.setMaterial(material);
        r.setMedida(unidadmedida);
        r.setPrecio(costo);
        r.setProveedor(proveedor);

        // Agregar el objeto reporte a la lista pdf
        pdf.add(r);

        // Agregar una nueva fila a la tabla con los datos del objeto reporte
        modelo.addRow(new Object[]{r.getMaterial(), r.getProveedor(), r.getPrecio(), r.getEjemplares(), r.getMedida()});
    }

    public void limpiarTabla() {
        pdf = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();

        modelo.setRowCount(0);
    }

    public void agregar() {
        Proveedor proveedor = (Proveedor) cbProovedor1.getSelectedItem();
        Secretaria secretaria = negocio.recuperaSecretaria();
        Compra compra = new Compra();

        LocalDate fechaLocal = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(fechaLocal);

        compra.setFecha(sqlDate);
        compra.setSecretaria(secretaria);
        compra.setProveedor(proveedor);
        compra.setEstado("Activa");
        List<DetalleCompra> detallesCompra = obtenerDetallesCompraDesdeTabla(tblDetalleCompra, compra);
        compra.setDetalleCompra(detallesCompra);

        // Calcular el costo total de la compra
        float costoTotal = 0.0f;
        for (DetalleCompra detalle : detallesCompra) {
            costoTotal += detalle.getCostoUnitario() * detalle.getCantidad();
        }
        compra.setCosto(costoTotal);

        negocio.guardarCompra(compra);
    }

    public List<DetalleCompra> obtenerDetallesCompraDesdeTabla(JTable tblDetalleCompra, Compra compra) {
        List<DetalleCompra> detallesCompra = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                String nombrematerial = modelo.getValueAt(i, 0).toString();
                float costoUnitario = Float.parseFloat(modelo.getValueAt(i, 2).toString());
                int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
                String unidadMedida = modelo.getValueAt(i, 4).toString();

                Material material = buscarMaterialPorNombre(nombrematerial);

                DetalleCompra detalleCompra = new DetalleCompra(costoUnitario, (short) cantidad, unidadMedida, material);
                detalleCompra.setCompra(compra);
                detallesCompra.add(detalleCompra);
            } catch (NumberFormatException e) {

                System.out.println("Error al convertir los datos: " + e.getMessage());
            }
        }

        return detallesCompra;
    }

    public void eliminarFilasSeleccionadas() {
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
        int[] filasSeleccionadas = tblDetalleCompra.getSelectedRows();

        if (filasSeleccionadas.length > 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el detalle de compra seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                    int filaSeleccionada = filasSeleccionadas[i];
                    reporte detalleCompra = pdf.get(filaSeleccionada);
                    detalleCompra.setEliminado(true); // Marcar el detalle de compra como eliminado

                    modelo.removeRow(filaSeleccionada);
                }
                JOptionPane.showMessageDialog(null, "El detalle de compra ha sido eliminado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una o más filas para eliminar.");
        }
    }

    public void editarFilaSeleccionada() {
        int filaSeleccionada = tblDetalleCompra.getSelectedRow();
        if (filaSeleccionada >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
            Float precio = Float.valueOf(modelo.getValueAt(filaSeleccionada, 2).toString());
            int cantidad = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 3).toString());
            String unidadMedida = modelo.getValueAt(filaSeleccionada, 4).toString();

            String nuevoPrecio = JOptionPane.showInputDialog(null, "Editar Precio:", precio);
            if (nuevoPrecio != null && !nuevoPrecio.isEmpty()) {
                String nuevaCantidad = JOptionPane.showInputDialog(null, "Editar Cantidad:", cantidad);
                if (nuevaCantidad != null && !nuevaCantidad.isEmpty()) {
                    String nuevaUnidadMedida = JOptionPane.showInputDialog(null, "Editar Unidad de Medida:", unidadMedida);
                    if (nuevaUnidadMedida != null && !nuevaUnidadMedida.isEmpty()) {
                        // Actualiza la tabla con los nuevos valores
                        modelo.setValueAt(Float.parseFloat(nuevoPrecio), filaSeleccionada, 2);
                        modelo.setValueAt(Integer.parseInt(nuevaCantidad), filaSeleccionada, 3);
                        modelo.setValueAt(nuevaUnidadMedida, filaSeleccionada, 4);
                    } else {
                        JOptionPane.showMessageDialog(null, "La Unidad de Medida no puede estar vacía.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La Cantidad no puede estar vacía.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Precio no puede estar vacío.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.");
        }
    }

    private Material buscarMaterialPorNombre(String nombre) {
        Proveedor proveedor = (Proveedor) cbProovedor1.getSelectedItem();
        List<Material> listaMateriales = proveedor.getMateriales();
        for (Material material : listaMateriales) {
            if (material.getNombre().equals(nombre)) {
                return material;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cbMaterial = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblUnidadMedida = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCompra = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbProovedor1 = new javax.swing.JComboBox<>();
        txtUnidadMedida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaterialActionPerformed(evt);
            }
        });
        jPanel2.add(cbMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 410, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Proveedor");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText(" Material");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 410, -1));

        lblUnidadMedida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUnidadMedida.setText("Unidad de Medida");
        jPanel2.add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 410, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 153, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrar2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 110, 40));

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material", "Proveedor", "Precio", "Ejemplares", "Unidad_de_Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetalleCompra);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 520, 110));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/basura2.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 100, -1));

        btnEditar.setBackground(new java.awt.Color(255, 255, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recargar2.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 100, -1));

        btnVolver.setBackground(new java.awt.Color(0, 153, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 80, -1));

        btnLimpiar.setBackground(new java.awt.Color(0, 153, 204));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 93, -1));

        btnPDF.setBackground(new java.awt.Color(0, 153, 204));
        btnPDF.setText("PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        jPanel2.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 78, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 153, 204));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 89, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Movagro.png"))); // NOI18N
        jLabel1.setText("         Registrar Compra");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 540, -1));

        cbProovedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProovedor1ActionPerformed(evt);
            }
        });
        jPanel2.add(cbProovedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 418, -1));

        txtUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadMedidaActionPerformed(evt);
            }
        });
        txtUnidadMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidadMedidaKeyTyped(evt);
            }
        });
        jPanel2.add(txtUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 410, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Costo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmAdministrarCompras principal = new FrmAdministrarCompras();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (tblDetalleCompra.getModel().getRowCount() > 0) {
                agregar();
                JOptionPane.showMessageDialog(null, "Compra Guardada");
                limpiarTabla();
                cbProovedor1.setEnabled(true);

                cbMaterial.setSelectedIndex(0);
                txtCantidad.setText("");
                txtCosto.setText("");
                txtUnidadMedida.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No hay detalles de compra para guardar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la compra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9')) {
            evt.consume();
        }

        if (txtCosto.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9')) {
            evt.consume();
        }

        if (txtCantidad.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void cbProovedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProovedor1ActionPerformed
        despliegaDatosMaterial();
        cbProovedor1.setEnabled(false);

    }//GEN-LAST:event_cbProovedor1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbProovedor1.setSelectedIndex(0);
        cbProovedor1.setEnabled(true);
        cbMaterial.setSelectedIndex(0);
        txtCantidad.setText("");
        txtCosto.setText("");
        txtUnidadMedida.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtCantidad.getText().isEmpty() || txtCosto.getText().isEmpty() || txtUnidadMedida.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        } else {
            this.llenarTabla();
            cbProovedor1.setEnabled(false);
            txtCantidad.setText("");
            txtCosto.setText("");
            txtUnidadMedida.setText("");

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarFilasSeleccionadas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarFilaSeleccionada();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        try {
            // Verificar si la tabla de detalle de compra está vacía
            if (tblDetalleCompra.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "La tabla de detalle de compra está vacía. No se puede generar el informe PDF.");
                return; // Salir del método
            }

            // Filtrar los detalles de compra eliminados y editados
            List<PdfReporte> detallesCompraFiltrados = new ArrayList<>();
            DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String material = modelo.getValueAt(i, 0).toString();
                String proveedor = modelo.getValueAt(i, 1).toString();
                String precio = modelo.getValueAt(i, 2).toString();
                String ejemplares = modelo.getValueAt(i, 3).toString();
                String unidadMedida = modelo.getValueAt(i, 4).toString();
                PdfReporte detalleCompra = new PdfReporte(material, proveedor, precio, ejemplares, unidadMedida);
                detallesCompraFiltrados.add(detalleCompra);
            }

            Map<String, Object> parametro = new HashMap<>();

            // Cargar los datos filtrados en un JRBeanCollectionDataSource
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(detallesCompraFiltrados);

            // Cargar el archivo JRXML del reporte
            InputStream reportFile = getClass().getResourceAsStream("/ReportePdf.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);

            // Llenar el reporte con los datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, beanColDataSource);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(FrmRegistrarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnPDFActionPerformed

    private void txtUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadMedidaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtUnidadMedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadMedidaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }

        // Verificar la longitud del texto ingresado
        if (txtUnidadMedida.getText().length() == 10) {
            evt.consume();
        }


    }//GEN-LAST:event_txtUnidadMedidaKeyTyped

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void cbMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaterialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<Material> cbMaterial;
    private javax.swing.JComboBox<Proveedor> cbProovedor1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JTable tblDetalleCompra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
