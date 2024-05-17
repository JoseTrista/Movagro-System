/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.futuresoft.sistemamovagro_presentacion;

import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.DetalleCompra;
import com.futuresoft.sistemamovagro_negocio.FachadaNegocio;
import com.futuresoft.sistemamovagro_negocio.INegocio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Equipo Movagro
 */
public class FrmEditarCompra extends javax.swing.JFrame {
    INegocio negocio;
    private List<Compra> listaCompra;
    private List<DetalleCompra> detalleCompra;
    /**
     * Creates new form FrmEditarCompra
     */
    public FrmEditarCompra(List<Compra> compra) {
        negocio = new FachadaNegocio();
        initComponents();
        this.listaCompra = compra;
        this.detalleCompra = new ArrayList<>();
        despliegaDatosRecuperados(compra);
        // Añadir ActionListener al comboBox
        cbCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComprasActionPerformed(evt);
            }
        });
    }
    
    public void despliegaDatosRecuperados(List<Compra> compra) {
        System.out.println(compra);
        for (Compra p : compra) {

            cbCompras.addItem(p);
        }
    }
    
    public void editarFilaSeleccionada() {
        int filaSeleccionada = tblDetalleCompra.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtén los valores actuales de la fila seleccionada para editarlos
            DefaultTableModel modelo = (DefaultTableModel) tblDetalleCompra.getModel();
            int id = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
//            String material = modelo.getValueAt(filaSeleccionada, 1).toString();
//            String proveedor = modelo.getValueAt(filaSeleccionada, 2).toString();
            Float precio = Float.valueOf(modelo.getValueAt(filaSeleccionada, 3).toString());
            int cantidad = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 4).toString());
            String unidadMedida = modelo.getValueAt(filaSeleccionada, 5).toString();
            // Repite para otras columnas según necesites

            // Muestra un diálogo para editar. Este es solo un ejemplo simple.
            String nuevoPrecio = JOptionPane.showInputDialog(null, "Editar Precio:", precio);
            String nuevaCantidad = JOptionPane.showInputDialog(null, "Editar Cantidad:", cantidad);
            String nuevaUnidadMedida = JOptionPane.showInputDialog(null,"Editar Unidad de Medida:", unidadMedida);
            // Repite para otras columnas según necesites

            for (DetalleCompra detalleCompra1 : detalleCompra) {
                if(detalleCompra1.getId() == id){
                    detalleCompra1.setCantidad(Short.parseShort(nuevaCantidad));
                    detalleCompra1.setCostoUnitario(Float.parseFloat(nuevoPrecio));
                    detalleCompra1.setUnidadMedida(nuevaUnidadMedida);
                }
            } 
            // Actualiza la tabla con los nuevos valores
            Compra compra = (Compra) cbCompras.getSelectedItem();
            compra.setDetalleCompra(detalleCompra);
            // Repite para otras columnas según necesites
            
            negocio.editarCompra(compra);
            actualizarTablaDetalles(detalleCompra);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.");
        }
    }
    
    private void actualizarTablaDetalles(List<DetalleCompra> detalles) {
        DefaultTableModel model = (DefaultTableModel) tblDetalleCompra.getModel();
        detalleCompra = detalles;
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevas filas

        for (DetalleCompra detalle : detalles) {
            Object[] fila = new Object[]{
                detalle.getId(),
                detalle.getMaterial().getNombre(),
                detalle.getMaterial().getProveedor().getNombre(),
                detalle.getCostoUnitario(),
                detalle.getCantidad(),
                detalle.getMaterial().getUnidadMedida()
            };
            model.addRow(fila);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cbCompras = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCompra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Movagro.png"))); // NOI18N
        jLabel1.setText("       Editar Compra");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));

        btnEditar.setBackground(new java.awt.Color(255, 255, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recargar2.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(0, 153, 204));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar-sesion (1).png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cbCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComprasActionPerformed(evt);
            }
        });

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Material", "Proveedor", "Precio", "Ejemplares", "Unidad_de_Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetalleCompra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(cbCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarFilaSeleccionada();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmAdministrarCompras principal = new FrmAdministrarCompras();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComprasActionPerformed
        Compra compraSeleccionada = (Compra) cbCompras.getSelectedItem();
        if (compraSeleccionada != null) {
            List<DetalleCompra> detalles = negocio.recuperaDetalleCompra(compraSeleccionada.getId());
            actualizarTablaDetalles(detalles);
        }
    }//GEN-LAST:event_cbComprasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<Compra> cbCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalleCompra;
    // End of variables declaration//GEN-END:variables
}
