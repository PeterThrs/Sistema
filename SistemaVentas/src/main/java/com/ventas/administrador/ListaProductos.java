/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ventas.administrador;

import Objetos.Producto;
import configuracion.Configuracion;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

/**
 *
 * @author juanj
 */
public class ListaProductos extends javax.swing.JFrame {
    
    /**
     * Creates new form test
     */
    public ListaProductos() {
        initComponents();
        Configuracion.titulo(btnAgregar);
        Configuracion.styles(this);
        this.setTitle("Lista de Productos");
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
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }
    private void registrar(Producto p, DefaultTableModel model){
        model.addRow(new Object[]{
            p.getCodigo(),p.getNombre(),p.getPrecio(),p.getArea(),p.getMarca(),p.getCantidad()
        });
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
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Lista de productos en Almacen");
        jPanel3.add(jLabel1, new java.awt.GridBagConstraints());

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 22, 0);
        jPanel3.add(btnAgregar, gridBagConstraints);

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
                "Código", "Nombre", "Precio", "Área", "Marca", "Cantidad", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
            table.getColumnModel().getColumn(6).setPreferredWidth(30);
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
            /*Agregar_Producto crear=new Agregar_Producto(new JFrame(), true);
            crear.setVisible(true);
            DefaultTableModel model=(DefaultTableModel) table.getModel();
            registrar(crear.getProducto(),model);*/
        } catch (Exception e)
        {
            System.err.print(e);
        }
    }
    private void datosActualizados(){
        int fila=table.getSelectedRow();
        long codigo=Long.parseLong(table.getValueAt(fila, 0).toString());
        String nombre=table.getValueAt(fila, 1).toString();
        double precio=Double.parseDouble(table.getValueAt(fila, 2).toString());
        String area=table.getValueAt(fila, 3).toString();
        String marca=table.getValueAt(fila, 4).toString();
        double cantidad=Double.parseDouble(table.getValueAt(fila, 5).toString());
        Producto producto=new Producto(codigo, nombre, precio, area, marca, cantidad);

        //EditarProducto actualizar=new EditarProducto(this, true,producto);
        //actualizar.setVisible(true);
        //actualizar.producto();   
        //nuevosDatos(actualizar.producto(),fila);
    }
    private void nuevosDatos(Producto p,int fila){
        table.setValueAt(p.getCodigo(),fila, 0);
        table.setValueAt(p.getNombre(),fila, 1);
        table.setValueAt(p.getPrecio(),fila, 2);
        table.setValueAt(p.getArea(),fila, 3);
        table.setValueAt(p.getMarca(),fila, 4);
        table.setValueAt(p.getCantidad(),fila, 5);
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
