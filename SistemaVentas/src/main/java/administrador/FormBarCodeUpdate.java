package administrador;

import configuracion.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class FormBarCodeUpdate extends javax.swing.JDialog {

    public FormBarCodeUpdate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        agregarEstilos();
    }

    private void agregarEstilos() {
        try {
            this.setMinimumSize(new Dimension(350, 200));
            Configuracion.styles(this);
            Configuracion.normalItalic(this.btnClose, this.btnContinue);
            Configuracion.normal(this.tfBarCode);
            Configuracion.normalItalic(this.jlIndication);

            //Quitar el borde a los text Field
            Configuracion.borde(this.tfBarCode);

            //configuracion para establecer el foreground
            //color azul fuerte
            Color color = new Color(29, 53, 87);
            Configuracion.foreground(color, this.jlIndication);
            //Configuracion.foreground(color, this.btnClose, this.btnContinue);

            //color rojo fuerte
            color = new Color(230, 57, 70);
            Configuracion.foreground(color, this.linea1);

            //color blanco crema
            color = new Color(241, 250, 238);
            Configuracion.background(color, this.panel, this.tfBarCode);
            Configuracion.foreground(color, this.btnClose, this.btnContinue);

            //color azul bajo
            color = new Color(168, 218, 220);
            //color azul intermedio
            color = new Color(69, 123, 157);
            Configuracion.background(color, this.btnClose, this.btnContinue);
            
        } catch (Exception ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        jlIndication = new javax.swing.JLabel();
        tfBarCode = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();
        linea1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setLayout(new java.awt.GridBagLayout());

        jlIndication.setText("Ingrese el codigo de barras del producto: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        panel.add(jlIndication, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 12);
        panel.add(tfBarCode, gridBagConstraints);

        btnClose.setText("Regresar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        panel.add(btnClose, gridBagConstraints);

        btnContinue.setText("Continuar");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        panel.add(btnContinue, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        try{
            this.dispose(); 
            FormProduct vProduct = new FormProduct(new JFrame(), true); 
            vProduct.setVisible(true);
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnContinueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnContinue;
    private javax.swing.JLabel jlIndication;
    private javax.swing.JSeparator linea1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tfBarCode;
    // End of variables declaration//GEN-END:variables
}
