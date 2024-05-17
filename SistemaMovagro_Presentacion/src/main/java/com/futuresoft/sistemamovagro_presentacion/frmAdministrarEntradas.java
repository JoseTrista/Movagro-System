/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.futuresoft.sistemamovagro_presentacion;

import static com.futuresoft.sistemamovagro_dominio.DetalleCompra_.material;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Movimiento;
import com.futuresoft.sistemamovagro_negocio.FachadaNegocio;
import com.futuresoft.sistemamovagro_negocio.INegocio;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class frmAdministrarEntradas extends javax.swing.JFrame {

       INegocio negocio;
    public frmAdministrarEntradas() {
        initComponents();
        negocio = new FachadaNegocio();
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
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(0, 153, 204));
        btnRegistrar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar Entradas");
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 240, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setText("Administrar Entradas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnConsultar.setBackground(new java.awt.Color(0, 153, 204));
        btnConsultar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar Entradas");
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultarMouseExited(evt);
            }
        });
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 240, -1));

        btnEditar.setBackground(new java.awt.Color(0, 153, 204));
        btnEditar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar Entradas");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, -1));

        btnVolver.setBackground(new java.awt.Color(0, 153, 204));
        btnVolver.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        // btnRegistrar.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        //    btnRegistrar.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        List<Material> materialesC = negocio.recuperaMaterial();
        FrmRegistrarEntradas frmAdministrar = new FrmRegistrarEntradas(materialesC);
        frmAdministrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseEntered
        //    btnConsultar.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnConsultarMouseEntered

    private void btnConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseExited
        //   btnConsultar.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnConsultarMouseExited

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
           List<Movimiento> listaM=negocio.consultarMovimientos();
        FrmConsultarEntradas consultarE = new FrmConsultarEntradas(listaM);
        consultarE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        //    btnEditar.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        //   btnEditar.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_btnEditarMouseExited

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       List<Movimiento> listaM=negocio.consultarMovimientos();
        FrmEditarEntrada consultarE = new FrmEditarEntrada(listaM);
        consultarE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
