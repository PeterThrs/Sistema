/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admin;

import com.admin.enumerador.Entrada;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Root
 */
public class VistaAltaUsuario extends javax.swing.JFrame {

    private JLabel nombreVentana;
    private JLabel jlNombre, jlPaterno, jlMaterno, jlEmail, jlTel1, jlTel2, jlEdad, jlCurp, jlRfc, jlSexo, jlCodPosta, jlEstado, jlColonia, jlMun, jlNumCasa, jlCalle, jlUsuario, jlContrasenia, jlRol, jlConfirmar;
    private JTextField tNombre, tPaterno, tMaterno, tEmail, tTel1, tTel2, tEdad, tCurp, tRfc, tCodPosta, tEstado, tColonia, tMun, tNumCasa, tCalle, tUsuario;
    private JPasswordField pContrasenia, pConfirmar;
    private JSeparator linea1, linea2, linea3, linea4, linea5, linea6, linea7, linea8, linea9, linea10, linea11, linea12,
            linea13, linea14, linea15, linea16, linea17, linea18, linea19, linea20, linea21;
    private JRadioButton rbSexoH, rbSexoM;
    private JComboBox cbRol;
    private JCheckBox cbEnviar;
    private JButton btnRegistrar, btnEliminar, btnActualizar, btnInsertarImagen;

    private JPanel titulo, contenido, contenidoIzq, contenidoDer, contenidoCen, infoUsuario, footer;
    private GridBagConstraints c;
    private Color colorPrincipal, colorBlanco;

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
    private Entrada entrada;

    public VistaAltaUsuario(Entrada entrada, Usuario usuario, Persona persona) {
        super("Cajero");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setMinimumSize(new Dimension(1000, 600));
        this.setLocationRelativeTo(this);
        this.colorPrincipal = new Color(39, 54, 77);
        this.colorBlanco = new Color(255, 255, 255);
        this.c = new GridBagConstraints();
        this.entrada = entrada;
        verificarEstado(usuario, persona);
        cargarComponentes();

    }

    private void verificarEstado(Usuario usuario, Persona persona) {
        switch (entrada) {
            case CONSULTAR:
                this.persona = new Persona();
                this.usuario = new Usuario();
                break;
            case ELIMINAR:
                this.usuario = usuario;
                this.persona = persona;
                break;
            case AGREGAR:
                this.persona = new Persona();
                this.usuario = new Usuario();
                break;
            case EDITAR:
                this.usuario = usuario;
                this.persona = persona;
                break;
        }
    }

    private void cargarComponentes() {
        instancias();
        colocarPaneles();
        componentesTitulo();
        componentesContenidoIzq();
        componentesContenidoCen();
        componentesContenidoDer();
        componentesFooter();
        agregarEstilos();
        agregarRadioBotones();
        modeloComboBox();
        accionBotones();

    }

    public void instancias() {
        this.personaDao = new PersonaDao();
        this.usuarioDao = new UsuarioDao();
        this.validar = Validaciones.getValidacion();
        this.oGraficos = ObjGraficosService.getService();
        this.validacion = Validaciones.getValidacion();
        this.archivoo = null;
    }

    private void colocarPaneles() {
        this.setLayout(new GridBagLayout());
        this.titulo = new JPanel();
        this.contenido = new JPanel();
        this.contenidoIzq = new JPanel();
        this.contenidoDer = new JPanel();
        this.contenidoCen = new JPanel();
        this.footer = new JPanel();

        c = new GridBagConstraints();

        // Panel del titulo
        this.titulo = new JPanel();
        this.titulo.setBackground(colorPrincipal);
        this.titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0.15;
        c.fill = GridBagConstraints.BOTH;
        this.titulo.setLayout(new GridBagLayout());
        add(this.titulo, c);

        //Contenido
        this.contenido = new JPanel();
        this.contenido.setBackground(this.colorBlanco);
        //this.contenido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 0.7;
        this.contenido.setLayout(new GridBagLayout());
        this.contenido.setFocusable(true);
        c.fill = GridBagConstraints.BOTH;
        add(this.contenido, c);

        //footer
        this.footer = new JPanel();
        this.footer.setBackground(Color.YELLOW);
        this.footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 0.15;
        this.footer.setLayout(new GridBagLayout());
        this.footer.setFocusable(true);
        c.fill = GridBagConstraints.BOTH;
        add(this.footer, c);

        //contenido
        //Contenido Izquierda
        this.contenidoIzq = new JPanel();
        this.contenidoIzq.setBackground(this.colorBlanco);
        this.contenidoIzq.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.37;
        c.weighty = 1;
        this.contenidoIzq.setLayout(new GridBagLayout());
        this.contenidoIzq.setFocusable(true);
        c.fill = GridBagConstraints.BOTH;
        this.contenido.add(this.contenidoIzq, c);

        //Contenido Centro
        this.contenidoCen = new JPanel();
        this.contenidoCen.setBackground(this.colorBlanco);
        this.contenidoCen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.25;
        c.weighty = 1;
        this.contenidoCen.setLayout(new GridBagLayout());
        this.contenidoCen.setFocusable(true);
        c.fill = GridBagConstraints.BOTH;
        this.contenido.add(this.contenidoCen, c);

        //Contenido Derecha
        this.contenidoDer = new JPanel();
        this.contenidoDer.setBackground(this.colorBlanco);
        this.contenidoDer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.37;
        c.weighty = 1;
        this.contenidoDer.setLayout(new GridBagLayout());
        this.contenidoDer.setFocusable(true);
        c.fill = GridBagConstraints.BOTH;
        this.contenido.add(this.contenidoDer, c);

    }

    private void componentesTitulo() {
        switch (entrada) {
            case CONSULTAR:
                this.nombreVentana = new JLabel("Consultar Usuario");
                break;
            case ELIMINAR:
                this.nombreVentana = new JLabel("Eliminar Usuario");
                break;
            case AGREGAR:
                this.nombreVentana = new JLabel("Agregar Usuario");
                break;
            case EDITAR:
                this.nombreVentana = new JLabel("Editar Usuario");
                break;
        }
        c = grid(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        agregarAlPanel(this.titulo, this.nombreVentana, c);
    }

    private void componentesContenidoIzq() {
        c = new GridBagConstraints();

        this.jlNombre = new JLabel("Nombre:");
        c = grid(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlNombre, c);

        this.jlMaterno = new JLabel("Apellido Materno:");
        c = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlMaterno, c);

        this.jlTel1 = new JLabel("Teléfono 1:");
        c = grid(0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlTel1, c);

        this.jlEdad = new JLabel("Edad:");
        c = grid(0, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlEdad, c);

        this.jlRfc = new JLabel("RFC:");
        c = grid(0, 8, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlRfc, c);

        this.jlCodPosta = new JLabel("Código Postal");
        c = grid(0, 10, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlCodPosta, c);

        this.jlColonia = new JLabel("Colonia:");
        c = grid(0, 12, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlColonia, c);

        this.jlNumCasa = new JLabel("Número de Casa:");
        c = grid(0, 14, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.jlNumCasa, c);

        //textfield 
        this.tNombre = new JTextField();
        c = grid(1, 0, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tNombre, c);
        this.linea1 = new JSeparator();
        c = grid(1, 1, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea1, c);

        this.tMaterno = new JTextField();
        c = grid(1, 2, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tMaterno, c);
        this.linea2 = new JSeparator();
        c = grid(1, 3, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea2, c);

        this.tTel1 = new JTextField();
        c = grid(1, 4, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tTel1, c);
        this.linea3 = new JSeparator();
        c = grid(1, 5, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea3, c);

        this.tEdad = new JTextField();
        c = grid(1, 6, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tEdad, c);
        this.linea4 = new JSeparator();
        c = grid(1, 7, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea4, c);

        this.tRfc = new JTextField();
        c = grid(1, 8, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tRfc, c);
        this.linea5 = new JSeparator();
        c = grid(1, 9, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea5, c);

        this.tCodPosta = new JTextField();
        c = grid(1, 10, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tCodPosta, c);
        this.linea6 = new JSeparator();
        c = grid(1, 11, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea6, c);

        this.tColonia = new JTextField();
        c = grid(1, 12, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tColonia, c);
        this.linea7 = new JSeparator();
        c = grid(1, 13, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea7, c);

        this.tNumCasa = new JTextField();
        c = grid(1, 14, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.tNumCasa, c);
        this.linea8 = new JSeparator();
        c = grid(1, 15, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoIzq, this.linea8, c);

    }

    private void componentesContenidoCen() {
        c = new GridBagConstraints();

        this.jlPaterno = new JLabel("Apellido Paterno:");
        c = grid(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlPaterno, c);

        this.jlEmail = new JLabel("Email:");
        c = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlEmail, c);

        this.jlTel2 = new JLabel("Telefono 2:");
        c = grid(0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlTel2, c);

        this.jlCurp = new JLabel("CURP:");
        c = grid(0, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlCurp, c);

        this.jlSexo = new JLabel("Sexo:");
        c = grid(0, 8, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlSexo, c);

        this.jlEstado = new JLabel("Estado:");
        c = grid(0, 9, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlEstado, c);

        this.jlMun = new JLabel("Municipio:");
        c = grid(0, 11, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlMun, c);

        this.jlCalle = new JLabel("Calle:");
        c = grid(0, 13, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.jlCalle, c);

        //textfield 
        this.tPaterno = new JTextField();
        c = grid(1, 0, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tPaterno, c);
        this.linea9 = new JSeparator();
        c = grid(1, 1, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea9, c);

        this.tEmail = new JTextField();
        c = grid(1, 2, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tEmail, c);
        this.linea10 = new JSeparator();
        c = grid(1, 3, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea10, c);

        this.tTel2 = new JTextField();
        c = grid(1, 4, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tTel2, c);
        this.linea11 = new JSeparator();
        c = grid(1, 5, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea11, c);

        this.tCurp = new JTextField();
        c = grid(1, 6, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tCurp, c);
        this.linea12 = new JSeparator();
        c = grid(1, 7, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea12, c);

        this.rbSexoH = new JRadioButton("Hombre");
        c = grid(1, 8, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.rbSexoH, c);

        this.rbSexoM = new JRadioButton("Mujer");
        c = grid(2, 8, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.rbSexoM, c);

        this.tEstado = new JTextField();
        c = grid(1, 9, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tEstado, c);
        this.linea13 = new JSeparator();
        c = grid(1, 10, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea13, c);

        this.tMun = new JTextField();
        c = grid(1, 11, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tMun, c);
        this.linea14 = new JSeparator();
        c = grid(1, 12, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea14, c);

        this.tCalle = new JTextField();
        c = grid(1, 13, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.tCalle, c);
        this.linea15 = new JSeparator();
        c = grid(1, 14, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoCen, this.linea15, c);

    }

    private void componentesContenidoDer() {
        c = new GridBagConstraints();

        this.jlUsuario = new JLabel("Usuario:");
        c = grid(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.jlUsuario, c);

        this.jlRol = new JLabel("Rol:");
        c = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.jlRol, c);

        this.jlContrasenia = new JLabel("Contraseña:");
        c = grid(0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.jlContrasenia, c);

        this.jlConfirmar = new JLabel("Confirmar:");
        c = grid(0, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.jlConfirmar, c);

        //textfield 
        this.tUsuario = new JTextField();
        c = grid(1, 0, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.tUsuario, c);
        this.linea16 = new JSeparator();
        c = grid(1, 1, 2, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.linea16, c);

        this.cbRol = new JComboBox();
        c = grid(1, 2, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.cbRol, c);
        this.linea17 = new JSeparator();
        c = grid(1, 3, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.linea17, c);

        this.pContrasenia = new JPasswordField();
        c = grid(1, 4, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.pContrasenia, c);
        this.linea18 = new JSeparator();
        c = grid(1, 5, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.linea18, c);

        this.pConfirmar = new JPasswordField();
        c = grid(1, 6, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.pConfirmar, c);
        this.linea19 = new JSeparator();
        c = grid(1, 7, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_START, new Insets(0, 10, 0, 10), 0, 0);
        agregarAlPanel(this.contenidoDer, this.linea19, c);

    }

    private void componentesFooter() {
        this.btnRegistrar = new JButton("Registrar");
        this.btnEliminar = new JButton("Eliminar");
        this.btnActualizar = new JButton("Actualizar");
        this.btnInsertarImagen = new JButton("Seleccionar Imagen");
        switch (entrada) {
            case CONSULTAR:

                break;
            case ELIMINAR:
                c = grid(0, 0, 1, 1, 0.5, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
                agregarAlPanel(this.footer, this.btnEliminar, c);
                break;
            case AGREGAR:
                c = grid(0, 0, 1, 1, 0.5, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
                agregarAlPanel(this.footer, this.btnRegistrar, c);
                c = grid(1, 0, 1, 1, 0.5, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
                agregarAlPanel(this.footer, this.btnInsertarImagen, c);
                break;
            case EDITAR:
                c = grid(0, 0, 1, 1, 0.5, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
                agregarAlPanel(this.footer, this.btnActualizar, c);
                break;
        }
    }

    /**
     *
     * @param <T>
     * @param gridx - La posición del componente en el eje x.
     * @param gridy - La posición del componente en el eje y.
     * @param gridWidth - El número de celdas de la cuadrícula que ocupa el
     * componente en el eje x.
     * @param gridHeight - El número de celdas de la cuadrícula que ocupa el
     * componente el eje y.
     * @param weightx - La cantidad de espacio extra que se asignará a la celda
     * en el eje x si el espacio disponible en la ventana se agranda.
     * @param weighty - La cantidad de espacio extra que se asignará a la celda
     * en el y si el espacio disponible en la ventana se agranda.
     * @param fill - Determinacómo se estirará el componente para llenar la
     * celda: NONE, HORIZONTAL,VERTICAL o BOTH.
     * @param anchor - La posición del componente dentro de la celda si la celda
     * es más grande que el componente.
     * @param insets - El espacio entre el borde del componente y el borde de su
     * celda.
     * @param ipadx - La cantidad de espacio extra en píxeles que se agregará al
     * ancho preferido del componente.
     * @param ipady - La cantidad de espacio extra en píxeles que se agregará al
     * alto preferido del componente.
     */
    private <T extends JComponent> GridBagConstraints grid(int gridx, int gridy, int gridWidth, int gridHeight,
            double weightx, double weighty, int fill, int anchor, Insets insets, int ipadx, int ipady) {
        c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightx;
        c.weighty = weighty;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = insets;
        c.ipadx = ipadx;
        c.ipady = ipady;
        return c;
    }

    private <T extends JComponent> void agregarAlPanel(JPanel panel, T componente, GridBagConstraints c) {
        //Arrays.asList(componentes).forEach(e -> panel.add(e, a.iterator().next()));
        panel.add(componente, c);
    }

    private void agregarEstilos() {
        try {
            //configuraciones del panel
            //Configuracion.background(CodigoColor.cFondoBlanco, this);

            //configuraciones de los JLabel
            Configuracion.foreground(this.colorBlanco, this.nombreVentana);
            Configuracion.robotoBold20(this.nombreVentana);
            Configuracion.robotoPlain14(this.jlCalle, this.jlCodPosta, this.jlColonia, this.jlConfirmar, this.jlContrasenia,
                    this.jlCurp, this.jlEdad, this.jlEmail, this.jlEstado, this.jlMaterno, this.jlMun, this.jlNombre,
                    this.jlNumCasa, this.jlPaterno, this.jlRfc, this.jlRol, this.jlSexo, this.jlTel1, this.jlTel2, this.jlUsuario);
            Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlCalle, this.jlCodPosta, this.jlColonia, this.jlConfirmar, this.jlContrasenia,
                    this.jlCurp, this.jlEdad, this.jlEmail, this.jlEstado, this.jlMaterno, this.jlMun, this.jlNombre,
                    this.jlNumCasa, this.jlPaterno, this.jlRfc, this.jlRol, this.jlSexo, this.jlTel1, this.jlTel2, this.jlUsuario);

            //configuraciones de los JTextField
            Configuracion.robotoPlain14(this.tCalle, this.tCodPosta, this.tColonia, this.pConfirmar, this.pContrasenia,
                    this.tCurp, this.tEdad, this.tEmail, this.tEstado, this.tMaterno, this.tMun, this.tNombre,
                    this.tNumCasa, this.tPaterno, this.tRfc, this.cbRol, this.rbSexoH, this.rbSexoM, this.tTel1,
                    this.tTel2, this.tUsuario);
            Configuracion.withoutBorde(this.tCalle, this.tCodPosta, this.tColonia, this.pConfirmar, this.pContrasenia,
                    this.tCurp, this.tEdad, this.tEmail, this.tEstado, this.tMaterno, this.tMun, this.tNombre,
                    this.tNumCasa, this.tPaterno, this.tRfc, this.cbRol, this.rbSexoH, this.rbSexoM, this.tTel1,
                    this.tTel2, this.tUsuario);
            Configuracion.background(this.colorBlanco, this.tCalle, this.tCodPosta, this.tColonia, this.pConfirmar, this.pContrasenia,
                    this.tCurp, this.tEdad, this.tEmail, this.tEstado, this.tMaterno, this.tMun, this.tNombre,
                    this.tNumCasa, this.tPaterno, this.tRfc, this.cbRol, this.rbSexoH, this.rbSexoM, this.tTel1,
                    this.tTel2, this.tUsuario);
            Configuracion.foreground(CodigoColor.cLetrasNegro, this.tCalle, this.tCodPosta, this.tColonia, this.pConfirmar, this.pContrasenia,
                    this.tCurp, this.tEdad, this.tEmail, this.tEstado, this.tMaterno, this.tMun, this.tNombre,
                    this.tNumCasa, this.tPaterno, this.tRfc, this.cbRol, this.rbSexoH, this.rbSexoM, this.tTel1,
                    this.tTel2, this.tUsuario);

            //configuraciones de los botones
            Configuracion.robotoPlain14(this.btnEliminar, this.btnRegistrar, this.btnInsertarImagen, this.btnActualizar);
            Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnEliminar, this.btnRegistrar, this.btnInsertarImagen, this.btnActualizar);
            Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnEliminar, this.btnRegistrar, this.btnInsertarImagen, this.btnActualizar);

            //configuraciones del JRadioButton
            Configuracion.robotoPlain14(this.rbSexoH, this.rbSexoM);
            Configuracion.foreground(CodigoColor.cLetrasNegro, this.rbSexoH, this.rbSexoM);
            Configuracion.background(CodigoColor.cFondoGris, this.rbSexoH, this.rbSexoM);

            //Configuracion JCheckBox
//        Configuracion.robotoPlain14(this.cbEnviar);
//        Configuracion.withoutBorde(this.cbEnviar);
//        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbEnviar);
//        Configuracion.background(CodigoColor.cFondoGris, this.cbEnviar);
            //Configuracion jComboBox
            Configuracion.robotoPlain14(this.cbRol);

            //configuraciones de los jSeparator
            Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                    this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13, this.linea14,
                    this.linea15, this.linea16, this.linea17, this.linea18, this.linea19);
            //Configuracion.foreground(CodigoColor.cFondoBtnAzul, this.linea15, this.linea16);
            Configuracion.background(CodigoColor.cFondoGris, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                    this.linea7, this.linea8, this.linea9, this.linea10, this.linea11, this.linea12, this.linea13, this.linea14,
                    this.linea15, this.linea16, this.linea17, this.linea18, this.linea19);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void agregarRadioBotones() {
        try {
            groupRadioBtn = new ButtonGroup();
            groupRadioBtn.add(this.rbSexoH);
            groupRadioBtn.add(this.rbSexoM);
            this.rbSexoH.setSelected(true);
        } catch (Exception ex) {

        }
    }

    private void modeloComboBox() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        List<Rol> roles = RolDAO.seleccionar();
        roles.forEach(rol
                -> {
            dcbm.addElement(rol.getNombre());
        });
        this.cbRol.setModel(dcbm);
        this.cbRol.getEditor().getEditorComponent().setForeground(CodigoColor.cLetrasNegro);
        this.cbRol.getEditor().getEditorComponent().setBackground(CodigoColor.cFondoGris);
        this.cbRol.setSelectedIndex(1);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbRol);
        Configuracion.background(CodigoColor.cFondoGris, this.cbRol);
    }

    private static void regresarEstiloOriginal() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // Manejo de excepciones
        }
    }

    //logica del programa por falta de tiempo se colocara aqui
    public boolean validarFomr() throws NumberFormatException, Exception {

        if (validar.validarCadena(this.nombre) && validar.validarCadena(this.aPaterno)
                && validar.validarCadena(this.aMaterno) && validar.validarEmail(this.email)
                && validar.validarTelefono(this.telefono1) && validar.validarTelefono(this.telefono2)
                && validar.validarEdad(this.edad) && validar.validarCadena(curp) && validar.validarCadena(this.rfc)
                && validar.validarCadena(this.sexo) && validar.validarCodPostal(this.codigoPostal)
                && validar.validarCadena(this.estado) && validar.validarCadena(this.municipio)
                && validar.validarCadena(this.colonia) && validar.validarCadena(this.calle)
                && validar.validarNumCasa(this.numCasa) && validar.validarCadena(nomUsuario)
                && validar.validarContrasenia(this.contrasenia, this.contrasenia, this.confirmacion) && idRol > 0 && archivoo != null) {

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

        } else {
            JOptionPane.showMessageDialog(null, "Faltan campos por completar");
        }
        return false;
    }

    public void recuperarDatos() throws NumberFormatException {
        //datos de una persona
        this.nombre = this.tNombre.getText();
        this.aPaterno = this.tPaterno.getText();
        this.aMaterno = this.tMaterno.getText();
        this.email = this.tEmail.getText();
        this.telefono1 = this.tTel1.getText();
        this.telefono2 = this.tTel2.getText();
        this.edad = parse(this.tEdad.getText());
        this.curp = this.tCurp.getText();
        this.rfc = this.tRfc.getText();
        this.sexo = recuperarSexo();
        this.codigoPostal = parse(this.tCodPosta.getText());
        this.estado = this.tEstado.getText();
        this.municipio = this.tMun.getText();
        this.colonia = this.tColonia.getText();
        this.calle = this.tCalle.getText();
        this.numCasa = parse(tNumCasa.getText());

        //datos de usuario
        this.nomUsuario = this.tUsuario.getText();
        this.contrasenia = String.valueOf(this.pContrasenia.getPassword());
        this.confirmacion = String.valueOf(this.pConfirmar.getPassword());
        this.idRol = this.cbRol.getSelectedIndex() + 1;

    }

    public String recuperarSexo() {
        return (this.rbSexoH.isSelected()) ? "H" : (this.rbSexoM.isSelected()) ? "M" : "";
    }

    public int parse(String n) throws NumberFormatException {
        int num = Integer.parseInt(n);
        return num;
    }

    private void accionBotones() {

        //Agregar
        this.btnRegistrar.addActionListener(e
                -> {
            try {

                recuperarDatos();
                validarFomr();
                //insertamos primero la persona
                int registro = personaDao.insertar(persona);

                if (registro > 0) {
                    //recuperamos el idPersona
                    List<Persona> lista = this.personaDao.seleccionar();
                    persona = lista.get(lista.size() - 1);
                    idPersona = persona.getIdPersona();

                    usuario.setIdPersona(idPersona);

                    int reg = UsuarioDao.insertar(usuario, longitudBytes);

                    if (reg > 0) {
                        limpiarForm();
                        JOptionPane.showMessageDialog(null, "Se ha logrado insertar los datos correctamente");
                    }

                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        //Eliminar
        this.btnEliminar.addActionListener(e
                -> {
            try {
                recuperarDatos();
                validarFomr();

                int regPersona = personaDao.eliminar(persona);
                int regUsuario = usuarioDao.eliminar(usuario);
                limpiarForm();
                if (regPersona > 0 && regUsuario > 0) {
                    JOptionPane.showMessageDialog(null, "Se han eliminado los datos correctamente");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        //Actualizar
        this.btnActualizar.addActionListener(e
                -> {
            try {
                recuperarDatos();
                validarFomr();

                int regPersona = personaDao.actualizar(persona);
                int regUsuario = usuarioDao.actualizar(usuario, longitudBytes);
                if (regPersona > 0 && regUsuario > 0) {
                    limpiarForm();
                    JOptionPane.showMessageDialog(null, "Se ha logrado insertar los datos correctamente");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        //insertar imagen
        this.btnInsertarImagen.addActionListener(e -> {
            //Crear un JFileChooser
            JFileChooser chooser = personalizarVentana();
            //Crear filtro
            FileNameExtensionFilter filter = new FileNameExtensionFilter("png, jpg", "png", "jpg");
            chooser.setFileFilter(filter);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
                    try {
                        //se obtiene el archivo seleccionado
                        archivoo = new FileInputStream(chooser.getSelectedFile());
                        this.longitudBytes = (int) chooser.getSelectedFile().length();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(PanelUserNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //obtenemos ruta absoluta
                    ruta = file.getPath().replace('\\', '/');
                    System.out.println("Archivo Seleccionado: " + ruta);
                    //this.jlFileSelect.setText(file.getName());
                } else {
                    System.out.println("Error: El archivo selecconado no es una imagen. ");
                }
            }
            regresarEstiloOriginal();

        });
    }

    //cargar datos de la bd en los campos
    public void cargarDatos() {
        //cargamos los datos de la persona
        this.tNombre.setText(this.persona.getNombre());
        this.tMaterno.setText(this.persona.getApellidoMaterno());
        this.tPaterno.setText(this.persona.getApellidoPaterno());
        this.tEmail.setText(this.persona.getEmail());
        this.tTel1.setText(this.persona.getTelefono1());
        this.tTel2.setText(this.persona.getTelefono2());
        this.tEdad.setText(String.valueOf(this.persona.getEdad()));
        this.tCurp.setText(this.persona.getCurp());
        this.tRfc.setText(this.persona.getRFC());
        if (this.persona.getSexo().equals("M")) {
            this.rbSexoH.setSelected(true);
            this.rbSexoM.setSelected(false);
        } else {
            this.rbSexoH.setSelected(false);
            this.rbSexoM.setSelected(true);
        }
        this.tCodPosta.setText(String.valueOf(persona.getCodigoPostal()));
        this.tEstado.setText(this.persona.getEstado());
        this.tMun.setText(this.persona.getMunicipio());
        this.tColonia.setText(this.persona.getColonia());
        this.tCalle.setText(this.persona.getCalle());
        this.tNumCasa.setText(String.valueOf(this.persona.getNumCasa()));

        //cargamos los datos del usuario
        this.tUsuario.setText(this.usuario.getNomUsuario());
        this.pContrasenia.setText(this.usuario.getContrasenia());
        this.pConfirmar.setText(this.usuario.getContrasenia());
        this.cbRol.setSelectedIndex(this.usuario.getIdRol() - 1);

    }

    public void limpiarForm() {
        //cargamos los datos de la persona
        this.tNombre.setText("");
        this.tMaterno.setText("");
        this.tPaterno.setText("");
        this.tEmail.setText("");
        this.tTel1.setText("");
        this.tTel2.setText("");
        this.tEdad.setText("");
        this.tCurp.setText("");
        this.tRfc.setText("");
        this.rbSexoH.setSelected(true);
        this.tCodPosta.setText("");
        this.tEstado.setText("");
        this.tMun.setText("");
        this.tColonia.setText("");
        this.tCalle.setText("");
        this.tNumCasa.setText("");

        //cargamos los datos del usuario
        this.tUsuario.setText("");
        this.pContrasenia.setText("");
        this.pConfirmar.setText("");
        this.cbRol.setSelectedIndex(1);

    }

}
