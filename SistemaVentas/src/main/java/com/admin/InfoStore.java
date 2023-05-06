/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.classes.Tienda;
import com.conexion.TiendaDAO;
import static com.settings.Recursos.mostrarImagen;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InfoStore extends javax.swing.JPanel {

    private JLabel icon, nombre, slogan, facebookIcon, phone1Icon, phone2Icon, phone1, phone2, gmailIcon, gmail;
    private Tienda tienda;

    public InfoStore() {
        initComponents();

        tienda = TiendaDAO.traerUltimo();

        ImageIcon iFondo;
        try
        {
            iFondo = mostrarImagen("src/main/resources/icono/logo.png");
            System.out.println("Cargamos la imagen exitosamente");
        } catch (IOException ex)
        {
            Logger.getLogger(InfoStore.class.getName()).log(Level.SEVERE, null, ex);
            iFondo = new ImageIcon("src/main/resources/tienda.png");
            System.out.println("Hubo un error al cargar la imagen");
        }
        ImageIcon iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(400, 270, Image.SCALE_AREA_AVERAGING)
        );
        icon = new JLabel();
        icon.setSize(400, 270);
        icon.setLocation(400, 100);
        icon.setIcon(iDimAux);

        iFondo = new ImageIcon("src/main/resources/img/facebook.png");
        iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING)
        );
        facebookIcon = new JLabel();
        facebookIcon.setSize(30, 30);
        facebookIcon.setLocation(1202, 695);
        facebookIcon.setIcon(iDimAux);

        iFondo = new ImageIcon("src/main/resources/img/llamada-telefonica.png");
        iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING)
        );
        phone1Icon = new JLabel();
        phone1Icon.setSize(30, 30);
        phone1Icon.setLocation(952, 695);
        phone1Icon.setIcon(iDimAux);

        iFondo = new ImageIcon("src/main/resources/img/llamada-telefonica.png");
        iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING)
        );
        phone2Icon = new JLabel();
        phone2Icon.setSize(30, 30);
        phone2Icon.setLocation(702, 695);
        phone2Icon.setIcon(iDimAux);

        iFondo = new ImageIcon("src/main/resources/img/email.png");
        iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING)
        );
        gmailIcon = new JLabel();
        gmailIcon.setSize(30, 30);
        gmailIcon.setLocation(0, 695);
        gmailIcon.setIcon(iDimAux);

        phone1 = new JLabel("+52 " + tienda.getTelefono2());
        phone1.setFont(new Font(null, Font.PLAIN, 20));
        phone1.setBounds(994, 687, 200, 50);
        phone1.setOpaque(false);

        phone2 = new JLabel("+52 " + tienda.getTelefono1());
        phone2.setFont(new Font(null, Font.PLAIN, 20));
        phone2.setBounds(744, 687, 200, 50);
        phone2.setOpaque(false);

        gmail = new JLabel(tienda.getEmail());
        gmail.setFont(new Font(null, Font.PLAIN, 20));
        gmail.setBounds(42, 687, 640, 50);
        gmail.setOpaque(true);

        nombre = new JLabel(tienda.getNombre());
        nombre.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 40));
        nombre.setBounds(0, 0, 1200, 100);
        nombre.setOpaque(true);
        nombre.setHorizontalAlignment(SwingConstants.CENTER);

        slogan = new JLabel("<html><center>" + seleccionar(tienda.getSlogan()) + "</center></html>");
        slogan.setFont(new Font("Forte", Font.PLAIN, 30));
        slogan.setBounds(250, 400, 700, 200);
        slogan.setOpaque(true);
        slogan.setHorizontalAlignment(JLabel.CENTER);

        
        
        GridBagLayout gbl = new GridBagLayout(); 
        
        this.setLayout(gbl);
        
        GridBagConstraints gbc = new GridBagConstraints(); 
        
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        this.add(nombre, gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.gridwidth = 0; ;
        gbc.ipady = 50;
        this.add(icon, gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        this.add(slogan, gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        this.add(phone1Icon, gbc);
        
         gbc.gridx = 1; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 100;
        this.add(phone1, gbc);
        
        gbc.gridx = 3; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 10;
        this.add(phone2Icon, gbc);
        
        gbc.gridx = 4; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 100;
        this.add(phone2, gbc);
        
        gbc.gridx = 6; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 10;
        this.add(gmailIcon, gbc);
        
        gbc.gridx = 7; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 100;
        this.add(gmail, gbc);
        
        gbc.gridx = 9; 
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 5;
        gbc.ipadx = 10;
        this.add(facebookIcon, gbc);
    }
    
    public static String seleccionar(String texto) {
        int longitudMaxima = 28;

        java.util.List<String> lineas = new ArrayList<String>();
        int inicio = 0;
        int fin = longitudMaxima;
        while (inicio < texto.length())
        {
            if (fin >= texto.length())
            {
                fin = texto.length();
            } else
            {
                fin = texto.lastIndexOf(" ", fin);
            }
            lineas.add(texto.substring(inicio, fin));
            inicio = fin + 1;
            fin = inicio + longitudMaxima;
        }
        return String.join("<br>", lineas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
