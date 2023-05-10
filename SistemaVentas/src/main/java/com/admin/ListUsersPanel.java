package com.admin;

import com.classes.Persona;
import com.classes.Rol;
import com.classes.Usuario;
import com.conexion.PersonaDao;
import com.conexion.RolDAO;
import com.conexion.UsuarioDao;
import com.formdev.flatlaf.FlatLightLaf;
import com.settings.Configuracion;
import com.table.TableActionCellEditor;
import com.table.TableActionCellRender;
import com.table.TableActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ListUsersPanel extends javax.swing.JPanel {

    private DefaultTableModel model;
    private List<Usuario> usuarios;
    private Usuario usuario;
    private Persona persona;
    private PrincipalAdmin principalAdmin;
    private UsuarioDao usuarioDao;

    public ListUsersPanel(PrincipalAdmin principalAdmin) {
        usuarioDao = new UsuarioDao();
        initComponents();
        this.model = (DefaultTableModel) table.getModel();
        this.principalAdmin = principalAdmin;
        anchoFilas();
        registrar();
        formatTable();
        clicSecundario();
    }

    private void registrar() {
        this.usuarios = UsuarioDao.seleccionar();
        usuarios.forEach(usuario ->
        {
            Persona p = PersonaDao.seleccionIndividual(new Persona(usuario.getIdPersona()));
            Rol r = RolDAO.seleccionIndividual(new Rol(usuario.getIdRol()));
            model.addRow(new Object[]
            {
                usuario.getIdUsuario(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), r.getNombre(), p.getTelefono1(), p.getEmail()
            });
        });
    }

    private void registrarPorFiltro(int id) {
        this.usuarios.forEach(usuario ->
        {
            Persona p = PersonaDao.seleccionIndividual(new Persona(usuario.getIdPersona()));
            Rol r = RolDAO.seleccionIndividual(new Rol(usuario.getIdRol()));
            if (id == r.getIdRol())
            {
                model.addRow(new Object[]
                {
                    usuario.getIdUsuario(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), r.getNombre(), p.getTelefono1(), p.getEmail()
                });
            }
        });
    }

    public void formatTable() {
        try
        {
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
                    Configuracion.colorSelectedBotones(principalAdmin.getBtnAdminUser(), principalAdmin.getBtnHoome(), principalAdmin.getBtnAdminProductos(), principalAdmin.getBtnListarUsuarios(), principalAdmin.getBtnListarProductos(), principalAdmin.getBtnInfoEmpresa(), principalAdmin.getBtnConfiguracion(), principalAdmin.getBtnCerrarSesion());
                    principalAdmin.repaint();
                }

                @Override
                public void onDelete(int row) {
                    if (table.isEditing())
                    {
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
                }
            };

            table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
            table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void anchoFilas() {
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        for (int i = 1; i < table.getColumnCount() - 1; i++)
        {
            table.getColumnModel().getColumn(i).setPreferredWidth(160);
        }
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

        roles.forEach(rol ->
        {
            subMenus.add(new JMenuItem(rol.getNombre()));
        });

        subMenus.forEach(submenu ->
        {
            subMenu.add(submenu);
            subMenu.addSeparator();
        });
        popupMenu.add(subMenu);

        for (int i = 0; i < subMenus.size(); i++)
        {
            eventoSubmenu(subMenus.get(i), i + 1);
        }

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopupMenu(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopupMenu(e);
            }

            private void showPopupMenu(MouseEvent e) {
                if (e.isPopupTrigger())
                {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido P", "Apellido M", "Rol", "Teléfono", "Correo e.", "Opciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
