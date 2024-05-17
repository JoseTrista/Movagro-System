/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.futuresoft.sistemamovagro_presentacion;

/**
 *
 * @author IVAN
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
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
        btnAdministrarEntradas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAdministrarCompra = new javax.swing.JButton();
        btnAdministrarMaterial1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdministrarEntradas.setBackground(new java.awt.Color(0, 153, 204));
        btnAdministrarEntradas.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAdministrarEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida.png"))); // NOI18N
        btnAdministrarEntradas.setText("    Administrar Entradas");
        btnAdministrarEntradas.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        btnAdministrarEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarEntradasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdministrarEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 260, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Movagro.png"))); // NOI18N
        jLabel1.setText("    MENU PRINCIPAL");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 460, 70));

        btnAdministrarCompra.setBackground(new java.awt.Color(0, 153, 204));
        btnAdministrarCompra.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAdministrarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrito-de-compras (2).png"))); // NOI18N
        btnAdministrarCompra.setText("Administrar Compra");
        btnAdministrarCompra.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        btnAdministrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdministrarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 240, -1));

        btnAdministrarMaterial1.setBackground(new java.awt.Color(0, 153, 204));
        btnAdministrarMaterial1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAdministrarMaterial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/materiales-de-construccion.png"))); // NOI18N
        btnAdministrarMaterial1.setText("Administrar Material");
        btnAdministrarMaterial1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        btnAdministrarMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarMaterial1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdministrarMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarCompraActionPerformed
        FrmAdministrarCompras adminCompras = new FrmAdministrarCompras();
        adminCompras.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarCompraActionPerformed

    private void btnAdministrarMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarMaterial1ActionPerformed
        FrmAdministrarMaterial adminMat = new FrmAdministrarMaterial();
        adminMat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarMaterial1ActionPerformed

    private void btnAdministrarEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarEntradasActionPerformed
        frmAdministrarEntradas adminEntradas = new frmAdministrarEntradas();
        adminEntradas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarEntradasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarCompra;
    private javax.swing.JButton btnAdministrarEntradas;
    private javax.swing.JButton btnAdministrarMaterial1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
