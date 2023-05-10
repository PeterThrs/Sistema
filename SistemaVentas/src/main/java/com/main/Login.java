package com.main;

//import com.cashiers.Ventana;
import com.counter.VentanaContador;
import com.classes.Sesion;
import com.settings.CodigoColor;
import java.awt.event.KeyEvent;
import com.settings.Configuracion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.admin.PrincipalAdmin;
import com.classes.Usuario;
import com.conexion.PersonaDao;
import com.conexion.UsuarioDao;
import java.util.List;
import javax.swing.SwingUtilities;

public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;
    public FondoPanel fondo = new FondoPanel();
    Runnable runApplication;

    public Login() {
        initComponents();
        agregarEstilos();

        this.setIconImage(Sesion.app.getIcono());

        ImageIcon wallpaper = new ImageIcon("src/main/resources/images/User.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_DEFAULT));

        iconUser.setIcon(new Configuracion().setIconoEtiqueta("/user.png", iconUser));
        iconPassword.setIcon(new Configuracion().setIconoEtiqueta("/password icon.png", iconPassword));
        jLogo.setIcon(new Configuracion().setIconoEtiqueta("/logo.png", jLogo));
        this.image.setIcon(icono);
        this.repaint();

        setVisible(true);
    }

    private void agregarEstilos() {
        //configuracion de la ventana 
        Configuracion.styles(this);
        this.setExtendedState(this.NORMAL);

        //configuracion al JPanel
        Configuracion.background(CodigoColor.cFondoGris, this.PanelDerecho, this.header);
        //Configuracion.background(CodigoColor.cFondoGris); 

        //configuracion JLabel
        Configuracion.titulo(this.jLabel2, this.jlTitulo);
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jlTitulo, this.jLabel2);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlTitulo);

        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jLabel3, this.jLabel4,
                this.jLabel5, this.jlPassword, this.jlUser);
        Configuracion.robotoItalic14(this.jLabel3, this.jLabel4,
                this.jLabel5, this.jlPassword, this.jlUser);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jLabel3, this.jLabel4,
                this.jLabel5, this.jlPassword, this.jlUser);
        Configuracion.foreground(CodigoColor.cLetrasBlanco, this.jLabel3, this.jLabel4,
                this.jLabel5);

        //configuraicon JTextField
        Configuracion.robotoPlain12(this.cPassword, this.cUser);
        Configuracion.withoutBorde(this.cPassword, this.cUser);
        Configuracion.background(CodigoColor.cFondoGris, this.cUser, this.cPassword);
        Configuracion.foreground(CodigoColor.cLetrasTextField, this.cUser, this.cPassword);

        //configuracion JSeparator
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.jSeparator1, this.jSeparator2);

        //configuracion JButton
        Configuracion.robotoItalic14(this.jIngresar);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.jIngresar);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.jIngresar);

        //configuracion JSpinner
    }

    public void Cerrar() {
        this.dispose();
    }

    /*@Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage("src/main/resources/images/icono/austronauta.png");
        return retValue;
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDerecho = new javax.swing.JPanel();
        header = new FondoPanel();
        jlPassword = new javax.swing.JLabel();
        jIngresar = new javax.swing.JButton();
        jlUser = new javax.swing.JLabel();
        cUser = new javax.swing.JTextField();
        cPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        iconPassword = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLogo = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelDerecho.setBackground(new java.awt.Color(255, 255, 255));
        PanelDerecho.setPreferredSize(new java.awt.Dimension(1100, 700));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jlPassword.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jlPassword.setText("CONTRASEÑA:");

        jIngresar.setBackground(new java.awt.Color(0, 51, 102));
        jIngresar.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jIngresar.setText("INGRESAR");
        jIngresar.setBorder(null);
        jIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jIngresarMouseExited(evt);
            }
        });
        jIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIngresarActionPerformed(evt);
            }
        });
        jIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jIngresarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jIngresarKeyReleased(evt);
            }
        });

        jlUser.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jlUser.setText("USUARIO:");

        cUser.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cUser.setBorder(null);
        cUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cUserMousePressed(evt);
            }
        });
        cUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUserActionPerformed(evt);
            }
        });
        cUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cUserKeyPressed(evt);
            }
        });

        cPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cPassword.setBorder(null);
        cPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cPasswordMousePressed(evt);
            }
        });
        cPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPasswordActionPerformed(evt);
            }
        });
        cPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cPasswordKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("INICIAR SESIÓN");

        iconPassword.setText("jLabel6");

        iconUser.setText("jLabel6");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Todos los derechos reservados © 2023.");

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(0, 0, 102));
        jlTitulo.setText("SISTEMA DE VENTAS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("SisVentas®");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Un producto de PJEJ Consulting.");

        close.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        close.setForeground(new java.awt.Color(51, 51, 255));
        close.setText("    X");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setPreferredSize(new java.awt.Dimension(40, 40));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jlTitulo))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cUser, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(iconPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel4))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel5))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addContainerGap(120, Short.MAX_VALUE)
                        .addComponent(jlTitulo)
                        .addGap(54, 54, 54))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlUser)
                            .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(cUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );

        javax.swing.GroupLayout PanelDerechoLayout = new javax.swing.GroupLayout(PanelDerecho);
        PanelDerecho.setLayout(PanelDerechoLayout);
        PanelDerechoLayout.setHorizontalGroup(
            PanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelDerechoLayout.setVerticalGroup(
            PanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void cPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            jIngresar.setBackground(Color.RED);

            try {
                loggear();
//                String user = cUser.getText();
//                String password = String.valueOf(cPassword.getPassword());
//                boolean correcto = Sesion.validar(user, password);
//
//                if (correcto) {
//                    if (user.equals(Sesion.seguridad.getUserAdmin())) {
//                        Runnable runApplication = new Runnable() {
//                            public void run() {
//                                PrincipalAdmin pa = new PrincipalAdmin();
//                                pa.getClass();
//                            }
//                        };
//                        SwingUtilities.invokeLater(runApplication);
//                    } else if (user.equals(Sesion.seguridad.getUserCount())) {
//                        Runnable runApplication = new Runnable() {
//                            public void run() {
//                                VentanaContador ic = new VentanaContador();
//                                ic.getClass();
//                            }
//                        };
//                        SwingUtilities.invokeLater(runApplication);
//                    } else {
//                        Runnable runApplication = new Runnable() {
//                            public void run() {
//                                VentanaCajero vc = new VentanaCajero();
//                                vc.getClass();
//                            }
//                        };
//                        SwingUtilities.invokeLater(runApplication);
//                    }
//                    this.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(this, "El usuario o contraseña son incorrectos", "Error", HEIGHT);
//                }
            } catch (Exception ex) {

            }

        }
    }//GEN-LAST:event_cPasswordKeyPressed

    private void cPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPasswordActionPerformed

    private void cPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cPasswordMousePressed
        // TODO add your handling code here:

        if (String.valueOf(cPassword.getPassword()).equals("")) {
            cPassword.setText("");
            cPassword.setForeground(Color.black);
        }

        if (cUser.getText().isEmpty()) {
            cUser.setText("");
            cUser.setForeground(Color.gray);
        }
    }//GEN-LAST:event_cPasswordMousePressed

    private void cUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cUserActionPerformed

    private void cUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cUserMousePressed
        if (cUser.getText().equals("")) {
            cUser.setText("");
            cUser.setForeground(Color.black);
        }

        if (String.valueOf(cPassword.getPassword()).isEmpty()) {
            cPassword.setText("");
            cPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_cUserMousePressed

    private void jIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIngresarKeyReleased

    }//GEN-LAST:event_jIngresarKeyReleased

    private void jIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIngresarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jIngresar.setBackground(Color.red);
        }
    }//GEN-LAST:event_jIngresarKeyPressed

    private void loggear() {
        String user = cUser.getText();
        String password = String.valueOf(cPassword.getPassword());
        Usuario usuario = buscar(user, password);

        if (usuario != null) {
            int idRol = usuario.getIdRol();
            switch (idRol) {
                case 1:
                    runApplication = new Runnable() {
                        public void run() {
                            //Ventana cajero = new Ventana();
                            //cajero.getClass();
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
        } else {
            JOptionPane.showMessageDialog(this, "El usuario o contraseña son incorrectos", "Error", HEIGHT);
        }
    }

    private void jIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIngresarActionPerformed
        try {
            loggear();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jIngresarActionPerformed

    private Usuario buscar(String user, String password) {
        List<Usuario> usuarios = UsuarioDao.seleccionar();
        Usuario userLogin = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNomUsuario().equals(user) && usuario.getContrasenia().equals(password)) {
                userLogin = usuario;
                break;
            }
        }
        return userLogin;
    }

    private void jIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIngresarMouseExited
        // TODO add your handling code here:
        jIngresar.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_jIngresarMouseExited

    private void jIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIngresarMouseEntered
        // TODO add your handling code here:
        jIngresar.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_jIngresarMouseEntered

    private void jIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIngresarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jIngresarMouseClicked

    private void closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_closeMousePressed

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_closeMouseExited

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        // TODO add your handling code here:
        close.setForeground(Color.red);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void cUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jIngresar.setBackground(Color.RED);
            try {
                loggear();
            } catch (Exception ex) {

            }

        }
    }//GEN-LAST:event_cUserKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDerecho;
    private javax.swing.JPasswordField cPassword;
    private javax.swing.JTextField cUser;
    private javax.swing.JLabel close;
    private javax.swing.JPanel header;
    private javax.swing.JLabel iconPassword;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel image;
    private javax.swing.JButton jIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUser;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon("src/main/resources/imagenes/juan/f.jpg").getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
