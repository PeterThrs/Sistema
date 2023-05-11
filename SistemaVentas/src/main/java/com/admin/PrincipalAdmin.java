package com.admin;

import com.librery.Animacion;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.librery.RSButtonMetro;
import com.newLogin.LoginTemplate;
import com.settings.Configuracion;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PrincipalAdmin extends javax.swing.JFrame {

    int x, y;
    private ListUsersPanel listaUsuarios;
    private ListProductsPanel listaProductos;

    public PrincipalAdmin() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);

        new CambiaPanel(pnlPrincipal, new InfoStore());
        desactivarBotonesIniciar();
        buscaar.setEnabled(false);
        listaUsuarios = new ListUsersPanel(this);
        listaProductos = new ListProductsPanel(this);
        buscaar.setVisible(false);

        setVisible(true);
    }

    public RSButtonMetro getBtnAdminProductos() {
        return btnAdminProductos;
    }

    public RSButtonMetro getBtnAdminUser() {
        return btnAdminUser;
    }

    public RSButtonMetro getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public RSButtonMetro getBtnConfiguracion() {
        return btnConfiguracion;
    }

    public RSButtonMetro getBtnHoome() {
        return btnHoome;
    }

    public RSButtonMetro getBtnInfoEmpresa() {
        return btnInfoEmpresa;
    }

    public RSButtonMetro getBtnListarProductos() {
        return btnListarProductos;
    }

    public RSButtonMetro getBtnListarUsuarios() {
        return btnListarUsuarios;
    }

    public void desactivarBotonesIniciar() {
        this.btnHoome.setColorNormal(new Color(239, 238, 244));
        this.btnHoome.setColorHover(new Color(204, 204, 204));
        this.btnHoome.setColorPressed(new Color(204, 204, 204));

        this.btnAdminUser.setColorNormal(new Color(239, 238, 244));
        this.btnAdminUser.setColorHover(new Color(204, 204, 204));
        this.btnAdminUser.setColorPressed(new Color(204, 204, 204));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        btnAdminUser = new com.librery.RSButtonMetro();
        btnInfoEmpresa = new com.librery.RSButtonMetro();
        btnAdminProductos = new com.librery.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        btnConfiguracion = new com.librery.RSButtonMetro();
        btnCerrarSesion = new com.librery.RSButtonMetro();
        btnListarProductos = new com.librery.RSButtonMetro();
        btnListarUsuarios = new com.librery.RSButtonMetro();
        btnHoome = new com.librery.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscaar = new com.librery.JCTextField();
        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlMenu.setBackground(new java.awt.Color(239, 238, 244));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(239, 238, 244)));

        btnAdminUser.setForeground(new java.awt.Color(128, 128, 131));
        btnAdminUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/administracion.png"))); // NOI18N
        btnAdminUser.setText("Administrar Usuarios");
        btnAdminUser.setColorHover(new java.awt.Color(204, 204, 204));
        btnAdminUser.setColorNormal(new java.awt.Color(204, 204, 204));
        btnAdminUser.setColorPressed(new java.awt.Color(204, 204, 204));
        btnAdminUser.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnAdminUser.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnAdminUser.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnAdminUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdminUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdminUser.setIconTextGap(25);
        btnAdminUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAdminUserMousePressed(evt);
            }
        });
        btnAdminUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminUserActionPerformed(evt);
            }
        });

        btnInfoEmpresa.setBackground(new java.awt.Color(239, 238, 244));
        btnInfoEmpresa.setForeground(new java.awt.Color(128, 128, 131));
        btnInfoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/George/Datos de la empresa.png"))); // NOI18N
        btnInfoEmpresa.setText("  Datos de la Empresa");
        btnInfoEmpresa.setColorHover(new java.awt.Color(204, 204, 204));
        btnInfoEmpresa.setColorNormal(new java.awt.Color(239, 238, 244));
        btnInfoEmpresa.setColorPressed(new java.awt.Color(204, 204, 204));
        btnInfoEmpresa.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnInfoEmpresa.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnInfoEmpresa.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnInfoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInfoEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInfoEmpresa.setIconTextGap(19);
        btnInfoEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInfoEmpresaMousePressed(evt);
            }
        });
        btnInfoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoEmpresaActionPerformed(evt);
            }
        });

        btnAdminProductos.setBackground(new java.awt.Color(239, 238, 244));
        btnAdminProductos.setForeground(new java.awt.Color(128, 128, 131));
        btnAdminProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/George/AP (2).png"))); // NOI18N
        btnAdminProductos.setText("Administrar Productos");
        btnAdminProductos.setColorHover(new java.awt.Color(204, 204, 204));
        btnAdminProductos.setColorNormal(new java.awt.Color(239, 238, 244));
        btnAdminProductos.setColorPressed(new java.awt.Color(204, 204, 204));
        btnAdminProductos.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnAdminProductos.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnAdminProductos.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnAdminProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdminProductos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdminProductos.setIconTextGap(25);
        btnAdminProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAdminProductosMousePressed(evt);
            }
        });
        btnAdminProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProductosActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(239, 238, 244));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        btnConfiguracion.setBackground(new java.awt.Color(239, 238, 244));
        btnConfiguracion.setForeground(new java.awt.Color(128, 128, 131));
        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuracion.png"))); // NOI18N
        btnConfiguracion.setText("  Configuración");
        btnConfiguracion.setColorHover(new java.awt.Color(204, 204, 204));
        btnConfiguracion.setColorNormal(new java.awt.Color(239, 238, 244));
        btnConfiguracion.setColorPressed(new java.awt.Color(204, 204, 204));
        btnConfiguracion.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnConfiguracion.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnConfiguracion.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConfiguracion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConfiguracion.setIconTextGap(19);
        btnConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfiguracionMousePressed(evt);
            }
        });
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(239, 238, 244));
        btnCerrarSesion.setForeground(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setText("  Cerrar Sesión");
        btnCerrarSesion.setColorHover(new java.awt.Color(204, 204, 204));
        btnCerrarSesion.setColorNormal(new java.awt.Color(239, 238, 244));
        btnCerrarSesion.setColorPressed(new java.awt.Color(204, 204, 204));
        btnCerrarSesion.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCerrarSesion.setIconTextGap(19);
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMousePressed(evt);
            }
        });
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnListarProductos.setBackground(new java.awt.Color(239, 238, 244));
        btnListarProductos.setForeground(new java.awt.Color(128, 128, 131));
        btnListarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/George/Administrar productos.png"))); // NOI18N
        btnListarProductos.setText(" Listar Productos");
        btnListarProductos.setColorHover(new java.awt.Color(204, 204, 204));
        btnListarProductos.setColorNormal(new java.awt.Color(239, 238, 244));
        btnListarProductos.setColorPressed(new java.awt.Color(204, 204, 204));
        btnListarProductos.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnListarProductos.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnListarProductos.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnListarProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListarProductos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnListarProductos.setIconTextGap(25);
        btnListarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListarProductosMousePressed(evt);
            }
        });
        btnListarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProductosActionPerformed(evt);
            }
        });

        btnListarUsuarios.setBackground(new java.awt.Color(239, 238, 244));
        btnListarUsuarios.setForeground(new java.awt.Color(128, 128, 131));
        btnListarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/George/Listar usuarios.png"))); // NOI18N
        btnListarUsuarios.setText(" Listar Usuarios");
        btnListarUsuarios.setColorHover(new java.awt.Color(204, 204, 204));
        btnListarUsuarios.setColorNormal(new java.awt.Color(239, 238, 244));
        btnListarUsuarios.setColorPressed(new java.awt.Color(204, 204, 204));
        btnListarUsuarios.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnListarUsuarios.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnListarUsuarios.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnListarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListarUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnListarUsuarios.setIconTextGap(25);
        btnListarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListarUsuariosMousePressed(evt);
            }
        });
        btnListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarUsuariosActionPerformed(evt);
            }
        });

        btnHoome.setForeground(new java.awt.Color(128, 128, 131));
        btnHoome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btnHoome.setText("Home");
        btnHoome.setColorHover(new java.awt.Color(204, 204, 204));
        btnHoome.setColorNormal(new java.awt.Color(204, 204, 204));
        btnHoome.setColorPressed(new java.awt.Color(204, 204, 204));
        btnHoome.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnHoome.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnHoome.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnHoome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHoome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHoome.setIconTextGap(25);
        btnHoome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHoomeMousePressed(evt);
            }
        });
        btnHoome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInfoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdminUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHoome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdminProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHoome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdminUser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdminProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInfoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 8.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(pnlMenu, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema Ventas");

        buscaar.setBackground(new java.awt.Color(38, 86, 186));
        buscaar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        buscaar.setForeground(new java.awt.Color(255, 255, 255));
        buscaar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buscaar.setPhColor(new java.awt.Color(255, 255, 255));
        buscaar.setPlaceholder("Buscar");
        buscaar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaarActionPerformed(evt);
            }
        });
        buscaar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscaarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                .addComponent(buscaar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnlCentro.setBackground(new java.awt.Color(239, 238, 244));

        jScrollPane1.setBorder(null);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlPrincipal);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnlCentro, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void userAction() {
        Configuracion.colorSelectedBotones(this.btnAdminUser, this.btnAdminProductos, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
    }

    public void cambiarPanelExterno(JPanel panel) {
        try
        {
            new CambiaPanel(pnlPrincipal, panel);
            Configuracion.colorSelectedBotones(this.btnAdminUser, this.btnHoome, this.btnAdminProductos, this.btnListarUsuarios, this.btnListarProductos, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
        this.repaint();
    }

    private void adminAction() {
        Configuracion.colorSelectedBotones(this.btnAdminProductos, this.btnAdminUser, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Pequeño cuerpo de codigo que hara que la ventana se acople al tamaño real.
        if (pnlMenu.isVisible())
        {
            pnlMenu.setVisible(false);
        } else
        {
            pnlMenu.setVisible(true);
        }

        // Este es otro codigo. 
        try
        {
            int posicion = pnlMenu.getX();
            if (posicion > -1)
            {
                Animacion.mover_izquierda(0, -264, 2, 2, pnlMenu);
            } else
            {
                Animacion.mover_derecha(-264, 0, 2, 2, pnlMenu);
            }
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, " -> ESTA OPCIÓN ESTA EN PROCESO DE MANTENIMIENTO.");

    }

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:

    }

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
            new CambiaPanel(pnlPrincipal, new InfoStore());
            if (this.btnHoome.isSelected())
            {
                this.btnAdminUser.setColorNormal(new Color(239, 238, 244));
                this.btnAdminUser.setColorHover(new Color(204, 204, 204));
                this.btnAdminUser.setColorPressed(new Color(204, 204, 204));

                this.btnAdminProductos.setColorNormal(new Color(239, 238, 244));
                this.btnAdminProductos.setColorHover(new Color(204, 204, 204));
                this.btnAdminProductos.setColorPressed(new Color(204, 204, 204));

                this.btnListarUsuarios.setColorNormal(new Color(239, 238, 244));
                this.btnListarUsuarios.setColorHover(new Color(204, 204, 204));
                this.btnListarUsuarios.setColorPressed(new Color(204, 204, 204));

                this.btnListarProductos.setColorNormal(new Color(239, 238, 244));
                this.btnListarProductos.setColorHover(new Color(204, 204, 204));
                this.btnListarProductos.setColorPressed(new Color(204, 204, 204));

                this.btnInfoEmpresa.setColorNormal(new Color(239, 238, 244));
                this.btnInfoEmpresa.setColorHover(new Color(204, 204, 204));
                this.btnInfoEmpresa.setColorPressed(new Color(204, 204, 204));

                this.btnConfiguracion.setColorNormal(new Color(239, 238, 244));
                this.btnConfiguracion.setColorHover(new Color(204, 204, 204));
                this.btnConfiguracion.setColorPressed(new Color(204, 204, 204));

                this.btnHoome.setColorNormal(new Color(204, 204, 204));
                this.btnHoome.setColorHover(new Color(204, 204, 204));
                this.btnHoome.setColorPressed(new Color(204, 204, 204));

                this.btnCerrarSesion.setColorNormal(new Color(239, 238, 244));
                this.btnCerrarSesion.setColorHover(new Color(204, 204, 204));
                this.btnCerrarSesion.setColorPressed(new Color(204, 204, 204));
            } else
            {
                this.btnHoome.setColorNormal(new Color(239, 238, 244));
                this.btnHoome.setColorHover(new Color(204, 204, 204));
                this.btnHoome.setColorPressed(new Color(204, 204, 204));
            }
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }

    private void btnHoomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoomeMousePressed
        try
        {
            this.btnHoome.setSelected(true);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnHoomeMousePressed

    private void btnListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarUsuariosActionPerformed
        try
        {
            buscaar.setVisible(true);
            buscaar.setEnabled(true);
            buscaar.setText("");
            new CambiaPanel(pnlPrincipal, listaUsuarios);
            listaUsuarios.registrar();
            Configuracion.colorSelectedBotones(this.btnListarUsuarios, this.btnHoome, this.btnAdminProductos, this.btnAdminUser, this.btnListarProductos, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnListarUsuariosActionPerformed

    private void btnListarUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarUsuariosMousePressed
        try
        {
            this.btnHoome.setSelected(false);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(true);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnListarUsuariosMousePressed

    private void btnListarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProductosActionPerformed
        try
        {
            buscaar.setVisible(true);
            buscaar.setEnabled(true);
            buscaar.setText("");
            new CambiaPanel(pnlPrincipal, listaProductos);
            listaProductos.registrar();
            Configuracion.colorSelectedBotones(this.btnListarProductos, this.btnHoome, this.btnAdminUser, this.btnAdminProductos, this.btnListarUsuarios, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnListarProductosActionPerformed

    private void btnListarProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarProductosMousePressed
        try
        {
            this.btnHoome.setSelected(false);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(true);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnListarProductosMousePressed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        try
        {
            buscaar.setVisible(false);
            buscaar.setEnabled(false);
            Configuracion.colorSelectedBotones(this.btnCerrarSesion, this.btnHoome, this.btnAdminUser, this.btnAdminProductos, this.btnListarProductos, this.btnListarUsuarios, this.btnInfoEmpresa, this.btnConfiguracion);
            this.dispose();
            LoginTemplate log = new LoginTemplate();
            log.setVisible(true);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCerrarSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMousePressed
        try
        {
            this.btnHoome.setSelected(false);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(true);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnCerrarSesionMousePressed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        try
        {
            buscaar.setVisible(false);
            buscaar.setEnabled(false);
            Configuracion.colorSelectedBotones(this.btnConfiguracion, this.btnHoome, this.btnAdminUser, this.btnAdminProductos, this.btnListarProductos, this.btnListarUsuarios, this.btnInfoEmpresa, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnConfiguracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMousePressed
        try
        {
            this.btnHoome.setSelected(false);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(true);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnConfiguracionMousePressed

    private void btnAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProductosActionPerformed
        try
        {
            buscaar.setVisible(false);
            buscaar.setEnabled(false);
            new CambiaPanel(pnlPrincipal, new com.admin.PanelProducto());
            Configuracion.colorSelectedBotones(this.btnAdminProductos, this.btnHoome, this.btnAdminUser, this.btnListarUsuarios, this.btnListarProductos, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnAdminProductosActionPerformed

    private void btnAdminProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminProductosMousePressed
        try
        {
            this.btnHoome.setSelected(false);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(true);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnAdminProductosMousePressed

    private void btnInfoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoEmpresaActionPerformed
        try
        {
            buscaar.setVisible(false);
            buscaar.setEnabled(false);
            new CambiaPanel(pnlPrincipal, new com.admin.EditInfoStore());
            Configuracion.colorSelectedBotones(this.btnInfoEmpresa, this.btnHoome, this.btnAdminUser, this.btnAdminProductos, this.btnListarProductos, this.btnListarUsuarios, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnInfoEmpresaActionPerformed

    private void btnInfoEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoEmpresaMousePressed
        try
        {
            this.btnHoome.setSelected(false);
            this.btnAdminUser.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(true);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnInfoEmpresaMousePressed

    private void btnAdminUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminUserActionPerformed
        try
        {
            buscaar.setVisible(false);
            buscaar.setEnabled(false);
            new CambiaPanel(pnlPrincipal, new com.admin.PanelUserNew());
            Configuracion.colorSelectedBotones(this.btnAdminUser, this.btnHoome, this.btnAdminProductos, this.btnListarUsuarios, this.btnListarProductos, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnAdminUserActionPerformed

    private void btnAdminUserMousePressed(java.awt.event.MouseEvent evt) {
        try
        {
            this.btnAdminUser.setSelected(true);
            this.btnHoome.setSelected(false);
            this.btnListarUsuarios.setSelected(false);
            this.btnListarProductos.setSelected(false);
            this.btnAdminProductos.setSelected(false);
            this.btnInfoEmpresa.setSelected(false);
            this.btnConfiguracion.setSelected(false);
            this.btnCerrarSesion.setSelected(false);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }

    private void btnHoomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoomeActionPerformed
        try
        {
            buscaar.setEnabled(false);
            buscaar.setVisible(false);
            new CambiaPanel(pnlPrincipal, new InfoStore());
            Configuracion.colorSelectedBotones(this.btnHoome, this.btnAdminUser, this.btnAdminProductos, this.btnListarProductos, this.btnListarUsuarios, this.btnInfoEmpresa, this.btnConfiguracion, this.btnCerrarSesion);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnHoomeActionPerformed

    private void buscaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaarActionPerformed
        if (btnListarUsuarios.isSelected() && !buscaar.getText().isEmpty())
        {
            listaUsuarios.buscarENtabla(buscaar.getText());
        } else if (btnListarProductos.isSelected() && !buscaar.getText().isEmpty())
        {
            listaProductos.buscarENtabla(buscaar.getText());
        } else if (btnListarProductos.isSelected() && buscaar.getText().isEmpty())
        {            
            listaProductos = new ListProductsPanel(this);
            new CambiaPanel(pnlPrincipal, listaProductos);
        } else if (btnListarUsuarios.isSelected() && buscaar.getText().isEmpty())
        {
            listaUsuarios = new ListUsersPanel(this);
            new CambiaPanel(pnlPrincipal, listaUsuarios);
        }
    }//GEN-LAST:event_buscaarActionPerformed

    private void buscaarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaarKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_buscaarKeyPressed

    public static void main(String args[]) {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new PrincipalAdmin().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
                {
                    Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.librery.RSButtonMetro btnAdminProductos;
    private com.librery.RSButtonMetro btnAdminUser;
    private com.librery.RSButtonMetro btnCerrarSesion;
    private com.librery.RSButtonMetro btnConfiguracion;
    private com.librery.RSButtonMetro btnHoome;
    private com.librery.RSButtonMetro btnInfoEmpresa;
    private com.librery.RSButtonMetro btnListarProductos;
    private com.librery.RSButtonMetro btnListarUsuarios;
    private com.librery.JCTextField buscaar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
