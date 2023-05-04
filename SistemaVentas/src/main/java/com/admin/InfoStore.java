/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.classes.Tienda;
import com.conexion.TiendaDao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InfoStore extends javax.swing.JPanel {

    private JLabel icon, nombre, slogan, facebookIcon, phone1Icon, phone2Icon, phone1, phone2, gmailIcon, gmail;
    private Tienda tienda;

    public InfoStore() {
        initComponents();

        tienda = TiendaDao.traerUltimo();

        ImageIcon iFondo = new ImageIcon("src/main/resources/tienda.png");
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
        gbc.gridwidth = 5; 
        this.add(icon, gbc);
        
        gbc.gridx = 3; 
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(facebookIcon, gbc);
        gbc.gridx = 0; 
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        this.add(phone1Icon, gbc);
        gbc.gridx = 1; 
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        this.add(phone2Icon, gbc);
        gbc.gridx = 3; 
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        this.add(nombre, gbc);
        gbc.gridx = 3; 
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        this.add(slogan, gbc);
        gbc.gridx = 3; 
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        this.add(phone1, gbc);
        gbc.gridx = 3; 
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        this.add(phone2, gbc);
        gbc.gridx = 3; 
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        this.add(gmailIcon, gbc);
        gbc.gridx = 3; 
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        this.add(gmail, gbc);
        
        
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
        //System.out.println("Texto formateado: " + textoFormateado);
        //JLabel label = new JLabel("<html>" + textoFormateado + "</html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
