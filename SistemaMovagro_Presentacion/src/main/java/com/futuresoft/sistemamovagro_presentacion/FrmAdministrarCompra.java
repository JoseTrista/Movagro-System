/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.futuresoft.sistemamovagro_presentacion;

import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.DetalleCompra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import com.futuresoft.sistemamovagro_dominio.Secretaria;
import com.futuresoft.sistemamovagro_negocio.FachadaNegocio;
import com.futuresoft.sistemamovagro_negocio.INegocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jctri
 */
public class FrmAdministrarCompra extends javax.swing.JFrame {

    INegocio negocio;
    private List<Proveedor> listaProveedores;

    /**
     * Creates new form FrmAdministrarCompra
     *
     * @param proveedor
     */
    public FrmAdministrarCompra(List<Proveedor> proveedor) {
        negocio = new FachadaNegocio();
        initComponents();
        this.listaProveedores = proveedor;
        despliegaDatosRecuperados(proveedor);
        despliegaDatosMaterial();
        cbProovedor1.setEnabled(true);
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
        String unidadMedida = txtUnidadMedida.getText();
        modelo.addRow(new Object[]{material, proveedor, costo, ejemplares, unidadMedida});
    }

    public void limpiarTabla() {
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

    public void eliminarFilaSeleccionada() {
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
        int filaSeleccionada = tblDetalleCompra.getSelectedRow();

        // Verifica si hay una fila seleccionada
        if (filaSeleccionada >= 0) {
            // Elimina la fila seleccionada
            modelo.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }

    public void editarFilaSeleccionada() {
        int filaSeleccionada = tblDetalleCompra.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtén los valores actuales de la fila seleccionada para editarlos
            DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
            String material = modelo.getValueAt(filaSeleccionada, 0).toString();
            String proveedor = modelo.getValueAt(filaSeleccionada, 1).toString();
            Float precio = Float.valueOf(modelo.getValueAt(filaSeleccionada, 2).toString());
            int cantidad = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 3).toString());
            String unidadMedida = modelo.getValueAt(filaSeleccionada, 4).toString();
            // Repite para otras columnas según necesites

            // Muestra un diálogo para editar. Este es solo un ejemplo simple.
            String nuevoMaterial = JOptionPane.showInputDialog(null, "Editar Material:", material);
            String nuevoPrecio = JOptionPane.showInputDialog(null, "Editar Precio:", precio);
            String nuevaCantidad = JOptionPane.showInputDialog(null, "Editar Cantidad:", cantidad);
            String nuevaUnidadMedida = JOptionPane.showInputDialog(null,"Editar Unidad de Medida:", unidadMedida);
            // Repite para otras columnas según necesites

            // Actualiza la tabla con los nuevos valores
            modelo.setValueAt(nuevoMaterial, filaSeleccionada, 0);
            modelo.setValueAt(proveedor, filaSeleccionada, 1);
            modelo.setValueAt(nuevoPrecio, filaSeleccionada, 2);
            modelo.setValueAt(nuevaCantidad, filaSeleccionada, 3);
            modelo.setValueAt(nuevaUnidadMedida, filaSeleccionada, 4);
            // Repite para otras columnas según necesites
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

        jPanel2.add(cbMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 410, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Proveedor");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText(" Material");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 410, -1));

        lblUnidadMedida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUnidadMedida.setText("Unidad de Medida");
        jPanel2.add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 410, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 418, -1));

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 600, 110));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 73, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 490, 80, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 93, -1));

        btnPDF.setText("PDF");
        jPanel2.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 78, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 89, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setText("Registrar Compra");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        cbProovedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProovedor1ActionPerformed(evt);
            }
        });
        jPanel2.add(cbProovedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 418, -1));
        jPanel2.add(txtUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 410, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Costo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmMenuPrincipal principal = new FrmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (tblDetalleCompra.getModel().getRowCount() > 0) {
                agregar();
                JOptionPane.showMessageDialog(null, "Compra Guardada");
                limpiarTabla();
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
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarFilaSeleccionada();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarFilaSeleccionada();
    }//GEN-LAST:event_btnEditarActionPerformed


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
