package confused;

import com.settings.CodigoColor;
import com.settings.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class FormIdUpdate extends javax.swing.JDialog {

    public FormIdUpdate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        agregarEstilos();
    }

    private void agregarEstilos() {
        //configuracion ventana
        this.setMinimumSize(new Dimension(300, 200));
        this.setSize(new Dimension(300, 200));
        Configuracion.styles(this);
        
        //configuración JPanel
        Configuracion.background(CodigoColor.cFondoGris, this.panel);
        
        //configuracion JLabel
        Configuracion.robotoItalic14(this.jlIndication);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlIndication);
        
        //configuracion JTextField
        Configuracion.robotoPlain12(this.tfId);
        Configuracion.withoutBorde(this.tfId);
        Configuracion.background(CodigoColor.cFondoGris,this.tfId);
        
        //Configuracion JButton
        Configuracion.robotoItalic14(this.btnCancel, this.btnAcept);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCancel, this.btnAcept);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCancel, this.btnAcept);
        
        //Configuración JSeparador
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea1);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        jlIndication = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        linea1 = new javax.swing.JSeparator();
        btnCancel = new javax.swing.JButton();
        btnAcept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setLayout(new java.awt.GridBagLayout());

        jlIndication.setText("Ingrese el id del Usuario a Editar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 7, 7, 7);
        panel.add(jlIndication, gridBagConstraints);

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 7, 0, 7);
        panel.add(tfId, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea1, gridBagConstraints);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 7, 7, 7);
        panel.add(btnCancel, gridBagConstraints);

        btnAcept.setText("Aceptar");
        btnAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(20, 7, 7, 7);
        panel.add(btnAcept, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptActionPerformed
        try{
            this.dispose(); 
            FormUser user = new FormUser(new JFrame(), true, true); 
            user.setVisible(true);
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnAceptActionPerformed

    public static void main(String args[]) {
        FormIdUpdate vUpdate = new FormIdUpdate(new JFrame(), true); 
        vUpdate.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jlIndication;
    private javax.swing.JSeparator linea1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables
}
