/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.classes.Persona;
import com.classes.Rol;
import com.classes.Usuario;
import com.conexion.PersonaDao;
import com.conexion.RolDAO;
import com.conexion.UsuarioDao;
import com.table.TableActionCellEditor;
import com.table.TableActionCellRender;
import com.table.TableActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanj
 */
public class ListUsersPanel extends javax.swing.JPanel {

    DefaultTableModel model;

    public ListUsersPanel() {
        initComponents();
        model = (DefaultTableModel) table.getModel();
        anchoFilas();
        registrar();
        formatTable();
    }

    private void registrar() {
        List<Usuario> usuarios = UsuarioDao.seleccionar();
        usuarios.forEach(usuario ->
        {
            Persona p = PersonaDao.seleccionIndividual(new Persona(usuario.getIdPersona()));
            Rol r = RolDAO.seleccionIndividual(new Rol(usuario.getIdRol()));
            System.out.println(usuario);
            //System.out.println(p);
            //System.out.println(r);
            model.addRow(new Object[]
            {
                usuario.getIdUsuario(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), r.getNombre(), p.getTelefono1(), p.getEmail()
            });
        });
    }

    public void formatTable() {
        try
        {
            TableActionEvent event = new TableActionEvent() {
                @Override
                public void onEdit(int row) {
                    System.out.println("Edit roooooooooooow : " + row);
                }

                @Override
                public void onDelete(int row) {
                    if (table.isEditing())
                    {
                        table.getCellEditor().stopCellEditing();
                    }
                    int fila = table.getSelectedRow();
                    int idUsuario = Integer.parseInt(table.getValueAt(fila, 0).toString());
                    
                    Usuario usuario = UsuarioDao.seleccionIndividual(new Usuario(idUsuario));
                    UsuarioDao.eliminar(new Usuario(usuario.getIdUsuario()));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        table.setSelectionBackground(new java.awt.Color(20, 169, 98));
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
