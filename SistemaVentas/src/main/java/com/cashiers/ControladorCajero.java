/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

import com.classes.Producto;
import com.conexion.ProductoDAO;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Root
 */
public class ControladorCajero {

    private ProductoDAO productoDao;
    private VistaCajero vistaCajero;
    private List<Producto> productosBD;
    private Ticket ticket;

    public ControladorCajero(VistaCajero vistaCajero) {
        this.vistaCajero = vistaCajero;
        this.productoDao = new ProductoDAO();
        this.ticket = new Ticket();
        this.productosBD = productoDao.seleccionar();
        acciones();
    }

    private void acciones() {
        accionesBotones();
        //eventosTeclado();
    }

    private void actualizarTabla() {
        Object[][] filas = ticket.matrizTabla();
        vistaCajero.cargarModeloTabla();
        for (Object[] o : filas) {
            ((DefaultTableModel) vistaCajero.getTabla().getModel()).addRow(o);
        }
        vistaCajero.getTabla().repaint();
    }

    private void limpiarTabla() {
        vistaCajero.cargarModeloTabla();
        vistaCajero.getTabla().repaint();
    }

    private void agregarProducto() throws NumberFormatException, Exception {
        String codigoProducto = vistaCajero.gettCodigo().getText();
        System.out.println("codigoProducto = " + codigoProducto);
        //recuperamos el producto
        Producto producto = productosBD.stream().filter(p -> (p.getCodigo().equals(codigoProducto))).findFirst().orElse(null);

        if (producto == null) {
            throw new Exception("Producto no encontrado");
        } else {
            ticket.agregarProducto(producto, 1);
            actualizarTabla();
        }
    }

    private void actualizarPrecio() {
        vistaCajero.getJlTotal().setText(String.valueOf(ticket.getTotal()));
    }

    private void accionesBotones() {
        //btn Agregar
        vistaCajero.getBtnAgregar().addActionListener(e -> {
            try {
                System.out.println("\n\n------------------------Opcion de Agregar------------------");
                System.out.println("Entramos a la accion btn agregar");
                agregarProducto();
                actualizarPrecio();
                int pos = ticket.getSize() -1; 
                marcarRow(pos);
                vistaCajero.gettCodigo().setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (Exception ex) {
                //ex.printStackTrace(System.out);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        //btn Eliminar
        vistaCajero.getBtnEliminar().addActionListener(e -> {
            try {
                System.out.println("\n\n------------------------Opcion de eliminar------------------");
                String codigo = "";
                int fila = vistaCajero.getTabla().getSelectedRow();
                if (fila != -1) {
                    codigo = (String) ((DefaultTableModel) vistaCajero.getTabla().getModel()).getValueAt(fila, 0);
                    ticket.eliminarProducto(new Producto(codigo));
                    actualizarTabla();
                    actualizarPrecio();
                    ticket.imprimirProductos();
                } else {
                    JOptionPane.showMessageDialog(null, "No hay elemento Seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //btnAumentar
        vistaCajero.getBtnAumentar().addActionListener(e -> {
            try {
                System.out.println("\n\n------------------------Opcion de Aumentar------------------");
                String codigo = "";
                int fila = vistaCajero.getTabla().getSelectedRow();
                if (fila != -1) {
                    codigo = (String) ((DefaultTableModel) vistaCajero.getTabla().getModel()).getValueAt(fila, 0);
                    System.out.println("codigo = " + codigo);
                    ticket.agregarProducto(new Producto(codigo), 1);
                    actualizarTabla();
                    actualizarPrecio();
                    ticket.imprimirProductos();
                    marcarRow(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay elemento Seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //btnDecrecer
        vistaCajero.getBtnDecrementar().addActionListener(e -> {
            try {
                System.out.println("\n\n------------------------Opcion de Decrementar------------------");
                String codigo = "";
                int fila = vistaCajero.getTabla().getSelectedRow();
                if (fila != -1) {
                    codigo = (String) ((DefaultTableModel) vistaCajero.getTabla().getModel()).getValueAt(fila, 0);
                    ticket.agregarProducto(new Producto(codigo), -1);
                    actualizarTabla();
                    actualizarPrecio();
                    ticket.imprimirProductos();
                    marcarRow(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay elemento Seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //btnVender
        vistaCajero.getBtnCobrar().addActionListener(e -> {
            try {
                System.out.println("\n\n------------------------Opcion de Cobrar------------------");
                int reg = 0;
                if (!ticket.vacio()) {
                    //actualizar los datos en cada producto
                    ticket.realizarVenta();
                    for (int i = 0; i < ticket.getSize(); i++) {
                        Producto p = ticket.getProducto(i);
                        reg += productoDao.actualizar(p);
                    }
                    ticket.imprimirTicket();
                    limpiarTabla();
                    this.productoDao = new ProductoDAO();
                    this.ticket = new Ticket();
                    this.productosBD = productoDao.seleccionar();
                    System.out.println("Imprimimos nuevamente los datos de la bd");
                    productosBD.forEach(System.out::println);

                    JOptionPane.showMessageDialog(null, "La venta se realizo exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay productos Seleccionados", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        });
    }

    private void eventosTeclado() {

        KeyListener eventoJText = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                /* try {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                } catch (Exception ex) {

                }*/
            }
        };
        //vistaCajero.gettCodigo().addKeyListener(eventoJText);

        KeyListener eventoTabla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                /*try {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_DELETE ->
                            eliminar();
                        case KeyEvent.VK_ADD -> {
                        }
                        case KeyEvent.VK_SUBTRACT -> {
                        }

                    }
                } catch (Exception ex) {

                }*/
            }

        };
        //vistaCajero.getTabla().addKeyListener(eventoTabla);

    }

    private void marcarRow(int row) {
        try {
            if (!ticket.vacio()) {
                vistaCajero.getTabla().setRowSelectionInterval(row, row);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

}
