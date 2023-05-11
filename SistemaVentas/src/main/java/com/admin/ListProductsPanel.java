package com.admin;

import com.classes.Departamento;
import com.classes.Producto;
import com.conexion.DepartamentoDao;
import com.conexion.ProductoDAO;
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
import java.util.regex.Pattern;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListProductsPanel extends javax.swing.JPanel {

    private PrincipalAdmin principalAdmin;
    private DefaultTableModel model;
    private List<Producto> productos;
    private ProductoDAO productoDAO;
    private DepartamentoDao departamentoDao;
    private Recursos recursos;

    public ListProductsPanel(PrincipalAdmin principalAdmin) {
        initComponents();
        recursos = Recursos.getService();
        this.principalAdmin = principalAdmin;
        this.model = (DefaultTableModel) table.getModel();
        this.productoDAO = new ProductoDAO();
        this.departamentoDao = new DepartamentoDao();
        this.productos = productoDAO.seleccionar();
        configuracion();
        clicSecundario();
    }

    private void configuracion() {
        anchoFilas();
        registrar();
        formatTable();
    }

    public void registrar() {
        model.setRowCount(0);
        this.productos.forEach(producto ->
        {
            Producto p = productoDAO.seleccionIndividual(new Producto(producto.getCodigo()));
            Departamento dep = departamentoDao.seleccionIndividual(new Departamento(p.getIdDepartamento()));
            model.addRow(new Object[]
            {
                producto.getCodigo(), producto.getNombre(), producto.getPrecioCosto(), producto.getMayoreo(), producto.getCantidad(), dep.getDepartamento()
            });
        });
    }

    private void registrarPorFiltro(int id) {
        this.productos.forEach(producto ->
        {
            Producto p = productoDAO.seleccionIndividual(new Producto(producto.getCodigo()));
            Departamento dep = departamentoDao.seleccionIndividual(new Departamento(p.getIdDepartamento()));
            if (id == dep.getidDepartamento())
            {
                model.addRow(new Object[]
                {
                    producto.getCodigo(), producto.getNombre(), producto.getPrecioCosto(), producto.getMayoreo(), producto.getCantidad(), dep.getDepartamento()
                });
            }
        });
        if (table.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "No hay productos en esta categoria");
            registrar();
        }
    }

    public void formatTable() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                String codigo = (String) table.getValueAt(row, 0);
                Producto producto = productos.stream().filter(p -> (p.getCodigo().equals(codigo))).findFirst().get();
                //System.out.println("Mostrando el producto seleccionado");
                //System.out.println("producto = " + producto);
                principalAdmin.cambiarPanelExterno(new PanelProducto(producto));
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing())
                {
                    table.getCellEditor().stopCellEditing();
                }
                int fila = table.getSelectedRow();
                String codigo = table.getValueAt(fila, 0).toString();

                ProductoDAO.eliminar(new Producto(codigo));
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

        List<Departamento> departamentos = DepartamentoDao.seleccionar();
        List<JMenuItem> subMenus = new ArrayList<>();

        JMenu subMenu = new JMenu("Filtrar por");

        departamentos.forEach(departamento ->
        {
            subMenus.add(new JMenuItem(departamento.getDepartamento()));
        });
        subMenus.add(new JMenuItem("General"));

        subMenus.forEach(submenu ->
        {
            subMenu.add(submenu);
            subMenu.addSeparator();
        });
        popupMenu.add(subMenu);

        for (int i = 0; i < subMenus.size() - 1; i++)
        {
            eventoSubmenu(subMenus.get(i), i + 1);
        }
        subMenus.get(12).addActionListener(new ActionListener() {
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
