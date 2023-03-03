/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Cajero;

import Objetos.Persona;
import Objetos.Sesion;
import com.ventas.administrador.FormCrearUsuario;
import com.ventas.administrador.FormCrearUsuario;
import java.sql.PreparedStatement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanj
 */
public class ModificarListaUsuarios extends javax.swing.JDialog {
    DefaultTableModel dtm=new DefaultTableModel();
    /**
     * Creates new form ModificarListaUsuarios
     */
    public ModificarListaUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(Sesion.app.getAppNombre());
        String[] titulo=new String[]{"Id","Usuario","Nombre","Apellido Paterno","Apellido Materno","Telefono","Correo electrónico","Nacionalidad","Calle"};
        dtm.setColumnIdentifiers(titulo);
        tblDatos.setModel(dtm);
    }
    private void agregar(Persona p){
        dtm.addRow(new Object[]{
            p.getId(),p.getNomUsuario(),p.getNombre(),p.getApellidoPaterno(),p.getApellidoMaterno(),p.getNumTelefono(),p.getCorreoElectronico(),p.getNacionalidad(),p.getCalle()
        });
    }
    private void eliminar(){
        int fila=tblDatos.getSelectedRow();
        dtm.removeRow(fila);
    }
    
    public void actualizarDatos(){
        int fila=tblDatos.getSelectedRow();
        int id=Integer.parseInt(this.tblDatos.getValueAt(fila, 0).toString());
        String nombreUsuario=tblDatos.getValueAt(fila, 2).toString();
        String nombre=tblDatos.getValueAt(fila, 3).toString();
        String apellidoP=tblDatos.getValueAt(fila, 4).toString();
        String apellidoM=tblDatos.getValueAt(fila, 5).toString();
        String telefono=tblDatos.getValueAt(fila, 6).toString();
        String correoElec=tblDatos.getValueAt(fila, 7).toString();
        String nacionalidad=tblDatos.getValueAt(fila, 8).toString();
        String calle=tblDatos.getValueAt(fila, 9).toString();
        System.out.println("");
        
        
    }
    private void actualizar2(){
        int fila=tblDatos.getSelectedRow();
        //dtm.setValueAt(jTextId.getText(), fila, 0);
        //dtm.setValueAt(jTextNombre.getText(), fila, 1);
        //dtm.setValueAt(jTextApellido.getText(), fila, 2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAgregar)
                .addGap(68, 68, 68)
                .addComponent(jButtonEliminar)
                .addGap(52, 52, 52)
                .addComponent(jButtonModificar)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonModificar))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        FormCrearUsuario crear=new FormCrearUsuario(new JFrame(), true);
        crear.setVisible(true);
        agregar(crear.usuario());
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        actualizarDatos();
    }//GEN-LAST:event_jButtonModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
