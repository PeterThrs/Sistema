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

/**
 *
 * @author Root
 */
public class ControladorCajero {

    private ProductoDAO productoDao;
    private Producto producto;

    private VistaCajero vistaCajero;
    private List<Producto> productoBD;
    private Ticket ticket;
    private String codigoProducto;

    public ControladorCajero(VistaCajero vistaCajero) {
        this.vistaCajero = vistaCajero;
        this.productoDao = new ProductoDAO();
        this.ticket = new Ticket(); 
        this.productoBD = new ArrayList<>();
        acciones();
    }

    private void acciones() {
        accionBtnAgregar();
        accionBtnEliminar();
        eventosTeclado();
    }

    private void recuperarProducto() throws NumberFormatException {
        this.codigoProducto = vistaCajero.gettCodigo().getText();
        //recuperamos el producto
        producto = new Producto(this.codigoProducto);
        productoBD = productoDao.seleccionar();
        producto = productoBD.stream().filter(p -> (p.getCodigo().equals(producto.getCodigo()))).findFirst().orElse(null);
    }
    
    private void actualizarTabla(){
        
    }

    private void agregarProducto() throws Exception {
        if (producto == null) {
            throw new Exception("Producto no encontrado");
        } else if (!ticket.existente(producto)) {
            Object[] fila = {producto.getCodigo(), producto.getDescripcion(), producto.getPrecioFinal(), producto.getTotalVender(), producto.getImporte(), producto.getExistencia()};
            vistaCajero.getModel().addRow(fila);
            //productosTicket.add(producto);
            marcarRow();
        } else {
            System.out.println("Vamos a modificar el producto");
            producto.aumentarTotalVender();
            producto.actualizar();
            modificarProducto();
        }
    }

    private void modificarProducto() {
        try {
            int fila = vistaCajero.getTabla().getSelectedRow();
            if (fila != -1) {
                if (producto.getTotalVender() > 0 && producto.getExistencia() > 0) {
                    System.out.println("Entramos a modificar los datos de la tabla");
                    System.out.println("producto = " + producto);
                    vistaCajero.getModel().setValueAt(producto.getTotalVender(), fila, 3); //modificamos la cantidad
                    vistaCajero.getModel().setValueAt(producto.getImporte(), fila, 4); //modificamos el importe
                    vistaCajero.getModel().setValueAt(producto.getExistencia(), fila, 5); //modificamos la existencia
                    vistaCajero.getTabla().revalidate();
                    vistaCajero.repaint();
                    System.out.println("producto = " + producto);
                } else if (producto.getTotalVender() == 0) {
                    eliminar();
                } else {
                    JOptionPane.showMessageDialog(null, "No hay mas stock disponible", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregar() {
        try {
            recuperarProducto();
            agregarProducto();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            //ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionBtnAgregar() {
        vistaCajero.getBtnAgregar().addActionListener(e -> {
            agregar();
        });
    }

    private void eliminar() {
        try {
            int fila = vistaCajero.getTabla().getSelectedRow();
            if (fila != -1) {
                vistaCajero.getModel().removeRow(fila);
                vistaCajero.getTabla().revalidate();
            } else {
                JOptionPane.showMessageDialog(null, "No hay elemento Seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionBtnEliminar() {
        vistaCajero.getBtnEliminar().addActionListener(e -> {
            eliminar();
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
                try {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_ENTER ->
                            agregar();
                    }
                } catch (Exception ex) {

                }
            }
        };
        vistaCajero.gettCodigo().addKeyListener(eventoJText);

        KeyListener eventoTabla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_DELETE ->
                            eliminar();
                        case KeyEvent.VK_ADD -> {
                            modificarProducto();
                        }
                        case KeyEvent.VK_SUBTRACT -> {
                            modificarProducto();
                        }

                    }
                } catch (Exception ex) {

                }
            }

        };
        vistaCajero.getTabla().addKeyListener(eventoTabla);

    }

    private void marcarRow() {
        //if (!productosTicket.isEmpty()) {
          //  vistaCajero.getTabla().setRowSelectionInterval(productosTicket.size() - 1, productosTicket.size() - 1);
        //}
    }

}
