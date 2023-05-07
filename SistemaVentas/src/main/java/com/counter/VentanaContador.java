/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.counter;

import com.librery.Animacion;
import com.main.Login;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.admin.CambiaPanel;
public class VentanaContador extends javax.swing.JFrame {

    int x, y;
    /**
     * Creates new form Principal
     */
    
    public VentanaContador() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        this.btnHome.setSelected(true);
        new CambiaPanel(pnlPrincipal, new pnlHomeContador());
        setVisible(true);
        desactivarBotonesIniciar();
    }

    public void desactivarBotonesIniciar() {
        this.btnGrafica.setColorNormal(new Color(239, 238, 244));
        this.btnGrafica.setColorHover(new Color(204, 204, 204));
        this.btnGrafica.setColorPressed(new Color(204, 204, 204));

        this.btnCerrarSesion.setColorNormal(new Color(239, 238, 244));
        this.btnCerrarSesion.setColorHover(new Color(204, 204, 204));
        this.btnCerrarSesion.setColorPressed(new Color(204, 204, 204));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        btnGrafica = new com.librery.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        btnHome = new com.librery.RSButtonMetro();
        btnCerrarSesion = new com.librery.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlMenu.setBackground(new java.awt.Color(239, 238, 244));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(239, 238, 244)));

        btnGrafica.setForeground(new java.awt.Color(128, 128, 131));
        btnGrafica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosContador/ventas.png"))); // NOI18N
        btnGrafica.setText("Historial Financiero");
        btnGrafica.setColorHover(new java.awt.Color(204, 204, 204));
        btnGrafica.setColorNormal(new java.awt.Color(204, 204, 204));
        btnGrafica.setColorPressed(new java.awt.Color(204, 204, 204));
        btnGrafica.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnGrafica.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnGrafica.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnGrafica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGrafica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGrafica.setIconTextGap(25);
        btnGrafica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGraficaMousePressed(evt);
            }
        });
        btnGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(239, 238, 244));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        btnHome.setForeground(new java.awt.Color(128, 128, 131));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setColorHover(new java.awt.Color(204, 204, 204));
        btnHome.setColorNormal(new java.awt.Color(204, 204, 204));
        btnHome.setColorPressed(new java.awt.Color(204, 204, 204));
        btnHome.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnHome.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnHome.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHome.setIconTextGap(25);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(239, 238, 244));
        btnCerrarSesion.setForeground(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setColorHover(new java.awt.Color(204, 204, 204));
        btnCerrarSesion.setColorNormal(new java.awt.Color(239, 238, 244));
        btnCerrarSesion.setColorPressed(new java.awt.Color(204, 204, 204));
        btnCerrarSesion.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCerrarSesion.setIconTextGap(19);
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMousePressed(evt);
            }
        });
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 8.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(pnlMenu, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(825, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnlCentro.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlPrincipal);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnlCentro, gridBagConstraints);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaActionPerformed
        try
        {
            new CambiaPanel(pnlPrincipal, new pnlGrafica());
            if(this.btnGrafica.isSelected()){
                this.btnGrafica.setColorNormal(new Color(204,204,204));
                this.btnGrafica.setColorHover(new Color(204,204,204));
                this.btnGrafica.setColorPressed(new Color(204,204,204));

                this.btnHome.setColorNormal(new Color(239,238,244));
                this.btnHome.setColorHover(new Color(204,204,204));
                this.btnHome.setColorPressed(new Color(204,204,204));
            
                this.btnCerrarSesion.setColorNormal(new Color(239,238,244));
                this.btnCerrarSesion.setColorHover(new Color(204,204,204));
                this.btnCerrarSesion.setColorPressed(new Color(204,204,204));
            }else{
                this.btnGrafica.setColorNormal(new Color(239,238,244));
                this.btnGrafica.setColorHover(new Color(204,204,204));
                this.btnGrafica.setColorPressed(new Color(204,204,204));
            }
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnGraficaActionPerformed

    private void btnGraficaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficaMousePressed
        try
        {
            this.btnGrafica.setSelected(true);
            this.btnHome.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnGraficaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            int posicion = pnlMenu.getX();
            if(posicion > -1){
                Animacion.mover_izquierda(0, -264, 2, 2, pnlMenu);
            }else{
                Animacion.mover_derecha(-264, 0, 2, 2, pnlMenu);
            }
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        try
        {
            if(this.btnCerrarSesion.isSelected()){
                this.btnGrafica.setColorNormal(new Color(239,238,244));
                this.btnGrafica.setColorHover(new Color(204,204,204));
                this.btnGrafica.setColorPressed(new Color(204,204,204));
                
                this.btnHome.setColorNormal(new Color(239,238,244));
                this.btnHome.setColorHover(new Color(204,204,204));
                this.btnHome.setColorPressed(new Color(204,204,204));
            
                this.btnCerrarSesion.setColorNormal(new Color(204,204,204));
                this.btnCerrarSesion.setColorHover(new Color(204,204,204));
                this.btnCerrarSesion.setColorPressed(new Color(204,204,204));
           
            }else{
                this.btnCerrarSesion.setColorNormal(new Color(239,238,244));
                this.btnCerrarSesion.setColorHover(new Color(204,204,204));
                this.btnCerrarSesion.setColorPressed(new Color(204,204,204));
            }
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCerrarSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMousePressed
        try
        {
            this.btnCerrarSesion.setSelected(true);
            this.btnHome.setSelected(false);
            this.btnGrafica.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnCerrarSesionMousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed
        try
        {
            this.btnHome.setSelected(true);
            this.btnGrafica.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnHomeMousePressed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        try
        {
            if(this.btnHome.isSelected()){
                this.btnHome.setColorNormal(new Color(204,204,204));
                this.btnHome.setColorHover(new Color(204,204,204));
                this.btnHome.setColorPressed(new Color(204,204,204));
            
                this.btnGrafica.setColorNormal(new Color(239,238,244));
                this.btnGrafica.setColorHover(new Color(204,204,204));
                this.btnGrafica.setColorPressed(new Color(204,204,204));
            
                this.btnCerrarSesion.setColorNormal(new Color(239,238,244));
                this.btnCerrarSesion.setColorHover(new Color(204,204,204));
                this.btnCerrarSesion.setColorPressed(new Color(204,204,204));
            }else{
                this.btnHome.setColorNormal(new Color(239,238,244));
                this.btnHome.setColorHover(new Color(204,204,204));
                this.btnHome.setColorPressed(new Color(204,204,204));
            }
            new CambiaPanel(pnlPrincipal, new pnlHomeContador());
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new VentanaContador().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(VentanaContador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.librery.RSButtonMetro btnCerrarSesion;
    private com.librery.RSButtonMetro btnGrafica;
    private com.librery.RSButtonMetro btnHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
