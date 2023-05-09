/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newFondo;

import com.admin.PrincipalAdmin;
import com.cashiers.VentanaCajero;
import com.classes.Usuario;
import com.conexion.UsuarioDao;
import com.counter.VentanaContador;
import static com.settings.CambiarColorJButton.cambiarColorJButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import com.settings.ObjGraficosService;
import com.settings.Recursos;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.net.URI;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginTemplate extends JFrame {

    private JPanel pDerecha, pIzquierda;
    private JLabel lTituloApp, /*lEslogan,*/ lTituloLogin, lNotificaciones, lFondo, lSvg1, lLogo, lUsuario, lClave, lFacebook/*, lTwitter, lYoutube*/;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
//    private JComboBox cbTipoUsuario;
    private JButton bEntrar, bCerrar, /*bRegistrarse,*/ bOpcion1, bOpcion2, bOpcion3;
    private JCheckBox checkSi, checkNo;
    private ButtonGroup grupo;

    private ImageIcon iFondo, iLogo;
    private ImageIcon iSvg1, iUsuario2, iClave2, iPunto1, iFacebook1, iTwitter1, iYoutube1, iDimAux;

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
        this.crearJCheckBoxes();
        this.crearJLabels();
        this.confVentana();

        eventos();
    }

    public void eventos() {
        cambiarColorJButton(bCerrar);
        //Evento de cerra la ventana en la x
        bCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana al hacer clic en el JButton
                System.exit(0);
            }
        });
        //evento de enter sobre el jtextfield
        tNombreUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bEntrar.doClick();
            }
        });
        //El mismo evento de arriba pero con otro jtextfield
        tClaveUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bEntrar.doClick();
            }
        });
        //Evento del boton para el login
        bEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana al hacer clic en el JButton
                loggear();
            }
        });
        //sombrear toda la caja de password
        tClaveUsuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                // Seleccionar todo el contenido del JTextField al hacer clic en él
                tClaveUsuario.selectAll();
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
        Usuario usuario = buscar(user, password);

        if (usuario != null)
        {
            int idRol = usuario.getIdRol();
            switch (idRol)
            {
                case 1:
                    runApplication = new Runnable() {
                        public void run() {
                            VentanaCajero cajero = new VentanaCajero();
                            cajero.getClass();
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
        } else
        {
            JOptionPane.showMessageDialog(this, "El usuario o contraseña son incorrectos", "Error", HEIGHT);
        }
    }

    private Usuario buscar(String user, String password) {
        List<Usuario> usuarios = UsuarioDao.seleccionar();
        Usuario userLogin = null;
        for (Usuario usuario : usuarios)
        {
            if (usuario.getNomUsuario().equals(user) && usuario.getContrasenia().equals(password))
            {
                userLogin = usuario;
                break;
            }
        }
        return userLogin;
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
        tNombreUsuario = sObjGraficos.construirJTextField("Nombre Usuario", (pDerecha.getWidth() - 260) / 2, 150, 260, 40,
                sRecursos.getFontTitulo2(), Color.WHITE, sRecursos.getColorPrincipal(), sRecursos.getColorGrisOscuro(),
                sRecursos.getBorderInferiorAzul(), "c");
        tNombreUsuario.selectAll();
        pDerecha.add(tNombreUsuario);
    }

    public void crearObjetosDecoradores() {

        iFondo = new ImageIcon("src/main/resources/newLogin/fondo.png");
        iLogo = new ImageIcon("src/main/resources/newLogin/logo.png");
        iUsuario2 = new ImageIcon("src/main/resources/newLogin/usuario2.png");
        iClave2 = new ImageIcon("src/main/resources/newLogin/clave2.png");
        iPunto1 = new ImageIcon("src/main/resources/newLogin/punto1.png");
        iFacebook1 = new ImageIcon("src/main/resources/newLogin/facebook1.png");
        iTwitter1 = new ImageIcon("src/main/resources/newLogin/twitter1.png");
        iYoutube1 = new ImageIcon("src/main/resources/newLogin/youtube1.png");
        iSvg1 = new ImageIcon("src/main/resources/newLogin/imagen1.png");
    }

    public void crearJButtons() {
        bEntrar = sObjGraficos.construirJButton(
                "Ingresar",
                (pDerecha.getWidth() - 250) / 2, 330, 250, 45,
                sRecursos.getCMano(),
                null, null,
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
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
        lTituloLogin = sObjGraficos.construirJLabel("Registra tus datos", (pDerecha.getWidth() - 150) / 2, 80, 150, 30,
                null, null, sRecursos.getFontTitulo2(), null, sRecursos.getColorGrisOscuro(),
                null, "c");
        pDerecha.add(lTituloLogin);

        lNotificaciones = sObjGraficos.construirJLabel("¿Recibir Notificaciones?", (pDerecha.getWidth() - 140) / 2, 400, 140, 20,
                null, null, sRecursos.getFontSubtitulo2(), null, sRecursos.getColorGrisOscuro(),
                null, "c");
        pDerecha.add(lNotificaciones);

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
    public void crearJCheckBoxes() {
        checkSi = sObjGraficos.construirJCheckBox("Si", (pDerecha.getWidth() - 375) / 2 - 15, 375, 45, 25,
                sRecursos.getCMano(), null, null);
        checkSi = new JCheckBox("Si");
        checkSi.setSize(45, 25);
        checkSi.setFocusable(false);
        checkSi.setBackground(Color.WHITE);
        checkSi.setLocation((pDerecha.getWidth() - checkSi.getWidth()) / 2 - 15, 375);
        checkSi.setCursor(sRecursos.getCMano());
        pDerecha.add(checkSi);

        checkNo = new JCheckBox("No");
        checkNo.setSize(45, 25);
        checkNo.setFocusable(false);
        checkNo.setBackground(Color.WHITE);
        checkNo.setLocation((pDerecha.getWidth() + checkNo.getWidth()) / 2 - 15, 375);
        checkNo.setCursor(sRecursos.getCMano());
        pDerecha.add(checkNo);

        grupo = new ButtonGroup();
        grupo.add(checkSi);
        grupo.add(checkNo);
    }

    private void generarFuentes() {

    }
}
