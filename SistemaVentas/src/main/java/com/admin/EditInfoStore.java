/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.classes.Tienda;
import com.conexion.TiendaDAO;
import com.settings.CodigoColor;
import com.settings.Configuracion;
import com.settings.Recursos;
import static com.settings.Recursos.guardarImagen;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juanj
 */
public class EditInfoStore extends javax.swing.JPanel {

    String ruta;

    public EditInfoStore() {
        initComponents();
        agregarEstilos();
        rellenarDatos();
        jlFileSelect.setText(Recursos.obtenerNombreArchivo("src/main/resources/icono") != null ? "logo.png" : "");
    }

    public void rellenarDatos() {
        Tienda tienda = TiendaDAO.traerUltimo();
        if (tienda != null)
        {
            tfName.setText(tienda.getNombre());
            tfSlogan.setText(tienda.getSlogan());
            tfPhone1.setText(tienda.getTelefono1());
            tfPhone2.setText(tienda.getTelefono2());
            tfCorreoE.setText(tienda.getEmail());
            tfMision.setText(tienda.getMision());
            tfVision.setText(tienda.getVision());
            tfCodigoPostal.setText(String.valueOf(tienda.getCodigoPostal()));
            tfEstado.setText(tienda.getEstado());
            tfMunicipio.setText(tienda.getMunicipio());
            tfColonia.setText(tienda.getColonia());
            tfCalle.setText(tienda.getCalle());
            tfNumCasa.setText(String.valueOf(tienda.getNumCasa()));
            btnCreate.setEnabled(false);
        } else
        {
            btnUpdate.setEnabled(false);
        }
    }

    public void agregarEstilos() {
        this.setMinimumSize(new Dimension(650, 600));
        this.setSize(new Dimension(650, 600));

        //configuracion al JPanel
        Configuracion.background(CodigoColor.cFondoGris, this);

        //titulo
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jlTitle);
        Configuracion.robotoBold20(this.jlTitle);

        //demas datos
        Configuracion.robotoPlain14(this.jlName, this.jSlogan, this.jPhone1, this.jPhone2,
                this.jCorreoE, this.jMision, this.jVision, this, jCodigoPostal, this.jEstado, this.jMunicipio, this.jColonia, this.jCalle, this.jNumCasa, this.jlFileSelect);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlName, this.jSlogan, this.jPhone1, this.jPhone2,
                this.jCorreoE, this.jMision, this.jVision, this, jCodigoPostal, this.jEstado, this.jMunicipio, this.jColonia, this.jCalle, this.jNumCasa);

        //configuraicon JTextField
        Configuracion.robotoPlain14(this.tfName, this.tfSlogan, this.tfPhone1, this.tfPhone2, this.tfCorreoE, this.tfMision, tfVision,
                this.tfCorreoE, this.tfMision, this.tfVision, this.tfCodigoPostal, this.tfEstado, tfMunicipio, tfColonia, tfCalle, this.tfNumCasa);
        Configuracion.withoutBorde(this.tfName, this.tfSlogan, this.tfPhone1, this.tfPhone2, this.tfCorreoE, this.tfMision, tfVision,
                this.tfCorreoE, this.tfMision, this.tfVision, this.tfCodigoPostal, this.tfEstado, tfMunicipio, tfColonia, tfCalle, this.tfNumCasa);
        Configuracion.background(CodigoColor.cFondoGris, this.tfName, this.tfSlogan, this.tfPhone1, this.tfPhone2, this.tfCorreoE, this.tfMision, tfVision,
                this.tfCorreoE, this.tfMision, this.tfVision, this.tfCodigoPostal, this.tfEstado, tfMunicipio, tfColonia, tfCalle, this.tfNumCasa);
        Configuracion.foreground(CodigoColor.cLetrasTextField, this.tfName, this.tfSlogan, this.tfPhone1, this.tfPhone2, this.tfCorreoE, this.tfMision, tfVision,
                this.tfCorreoE, this.tfMision, this.tfVision, this.tfCodigoPostal, this.tfEstado, tfMunicipio, tfColonia, tfCalle, this.tfNumCasa);

        //configuracion JSeparator
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea10, this.linea18, this.linea19, this.linea11, this.linea3, this.linea4, this.linea5,
                this.linea6, this.linea12, this.linea13, this.linea14, this.linea15, this.linea16, this.linea17);

        //configuracion JButton
        Configuracion.robotoPlain14(this.btnCreate, this.btnUpdate, btnInsertImage);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCreate, this.btnUpdate, btnInsertImage);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCreate, this.btnUpdate, btnInsertImage);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSlogan = new javax.swing.JLabel();
        jPhone1 = new javax.swing.JLabel();
        jPhone2 = new javax.swing.JLabel();
        jCorreoE = new javax.swing.JLabel();
        jMision = new javax.swing.JLabel();
        jVision = new javax.swing.JLabel();
        tfSlogan = new javax.swing.JTextField();
        tfPhone1 = new javax.swing.JTextField();
        tfCorreoE = new javax.swing.JTextField();
        tfVision = new javax.swing.JTextField();
        jNumCasa = new javax.swing.JLabel();
        tfNumCasa = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        linea3 = new javax.swing.JSeparator();
        linea4 = new javax.swing.JSeparator();
        linea5 = new javax.swing.JSeparator();
        linea6 = new javax.swing.JSeparator();
        jlTitle = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        linea9 = new javax.swing.JSeparator();
        linea10 = new javax.swing.JSeparator();
        tfPhone2 = new javax.swing.JTextField();
        linea11 = new javax.swing.JSeparator();
        linea12 = new javax.swing.JSeparator();
        tfMision = new javax.swing.JTextField();
        jCodigoPostal = new javax.swing.JLabel();
        tfCodigoPostal = new javax.swing.JTextField();
        jEstado = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jMunicipio = new javax.swing.JLabel();
        tfMunicipio = new javax.swing.JTextField();
        tfColonia = new javax.swing.JTextField();
        jColonia = new javax.swing.JLabel();
        jCalle = new javax.swing.JLabel();
        tfCalle = new javax.swing.JTextField();
        linea13 = new javax.swing.JSeparator();
        linea14 = new javax.swing.JSeparator();
        linea15 = new javax.swing.JSeparator();
        linea16 = new javax.swing.JSeparator();
        linea17 = new javax.swing.JSeparator();
        linea18 = new javax.swing.JSeparator();
        linea19 = new javax.swing.JSeparator();
        btnInsertImage = new javax.swing.JButton();
        jlFileSelect = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jSlogan.setText("Slogan:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 51, 0, 0);
        add(jSlogan, gridBagConstraints);

        jPhone1.setText("Telefono 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 51, 0, 0);
        add(jPhone1, gridBagConstraints);

        jPhone2.setText("Telefono 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 53, 0, 0);
        add(jPhone2, gridBagConstraints);

        jCorreoE.setText("Correo electronico:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 51, 0, 0);
        add(jCorreoE, gridBagConstraints);

        jMision.setText("Misión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 51, 0, 0);
        add(jMision, gridBagConstraints);

        jVision.setText("Visión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 51, 0, 0);
        add(jVision, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfSlogan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfPhone1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfCorreoE, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfVision, gridBagConstraints);

        jNumCasa.setText("Número de casa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 51, 0, 0);
        add(jNumCasa, gridBagConstraints);

        tfNumCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumCasaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfNumCasa, gridBagConstraints);

        btnCreate.setText("Registrar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 31, 0);
        add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 33;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 37, 31, 0);
        add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea6, gridBagConstraints);

        jlTitle.setText("Datos de la Tienda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 71, 0, 0);
        add(jlTitle, gridBagConstraints);

        jlName.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 51, 0, 0);
        add(jlName, gridBagConstraints);

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 20);
        add(tfName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.ipadx = 454;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 46, 0, 46);
        add(linea10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 28);
        add(tfPhone2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfMision, gridBagConstraints);

        jCodigoPostal.setText("Código postal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 51, 0, 0);
        add(jCodigoPostal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfCodigoPostal, gridBagConstraints);

        jEstado.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 51, 0, 0);
        add(jEstado, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfEstado, gridBagConstraints);

        jMunicipio.setText("Municipio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 51, 0, 0);
        add(jMunicipio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfMunicipio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfColonia, gridBagConstraints);

        jColonia.setText("Colonia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 51, 0, 0);
        add(jColonia, gridBagConstraints);

        jCalle.setText("Calle:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 51, 0, 0);
        add(jCalle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(tfCalle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea18, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 46);
        add(linea19, gridBagConstraints);

        btnInsertImage.setText("Insertar logo");
        btnInsertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 0, 0);
        add(btnInsertImage, gridBagConstraints);

        jlFileSelect.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlFileSelect.setText("Aun no ha seleccionado ningun archivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.insets = new java.awt.Insets(10, 43, 10, 0);
        add(jlFileSelect, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void tfNumCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumCasaActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try
        {
            if (validarCadena(tfName.getText()) && validarCadena(tfSlogan.getText()) && validarTelefono(tfPhone1.getText()) && validarTelefono(tfPhone2.getText()) && validarEmail(tfCorreoE.getText()) && validarCadena(tfMision.getText()) && validarCadena(tfVision.getText()) && validarCodPostal(Integer.parseInt(tfCodigoPostal.getText())) && validarCadena(tfEstado.getText()) && validarCadena(tfMunicipio.getText()) && validarCadena(tfColonia.getText()) && validarCadena(tfCalle.getText()) && validarNumCasa(Integer.parseInt(tfNumCasa.getText())))
            {
                TiendaDAO.insertar(new Tienda(tfName.getText(), tfSlogan.getText(), tfPhone1.getText(), tfPhone2.getText(), tfCorreoE.getText(), tfMision.getText(), tfVision.getText(), Integer.parseInt(tfCodigoPostal.getText()), tfEstado.getText(), tfMunicipio.getText(), tfColonia.getText(), tfCalle.getText(), Integer.parseInt(tfNumCasa.getText())));
            } else
            {
                JOptionPane.showMessageDialog(null, "Verifica tus datos");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(EditInfoStore.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, verifica tus datos");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    public boolean validarEmail(String email) throws Exception {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (email.matches(regex))
        {
            return true;
        }
        throw new Exception("Formato de email incorrecto");
    }

    public boolean validarCadena(String c) throws Exception {
        if (!c.isEmpty())
        {
            return true;
        }
        throw new Exception("Campos vacios");
    }

    public boolean validarTelefono(String t) throws Exception {
        //forma correcta de un numero = +52-9511911329
        String regex = "^\\+\\d{1,3}-\\d{10}$";
        if (t.matches(regex))
        {
            return true;
        }
        throw new Exception("El telefono no cumple con el formato solicitado");
    }

    public boolean validarCodPostal(int codPostal) throws Exception {
        if (codPostal >= 0)
        {
            return true;
        }
        throw new Exception("El codigo postal no puede ser negativo");
    }

    public boolean validarNumCasa(int num) throws Exception {
        if (num > 0)
        {
            return true;
        }
        throw new Exception("El numero de casa no puede ser negativo");

    }

    private static JFileChooser personalizarVentana() {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(EditInfoStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser chooser = new JFileChooser();
        return chooser;
    }

    private static void regresarEstiloOriginal() {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            // Manejo de excepciones
        }
    }

    private void btnInsertImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertImageActionPerformed
        //Crear un JFileChooser
        JFileChooser chooser = personalizarVentana();
        //agregarIconoJFileChooser(chooser);
        //mostrarIconosFileChooser(chooser);
        //Crear filtro
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png, jpg", "png", "jpg");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            //se obtiene el archivo seleccionado
            File file = chooser.getSelectedFile();
            if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg"))
            {
                //obtenemos ruta absoluta
                ruta = file.getPath().replace('\\', '/');
                System.out.println("Archivo Seleccionado: " + ruta);

                BufferedImage imagen;
                try
                {
                    imagen = ImageIO.read(new File(ruta));
                    guardarImagen("src/main/resources/icono/logo.png", imagen);
                    System.out.println("La imagen fue creada exitosamente");
                } catch (IOException ex)
                {
                    Logger.getLogger(EditInfoStore.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Ocurrio un error al intentar crear la imagen");
                }
                this.jlFileSelect.setText(file.getName());
            } else
            {
                System.out.println("Error: El archivo selecconado no es una imagen. ");
            }
        }
        regresarEstiloOriginal();
        /*JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION)
        {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            // Aquí puedes hacer algo con el archivo seleccionado
        }*/

    }//GEN-LAST:event_btnInsertImageActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try
        {
            if (validarCadena(tfName.getText()) && validarCadena(tfSlogan.getText()) && validarTelefono(tfPhone1.getText()) && validarTelefono(tfPhone2.getText()) && validarEmail(tfCorreoE.getText()) && validarCadena(tfMision.getText()) && validarCadena(tfVision.getText()) && validarCodPostal(Integer.parseInt(tfCodigoPostal.getText())) && validarCadena(tfEstado.getText()) && validarCadena(tfMunicipio.getText()) && validarCadena(tfColonia.getText()) && validarCadena(tfCalle.getText()) && validarNumCasa(Integer.parseInt(tfNumCasa.getText())))
            {
                TiendaDAO.actualizar(new Tienda(tfName.getText(), tfSlogan.getText(), tfPhone1.getText(), tfPhone2.getText(), tfCorreoE.getText(), tfMision.getText(), tfVision.getText(), Integer.parseInt(tfCodigoPostal.getText()), tfEstado.getText(), tfMunicipio.getText(), tfColonia.getText(), tfCalle.getText(), Integer.parseInt(tfNumCasa.getText())));
            } else
            {
                JOptionPane.showMessageDialog(null, "Verifica tus datos");
            }
        } catch (Exception ex)
        {
            Logger.getLogger(EditInfoStore.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, verifica tus datos");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnInsertImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jCalle;
    private javax.swing.JLabel jCodigoPostal;
    private javax.swing.JLabel jColonia;
    private javax.swing.JLabel jCorreoE;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jMision;
    private javax.swing.JLabel jMunicipio;
    private javax.swing.JLabel jNumCasa;
    private javax.swing.JLabel jPhone1;
    private javax.swing.JLabel jPhone2;
    private javax.swing.JLabel jSlogan;
    private javax.swing.JLabel jVision;
    private javax.swing.JLabel jlFileSelect;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JSeparator linea10;
    private javax.swing.JSeparator linea11;
    private javax.swing.JSeparator linea12;
    private javax.swing.JSeparator linea13;
    private javax.swing.JSeparator linea14;
    private javax.swing.JSeparator linea15;
    private javax.swing.JSeparator linea16;
    private javax.swing.JSeparator linea17;
    private javax.swing.JSeparator linea18;
    private javax.swing.JSeparator linea19;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea9;
    private javax.swing.JTextField tfCalle;
    private javax.swing.JTextField tfCodigoPostal;
    private javax.swing.JTextField tfColonia;
    private javax.swing.JTextField tfCorreoE;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfMision;
    private javax.swing.JTextField tfMunicipio;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNumCasa;
    private javax.swing.JTextField tfPhone1;
    private javax.swing.JTextField tfPhone2;
    private javax.swing.JTextField tfSlogan;
    private javax.swing.JTextField tfVision;
    // End of variables declaration//GEN-END:variables
}
