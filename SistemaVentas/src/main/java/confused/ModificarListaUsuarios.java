/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package confused;

import com.classes.Persona;
//import com.ventas.administrador.EditarUsuario;
//import com.ventas.administrador.FormCrearUsuario;
import com.settings.Configuracion;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import com.table.TableActionCellEditor;
import com.table.TableActionCellRender;
import com.table.TableActionEvent;

/**
 *
 * @author juanj
 */
public class ModificarListaUsuarios extends javax.swing.JFrame {
    
    /**
     * Creates new form test
     */
    public ModificarListaUsuarios() {
        //initComponents();
        Configuracion.titulo(btnAgregar);
        Configuracion.styles(this);
        this.setTitle("Lista de Usuarios");
        this.setMinimumSize(new Dimension(569,256));
        this.setExtendedState(MAXIMIZED_BOTH);
        TableActionEvent event=new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                datosActualizados();
            }

            @Override
            public void onDelete(int row) {
                if(table.isEditing()){
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model=(DefaultTableModel) table.getModel();
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
            }
        };
        table.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor(event));
    }
    private void registrar(Persona p, DefaultTableModel model){
       /* model.addRow(new Object[]{
            p.getId(),p.getNomUsuario(),p.getNombre(),p.getApellidoPaterno(),p.getApellidoMaterno(),p.getNumTelefono(),p.getCorreoElectronico(),p.getNacionalidad(),p.getCalle()
        });*/
    }
    public void actualizarDatos(){
        int fila=table.getSelectedRow();
        int id=Integer.parseInt(this.table.getValueAt(fila, 0).toString());
        String nombreUsuario=table.getValueAt(fila, 2).toString();
        String nombre=table.getValueAt(fila, 3).toString();
        String apellidoP=table.getValueAt(fila, 4).toString();
        String apellidoM=table.getValueAt(fila, 5).toString();
        String telefono=table.getValueAt(fila, 6).toString();
        String correoElec=table.getValueAt(fila, 7).toString();
        String nacionalidad=table.getValueAt(fila, 8).toString();
        String calle=table.getValueAt(fila, 9).toString();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        jPanel3.add(btnAgregar, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Usuarios");
        jPanel3.add(jLabel1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Name", "Apellido Paterno", "Apellido Materno", "Teléfono", "Correo Electrónico", "Nacionalidad", "Calle", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(20, 169, 98));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setPreferredWidth(50);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(9).setPreferredWidth(30);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try{
            agregar();
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    private void agregar(){
        try{
            /*FormCrearUsuario crear=new FormCrearUsuario(new JFrame(), true);
            crear.setVisible(true);
            DefaultTableModel model=(DefaultTableModel) table.getModel();
            registrar(crear.usuario(),model);*/
        } catch (Exception e)
        {
            System.err.print(e);
        }
    }
    private void datosActualizados(){
        int fila=table.getSelectedRow();
        long id=Long.parseLong(table.getValueAt(fila, 0).toString());
        String nombreUsuario=table.getValueAt(fila, 1).toString();
        String nombre=table.getValueAt(fila, 2).toString();
        String apellidoP=table.getValueAt(fila, 3).toString();
        String apellidoM=table.getValueAt(fila, 4).toString();
        long telefono=Long.parseLong(table.getValueAt(fila, 5).toString());
        String correoElec=table.getValueAt(fila, 6).toString();
        String nacionalidad=table.getValueAt(fila, 7).toString();
        String calle=table.getValueAt(fila, 8).toString();
        //Persona persona=new Persona(id, nombreUsuario, nombre, apellidoP, apellidoM, telefono, correoElec, nacionalidad, calle);

        //EditarUsuario actualizar=new EditarUsuario(this, true,persona);
        //actualizar.setVisible(true);
        //actualizar.usuario();   
        //nuevosDatos(actualizar.usuario(),fila);
    }
    private void nuevosDatos(Persona p,int fila){
        /*table.setValueAt(p.getId(),fila, 0);
        table.setValueAt(p.getNomUsuario(),fila, 1);
        table.setValueAt(p.getNombre(),fila, 2);
        table.setValueAt(p.getApellidoPaterno(),fila, 3);
        table.setValueAt(p.getApellidoMaterno(),fila, 4);
        table.setValueAt(p.getNumTelefono(),fila, 5);
        table.setValueAt(p.getCorreoElectronico(),fila, 6);
        table.setValueAt(p.getNacionalidad(),fila, 7);
        table.setValueAt(p.getCalle(),fila, 8);*/
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
