package com.admin;

import com.classes.Tienda;
import com.conexion.TiendaDAO;
import com.settings.CodigoColor;
import com.settings.Configuracion;
import com.settings.ObjGraficosService;
import static com.settings.ObjGraficosService.personalizarVentana;
import com.settings.Recursos;
import com.settings.Validaciones;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juanj
 */
public class EditInfoStore extends javax.swing.JPanel {

    private String ruta;
    private ObjGraficosService oGraficos; 
    private Validaciones validacion;
    
    public EditInfoStore() {
        initComponents();
        oGraficos = ObjGraficosService.getService();
        validacion = Validaciones.getValidacion();
        agregarEstilos();
        rellenarDatos();
        jlFileSelect.setText(Recursos.obtenerNombreArchivo("src/main/resources/icono") != null ? "logo.png" : "");
        jlFileSelect.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void rellenarDatos() {
        Tienda tienda = TiendaDAO.traerUltimo();
        if (tienda != null)
        {
            tfName.setText(tienda.getNombre());
            tfSlogan.setText(tienda.getSlogan());
            tfPhone1.setText("+52-"+tienda.getTelefono1());
            tfPhone2.setText("+52-"+tienda.getTelefono2());
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
        Configuracion.background(CodigoColor.cFondoBlanco, this);

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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 220, 0, 0);
        add(jSlogan, gridBagConstraints);

        jPhone1.setText("Telefono 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 220, 0, 0);
        add(jPhone1, gridBagConstraints);

        jPhone2.setText("Telefono 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(7, 221, 0, 0);
        add(jPhone2, gridBagConstraints);

        jCorreoE.setText("Correo electronico:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jCorreoE, gridBagConstraints);

        jMision.setText("Misión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jMision, gridBagConstraints);

        jVision.setText("Visión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jVision, gridBagConstraints);

        tfSlogan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSloganActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 114;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(tfSlogan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 19, 0, 0);
        add(tfPhone1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 114;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(tfCorreoE, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 89;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 294;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(tfVision, gridBagConstraints);

        jNumCasa.setText("Número de casa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 48;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jNumCasa, gridBagConstraints);

        tfNumCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumCasaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 48;
        gridBagConstraints.gridwidth = 115;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 180);
        add(tfNumCasa, gridBagConstraints);

        btnCreate.setText("Registrar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 54;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 1, 0, 0);
        add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 65;
        gridBagConstraints.gridy = 54;
        gridBagConstraints.gridwidth = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 13, 0, 0);
        add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 87;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 340;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea6, gridBagConstraints);

        jlTitle.setText("Datos de la Tienda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 13, 0, 0);
        add(jlTitle, gridBagConstraints);

        jlName.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jlName, gridBagConstraints);

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 115;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 180);
        add(tfName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 113;
        gridBagConstraints.ipadx = 479;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 220, 0, 0);
        add(linea10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(tfPhone2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 9, 0, 0);
        add(linea11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 90;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 296;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(tfMision, gridBagConstraints);

        jCodigoPostal.setText("Código postal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jCodigoPostal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 114;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(tfCodigoPostal, gridBagConstraints);

        jEstado.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jEstado, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.gridwidth = 115;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 180);
        add(tfEstado, gridBagConstraints);

        jMunicipio.setText("Municipio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 36;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jMunicipio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 36;
        gridBagConstraints.gridwidth = 115;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 180);
        add(tfMunicipio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 40;
        gridBagConstraints.gridwidth = 115;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 180);
        add(tfColonia, gridBagConstraints);

        jColonia.setText("Colonia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 40;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jColonia, gridBagConstraints);

        jCalle.setText("Calle:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 220, 0, 0);
        add(jCalle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 44;
        gridBagConstraints.gridwidth = 115;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 298;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 180);
        add(tfCalle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 33;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 37;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 41;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 45;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 49;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea18, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 88;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 343;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 0);
        add(linea19, gridBagConstraints);

        btnInsertImage.setText("Insertar logo");
        btnInsertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 36;
        gridBagConstraints.gridy = 52;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 23, 0, 0);
        add(btnInsertImage, gridBagConstraints);

        jlFileSelect.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlFileSelect.setText("Aun no ha seleccionado ningun archivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 53;
        gridBagConstraints.gridwidth = 43;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 39, 0, 0);
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
            if (validacion.validarCadena(tfName.getText()) && validacion.validarCadena(tfSlogan.getText()) && validacion.validarTelefono(tfPhone1.getText()) && validacion.validarTelefono(tfPhone2.getText()) && validacion.validarEmail(tfCorreoE.getText()) && validacion.validarCadena(tfMision.getText()) && validacion.validarCadena(tfVision.getText()) && validacion.validarCodPostal(Integer.parseInt(tfCodigoPostal.getText())) && validacion.validarCadena(tfEstado.getText()) && validacion.validarCadena(tfMunicipio.getText()) && validacion.validarCadena(tfColonia.getText()) && validacion.validarCadena(tfCalle.getText()) && validacion.validarNumCasa(Integer.parseInt(tfNumCasa.getText())))
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
                    oGraficos.guardarImagen("src/main/resources/icono/logo.png", imagen);
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
            if (validacion.validarCadena(tfName.getText()) && validacion.validarCadena(tfSlogan.getText()) && validacion.validarTelefono(tfPhone1.getText()) && validacion.validarTelefono(tfPhone2.getText()) && validacion.validarEmail(tfCorreoE.getText()) && validacion.validarCadena(tfMision.getText()) && validacion.validarCadena(tfVision.getText()) && validacion.validarCodPostal(Integer.parseInt(tfCodigoPostal.getText())) && validacion.validarCadena(tfEstado.getText()) && validacion.validarCadena(tfMunicipio.getText()) && validacion.validarCadena(tfColonia.getText()) && validacion.validarCadena(tfCalle.getText()) && validacion.validarNumCasa(Integer.parseInt(tfNumCasa.getText())))
            {
                TiendaDAO.actualizar(new Tienda(1,tfName.getText(), tfSlogan.getText(), tfPhone1.getText(), tfPhone2.getText(), tfCorreoE.getText(), tfMision.getText(), tfVision.getText(), Integer.parseInt(tfCodigoPostal.getText()), tfEstado.getText(), tfMunicipio.getText(), tfColonia.getText(), tfCalle.getText(), Integer.parseInt(tfNumCasa.getText())));
                JOptionPane.showMessageDialog(null, "Se actualizaron los datos de la tienda correctamente!");
            } else
            {
                JOptionPane.showMessageDialog(null, "Verifica tus datos");
            }
        } catch (Exception ex)
        {
            //Logger.getLogger(EditInfoStore.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, verifica tus datos");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tfSloganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSloganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSloganActionPerformed

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
