/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.admin;

import com.classes.Departamento;
import com.classes.Producto;
import com.conexion.DepartamentoDao;
import com.conexion.ProductoDao     ;
import com.table.TableActionCellEditor;
import com.table.TableActionCellRender;
import com.table.TableActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanj
 */
public class ListProductsPanel extends javax.swing.JPanel {

    DefaultTableModel model;

    public ListProductsPanel() {
        initComponents();
        model = (DefaultTableModel) table.getModel();
        anchoFilas();
        registrar();
        formatTable();
    }

    private void registrar() {
        List<Producto> productos = ProductoDao.seleccionar();
        System.out.println(productos.size());
        productos.forEach(producto ->
        {
            //System.out.println("Producto de la lista "+producto.getNombre()+"id "+producto.getIdDepartamento());
            Producto p = ProductoDao.seleccionIndividual(new Producto(producto.getCodigo()));
            System.out.println("id de p "+p.getIdDepartamento());
            Departamento dep = DepartamentoDao.seleccionIndividual(new Departamento(p.getIdDepartamento()));
            System.out.println(p);
            System.out.println(dep);
            model.addRow(new Object[]
            {
                producto.getCodigo(), producto.getNombre(), producto.getPrecioCosto(), producto.getMayoreo(), producto.getCantidad(), dep.getDepartamento()
            });
        });
    }

    public void formatTable() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing())
                {
                    table.getCellEditor().stopCellEditing();
                }
                int fila = table.getSelectedRow();
                String codigo = table.getValueAt(fila, 0).toString();

                ProductoDao.eliminar(new Producto(codigo));
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
            }
        };
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }

    public void anchoFilas() {
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        for (int i = 1; i < table.getColumnCount() - 1; i++)
        {
            table.getColumnModel().getColumn(i).setPreferredWidth(150);
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
                "ID", "Nombre", "Precio", "Mayoreo", "Cantidad en inventario", "Departamento", "Opciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
