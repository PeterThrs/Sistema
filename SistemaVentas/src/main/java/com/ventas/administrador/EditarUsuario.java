package com.ventas.administrador;

import Objetos.Persona;
import java.awt.event.KeyEvent;
import configuracion.Configuracion;
import javax.swing.JOptionPane;

public class EditarUsuario extends javax.swing.JDialog {
    Persona person;
    public EditarUsuario(java.awt.Frame parent, boolean modal, Persona p) {
        super(parent, modal);
        initComponents();
        jTextId.setText(Long.toString(p.getId()));
        jTextUsuario.setText(p.getNomUsuario());
        jTextNombre.setText(p.getNombre());
        jTextApellidoP.setText(p.getApellidoPaterno());
        jTextApellidoM.setText(p.getApellidoMaterno());
        jTextTelefono.setText(Long.toString(p.getNumTelefono()));
        jTextCorreoElec.setText(p.getCorreoElectronico());
        jTextNacionalidad.setText(p.getNacionalidad());
        jTextCalle.setText(p.getCalle());
        Configuracion.styles(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jTextNacionalidad = new javax.swing.JTextField();
        jTextTelefono = new javax.swing.JTextField();
        jTextApellidoM = new javax.swing.JTextField();
        jTextCalle = new javax.swing.JTextField();
        jTextApellidoP = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        btnActualizarDatos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTextId = new javax.swing.JTextField();
        jTextCorreoElec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creacion De Usuario");
        setBackground(new java.awt.Color(255, 255, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Editar Usuario ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 36;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 50, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Id: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 43, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Usuario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 43, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 43, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("Apellido Paterno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 43, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("Apellido Materno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 43, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("Telefono: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 43, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Calle: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 43, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        jLabel9.setText("Nacionalidad: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 43, 0, 0);
        getContentPane().add(jLabel9, gridBagConstraints);

        jTextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUsuarioActionPerformed(evt);
            }
        });
        jTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextUsuarioKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 24, 0, 32);
        getContentPane().add(jTextUsuario, gridBagConstraints);

        jTextNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNacionalidadActionPerformed(evt);
            }
        });
        jTextNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNacionalidadKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 32);
        getContentPane().add(jTextNacionalidad, gridBagConstraints);

        jTextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonoActionPerformed(evt);
            }
        });
        jTextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 32);
        getContentPane().add(jTextTelefono, gridBagConstraints);

        jTextApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoMActionPerformed(evt);
            }
        });
        jTextApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidoMKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 24, 0, 32);
        getContentPane().add(jTextApellidoM, gridBagConstraints);

        jTextCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCalleActionPerformed(evt);
            }
        });
        jTextCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCalleKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 32);
        getContentPane().add(jTextCalle, gridBagConstraints);

        jTextApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoPActionPerformed(evt);
            }
        });
        jTextApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidoPKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 32);
        getContentPane().add(jTextApellidoP, gridBagConstraints);

        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 24, 0, 32);
        getContentPane().add(jTextNombre, gridBagConstraints);

        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 64, 31, 0);
        getContentPane().add(btnActualizarDatos, gridBagConstraints);

        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 31, 0);
        getContentPane().add(btnCancelar, gridBagConstraints);

        jTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdActionPerformed(evt);
            }
        });
        jTextId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextIdKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 24, 0, 32);
        getContentPane().add(jTextId, gridBagConstraints);

        jTextCorreoElec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCorreoElecActionPerformed(evt);
            }
        });
        jTextCorreoElec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCorreoElecKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 32);
        getContentPane().add(jTextCorreoElec, gridBagConstraints);

        jLabel10.setText("Correo electrónico:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 43, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUsuarioActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNacionalidadActionPerformed

    private void jTextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoActionPerformed

    private void jTextApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoMActionPerformed

    private void jTextCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCalleActionPerformed

    private void jTextApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoPActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try
        {
            dispose(); 
        } catch (Exception e)
        {
            System.err.print(e);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdActionPerformed

    private void jTextCorreoElecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCorreoElecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoElecActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        try
        {
            if(!jTextId.getText().isEmpty() && !jTextUsuario.getText().isEmpty() && !jTextNombre.getText().isEmpty() && !jTextApellidoP.getText().isEmpty() && !jTextApellidoM.getText().isEmpty() && !jTextTelefono.getText().isEmpty() && !jTextCorreoElec.getText().isEmpty() && !jTextNacionalidad.getText().isEmpty() && !jTextCalle.getText().isEmpty()){
                person=new Persona(Integer.parseInt(jTextId.getText()),jTextUsuario.getText() , jTextNombre.getText(), jTextApellidoP.getText(), jTextApellidoM.getText(), Long.parseLong(jTextTelefono.getText()), jTextCorreoElec.getText(), jTextNacionalidad.getText(), jTextCalle.getText());            
            }else{
                JOptionPane.showMessageDialog(null, "Verifica los datos ingresados!");
            }
            this.dispose();
        } catch (Exception e)
        {
            System.err.print(e);
        }
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void jTextIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextIdKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextIdKeyTyped

    private void jTextUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUsuarioKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextUsuarioKeyTyped

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoPKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextApellidoPKeyTyped

    private void jTextApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoMKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextApellidoMKeyTyped

    private void jTextTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyTyped
        char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
    }//GEN-LAST:event_jTextTelefonoKeyTyped

    private void jTextCorreoElecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoElecKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextCorreoElecKeyTyped

    private void jTextNacionalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNacionalidadKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextNacionalidadKeyTyped

    private void jTextCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCalleKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextCalleKeyTyped
    public Persona usuario(){
        return this.person;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextApellidoM;
    private javax.swing.JTextField jTextApellidoP;
    private javax.swing.JTextField jTextCalle;
    private javax.swing.JTextField jTextCorreoElec;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNacionalidad;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
