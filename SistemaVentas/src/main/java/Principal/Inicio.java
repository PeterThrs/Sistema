/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import configuracion.Configuracion;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Objetos.Sesion;

/**
 *
 * @author EdRyz
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        //agregarEstilos();
        
        this.setIconImage(Sesion.app.getIcono());
        
        //ImageIcon wallpaper = new ImageIcon("src/main/resources/images/User.png"); 
        //Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(imagenf.getWidth(), imagenf.getHeight(), Image.SCALE_DEFAULT)); 
        
        //iconUser.setIcon(new Configuracion().setIconoEtiqueta("/user.png", iconUser));
        //iconPassword.setIcon(new Configuracion().setIconoEtiqueta("/password icon.png", iconPassword));
        //jLogo.setIcon(new Configuracion().setIconoEtiqueta("/logo.png", jLogo));
        //this.imagenf.setIcon(icono);
        //this.repaint(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenf = new javax.swing.JLabel();
        btnEntrarInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagenf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEntrarInicio.setText("Entrar");
        btnEntrarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(imagenf, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrarInicio)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(imagenf, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(btnEntrarInicio)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarInicioActionPerformed
        // TODO add your handling code here:
        Login login=new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnEntrarInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrarInicio;
    private javax.swing.JLabel imagenf;
    // End of variables declaration//GEN-END:variables

   class FondoPanel extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen=new ImageIcon(getClass().getResource("/f.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
}