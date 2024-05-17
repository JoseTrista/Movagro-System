/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.futuresoft.sistemamovagro_presentacion;

import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Movimiento;
import com.futuresoft.sistemamovagro_negocio.FachadaNegocio;
import com.futuresoft.sistemamovagro_negocio.INegocio;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IVAN
 */
public class FrmEditarEntrada extends javax.swing.JFrame {

    INegocio negocio;
    private List<Movimiento> listaMovimientos;

    public FrmEditarEntrada(List<Movimiento> movimientos) {
        negocio = new FachadaNegocio();
        initComponents();
        this.listaMovimientos = movimientos;
        actualizarTablaMovimientos(movimientos);
        tblMovimientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Configura selección única
    }

    private void actualizarTablaMovimientos(List<Movimiento> movimiento) {
        DefaultTableModel model = (DefaultTableModel) tblMovimientos.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Movimiento mov : movimiento) {
            model.addRow(new Object[]{
                mov.getId(),
                mov.getCantidad(),
                mov.getFecha(),
                mov.getMaterial(),
                mov.getTipoMovimiento()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnVolver1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Movagro.png"))); // NOI18N
        jLabel1.setText("     Editar Entradas");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cantidad", "Fecha", "Material", "Tipo Movimiento"
            }
        ));
        tblMovimientos.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblMovimientos);

        btnEditar.setBackground(new java.awt.Color(255, 255, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recargar2.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVolver1.setBackground(new java.awt.Color(0, 153, 204));
        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar-sesion (1).png"))); // NOI18N
        btnVolver1.setText("Volver");
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnVolver1))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        frmAdministrarEntradas adminEntradas = new frmAdministrarEntradas();
        adminEntradas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblMovimientos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una entrada para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int modelRow = tblMovimientos.convertRowIndexToModel(selectedRow);
            DefaultTableModel model = (DefaultTableModel) tblMovimientos.getModel();

            Movimiento selectedMovimiento = new Movimiento();
            selectedMovimiento.setId((Integer) model.getValueAt(modelRow, 0));
            selectedMovimiento.setCantidad((Integer) model.getValueAt(modelRow, 1));
            selectedMovimiento.setFecha((Date) model.getValueAt(modelRow, 2));
            selectedMovimiento.setMaterial((Material) model.getValueAt(modelRow, 3));
            selectedMovimiento.setTipoMovimiento((String) model.getValueAt(modelRow, 4));

            FrmEditarEntradaSeleccionada editarVentana = new FrmEditarEntradaSeleccionada(selectedMovimiento);
            editarVentana.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMovimientos;
    // End of variables declaration//GEN-END:variables
}
