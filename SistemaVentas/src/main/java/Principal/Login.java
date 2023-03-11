package Principal;

import Cajero.VentanaCajero;
import Contador.InicioContador;
import Objetos.Sesion;
import administrador.FormMainAdmi;
import com.ventas.administrador.PrincipalAdministrador;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import configuracion.Configuracion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        /*JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");*/
        /*try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.texture.patterns.textile");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        initComponents();
        Configuracion.styles(this);
        this.setExtendedState(this.NORMAL);
        
        Configuracion.normal(this.cUser, this.jIngresar, this.jlUser, this.jlPassword, this.cPassword);
        Configuracion.titulo(jlTitulo);
        
        //this.setIconImage(Sesion.app.getIcono());
        
        ImageIcon wallpaper = new ImageIcon("src/main/resources/images/icono/austronauta.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_DEFAULT)); 
        
        this.image.setIcon(icono);
        this.repaint(); 
    }
    
    /*@Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage("src/main/resources/images/icono/austronauta.png");
        return retValue;
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlUser = new javax.swing.JLabel();
        jlPassword = new javax.swing.JLabel();
        jIngresar = new javax.swing.JButton();
        cPassword = new javax.swing.JPasswordField();
        cUser = new javax.swing.JTextField();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jlTitulo.setText("SISTEMA DE VENTAS");

        jlUser.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jlUser.setText("Usuario");

        jlPassword.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jlPassword.setText("Contraseña");

        jIngresar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jIngresar.setText("Ingresar");
        jIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngresarActionPerformed(evt);
            }
        });
        jIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIngresarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jIngresarKeyReleased(evt);
            }
        });

        cPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPasswordKeyTyped(evt);
            }
        });

        cUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUserActionPerformed(evt);
            }
        });
        cUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cUserKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTitulo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jIngresar)))
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(cUser))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUser)
                    .addComponent(cUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPassword)
                    .addComponent(cPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jIngresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

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

    private void jIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngresarActionPerformed
        try {
            String user = cUser.getText();
            String password = String.valueOf(cPassword.getPassword());
            boolean correcto = Sesion.validar(user, password);

            if (correcto) {
                if (user.equals(Sesion.seguridad.getUserAdmin())) {
                    FormMainAdmi fma = new FormMainAdmi();
                    fma.setVisible(true);
                } else if (user.equals(Sesion.seguridad.getUserCount())) {
                    InicioContador ic = new InicioContador(); 
                    ic.setVisible(true);
                }else {
                    VentanaCajero vc = new VentanaCajero(); 
                    vc.setVisible(true);
                }
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "El usuario o contraseña son incorrectos", user, HEIGHT);
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jIngresarActionPerformed

    private void cUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cUserActionPerformed

    private void jIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIngresarKeyPressed
        
    }//GEN-LAST:event_jIngresarKeyPressed

    private void jIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIngresarKeyReleased
        
    }//GEN-LAST:event_jIngresarKeyReleased

    private void cUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cUserKeyTyped
        char cTeclaPresionada=evt.getKeyChar();
        if(cTeclaPresionada==KeyEvent.VK_ENTER){
            jIngresar.doClick();
        }
    }//GEN-LAST:event_cUserKeyTyped

    private void cPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPasswordKeyTyped
        char cTeclaPresionada=evt.getKeyChar();
        if(cTeclaPresionada==KeyEvent.VK_ENTER){
            jIngresar.doClick();
        }
    }//GEN-LAST:event_cPasswordKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cPassword;
    private javax.swing.JTextField cUser;
    private javax.swing.JLabel image;
    private javax.swing.JButton jIngresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUser;
    // End of variables declaration//GEN-END:variables
}
