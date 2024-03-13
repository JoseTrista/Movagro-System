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
import com.futuresoft.sistemamovagro_negocio.ControlCompra;
import com.futuresoft.sistemamovagro_negocio.FachadaNegocio;
import com.futuresoft.sistemamovagro_negocio.INegocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    }

//    public FrmAdministrarCompra() {
//        initComponents();
//    }
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
        // Iterar sobre la lista de proveedores y devolver el que coincida con el nombre
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getNombre().equals(nombreProveedor)) {
                return proveedor;
            }
        }
        return null; // Si no se encuentra el proveedor con el nombre dado
    }

    public List<Material> obtenerMaterialesPorProveedor(Proveedor proveedor) {
        // Obtener la lista de materiales asociados al proveedor
        // Supongamos que hay un método en Proveedor para obtener los materiales asociados
        return proveedor.getMateriales();
    }

    public void llenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
        String material = cbMaterial.getSelectedItem().toString();
        String costo = txtCosto.getText();
        String ejemplares = txtCantidad.getText();
        modelo.addRow(new Object[]{material, costo, ejemplares});
    }

    public void agregar() {
        //secretaria de prueba (falta ver como hacemos lo de secretaria xd)
        Proveedor proveedor = (Proveedor) cbProovedor1.getSelectedItem();
        Secretaria secretaria = negocio.recuperaSecretaria();
        Compra compra = new Compra();
        
        LocalDate fechaLocal = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(fechaLocal);


        compra.setFecha(sqlDate);
        compra.setCondicion("Pendiente");
        compra.setCosto(txtCosto.getText());
        compra.setSecretaria(secretaria);
        compra.setProveedor(proveedor);
        compra.setDetalleCompra(obtenerDetallesCompraDesdeTabla(tblDetalleCompra, compra));

        negocio.guardarCompra(compra);
    }

    public List<DetalleCompra> obtenerDetallesCompraDesdeTabla(JTable tblDetalleCompra,Compra compra) {
        List<DetalleCompra> detallesCompra = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                String nombrematerial = modelo.getValueAt(i, 0).toString();
                float costoUnitario = Float.parseFloat(modelo.getValueAt(i, 1).toString());
                int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());

                Material material = buscarMaterialPorNombre(nombrematerial);

                DetalleCompra detalleCompra = new DetalleCompra(costoUnitario, (short) cantidad, material);
                detalleCompra.setCompra(compra);
                detallesCompra.add(detalleCompra);
            } catch (NumberFormatException e) {
                
                System.out.println("Error al convertir los datos: " + e.getMessage());
            }
        }
        
        return detallesCompra;
    }
    
    private Material buscarMaterialPorNombre(String nombre) {
        Proveedor proveedor = (Proveedor) cbProovedor1.getSelectedItem();
        List <Material> listaMateriales = proveedor.getMateriales();
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
        jLabel5 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaterialActionPerformed(evt);
            }
        });
        jPanel2.add(cbMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 410, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Proveedor");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 104, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText(" Material");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 206, -1, -1));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 204, 418, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Costo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 255, -1, -1));

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 253, 418, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 293, 418, -1));

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material", "Precio", "Ejemplares"
            }
        ));
        jScrollPane1.setViewportView(tblDetalleCompra);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 334, -1, 110));

        btnEliminar.setText("Eliminar");
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 339, -1, -1));

        btnEditar.setText("Editar");
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 368, 73, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 87, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 93, -1));

        btnPDF.setText("PDF");
        jPanel2.add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 78, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 89, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setText("Administrar Compra");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        cbProovedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProovedor1ActionPerformed(evt);
            }
        });
        jPanel2.add(cbProovedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 102, 418, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmMenuPrincipal principal = new FrmMenuPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        agregar();
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

    private void cbMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaterialActionPerformed

    private void cbProovedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProovedor1ActionPerformed
        despliegaDatosMaterial();
    }//GEN-LAST:event_cbProovedor1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbProovedor1.setSelectedIndex(0);
        cbMaterial.setSelectedIndex(0);
        txtCantidad.setText("");
        txtCosto.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        this.llenarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmAdministrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmAdministrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmAdministrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmAdministrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmAdministrarCompra().setVisible(true);
//            }
//        });
//    }

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalleCompra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCosto;
    // End of variables declaration//GEN-END:variables
}
