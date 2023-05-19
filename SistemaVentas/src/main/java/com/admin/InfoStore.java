/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.classes.Tienda;
import com.conexion.TiendaDAO;
import com.settings.ObjGraficosService;
import com.settings.Recursos;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class InfoStore extends javax.swing.JPanel {

    private JLabel jlLogo, jlNombre, jlSlogan, jlFacebookIcon, jlPhone1Icon, jlPhone2Icon, jlPhone1, jlPhone2, jlGmailIcon, jlGmail;
    private Tienda tienda;
    private ImageIcon imgLogo, imgFacebook, imgPhone, imgGmail, iDimAux;
    private Recursos recursos;
    private ObjGraficosService oGraficos;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    public InfoStore() {
        initComponents();
        instancias();
        inicializarImagenes();
        cargarIconos();
        construirJLabels();
        colocarEnLayout();
    }

    public void instancias() {
        tienda = TiendaDAO.traerUltimo();
        recursos = Recursos.getService();
        oGraficos = ObjGraficosService.getService();
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.setLayout(gbl);
    }

    public void inicializarImagenes() {
        try
        {
            imgLogo = oGraficos.mostrarImagen("src/main/resources/icono/logo.png");
            System.out.println("Cargamos la imagen exitosamente");
        } catch (IOException ex)
        {
            Logger.getLogger(InfoStore.class.getName()).log(Level.SEVERE, null, ex);
            imgLogo = new ImageIcon("src/main/resources/tienda.png");
            System.out.println("Hubo un error al cargar la imagen");
        }
        imgFacebook = new ImageIcon("src/main/resources/img/facebook.png");
        imgPhone = new ImageIcon("src/main/resources/img/llamada-telefonica.png");
        imgGmail = new ImageIcon("src/main/resources/img/email.png");
    }

    public void cargarIconos() {
        iDimAux = new ImageIcon(imgLogo.getImage().getScaledInstance(400, 270, Image.SCALE_AREA_AVERAGING));
        jlLogo = oGraficos.construirJLabel(null, 400, 100, 400, 270, null, iDimAux, null, null, null, null, "z");

        iDimAux = new ImageIcon(imgFacebook.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
        jlFacebookIcon = oGraficos.construirJLabel(null, 1202, 695, 30, 30, recursos.getCMano(), iDimAux, null, null, null, null, "z");

        iDimAux = new ImageIcon(imgPhone.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
        jlPhone1Icon = oGraficos.construirJLabel(null, 952, 695, 30, 30, null, iDimAux, null, null, null, null, "z");

        iDimAux = new ImageIcon(imgPhone.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
        jlPhone2Icon = oGraficos.construirJLabel(null, 702, 695, 30, 30, null, iDimAux, null, null, null, null, "z");

        iDimAux = new ImageIcon(imgGmail.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
        jlGmailIcon = oGraficos.construirJLabel(null, 0, 695, 30, 30, null, iDimAux, null, null, null, null, "z");
    }

    public void construirJLabels() {
        jlPhone1 = oGraficos.construirJLabel("+52 " + tienda.getTelefono1(), 994, 687, 200, 50, null, null, recursos.getFontClasica(), null, null, null, "z");
        jlPhone2 = oGraficos.construirJLabel("+52 " + tienda.getTelefono2(), 744, 687, 200, 50, null, null, recursos.getFontClasica(), null, null, null, "z");
        jlGmail = oGraficos.construirJLabel(tienda.getEmail(), 42, 687, 640, 50, null, null, recursos.getFontClasica(), null, null, null, "z");
        jlNombre = oGraficos.construirJLabel(tienda.getNombre(), 0, 0, 1200, 100, null, null, recursos.getFontTitulo(), null, null, null, "c");
        jlSlogan = oGraficos.construirJLabel("<html><center>" + oGraficos.saltosDeLineaJlabel(tienda.getSlogan(),28) + "</center></html>", 250, 400, 700, 200, null, null, recursos.getFontSubtitulo(), null, null, null, "c");
    }

//    public void colocarEnLayout(JComponent component, int gridX, int gridY, int gridWidth, int gridHeight, int ipadX, int ipadY){
//        gbc.gridx = gridX; 
//        gbc.gridy = gridY;
//        gbc.gridwidth = gridWidth;
//        gbc.gridheight = gridHeight;
//        gbc.ipadx = ipadX;
//        gbc.ipady = ipadY;
//        this.add(component, gbc);
//    }
    public void colocarEnLayout() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        this.add(jlNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 0;;
        gbc.ipady = 50;
        this.add(jlLogo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        this.add(jlSlogan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        this.add(jlPhone1Icon, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 100;
        this.add(jlPhone1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 10;
        this.add(jlPhone2Icon, gbc);

        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 100;
        this.add(jlPhone2, gbc);

        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 10;
        this.add(jlGmailIcon, gbc);

        gbc.gridx = 7;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 100;
        this.add(jlGmail, gbc);

        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 10;
        this.add(jlFacebookIcon, gbc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
