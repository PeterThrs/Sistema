package com.admin;

import com.classes.Persona;
import com.classes.Rol;
import com.classes.Usuario;
import com.conexion.PersonaDao;
import com.conexion.RolDAO;
import com.conexion.UsuarioDao;
import com.settings.CodigoColor;
import com.settings.Configuracion;
import com.settings.ObjGraficosService;
import static com.settings.ObjGraficosService.personalizarVentana;
import com.settings.Validaciones;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelUserNew extends javax.swing.JPanel {

    //Datos del Form
    private String nombre, aPaterno, aMaterno, email, telefono1, telefono2, curp, rfc, sexo, estado, municipio, colonia, calle, nomUsuario, contrasenia, confirmacion;
    private int idPersona, edad, codigoPostal, numCasa, idUsuario, idRol, longitudBytes;
    //atributos para modificar la BD
    private Persona persona;
    private PersonaDao personaDao;
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private ButtonGroup groupRadioBtn;
    private Validaciones validar;
    private String ruta;
    private boolean actualizar;
    private ObjGraficosService oGraficos;
    private Validaciones validacion;
    private FileInputStream archivoo;

    public PanelUserNew() {
        this.actualizar = false;
        instancias();
        initComponents();
        agregarEstilos();
        configuracion();

    }

    public void instancias() {
        this.persona = new Persona();
        this.usuario = new Usuario();
        this.personaDao = new PersonaDao();
        this.usuarioDao = new UsuarioDao();
        this.validar = Validaciones.getValidacion();
        this.oGraficos = ObjGraficosService.getService();
        this.validacion = Validaciones.getValidacion();
        this.archivoo = null;
    }

    public PanelUserNew(Usuario usuario, Persona persona) {
        this.usuario = usuario;
        this.persona = persona;
        this.actualizar = true;
        this.personaDao = new PersonaDao();
        this.usuarioDao = new UsuarioDao();

        initComponents();
        agregarEstilos();
        configuracion();

        cargarDatos();
        accionBtnActualizar();
        accionBtnEliminar();

    }

    private void configuracion() {
        agregarRadioBotones();
        modeloComboBox();
        checkBoxItemListened();
        accionBtnCreate();
        verificarEstado();
    }

    private void agregarEstilos() {
        //configuraciones del panel
        Configuracion.background(CodigoColor.cFondoBlanco, this);

        //configuraciones de los JLabel
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jlTitle);
        Configuracion.robotoBold20(this.jlTitle);
        Configuracion.robotoPlain14(this.jlAge, this.jlCol, this.jlCurp, this.jlEmail, this.jlHouseNumber, this.jlLastNameM,
                this.jlLastNameP, this.jlMun, this.jlName, this.jlPhone1, this.jlPhone2, this.jlPostalCode,
                this.jlRfc, this.jlSex, this.jlStreet, this.jlRol, this.jlUser, this.jlPassword, this.jlSubtitulo,
                this.jlSecondApart, this.jlConfirm, this.jlState);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlAge, this.jlCol, this.jlCurp, this.jlEmail, this.jlHouseNumber, this.jlLastNameM,
                this.jlLastNameP, this.jlMun, this.jlName, this.jlPhone1, this.jlPhone2, this.jlPostalCode,
                this.jlRfc, this.jlSex, this.jlStreet, this.jlRol, this.jlUser, this.jlPassword, this.jlSubtitulo,
                this.jlSecondApart, this.jlConfirm, this.jlState);

        //configuraciones de los JTextField
        Configuracion.robotoPlain14(this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet, this.tfConfirm, this.tfPassword, this.tfUser, this.tfEdad, this.tfState);
        Configuracion.withoutBorde(this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet, this.tfConfirm, this.tfPassword, this.tfUser, this.tfEdad, this.tfState);
        Configuracion.background(CodigoColor.cFondoGris, this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet, this.tfConfirm, this.tfPassword, this.tfUser, this.tfEdad, this.tfState);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.tfCol, this.tfCurp, this.tfEmail, this.tfHouseNumber, this.tfLastNameM,
                this.tfLastNameP, this.tfMun, this.tfName, this.tfPhone1, this.tfPhone2, this.tfPostalCode, this.tfRfc,
                this.tfStreet, this.tfConfirm, this.tfPassword, this.tfUser, this.tfEdad, this.tfState);

        //configuraciones de los botones
        Configuracion.robotoPlain14(this.btnCancel, this.btnCreate, this.btnUpdate, this.btnInsertImage);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCancel, this.btnCreate, this.btnUpdate, this.btnInsertImage);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCancel, this.btnCreate, this.btnUpdate, this.btnInsertImage);
        this.btnCancel.setBackground(CodigoColor.cFondoBtnAzul);

        //configuraciones del JRadioButton
        Configuracion.robotoPlain14(this.rbMan, this.rbWoman);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.rbMan, this.rbWoman);
        Configuracion.background(CodigoColor.cFondoGris, this.rbMan, this.rbWoman);

        //Configuracion JCheckBox
        Configuracion.robotoPlain14(this.cbSendEmail);
        Configuracion.withoutBorde(this.cbSendEmail);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbSendEmail);
        Configuracion.background(CodigoColor.cFondoGris, this.cbSendEmail);

        //Configuracion jComboBox
        Configuracion.robotoPlain14(this.cbRol);

        //configuraciones de los jSeparator
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13, this.linea14,
                this.linea17, this.linea18, this.linea19, this.linea20, this.linea21);
        Configuracion.foreground(CodigoColor.cFondoBtnAzul, this.linea15, this.linea16);
        Configuracion.background(CodigoColor.cFondoGris, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13, this.linea14,
                this.linea15, this.linea16, this.linea17, this.linea18, this.linea19, this.linea20, this.linea21);

    }

    private void verificarEstado() {
        if (this.actualizar)
        {
            this.btnCreate.setEnabled(false);
            this.btnUpdate.setEnabled(true);
            this.btnCancel.setEnabled(true);
        } else
        {
            this.btnUpdate.setEnabled(false);
            this.btnCreate.setEnabled(true);
            this.btnCancel.setEnabled(false);
        }
    }

    private void agregarRadioBotones() {
        try
        {
            groupRadioBtn = new ButtonGroup();
            groupRadioBtn.add(this.rbMan);
            groupRadioBtn.add(this.rbWoman);
            rbMan.setSelected(true);
        } catch (Exception ex)
        {

        }
    }

    private void modeloComboBox() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        List<Rol> roles = RolDAO.seleccionar();
        roles.forEach(rol
                ->
        {
            dcbm.addElement(rol.getNombre());
        });
        this.cbRol.setModel(dcbm);
        this.cbRol.getEditor().getEditorComponent().setForeground(CodigoColor.cLetrasNegro);
        this.cbRol.getEditor().getEditorComponent().setBackground(CodigoColor.cFondoGris);
        this.cbRol.setSelectedIndex(1);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbRol);
        Configuracion.background(CodigoColor.cFondoGris, this.cbRol);
    }

    private void checkBoxItemListened() {
        this.cbSendEmail.addItemListener(e
                ->
        {
            if (this.cbSendEmail.isSelected())
            {
                System.out.println("Enviamos un mensaje al correo del usuario");
            } else
            {
                System.out.println("No se envia nada al email del usuario");
            }
        });
    }

    public boolean validarFomr() throws NumberFormatException, Exception {

        if (validar.validarCadena(this.nombre) && validar.validarCadena(this.aPaterno)
                && validar.validarCadena(this.aMaterno) && validar.validarEmail(this.email)
                && validar.validarTelefono(this.telefono1) && validar.validarTelefono(this.telefono2)
                && validar.validarEdad(this.edad) && validar.validarCadena(curp) && validar.validarCadena(this.rfc)
                && validar.validarCadena(this.sexo) && validar.validarCodPostal(this.codigoPostal)
                && validar.validarCadena(this.estado) && validar.validarCadena(this.municipio)
                && validar.validarCadena(this.colonia) && validar.validarCadena(this.calle)
                && validar.validarNumCasa(this.numCasa) && validar.validarCadena(nomUsuario)
                && validar.validarContrasenia(this.contrasenia, this.contrasenia, this.confirmacion) && idRol > 0 && archivoo!=null)
        {

            this.persona.setNombre(this.nombre);
            this.persona.setApellidoPaterno(this.aPaterno);
            this.persona.setApellidoMaterno(this.aMaterno);
            this.persona.setEmail(this.email);
            this.persona.setTelefono1(this.telefono1);
            this.persona.setTelefono2(this.telefono2);
            this.persona.setEdad(this.edad);
            this.persona.setCurp(this.curp);
            this.persona.setRFC(this.rfc);
            this.persona.setSexo(this.sexo);
            this.persona.setCodigoPostal(this.codigoPostal);
            this.persona.setEstado(this.estado);
            this.persona.setMunicipio(this.municipio);
            this.persona.setColonia(this.colonia);
            this.persona.setCalle(this.calle);
            this.persona.setNumCasa(this.numCasa);

            this.usuario.setImagen(archivoo);
            this.usuario.setNomUsuario(this.nomUsuario);
            this.usuario.setContrasenia(this.contrasenia);
            this.usuario.setIdRol(this.idRol);

        } else
        {
            JOptionPane.showMessageDialog(null, "Faltan campos por completar");
        }
        return false;
    }

    public void recuperarDatos() throws NumberFormatException {
        //datos de una persona
        this.nombre = this.tfName.getText();
        this.aPaterno = this.tfLastNameP.getText();
        this.aMaterno = this.tfLastNameM.getText();
        this.email = this.tfEmail.getText();
        this.telefono1 = this.tfPhone1.getText();
        this.telefono2 = this.tfPhone2.getText();
        this.edad = parse(this.tfEdad.getText());
        this.curp = this.tfCurp.getText();
        this.rfc = this.tfRfc.getText();
        this.sexo = recuperarSexo();
        this.codigoPostal = parse(this.tfPostalCode.getText());
        this.estado = this.tfState.getText();
        this.municipio = this.tfMun.getText();
        this.colonia = this.tfCol.getText();
        this.calle = this.tfStreet.getText();
        this.numCasa = parse(tfHouseNumber.getText());

        //datos de usuario
        this.nomUsuario = this.tfUser.getText();
        this.contrasenia = String.valueOf(this.tfPassword.getPassword());
        this.confirmacion = String.valueOf(this.tfConfirm.getPassword());
        this.idRol = this.cbRol.getSelectedIndex() + 1;

    }

    public String recuperarSexo() {
        return (this.rbMan.isSelected()) ? "H" : (this.rbWoman.isSelected()) ? "M" : "";
    }

    public int parse(String n) throws NumberFormatException {
        int num = Integer.parseInt(n);
        return num;
    }

    public void accionBtnCreate() {
        btnCreate.addActionListener(e ->
        {
            try
            {

                recuperarDatos();
                validarFomr();
                //insertamos primero la persona
                int registro = personaDao.insertar(persona);

                if (registro > 0)
                {
                    //recuperamos el idPersona
                    List<Persona> lista = this.personaDao.seleccionar();
                    persona = lista.get(lista.size() - 1);
                    idPersona = persona.getIdPersona();

                    usuario.setIdPersona(idPersona);

                    int reg = UsuarioDao.insertar(usuario, longitudBytes);

                    if (reg > 0)
                    {
                        limpiarForm();
                        JOptionPane.showMessageDialog(null, "Se ha logrado insertar los datos correctamente");
                    }

                }

            } catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });
    }

    //cargar datos de la bd en los campos
    public void cargarDatos() {
        //cargamos los datos de la persona
        this.tfName.setText(this.persona.getNombre());
        this.tfLastNameM.setText(this.persona.getApellidoMaterno());
        this.tfLastNameP.setText(this.persona.getApellidoPaterno());
        this.tfEmail.setText(this.persona.getEmail());
        this.tfPhone1.setText(this.persona.getTelefono1());
        this.tfPhone2.setText(this.persona.getTelefono2());
        this.tfEdad.setText(String.valueOf(this.persona.getEdad()));
        this.tfCurp.setText(this.persona.getCurp());
        this.tfRfc.setText(this.persona.getRFC());
        if (this.persona.getSexo().equals("M"))
        {
            this.rbMan.setSelected(true);
            this.rbWoman.setSelected(false);
        } else
        {
            this.rbMan.setSelected(false);
            this.rbWoman.setSelected(true);
        }
        this.tfPostalCode.setText(String.valueOf(persona.getCodigoPostal()));
        this.tfState.setText(this.persona.getEstado());
        this.tfMun.setText(this.persona.getMunicipio());
        this.tfCol.setText(this.persona.getColonia());
        this.tfStreet.setText(this.persona.getCalle());
        this.tfHouseNumber.setText(String.valueOf(this.persona.getNumCasa()));

        //cargamos los datos del usuario
        this.tfUser.setText(this.usuario.getNomUsuario());
        this.tfPassword.setText(this.usuario.getContrasenia());
        this.tfConfirm.setText(this.usuario.getContrasenia());
        this.cbRol.setSelectedIndex(this.usuario.getIdRol() - 1);

    }

    public void limpiarForm() {
        //cargamos los datos de la persona
        this.tfName.setText("");
        this.tfLastNameM.setText("");
        this.tfLastNameP.setText("");
        this.tfEmail.setText("");
        this.tfPhone1.setText("");
        this.tfPhone2.setText("");
        this.tfEdad.setText("");
        this.tfCurp.setText("");
        this.tfRfc.setText("");
        this.rbMan.setSelected(true);
        this.tfPostalCode.setText("");
        this.tfState.setText("");
        this.tfMun.setText("");
        this.tfCol.setText("");
        this.tfStreet.setText("");
        this.tfHouseNumber.setText("");

        //cargamos los datos del usuario
        this.tfUser.setText("");
        this.tfPassword.setText("");
        this.tfConfirm.setText("");
        this.cbRol.setSelectedIndex(1);

    }

    public void accionBtnActualizar() {
        this.btnUpdate.addActionListener(e ->
        {
            try
            {
                recuperarDatos();
                validarFomr();

                int regPersona = personaDao.actualizar(persona);
                int regUsuario = usuarioDao.actualizar(usuario,longitudBytes);
                if (regPersona > 0 && regUsuario > 0)
                {
                    limpiarForm();
                    JOptionPane.showMessageDialog(null, "Se ha logrado insertar los datos correctamente");
                }

            } catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }

    public void accionBtnEliminar() {
        this.btnCancel.addActionListener(e ->
        {
            try
            {
                recuperarDatos();
                validarFomr();

                int regPersona = personaDao.eliminar(persona);
                int regUsuario = usuarioDao.eliminar(usuario);
                limpiarForm();
                if (regPersona > 0 && regUsuario > 0)
                {
                    JOptionPane.showMessageDialog(null, "Se han eliminado los datos correctamente");
                }

            } catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jlTitle = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
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
        tfLastNameP = new javax.swing.JTextField();
        tfLastNameM = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfPhone1 = new javax.swing.JTextField();
        tfPhone2 = new javax.swing.JTextField();
        tfMun = new javax.swing.JTextField();
        tfCol = new javax.swing.JTextField();
        tfStreet = new javax.swing.JTextField();
        tfHouseNumber = new javax.swing.JTextField();
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
        linea15 = new javax.swing.JSeparator();
        linea16 = new javax.swing.JSeparator();
        jlRol = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        jlUser = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jlPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        jlConfirm = new javax.swing.JLabel();
        tfConfirm = new javax.swing.JPasswordField();
        cbSendEmail = new javax.swing.JCheckBox();
        jlSubtitulo = new javax.swing.JLabel();
        jlSecondApart = new javax.swing.JLabel();
        linea17 = new javax.swing.JSeparator();
        linea18 = new javax.swing.JSeparator();
        linea19 = new javax.swing.JSeparator();
        linea20 = new javax.swing.JSeparator();
        tfEdad = new javax.swing.JTextField();
        jlState = new javax.swing.JLabel();
        tfState = new javax.swing.JTextField();
        linea21 = new javax.swing.JSeparator();
        btnInsertImage = new javax.swing.JButton();
        jlFileSelect = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jlTitle.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        add(jlTitle, gridBagConstraints);

        jlName.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 0, 5);
        add(jlName, gridBagConstraints);

        tfName.setText("Paco");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfName, gridBagConstraints);

        jlLastNameP.setText("Apellido Paterno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlLastNameP, gridBagConstraints);

        jlLastNameM.setText("Apellido Materno: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 0, 5);
        add(jlLastNameM, gridBagConstraints);

        jlEmail.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlEmail, gridBagConstraints);

        jlPhone2.setText("Telefono 2: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlPhone2, gridBagConstraints);

        jlPhone1.setText("Telefono 1: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 0, 5);
        add(jlPhone1, gridBagConstraints);

        jlAge.setText("Edad: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlAge, gridBagConstraints);

        jlCurp.setText("CURP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlCurp, gridBagConstraints);

        jlSex.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlSex, gridBagConstraints);

        jlRfc.setText("RFC: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlRfc, gridBagConstraints);

        jlMun.setText("Municipio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlMun, gridBagConstraints);

        jlCol.setText("Colonia: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlCol, gridBagConstraints);

        jlStreet.setText("Calle: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlStreet, gridBagConstraints);

        jlHouseNumber.setText("Numero de Casa: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlHouseNumber, gridBagConstraints);

        jlPostalCode.setText("Codigo Postal: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlPostalCode, gridBagConstraints);

        tfLastNameP.setText("Martinez");
        tfLastNameP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastNamePActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfLastNameP, gridBagConstraints);

        tfLastNameM.setText("Martinez");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfLastNameM, gridBagConstraints);

        tfEmail.setText("pmartinez@gmail.com");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfEmail, gridBagConstraints);

        tfPhone1.setText("+52-9511911329");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfPhone1, gridBagConstraints);

        tfPhone2.setText("+521-8889991212");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfPhone2, gridBagConstraints);

        tfMun.setText("Oaxaca de Juarez");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfMun, gridBagConstraints);

        tfCol.setText("Estado de Oaxaca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfCol, gridBagConstraints);

        tfStreet.setText("Av. Independencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfStreet, gridBagConstraints);

        tfHouseNumber.setText("120");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfHouseNumber, gridBagConstraints);

        rbMan.setText("Hombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        add(rbMan, gridBagConstraints);

        rbWoman.setText("Mujer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 12;
        add(rbWoman, gridBagConstraints);

        tfRfc.setText("HCOEPARUI1010");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfRfc, gridBagConstraints);

        tfCurp.setText("LOHP030617HOCPRDA3");
        tfCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCurpActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfCurp, gridBagConstraints);

        tfPostalCode.setText("68000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfPostalCode, gridBagConstraints);

        btnCancel.setText("Eliminar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 114, 22, 114);
        add(btnCancel, gridBagConstraints);

        btnCreate.setText("Registrar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(14, 17, 17, 17);
        add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Modificar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 31;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 68, 13, 96);
        add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 12, 12);
        add(linea15, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(linea16, gridBagConstraints);

        jlRol.setText("Rol: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        add(jlRol, gridBagConstraints);

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRol.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(cbRol, gridBagConstraints);

        jlUser.setText("Usuario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlUser, gridBagConstraints);

        tfUser.setText("Thrs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfUser, gridBagConstraints);

        jlPassword.setText("Contraseña: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jlPassword, gridBagConstraints);

        tfPassword.setText("Password1@");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfPassword, gridBagConstraints);

        jlConfirm.setText("Confirmar: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 0);
        add(jlConfirm, gridBagConstraints);

        tfConfirm.setText("Password1@");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfConfirm, gridBagConstraints);

        cbSendEmail.setText("Enviar Información a Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.insets = new java.awt.Insets(17, 17, 17, 17);
        add(cbSendEmail, gridBagConstraints);

        jlSubtitulo.setText("Informacion General");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jlSubtitulo, gridBagConstraints);

        jlSecondApart.setText("Asignacion de Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jlSecondApart, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea18, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea19, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea20, gridBagConstraints);

        tfEdad.setText("20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 20);
        add(tfEdad, gridBagConstraints);

        jlState.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 5);
        add(jlState, gridBagConstraints);

        tfState.setText("Oaxaca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(tfState, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        add(linea21, gridBagConstraints);

        btnInsertImage.setText("Insertar foto");
        btnInsertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 5, 0, 0);
        add(btnInsertImage, gridBagConstraints);

        jlFileSelect.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlFileSelect.setText("Aun no ha seleccionado ningun archivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.gridwidth = 43;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 150, 10, 0);
        add(jlFileSelect, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tfLastNamePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastNamePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLastNamePActionPerformed

    private void tfCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCurpActionPerformed

    private void btnInsertImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertImageActionPerformed
        //Crear un JFileChooser
        JFileChooser chooser = personalizarVentana();
        //Crear filtro
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png, jpg", "png", "jpg");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg"))
            {
                try
                {
                    //se obtiene el archivo seleccionado
                    archivoo = new FileInputStream(chooser.getSelectedFile());
                    this.longitudBytes = (int) chooser.getSelectedFile().length();
                } catch (FileNotFoundException ex)
                {
                    Logger.getLogger(PanelUserNew.class.getName()).log(Level.SEVERE, null, ex);
                }
                //obtenemos ruta absoluta
                ruta = file.getPath().replace('\\', '/');
                System.out.println("Archivo Seleccionado: " + ruta);
                this.jlFileSelect.setText(file.getName());
            } else
            {
                System.out.println("Error: El archivo selecconado no es una imagen. ");
            }
        }
        regresarEstiloOriginal();
    }//GEN-LAST:event_btnInsertImageActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnInsertImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JCheckBox cbSendEmail;
    private javax.swing.JLabel jlAge;
    private javax.swing.JLabel jlCol;
    private javax.swing.JLabel jlConfirm;
    private javax.swing.JLabel jlCurp;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFileSelect;
    private javax.swing.JLabel jlHouseNumber;
    private javax.swing.JLabel jlLastNameM;
    private javax.swing.JLabel jlLastNameP;
    private javax.swing.JLabel jlMun;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlPhone1;
    private javax.swing.JLabel jlPhone2;
    private javax.swing.JLabel jlPostalCode;
    private javax.swing.JLabel jlRfc;
    private javax.swing.JLabel jlRol;
    private javax.swing.JLabel jlSecondApart;
    private javax.swing.JLabel jlSex;
    private javax.swing.JLabel jlState;
    private javax.swing.JLabel jlStreet;
    private javax.swing.JLabel jlSubtitulo;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlUser;
    private javax.swing.JSeparator linea1;
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
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea20;
    private javax.swing.JSeparator linea21;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea7;
    private javax.swing.JSeparator linea8;
    private javax.swing.JSeparator linea9;
    private javax.swing.JRadioButton rbMan;
    private javax.swing.JRadioButton rbWoman;
    private javax.swing.JTextField tfCol;
    private javax.swing.JPasswordField tfConfirm;
    private javax.swing.JTextField tfCurp;
    private javax.swing.JTextField tfEdad;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfHouseNumber;
    private javax.swing.JTextField tfLastNameM;
    private javax.swing.JTextField tfLastNameP;
    private javax.swing.JTextField tfMun;
    private javax.swing.JTextField tfName;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhone1;
    private javax.swing.JTextField tfPhone2;
    private javax.swing.JTextField tfPostalCode;
    private javax.swing.JTextField tfRfc;
    private javax.swing.JTextField tfState;
    private javax.swing.JTextField tfStreet;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
