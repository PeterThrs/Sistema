package com.newLogin;

import com.admin.PrincipalAdmin;
import com.cashiers.ControladorCajero;
import com.cashiers.VistaCajero;
import com.classes.Usuario;
import com.conexion.UsuarioDao;
import com.counter.VentanaContador;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import com.settings.ObjGraficosService;
import com.settings.PlaceholderUtils;
import com.settings.Recursos;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LoginTemplate extends JFrame {

    private JPanel pDerecha, pIzquierda;
    private JLabel lTituloApp, /*lEslogan,*/ lTituloLogin,/* lNotificaciones,*/ lFondo, lSvg1, lLogo, lUsuario, lClave, lFacebook/*, lTwitter, lYoutube*/;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
//    private JComboBox cbTipoUsuario;
    private JButton bEntrar, bCerrar, /*bRegistrarse,*/ bOpcion1, bOpcion2, bOpcion3;
    //private JCheckBox checkSi, checkNo;
    //private ButtonGroup grupo;

    private ImageIcon iFondo, iLogo;
    private ImageIcon iSvg1, iUsuario2, iClave2, iPunto1, iFacebook1, /*iTwitter1, iYoutube1,*/ iDimAux;

    private ObjGraficosService sObjGraficos;
    private Recursos sRecursos;
    private Runnable runApplication;

    public LoginTemplate() {
        this.obtenerServicios();
        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
//        this.crearJComboBoxes();
        this.crearJButtons();
        //this.crearJCheckBoxes();
        this.crearJLabels();
        this.confVentana();

        eventos();
        
        setIconImage(new ImageIcon(getClass().getResource("/images/User.png")).getImage());
    }

    public void eventos() {
        //cambiarColorJButton(bCerrar);
        bCerrar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color cuando el puntero del mouse entra en el JButton
                bCerrar.setBackground(Color.RED);
                bCerrar.setOpaque(true);
            }

            public void mouseExited(MouseEvent e) {
                // Restaurar el color cuando el puntero del mouse sale del JButton
                bCerrar.setBackground(UIManager.getColor("Button.background"));
                bCerrar.setOpaque(false);
            }
        });
//        //Evento de cerra la ventana en la x
//        bCerrar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Cerrar la ventana al hacer clic en el JButton
//                System.exit(0);
//            }
//        });
        bCerrar.addActionListener(e -> System.exit(0));
        //evento de enter sobre el jtextfield
//        tNombreUsuario.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                bEntrar.doClick();
//            }
//        });
        tNombreUsuario.addActionListener(e -> bEntrar.doClick());
        //El mismo evento de arriba pero con otro jtextfield
//        tClaveUsuario.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                bEntrar.doClick();
//            }
//        });
        tClaveUsuario.addActionListener(e -> bEntrar.doClick());
        //Evento del boton para el login
//        bEntrar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Cerrar la ventana al hacer clic en el JButton
//                loggear();
//            }
//        });
        bEntrar.addActionListener(e -> loggear());
        //sombrear toda la caja de password
        tClaveUsuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                // Seleccionar todo el contenido del JTextField al hacer clic en él
                tClaveUsuario.selectAll();
            }
        });
        //sombrear toda la caja de usuario
        tNombreUsuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                // Seleccionar todo el contenido del JTextField al hacer clic en él
                tNombreUsuario.selectAll();
            }
        });
        //abrir Facebook
        lFacebook.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try
                {
                    // Abrir el enlace a Facebook en el navegador predeterminado
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        //dinamizar el tamaño del icono facebook
        Dimension originalSize = lFacebook.getPreferredSize();
        Dimension clickedSize = new Dimension(originalSize.width + 10, originalSize.height + 10);

        lFacebook.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Cambiar el tamaño del JLabel al hacer clic
                lFacebook.setSize(clickedSize);
                lFacebook.repaint();
            }

            public void mouseReleased(MouseEvent e) {
                // Restablecer el tamaño original del JLabel al soltar el clic
                lFacebook.setSize(originalSize);
                lFacebook.repaint();
            }
        });
    }

    private void loggear() {
        String user = tNombreUsuario.getText();
        String password = String.valueOf(tClaveUsuario.getPassword());
        if (user.equals("Nombre de usuario") && password.equals("Ingresar contraseña"))
        {
            JOptionPane.showMessageDialog(this, "Ingrese su nombre de usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (user.isEmpty() && password.equals("Ingresar contraseña"))
        {
            JOptionPane.showMessageDialog(this, "Ingrese su nombre de usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (user.equals("Nombre de usuario") && password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Ingrese su nombre de usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!user.isEmpty() && password.equals("Ingresar contraseña"))
        {
            JOptionPane.showMessageDialog(this, "Ingrese su contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (user.equals("Nombre de usuario") && !password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Ingresado su nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else
        {
            Usuario usuario = buscar(user, password);
            if (usuario != null && usuario.getStatus()!=0)
            {
                int idRol = usuario.getIdRol();
                switch (idRol)
                {
                    case 1:
                        Runnable runApplication = new Runnable() {
                            public void run() {
                                VistaCajero vc = new VistaCajero();
                                ControladorCajero cc = new ControladorCajero(vc, usuario);
                                vc.getClass();
                                vc.setVisible(true);
                            }
                        };
                        SwingUtilities.invokeLater(runApplication);
                        break;
                    case 2:
                        runApplication = new Runnable() {
                            public void run() {
                                VentanaContador contador = new VentanaContador();
                                contador.getClass();
                            }
                        };
                        SwingUtilities.invokeLater(runApplication);
                        break;
                    case 3:
                        runApplication = new Runnable() {
                            public void run() {
                                PrincipalAdmin principalAdmin = new PrincipalAdmin();
                                principalAdmin.getClass();
                            }
                        };
                        SwingUtilities.invokeLater(runApplication);
                        break;
                }
                this.dispose();
            }
        }
    }

    private Usuario buscar(String user, String password) {
        List<Usuario> usuarios = UsuarioDao.seleccionar();
        Usuario user1 = buscarNombre(user, usuarios), user2 = buscarPasword(password, usuarios);
        if (user1 == null && user2 == null)
        {
            JOptionPane.showMessageDialog(this, "Nombre y contraseña del usuario incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (user1 == null && user2 != null){
            JOptionPane.showMessageDialog(this, "Nombre de usuario incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (user1 != null && user2 == null){
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            return user1;
        }
        return null;
    }

    private Usuario buscarNombre(String user, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios)
        {
            if (usuario.getNomUsuario().equals(user))
            {
                return usuario;
            }
        }
        return null;
    }

    private Usuario buscarPasword(String password, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios)
        {
            if (usuario.getContrasenia().equals(password))
            {
                return usuario;
            }
        }
        return null;
    }

    public void obtenerServicios() {
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = Recursos.getService();
    }

    public void confVentana() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setUndecorated(true);
        setVisible(true);
    }

    public void crearJPanels() {
        pIzquierda = sObjGraficos.construirJPanel(0, 0, 600, 500, Color.WHITE, null);
        this.add(pIzquierda);

        pDerecha = sObjGraficos.construirJPanel(600, 0, 400, 500, Color.white, null);
        this.add(pDerecha);
    }

    public void crearJTextFields() {
        tNombreUsuario = sObjGraficos.construirJTextField(null, (pDerecha.getWidth() - 260) / 2, 150, 260, 40,
                sRecursos.getFontTitulo2(), Color.WHITE, sRecursos.getColorPrincipal(), sRecursos.getColorGrisOscuro(),
                sRecursos.getBorderInferiorAzul(), "c");
        PlaceholderUtils.setPlaceholder(tNombreUsuario, "Nombre de usuario");
        //tNombreUsuario.selectAll();
        tNombreUsuario.setToolTipText("Ingresar nombre de usuario");
        pDerecha.add(tNombreUsuario);
    }

    public void crearObjetosDecoradores() {

        iFondo = new ImageIcon("src/main/resources/newLogin/fondo.png");
        iLogo = new ImageIcon("src/main/resources/newLogin/logo.png");
        iUsuario2 = new ImageIcon("src/main/resources/newLogin/usuario2.png");
        iClave2 = new ImageIcon("src/main/resources/newLogin/clave2.png");
        iPunto1 = new ImageIcon("src/main/resources/newLogin/punto1.png");
        iFacebook1 = new ImageIcon("src/main/resources/newLogin/facebook1.png");
//        iTwitter1 = new ImageIcon("src/main/resources/newLogin/twitter1.png");
//        iYoutube1 = new ImageIcon("src/main/resources/newLogin/youtube1.png");
        iSvg1 = new ImageIcon("src/main/resources/newLogin/imagen1.png");
    }

    public void crearJButtons() {
        //bEntrar.setBorder();
        bEntrar = sObjGraficos.construirJButton(
                "Ingresar",
                (pDerecha.getWidth() - 250) / 2, 330, 250, 45,
                sRecursos.getCMano(),
                null, sRecursos.getFontTitulo2(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                sRecursos.getBorderRedondeado(),
                "c",
                true
        );
        bEntrar.setToolTipText("Ingresar");
        pDerecha.add(bEntrar);

        iDimAux = new ImageIcon(
                sRecursos.getICerrar().getImage()
                        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        bCerrar = sObjGraficos.construirJButton(
                null,
                350, 10, 45, 30,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null, null,
                "c",
                false
        );
        bCerrar.setToolTipText("Cerrar");
        pDerecha.add(bCerrar);

//        bRegistrarse = sObjGraficos.construirJButton("Registrarse",
//                240, 460, 145, 35,
//                sRecursos.getCMano(),
//                null, null,
//                sRecursos.getColorPrincipal(), Color.WHITE, null,
//                "c",
//                true);
//        pDerecha.add(bRegistrarse);
        iDimAux = new ImageIcon(
                iPunto1.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        bOpcion1 = sObjGraficos.construirJButton(null, 10, 220, 30, 20,
                sRecursos.getCMano(), iDimAux, null,
                null, null, null,
                "c", false);
        pIzquierda.add(bOpcion1);

        bOpcion2 = sObjGraficos.construirJButton(null, 10, 250, 30, 20,
                sRecursos.getCMano(), iDimAux, null,
                null, null, null,
                "c", false);
        pIzquierda.add(bOpcion2);

        bOpcion3 = sObjGraficos.construirJButton(null, 10, 280, 30, 20,
                sRecursos.getCMano(), iDimAux, null,
                null, null, null,
                "c", false);
        bOpcion3.setIcon(iDimAux);
        pIzquierda.add(bOpcion3);
    }

    public void crearJLabels() {
        lTituloApp = sObjGraficos.construirJLabel("Login de Usuario", 100, 20, 220, 30,
                null, null, sRecursos.getFontTPrincipal(), null, Color.WHITE,
                null, "a");
        pIzquierda.add(lTituloApp);

//        lEslogan = sObjGraficos.construirJLabel("Te ayudamos en todo", (pDerecha.getWidth() - 130) / 2, 60, 130, 20,
//                null, null, sRecursos.getFontSubtitulo2(), null, sRecursos.getColorGrisOscuro(),
//                null, "c");
//        pDerecha.add(lEslogan);
        lTituloLogin = sObjGraficos.construirJLabel("Registra tus datos", (pDerecha.getWidth() - 270) / 2, 80, 250, 30,
                null, null, sRecursos.getFontTPrincipal(), null, sRecursos.getColorGrisOscuro(),
                null, "c");
        pDerecha.add(lTituloLogin);

//        lNotificaciones = sObjGraficos.construirJLabel("¿Recibir Notificaciones?", (pDerecha.getWidth() - 140) / 2, 400, 140, 20,
//                null, null, sRecursos.getFontSubtitulo2(), null, sRecursos.getColorGrisOscuro(),
//                null, "c");
//        pDerecha.add(lNotificaciones);
        iDimAux = new ImageIcon(
                iLogo.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        lLogo = sObjGraficos.construirJLabel(null, 50, 20, 40, 40,
                null, iDimAux, null, null, null, null, "a");
        pIzquierda.add(lLogo);

        iDimAux = new ImageIcon(
                iSvg1.getImage()
                        .getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING)
        );
        lSvg1 = sObjGraficos.construirJLabel(null, 100, 100, 500, 345,
                null, iDimAux, null, null, null, null, "a");
        pIzquierda.add(lSvg1);

        iDimAux = new ImageIcon(
                iFacebook1.getImage()
                        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lFacebook = sObjGraficos.construirJLabel(null, 20, 460, 30, 30,
                sRecursos.getCMano(), iDimAux, null, null, null, null, "a");
        lFacebook.setToolTipText("Soporte");
        pIzquierda.add(lFacebook);

//        iDimAux = new ImageIcon(
//                iTwitter1.getImage()
//                        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
//        );
//        lTwitter = sObjGraficos.construirJLabel(null, 60, 460, 30, 30,
//                sRecursos.getCMano(), iDimAux, null, null, null, null, "a");
//        pIzquierda.add(lTwitter);
//
//        iDimAux = new ImageIcon(
//                iYoutube1.getImage()
//                        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
//        );
//        lYoutube = sObjGraficos.construirJLabel(null, 100, 460, 30, 30,
//                sRecursos.getCMano(), iDimAux, null, null, null,
//                null, "a");
//        pIzquierda.add(lYoutube);
        iDimAux = new ImageIcon(
                iUsuario2.getImage()
                        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lUsuario = sObjGraficos.construirJLabel(null, 40, 150, 30, 30,
                null, iDimAux, null, null, null,
                null, "a");
        pDerecha.add(lUsuario);

        iDimAux = new ImageIcon(
                iClave2.getImage()
                        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lClave = sObjGraficos.construirJLabel(null, 40, 250, 30, 30,
                null, iDimAux, null, null, null,
                null, "a");
        pDerecha.add(lClave);

        iDimAux = new ImageIcon(
                iFondo.getImage()
                        .getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING)
        );
        lFondo = sObjGraficos.construirJLabel(null, 0, 0, 600, 600,
                null, iDimAux, null, null, null,
                null, "a");
        pIzquierda.add(lFondo);
    }

    public void crearJPasswordFields() {
        tClaveUsuario = sObjGraficos.construirJPasswordField("Clave Usuario", (pDerecha.getWidth() - 260) / 2, 240, 260, 40,
                null, null, sRecursos.getColorPrincipal(), sRecursos.getColorGrisOscuro(),
                sRecursos.getBorderInferiorAzul(), "c");
        PlaceholderUtils.setPlaceholder(tClaveUsuario, "Ingresar contraseña");
        tClaveUsuario.setToolTipText("Ingresar contraseña");
        pDerecha.add(tClaveUsuario);
    }

//    public void crearJComboBoxes() {
////        cbTipoUsuario = sObjGraficos.construirJComboBox("Cliente_Cajero_Administrador", (pDerecha.getWidth() - 220) / 2, 210, 220, 30, 
////                null, Color.WHITE, colorPrincipal, "c");
//        cbTipoUsuario = new JComboBox();
//        cbTipoUsuario.addItem("Cliente");
//        cbTipoUsuario.addItem("Cajero");
//        cbTipoUsuario.addItem("Administrador");
//        cbTipoUsuario.setSize(220, 30);
//        cbTipoUsuario.setLocation((pDerecha.getWidth() - cbTipoUsuario.getWidth()) / 2, 210);
//        cbTipoUsuario.setForeground(sRecursos.getColorPrincipal());
//        cbTipoUsuario.setBackground(Color.WHITE);
//        ((JLabel) cbTipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
//        pDerecha.add(cbTipoUsuario);
//    }
//    public void crearJCheckBoxes() {
//        checkSi = sObjGraficos.construirJCheckBox("Si", (pDerecha.getWidth() - 375) / 2 - 15, 375, 45, 25,
//                sRecursos.getCMano(), null, null);
//        checkSi = new JCheckBox("Si");
//        checkSi.setSize(45, 25);
//        checkSi.setFocusable(false);
//        checkSi.setBackground(Color.WHITE);
//        checkSi.setLocation((pDerecha.getWidth() - checkSi.getWidth()) / 2 - 15, 375);
//        checkSi.setCursor(sRecursos.getCMano());
//        pDerecha.add(checkSi);
//
//        checkNo = new JCheckBox("No");
//        checkNo.setSize(45, 25);
//        checkNo.setFocusable(false);
//        checkNo.setBackground(Color.WHITE);
//        checkNo.setLocation((pDerecha.getWidth() + checkNo.getWidth()) / 2 - 15, 375);
//        checkNo.setCursor(sRecursos.getCMano());
//        pDerecha.add(checkNo);
//
//        grupo = new ButtonGroup();
//        grupo.add(checkSi);
//        grupo.add(checkNo);
//    }
}
