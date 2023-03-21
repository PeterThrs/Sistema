/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Cajero;

import Contador.InicioContador;
import configuracion.CodigoColor;
import configuracion.Configuracion;
import Objetos.Sesion;
import com.ventas.administrador.PrincipalAdministrador;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author corte
 */
public class RegistrarCompra extends javax.swing.JDialog {

    /**
     * Creates new form Registrar
     */
    public RegistrarCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AgregarConfiguración ();
        setIconImage(new ImageIcon(getClass().getResource("/images/ven.png")).getImage());
    }
    
    private void AgregarConfiguración () {
    
        //Configuracion Ventana()
        
        Configuracion.styles(this);
        //this.setExtendedState(this.NORMAL);
        
        //Configuracion al JPanel()
        
         //Configuracion.background(CodigoColor.cFondo, this.JPanelPrincipal);
         //Configuracion.background(CodigoColor.cFondoizq, this.jPanelIzq);
         
        
        //Configuracion JLabel()
        
        Configuracion.titulo( this.jLabelTituloPago);
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jLabelTituloPago);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jLabelTituloPago);
        
        
        Configuracion.foreground(CodigoColor.cLetrasNegro,this.labelpago, this.labelcambio);
        Configuracion.normalItalic(this.labelpago, this.labelcambio);
        Configuracion.foreground(CodigoColor.cLetrasNegro,this.labelpago, this.labelcambio);
       
        //Configurar JTextField()
        
        Configuracion.normal(this.pago, this.tfcambio);
        Configuracion.withoutBorde(this.pago, this.tfcambio);
        Configuracion.background(CodigoColor.cFondoGris,this.pago, this.tfcambio); 
        Configuracion.foreground(CodigoColor.cLetrasTextField,this.pago, this.tfcambio);
            
        //Configuración En JButton ()
        
        Configuracion.normalItalic(this.btncobrar,this.btnregistrarcompra,this.btnsalir);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btncobrar,this.btnregistrarcompra,this.btnsalir);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btncobrar,this.btnregistrarcompra,this.btnsalir);
    
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
        jLabelTituloPago = new javax.swing.JLabel();
        labelpago = new javax.swing.JLabel();
        pago = new javax.swing.JTextField();
        btncobrar = new javax.swing.JButton();
        labelcambio = new javax.swing.JLabel();
        btnregistrarcompra = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        tfcambio = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 110), new java.awt.Dimension(0, 110), new java.awt.Dimension(32767, 110));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pago En Efectivo");
        setBackground(new java.awt.Color(255, 255, 204));
        setLocation(new java.awt.Point(80, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabelTituloPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTituloPago.setForeground(new java.awt.Color(102, 102, 255));
        jLabelTituloPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/venta.png"))); // NOI18N
        jLabelTituloPago.setText("    Pago");

        labelpago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelpago.setText("Pago Con:");

        pago.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pago.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoActionPerformed(evt);
            }
        });
        pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagoKeyPressed(evt);
            }
        });

        btncobrar.setBackground(new java.awt.Color(153, 255, 255));
        btncobrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoVCobrar.png"))); // NOI18N
        btncobrar.setText("  COBRAR");
        btncobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncobrarMouseClicked(evt);
            }
        });
        btncobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncobrarActionPerformed(evt);
            }
        });
        btncobrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btncobrarKeyPressed(evt);
            }
        });

        labelcambio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelcambio.setText("Su Cambio:");

        btnregistrarcompra.setBackground(new java.awt.Color(153, 255, 255));
        btnregistrarcompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrarcompra.setText("Registrar Compra");
        btnregistrarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarcompraActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(255, 102, 102));
        btnsalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir.png"))); // NOI18N
        btnsalir.setText("  Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tfcambio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfcambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcambioActionPerformed(evt);
            }
        });
        tfcambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfcambioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnregistrarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTituloPago, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelcambio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btncobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelpago)
                                    .addGap(18, 18, 18)
                                    .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)))
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelTituloPago, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelpago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btncobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelcambio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(btnregistrarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents


    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        try {
            System.exit(0);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btncobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncobrarActionPerformed

         

            try {
                int totalfinal;

                totalfinal = Integer.parseInt(JOptionPane.showInputDialog("¿ Total De Lo Que Vas A Cobrar: ?"));

                String botones[] = {"Si", "No"};

                int pagocon = Integer.parseInt(pago.getText());

                int opcion = JOptionPane.showOptionDialog(this, "Pago Con: $ " + pagocon + " pesos es correcto.", "Comprobando Pago", 0, 0, null, botones, this);

                if (opcion == JOptionPane.YES_OPTION) {

                    int cambio;

                    cambio = pagocon - totalfinal;

                    String resultadocambio = "$ " + cambio;

                    tfcambio.setText(resultadocambio);

                    // JOptionPane.showMessageDialog(null,resultadocambio);
                    if (pagocon < totalfinal) {
                        JOptionPane.showMessageDialog(null, " ERROR - VERIFIQUE CON CUANTO PAGO EL CLIENTE.");
                        dispose();
                    }
                } else if (opcion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "- INGRESE NUEVAMENTE LOS VALORES REALES.");
                    dispose();
                }

            } catch (Exception e) {

            }
        

    }//GEN-LAST:event_btncobrarActionPerformed

    private void btnregistrarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarcompraActionPerformed
        try {

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnregistrarcompraActionPerformed

    private void pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_pagoActionPerformed

    private void btncobrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncobrarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btncobrarMouseClicked

    private void tfcambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcambioActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_tfcambioActionPerformed

    private void pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagoKeyPressed
        // TODO add your handling code here:
        
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                int totalfinal;

                totalfinal = Integer.parseInt(JOptionPane.showInputDialog("¿ Total De Lo Que Vas A Cobrar: ?"));

                String botones[] = {"Si", "No"};

                int pagocon = Integer.parseInt(pago.getText());

                int opcion = JOptionPane.showOptionDialog(this, "Pago Con: $ " + pagocon + " pesos es correcto.", "Comprobando Pago", 0, 0, null, botones, this);

                if (opcion == JOptionPane.YES_OPTION) {

                    int cambio;

                    cambio = pagocon - totalfinal;

                    String resultadocambio = "$ " + cambio;

                    tfcambio.setText(resultadocambio);

                    // JOptionPane.showMessageDialog(null,resultadocambio);
                    if (pagocon < totalfinal) {
                        JOptionPane.showMessageDialog(null, " ERROR - VERIFIQUE CON CUANTO PAGO EL CLIENTE.");
                        dispose();
                    }
                } else if (opcion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "- INGRESE NUEVAMENTE LOS VALORES REALES.");
                    dispose();
                }

            } catch (Exception e) {

            }
        }

         

    }//GEN-LAST:event_pagoKeyPressed

    private void tfcambioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcambioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcambioKeyPressed

    private void btncobrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btncobrarKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                int totalfinal;

                totalfinal = Integer.parseInt(JOptionPane.showInputDialog("¿ Total De Lo Que Vas A Cobrar: ?"));

                String botones[] = {"Si", "No"};

                int pagocon = Integer.parseInt(pago.getText());

                int opcion = JOptionPane.showOptionDialog(this, "Pago Con: $ " + pagocon + " pesos es correcto.", "Comprobando Pago", 0, 0, null, botones, this);

                if (opcion == JOptionPane.YES_OPTION) {

                    int cambio;

                    cambio = pagocon - totalfinal;

                    String resultadocambio = "$ " + cambio;

                    tfcambio.setText(resultadocambio);

                    // JOptionPane.showMessageDialog(null,resultadocambio);
                    if (pagocon < totalfinal) {
                        JOptionPane.showMessageDialog(null, " ERROR - VERIFIQUE CON CUANTO PAGO EL CLIENTE.");
                        dispose();
                    }
                } else if (opcion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "- INGRESE NUEVAMENTE LOS VALORES REALES.");
                    dispose();
                }

            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btncobrarKeyPressed

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
            java.util.logging.Logger.getLogger(RegistrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarCompra dialog = new RegistrarCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btncobrar;
    private javax.swing.JButton btnregistrarcompra;
    private javax.swing.JButton btnsalir;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabelTituloPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelcambio;
    private javax.swing.JLabel labelpago;
    private javax.swing.JTextField pago;
    private javax.swing.JTextField tfcambio;
    // End of variables declaration//GEN-END:variables
}
