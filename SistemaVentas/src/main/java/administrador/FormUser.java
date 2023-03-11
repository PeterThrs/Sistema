package administrador;

import configuracion.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.SpinnerNumberModel;

public class FormUser extends javax.swing.JDialog {

    private ButtonGroup groupRadioBtn;

    public FormUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        agregarEstilos();
        configuracion();
    }

    private void agregarEstilos() {
        this.setMinimumSize(new Dimension(550, 700));
        Configuracion.styles(this);
        Configuracion.titulo(this.jlTitle);
        Configuracion.normalItalic(this.jlAge, this.jlCol, this.jlCurp, this.jlEmail, this.jlHouseNumber, this.jlLastNameM,
                this.jlLastNameP, this.jlMun, this.jlName, this.jlPhone1, this.jlPhone2, this.jlPostalCode,
                this.jlRfc, this.jlSex, this.jlStreet, this.rbMan, this.rbWoman);
        Configuracion.normal(this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet);
        Configuracion.normal(this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.normal(this.rbMan, this.rbWoman);

        //Quitar el borde a los text Field
        Configuracion.borde(this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet, this.sAge);

        //configuracion para establecer el foreground
        //color azul fuerte
        Color color = new Color(29, 53, 87);
        Configuracion.foreground(color, this.jlAge, this.jlCol, this.jlCurp, this.jlEmail, this.jlHouseNumber, this.jlLastNameM,
                this.jlLastNameP, this.jlMun, this.jlName, this.jlPhone1, this.jlPhone2, this.jlPostalCode,
                this.jlRfc, this.jlSex, this.jlStreet);

        //color rojo fuerte
        color = new Color(230, 57, 70);
        Configuracion.foreground(color, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13);

        //color blanco crema
        color = new Color(241, 250, 238);
        Configuracion.background(color, this.panel, this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet, this.sAge, this.rbMan, this.rbWoman);
        Configuracion.foreground(color, this.btnCancel, this.btnCreate, this.btnUpdate);

        //color azul bajo
        color = new Color(168, 218, 220);
        //color azul intermedio
        color = new Color(69, 123, 157);
        Configuracion.background(color, this.btnCancel, this.btnCreate, this.btnUpdate);

    }

    private void configuracion() {
        agregarRadioBotones();
        confSpinner();
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
    }
    
    public static void main(String[] args) {
        FormUser vUser = new FormUser(new JFrame(), true);
        vUser.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setLayout(new java.awt.GridBagLayout());

        jlTitle.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(33, 54, 33, 54);
        panel.add(jlTitle, gridBagConstraints);

        jlName.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlName, gridBagConstraints);

        jlLastNameP.setText("Apellido Paterno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlLastNameP, gridBagConstraints);

        jlLastNameM.setText("Apellido Materno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlLastNameM, gridBagConstraints);

        jlEmail.setText("Correo Electronico: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlEmail, gridBagConstraints);

        jlPhone2.setText("Telefono 2: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlPhone2, gridBagConstraints);

        jlPhone1.setText("Telefono 1: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlPhone1, gridBagConstraints);

        jlAge.setText("Edad: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 2, 6);
        panel.add(jlAge, gridBagConstraints);

        jlCurp.setText("Curp: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlCurp, gridBagConstraints);

        jlSex.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 6, 6);
        panel.add(jlSex, gridBagConstraints);

        jlRfc.setText("RFC: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlRfc, gridBagConstraints);

        jlMun.setText("Municipio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlMun, gridBagConstraints);

        jlCol.setText("Colonia: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlCol, gridBagConstraints);

        jlStreet.setText("Calle: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlStreet, gridBagConstraints);

        jlHouseNumber.setText("Numero de Casa: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlHouseNumber, gridBagConstraints);

        jlPostalCode.setText("Codigo Postal: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(jlPostalCode, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfLastNameP, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfLastNameM, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfPhone1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfPhone2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfMun, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfCol, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfStreet, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfHouseNumber, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 2, 6);
        panel.add(sAge, gridBagConstraints);

        rbMan.setText("Hombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 6, 6);
        panel.add(rbMan, gridBagConstraints);

        rbWoman.setText("Mujer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 6, 6);
        panel.add(rbWoman, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfRfc, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfCurp, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 2, 6);
        panel.add(tfPostalCode, gridBagConstraints);

        btnCancel.setText("Regresar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 35);
        panel.add(btnCancel, gridBagConstraints);

        btnCreate.setText("Registrar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 35);
        panel.add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.insets = new java.awt.Insets(35, 35, 35, 35);
        panel.add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea13, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
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
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea7;
    private javax.swing.JSeparator linea8;
    private javax.swing.JSeparator linea9;
    private javax.swing.JPanel panel;
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
