package com.admin;

import com.admin.enumerador.Entrada;
import com.classes.Persona;
import com.classes.Rol;
import com.classes.Usuario;
import com.conexion.PersonaDao;
import com.conexion.RolDAO;
import com.conexion.UsuarioDao;
import com.settings.Configuracion;
import com.settings.Recursos;
import com.table.TableActionCellEditor;
import com.table.TableActionCellRender;
import com.table.TableActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ListUsersPanel extends javax.swing.JPanel {

    private DefaultTableModel model;
    private List<Usuario> usuarios;
    private Usuario usuario;
    private Persona persona;
    private PrincipalAdmin principalAdmin;
    private UsuarioDao usuarioDao;
    private Recursos recursos;
    private DefaultTableCellRenderer centerRenderer;
    private String estatus;
    
    public ListUsersPanel(PrincipalAdmin principalAdmin) {
        estatus = "";
        usuarioDao = new UsuarioDao();
        recursos = Recursos.getService();
        initComponents();
        this.model = (DefaultTableModel) table.getModel();

        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.principalAdmin = principalAdmin;
        anchoFilas();
        registrar();
        formatTable();
        clicSecundario();
    }

    public void registrar() {
        model.setRowCount(0);
        this.usuarios = UsuarioDao.seleccionar();

        usuarios.forEach(usuario ->
        {
            String estatus = "";
            estatus = (usuario.getStatus() == 1) ? "Activo" : "Inactivo";
            Persona p = PersonaDao.seleccionIndividual(new Persona(usuario.getIdPersona()));
            Rol r = RolDAO.seleccionIndividual(new Rol(usuario.getIdRol()));
            model.addRow(new Object[]
            {
                usuario.getIdUsuario(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), estatus, r.getNombre(), p.getTelefono1(), p.getEmail()

            });
        });
    }

    private void registrarPorFiltro(int id) {

        this.usuarios.forEach(usuario ->
        {
            estatus = (usuario.getStatus() == 1) ? "Activo" : "Inactivo";
            Persona p = PersonaDao.seleccionIndividual(new Persona(usuario.getIdPersona()));
            Rol r = RolDAO.seleccionIndividual(new Rol(usuario.getIdRol()));
            if (id == r.getIdRol())
            {
                model.addRow(new Object[]
                {
                    usuario.getIdUsuario(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), estatus, r.getNombre(), p.getTelefono1(), p.getEmail()

                });
            }
        });
        if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos en esta categoria");
            registrar();
        }
    }

    public void formatTable() {
        try {
            TableActionEvent event = new TableActionEvent() {
                @Override
                public void onEdit(int row) {
                    System.out.println("Edit roooooooooooow : " + row);

                    int idUsuario = (int) table.getValueAt(row, 0);

                    usuario = usuarios.stream().filter(e -> (e.getIdUsuario() == idUsuario)).findFirst().get();

                    persona = new Persona(usuario.getIdPersona());

                    PersonaDao personaDao = new PersonaDao();
                    persona = personaDao.seleccionIndividual(persona);

                    //RolDAO rolDao = new RolDao(); 
                    //Rol rol = rolDao.seleccionIndividual(new Rol(usuario.getIdRol()));
                    System.out.println("Imprimiendo desde la clase Listar Usuarios");
                    System.out.println("usuario = " + usuario);
                    System.out.println("persona = " + persona);
                    principalAdmin.cambiarPanelExterno(new PanelUserNew(usuario, persona));
                    Configuracion.colorSelectedBotones(principalAdmin.getBtnAdminUser(), principalAdmin.getBtnHoome(), principalAdmin.getBtnAdminProductos(), principalAdmin.getBtnListarUsuarios(), principalAdmin.getBtnListarProductos(), principalAdmin.getBtnInfoEmpresa(), principalAdmin.getBtnCerrarSesion());
                    principalAdmin.repaint();
                }

                @Override
                public void onDelete(int row) {
                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }
                    int fila = table.getSelectedRow();
                    int idUsuario = Integer.parseInt(table.getValueAt(fila, 0).toString());

                    Usuario usuario = usuarioDao.seleccionIndividual(new Usuario(idUsuario));
                    UsuarioDao.eliminar(usuario);
                    PersonaDao.eliminar(new Persona(usuario.getIdPersona()));

                    model.removeRow(row);
                }

                @Override
                public void onView(int row) {
                    System.out.println("View row : " + row);
                    int idUsuario = (int) table.getValueAt(row, 0);

                    usuario = usuarios.stream().filter(e -> (e.getIdUsuario() == idUsuario)).findFirst().get();

                    persona = new Persona(usuario.getIdPersona());

                    PersonaDao personaDao = new PersonaDao();
                    persona = personaDao.seleccionIndividual(persona);

                    //RolDAO rolDao = new RolDao(); 
                    //Rol rol = rolDao.seleccionIndividual(new Rol(usuario.getIdRol()));
                    System.out.println("Imprimiendo desde la clase Listar Usuarios");
                    System.out.println("usuario = " + usuario);
                    System.out.println("persona = " + persona);
                    principalAdmin.cambiarPanelExterno(new PanelUserNew(usuario, persona));
                    Configuracion.colorSelectedBotones(principalAdmin.getBtnAdminUser(), principalAdmin.getBtnHoome(), principalAdmin.getBtnAdminProductos(), principalAdmin.getBtnListarUsuarios(), principalAdmin.getBtnListarProductos(), principalAdmin.getBtnInfoEmpresa(), principalAdmin.getBtnCerrarSesion());
                    principalAdmin.repaint();
                }
            };


            table.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
            table.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));

            for (int i = 0; i < table.getColumnCount()-1; i++)
            {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void anchoFilas() {
        table.getColumnModel().getColumn(0).setPreferredWidth(15);

        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(50);
//        for (int i = 1; i < table.getColumnCount() - 1; i++)
//        {
//            table.getColumnModel().getColumn(i).setPreferredWidth(160);
//        }
    }

    public void clicSecundario() {
//        try
//        {
//            UIManager.setLookAndFeel(new FlatLightLaf());
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        JPopupMenu popupMenu = new JPopupMenu();

        List<Rol> roles = RolDAO.seleccionar();
        List<JMenuItem> subMenus = new ArrayList<>();

        JMenu subMenu = new JMenu("Filtrar por");

        roles.forEach(rol
                -> {
            subMenus.add(new JMenuItem(rol.getNombre()));
        });
        subMenus.add(new JMenuItem("General"));

        subMenus.forEach(submenu
                -> {
            subMenu.add(submenu);
            subMenu.addSeparator();
        });
        popupMenu.add(subMenu);

        for (int i = 0; i < subMenus.size() - 1; i++) {
            eventoSubmenu(subMenus.get(i), i + 1);
        }
        subMenus.get(3).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrar();
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopupMenu(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopupMenu(e);
            }

            private void showPopupMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    public void eventoSubmenu(JMenuItem subMenu, int id) {
        subMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                registrarPorFiltro(id);
            }
        });
    }

    public void buscarENtabla(String texto) {
        recursos.buscarEnTabla(table, texto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Estatus", "Rol", "Teléfono", "Correo electrónico", "Opciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
