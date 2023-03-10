package administrador;

import Objetos.Roles;
import configuracion.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class FormCreateUser extends javax.swing.JDialog {

    public FormCreateUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.agregarEstilos();
        configuracion(); 
    }

    private void agregarEstilos() {
        try {
            this.setMinimumSize(new Dimension(350, 330));
            Configuracion.styles(this);
            Configuracion.normalItalic(this.btnCancel, this.btnAcept);
            Configuracion.normal(this.tfConfirm, this.tfPassword, this.tfUser, this.tfId);
            Configuracion.normalItalic(this.jlIndication, this.jlConfirm, this.jlPassword, this.jlRol, this.jlTitle,
                    this.jlUser, this.jlId);
            Configuracion.normalItalic(this.cbRol, this.cbSendEmail);

            //Quitar el borde a los text Field
            Configuracion.borde(this.tfConfirm, this.tfPassword, this.tfUser, this.cbRol, this.tfId);

            //configuracion para establecer el foreground
            //color azul fuerte
            Color color = new Color(29, 53, 87);
            Configuracion.foreground(color, this.jlIndication, this.jlConfirm, this.jlPassword, this.jlRol, this.jlTitle,
                    this.jlUser, this.jlId);
            Configuracion.background(color, this.btnCancel, this.btnAcept);

            //color rojo fuerte
            color = new Color(230, 57, 70);
            Configuracion.foreground(color, this.linea2, this.linea3, this.linea4, this.linea5);

            //color blanco crema
            color = new Color(241, 250, 238);
            Configuracion.background(color, this.panel, this.tfConfirm, this.tfPassword, this.tfUser, this.cbSendEmail,
                    this.cbRol);
            Configuracion.foreground(color, this.btnCancel, this.btnAcept);

            //color azul bajo
            color = new Color(168, 218, 220);
            //color azul intermedio
            color = new Color(69, 123, 157);
            

        } catch (Exception ex) {

        }
    }
    
    
    private void configuracion(){
        modeloComboBox();
        checkBoxItemListened();
    }
    
    private void modeloComboBox(){
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(); 
        dcbm.addElement(Roles.administrador);
        dcbm.addElement(Roles.cajero); 
        dcbm.addElement(Roles.contador); 
        this.cbRol.setModel(dcbm);
    }
    
    private void checkBoxItemListened(){
        this.cbSendEmail.addItemListener( e -> {
            if(this.cbSendEmail.isSelected()){
                System.out.println("Enviamos un mensaje al correo del usuario");
            }else {
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
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        panel.add(jlIndication, gridBagConstraints);

        jlRol.setText("Rol a desempe??ar: ");
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

        jlPassword.setText("Contrase??a: ");
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

        jlConfirm.setText("Confirma Contrase??a: ");
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

        cbSendEmail.setText("Enviar Informaci??n a Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
