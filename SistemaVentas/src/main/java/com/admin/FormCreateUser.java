package com.admin;

import com.classes.Roles;
import com.settings.CodigoColor;
import com.settings.Configuracion;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class FormCreateUser extends javax.swing.JDialog {

    public FormCreateUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configuracion();
        this.agregarEstilos();
    }

    private void agregarEstilos() {
        try {
            //configuracion ventana
            this.setMinimumSize(new Dimension(350, 330));
            Configuracion.styles(this);

            //configuracion jPanel
            Configuracion.background(CodigoColor.cFondoGris, this.panel);

            //Configuracion JLabels
            Configuracion.robotoItalic14(this.jlTitle);
            Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jlTitle);
            Configuracion.robotoItalic14(this.jlIndication, this.jlConfirm, this.jlPassword, this.jlRol,
                    this.jlUser, this.jlId);
            Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlIndication, this.jlConfirm, this.jlPassword, this.jlRol,
                    this.jlUser, this.jlId);

            //Configuraciion JTextField 
            Configuracion.robotoPlain12(this.tfConfirm, this.tfPassword, this.tfUser, this.tfId);
            Configuracion.withoutBorde(this.tfConfirm, this.tfPassword, this.tfUser, this.tfId);
            Configuracion.background(CodigoColor.cFondoGris, this.tfConfirm, this.tfPassword, this.tfUser, this.tfId);

            //Configuracion JCheckBox
            Configuracion.robotoItalic14(this.cbSendEmail);
            Configuracion.withoutBorde(this.cbSendEmail);
            Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbSendEmail);
            Configuracion.background(CodigoColor.cFondoGris, this.cbSendEmail);

            //Configuracion jComboBox
            Configuracion.robotoItalic14(this.cbRol);

            //Configuracion JButton
            Configuracion.robotoItalic14(this.btnCancel, this.btnAcept);
            Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCancel, this.btnAcept);
            Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCancel, this.btnAcept);

            //Configuracion JSeparator 
            Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea2, this.linea3, this.linea4, this.linea5);
            Configuracion.background(CodigoColor.cFondoGris, this.linea2, this.linea3, this.linea4, this.linea5);

        } catch (Exception ex) {

        }
    }

    private void configuracion() {
        modeloComboBox();
        checkBoxItemListened();
    }

    private void modeloComboBox() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement(Roles.administrador);
        dcbm.addElement(Roles.cajero);
        dcbm.addElement(Roles.contador);
        this.cbRol.setModel(dcbm);
        this.cbRol.getEditor().getEditorComponent().setForeground(CodigoColor.cLetrasNegro); 
        this.cbRol.getEditor().getEditorComponent().setBackground(CodigoColor.cFondoGris); 
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbRol);
        Configuracion.background(CodigoColor.cFondoGris, this.cbRol);
    }

    private void checkBoxItemListened() {
        this.cbSendEmail.addItemListener(e -> {
            if (this.cbSendEmail.isSelected()) {
                System.out.println("Enviamos un mensaje al correo del usuario");
            } else {
                System.out.println("No se envia nada al email del usuario");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        jlIndication = new javax.swing.JLabel();
        jlRol = new javax.swing.JLabel();
        jlUser = new javax.swing.JLabel();
        jlPassword = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        tfUser = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jlConfirm = new javax.swing.JLabel();
        tfConfirm = new javax.swing.JPasswordField();
        cbSendEmail = new javax.swing.JCheckBox();
        btnCancel = new javax.swing.JButton();
        btnAcept = new javax.swing.JButton();
        jlTitle = new javax.swing.JLabel();
        linea2 = new javax.swing.JSeparator();
        linea3 = new javax.swing.JSeparator();
        linea4 = new javax.swing.JSeparator();
        jlId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        linea5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setLayout(new java.awt.GridBagLayout());

        jlIndication.setText("Ultimos Pasos para crear al nuevo usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 14, 14);
        panel.add(jlIndication, gridBagConstraints);

        jlRol.setText("Rol a desempeñar: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(jlRol, gridBagConstraints);

        jlUser.setText("Usuario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(jlUser, gridBagConstraints);

        jlPassword.setText("Contraseña: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(jlPassword, gridBagConstraints);

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRol.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(cbRol, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(tfUser, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(tfPassword, gridBagConstraints);

        jlConfirm.setText("Confirma Contraseña: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(jlConfirm, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(tfConfirm, gridBagConstraints);

        cbSendEmail.setText("Enviar Información a Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(17, 17, 17, 17);
        panel.add(cbSendEmail, gridBagConstraints);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 16, 16);
        panel.add(btnCancel, gridBagConstraints);

        btnAcept.setText("Aceptar");
        btnAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 16, 16);
        panel.add(btnAcept, gridBagConstraints);

        jlTitle.setText("Finalizando Proceso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        panel.add(jlTitle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea4, gridBagConstraints);

        jlId.setText("id: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(jlId, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 7);
        panel.add(tfId, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea5, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAceptActionPerformed

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
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormCreateUser dialog = new FormCreateUser(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JCheckBox cbSendEmail;
    private javax.swing.JLabel jlConfirm;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlIndication;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlRol;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlUser;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField tfConfirm;
    private javax.swing.JTextField tfId;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
