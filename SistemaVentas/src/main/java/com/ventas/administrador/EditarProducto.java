package com.ventas.administrador;

import Objetos.Persona;
import Objetos.Producto;
import java.awt.event.KeyEvent;
import configuracion.Configuracion;
import javax.swing.JOptionPane;

public class EditarProducto extends javax.swing.JDialog {
    Producto producto;
    public EditarProducto(java.awt.Frame parent, boolean modal, Producto p) {
        super(parent, modal);
        initComponents();
        jTextCodigo.setText(Long.toString(p.getCodigo()));
        jTextNombree.setText(p.getNombre());
        jTextPrecio.setText(Double.toString(p.getPrecio()));
        jTextArea.setText(p.getArea());
        jTextMarca.setText(p.getMarca());
        jTextCantidad.setText(Double.toString(p.getCantidad()));
        Configuracion.styles(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        etqCodigo = new javax.swing.JLabel();
        etqNombre = new javax.swing.JLabel();
        etqPrecio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextNombree = new javax.swing.JTextField();
        jTextCantidad = new javax.swing.JTextField();
        jTextMarca = new javax.swing.JTextField();
        jTextArea = new javax.swing.JTextField();
        jTextPrecio = new javax.swing.JTextField();
        btnActualizarDatos = new javax.swing.JButton();
        jTextCodigo = new javax.swing.JTextField();

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
        jLabel1.setText("Editar Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 36;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 80, 4, 1);
        getContentPane().add(jLabel1, gridBagConstraints);

        etqCodigo.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 43, 0, 0);
        getContentPane().add(etqCodigo, gridBagConstraints);

        etqNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 43, 0, 0);
        getContentPane().add(etqNombre, gridBagConstraints);

        etqPrecio.setText("Precio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 43, 0, 0);
        getContentPane().add(etqPrecio, gridBagConstraints);

        jLabel5.setText("Area:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 43, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("Marca:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 43, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("Cantidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 43, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        jTextNombree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreeActionPerformed(evt);
            }
        });
        jTextNombree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreeKeyTyped(evt);
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
        getContentPane().add(jTextNombree, gridBagConstraints);

        jTextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadActionPerformed(evt);
            }
        });
        jTextCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 58;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 24, 0, 32);
        getContentPane().add(jTextCantidad, gridBagConstraints);

        jTextMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMarcaActionPerformed(evt);
            }
        });
        jTextMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMarcaKeyTyped(evt);
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
        getContentPane().add(jTextMarca, gridBagConstraints);

        jTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAreaActionPerformed(evt);
            }
        });
        jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaKeyTyped(evt);
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
        getContentPane().add(jTextArea, gridBagConstraints);

        jTextPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecioActionPerformed(evt);
            }
        });
        jTextPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioKeyTyped(evt);
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
        getContentPane().add(jTextPrecio, gridBagConstraints);

        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });
        btnActualizarDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnActualizarDatosKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 64, 31, 0);
        getContentPane().add(btnActualizarDatos, gridBagConstraints);

        jTextCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodigoActionPerformed(evt);
            }
        });
        jTextCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCodigoKeyTyped(evt);
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
        getContentPane().add(jTextCodigo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreeActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jTextMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMarcaActionPerformed

    private void jTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaActionPerformed

    private void jTextPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioActionPerformed

    private void jTextCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodigoActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        try
        {
            if(!jTextCodigo.getText().isEmpty() && !jTextNombree.getText().isEmpty() && !jTextPrecio.getText().isEmpty() && !jTextArea.getText().isEmpty() && !jTextMarca.getText().isEmpty() && !jTextCantidad.getText().isEmpty()){
                producto=new Producto(Long.parseLong(jTextCodigo.getText()),jTextNombree.getText() , Double.parseDouble(jTextPrecio.getText()), jTextArea.getText(), jTextMarca.getText(), Double.parseDouble(jTextCantidad.getText()));            
            }else{
                JOptionPane.showMessageDialog(null, "Verifica los datos ingresados!");
            }
            this.dispose();
        } catch (Exception e)
        {
            System.err.print(e);
        }
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void jTextCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCodigoKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextCodigoKeyTyped

    private void jTextNombreeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreeKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextNombreeKeyTyped

    private void jTextPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextPrecioKeyTyped

    private void jTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextAreaKeyTyped

    private void jTextMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMarcaKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jTextMarcaKeyTyped

    private void jTextCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadKeyTyped
        char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
    }//GEN-LAST:event_jTextCantidadKeyTyped

    private void btnActualizarDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarDatosKeyTyped
        try
        {
            char cTeclaPresionada=evt.getKeyChar();
            if(cTeclaPresionada==KeyEvent.VK_ENTER){
                btnActualizarDatos.doClick();
            }
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btnActualizarDatosKeyTyped
    public Producto producto(){
        return this.producto;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JLabel etqCodigo;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextArea;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextMarca;
    private javax.swing.JTextField jTextNombree;
    private javax.swing.JTextField jTextPrecio;
    // End of variables declaration//GEN-END:variables
}
