package com.admin;

import javax.swing.JFrame;

import com.settings.CodigoColor;
import com.settings.Configuracion;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;

public class PanelUser extends javax.swing.JPanel {

    private Boolean update;
    private ButtonGroup groupRadioBtn;

    public PanelUser() {
        initComponents();
        agregarEstilos();
        configuracion();
    }

    private void agregarEstilos() {

        //configuraciones del panel
        Configuracion.background(CodigoColor.cFondoGris, this);

        //configuraciones de los JLabel
        //titulo
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul,this.jlTitle);
        Configuracion.robotoBold20(this.jlTitle);
        //demas datos
        Configuracion.robotoItalic14(this.jlAge, this.jlCol, this.jlCurp, this.jlEmail, this.jlHouseNumber, this.jlLastNameM,
                this.jlLastNameP, this.jlMun, this.jlName, this.jlPhone1, this.jlPhone2, this.jlPostalCode,
                this.jlRfc, this.jlSex, this.jlStreet);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlAge, this.jlCol, this.jlCurp, this.jlEmail, this.jlHouseNumber, this.jlLastNameM,
                this.jlLastNameP, this.jlMun, this.jlName, this.jlPhone1, this.jlPhone2, this.jlPostalCode,
                this.jlRfc, this.jlSex, this.jlStreet);

        //configuraciones de los JTextField
        Configuracion.robotoPlain12(this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet);
        Configuracion.withoutBorde(this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet);
        Configuracion.background(CodigoColor.cFondoGris, this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet);

        //configuraciones de los botones
        Configuracion.robotoItalic14(this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCancel, this.btnCreate, this.btnUpdate);
        this.btnCancel.setBackground(CodigoColor.cFondoBtnAzul);

        //configurciones del JSpinner
        //configuraciones del JRadioButton
        Configuracion.robotoItalic14(this.rbMan, this.rbWoman);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.rbMan, this.rbWoman);
        Configuracion.background(CodigoColor.cFondoGris, this.rbMan, this.rbWoman);

        //configuraciones de los jSeparator
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13, this.linea14, this.linea15);
        Configuracion.background(CodigoColor.cFondoGris, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13, this.linea14,
                 this.linea15);

    }

    private void configuracion() {
        agregarRadioBotones();
        confSpinner();
        estadoBtnUpdate();
    }

    private void agregarRadioBotones() {
        try {
            groupRadioBtn = new ButtonGroup();
            groupRadioBtn.add(this.rbMan);
            groupRadioBtn.add(this.rbWoman);
        } catch (Exception ex) {

        }
    }

    private void confSpinner() {
        SpinnerNumberModel snm = new SpinnerNumberModel(18, 18, 100, 1);
        this.sAge.setModel(snm);
        this.sAge.getEditor().getComponent(0).setForeground(CodigoColor.cLetrasNegro);
        this.sAge.getEditor().getComponent(0).setBackground(CodigoColor.cFondoGris);
    }

    private void estadoBtnUpdate() {
        try {
            System.out.println(this.update);
            if (this.update) {
                this.btnUpdate.setEnabled(true);
            } else {
                this.btnUpdate.setEnabled(false);
            }
        } catch (Exception ex) {

        }
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jlName = new javax.swing.JLabel();
        jlLastNameP = new javax.swing.JLabel();
        jlLastNameM = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlPhone2 = new javax.swing.JLabel();
        jlPhone1 = new javax.swing.JLabel();
        jlAge = new javax.swing.JLabel();
        jlCurp = new javax.swing.JLabel();
        jlSex = new javax.swing.JLabel();
        jlRfc = new javax.swing.JLabel();
        jlMun = new javax.swing.JLabel();
        jlCol = new javax.swing.JLabel();
        jlStreet = new javax.swing.JLabel();
        jlHouseNumber = new javax.swing.JLabel();
        jlPostalCode = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfLastNameP = new javax.swing.JTextField();
        tfLastNameM = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfPhone1 = new javax.swing.JTextField();
        tfPhone2 = new javax.swing.JTextField();
        tfMun = new javax.swing.JTextField();
        tfCol = new javax.swing.JTextField();
        tfStreet = new javax.swing.JTextField();
        tfHouseNumber = new javax.swing.JTextField();
        sAge = new javax.swing.JSpinner();
        rbMan = new javax.swing.JRadioButton();
        rbWoman = new javax.swing.JRadioButton();
        tfRfc = new javax.swing.JTextField();
        tfCurp = new javax.swing.JTextField();
        tfPostalCode = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        linea1 = new javax.swing.JSeparator();
        linea2 = new javax.swing.JSeparator();
        linea3 = new javax.swing.JSeparator();
        linea4 = new javax.swing.JSeparator();
        linea5 = new javax.swing.JSeparator();
        linea6 = new javax.swing.JSeparator();
        linea7 = new javax.swing.JSeparator();
        linea8 = new javax.swing.JSeparator();
        linea9 = new javax.swing.JSeparator();
        linea10 = new javax.swing.JSeparator();
        linea11 = new javax.swing.JSeparator();
        linea12 = new javax.swing.JSeparator();
        linea13 = new javax.swing.JSeparator();
        linea14 = new javax.swing.JSeparator();
        jlTitle = new javax.swing.JLabel();
        linea15 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jlName.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlName, gridBagConstraints);

        jlLastNameP.setText("Apellido Paterno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlLastNameP, gridBagConstraints);

        jlLastNameM.setText("Apellido Materno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlLastNameM, gridBagConstraints);

        jlEmail.setText("Correo Electronico: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlEmail, gridBagConstraints);

        jlPhone2.setText("Telefono 2: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlPhone2, gridBagConstraints);

        jlPhone1.setText("Telefono 1: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlPhone1, gridBagConstraints);

        jlAge.setText("Edad: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlAge, gridBagConstraints);

        jlCurp.setText("CURP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlCurp, gridBagConstraints);

        jlSex.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlSex, gridBagConstraints);

        jlRfc.setText("RFC: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlRfc, gridBagConstraints);

        jlMun.setText("Municipio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlMun, gridBagConstraints);

        jlCol.setText("Colonia: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlCol, gridBagConstraints);

        jlStreet.setText("Calle: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlStreet, gridBagConstraints);

        jlHouseNumber.setText("Numero de Casa: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlHouseNumber, gridBagConstraints);

        jlPostalCode.setText("Codigo Postal: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlPostalCode, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfLastNameP, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfLastNameM, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfPhone1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfPhone2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfMun, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfCol, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfStreet, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfHouseNumber, gridBagConstraints);

        sAge.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(sAge, gridBagConstraints);

        rbMan.setText("Hombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(rbMan, gridBagConstraints);

        rbWoman.setText("Mujer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(rbWoman, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfRfc, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfCurp, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfPostalCode, gridBagConstraints);

        btnCancel.setText("Eliminar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 22, 22, 22);
        add(btnCancel, gridBagConstraints);

        btnCreate.setText("Registrar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 22, 22, 22);
        add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 22, 22, 22);
        add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(linea10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea14, gridBagConstraints);

        jlTitle.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 20, 5);
        add(jlTitle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(linea15, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            FormCreateUser createUser = new FormCreateUser(new JFrame(), true);
            createUser.setVisible(true);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jlAge;
    private javax.swing.JLabel jlCol;
    private javax.swing.JLabel jlCurp;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlHouseNumber;
    private javax.swing.JLabel jlLastNameM;
    private javax.swing.JLabel jlLastNameP;
    private javax.swing.JLabel jlMun;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlPhone1;
    private javax.swing.JLabel jlPhone2;
    private javax.swing.JLabel jlPostalCode;
    private javax.swing.JLabel jlRfc;
    private javax.swing.JLabel jlSex;
    private javax.swing.JLabel jlStreet;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea10;
    private javax.swing.JSeparator linea11;
    private javax.swing.JSeparator linea12;
    private javax.swing.JSeparator linea13;
    private javax.swing.JSeparator linea14;
    private javax.swing.JSeparator linea15;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea7;
    private javax.swing.JSeparator linea8;
    private javax.swing.JSeparator linea9;
    private javax.swing.JRadioButton rbMan;
    private javax.swing.JRadioButton rbWoman;
    private javax.swing.JSpinner sAge;
    private javax.swing.JTextField tfCol;
    private javax.swing.JTextField tfCurp;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfHouseNumber;
    private javax.swing.JTextField tfLastNameM;
    private javax.swing.JTextField tfLastNameP;
    private javax.swing.JTextField tfMun;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhone1;
    private javax.swing.JTextField tfPhone2;
    private javax.swing.JTextField tfPostalCode;
    private javax.swing.JTextField tfRfc;
    private javax.swing.JTextField tfStreet;
    // End of variables declaration//GEN-END:variables
}
