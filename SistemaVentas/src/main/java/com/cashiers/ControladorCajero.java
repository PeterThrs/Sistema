/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

import com.classes.Persona;
import com.classes.Producto;
import com.classes.Tienda;
import com.classes.Usuario;
import com.conexion.PersonaDao;
import com.conexion.ProductoDAO;
import com.conexion.TiendaDAO;
import com.newLogin.LoginTemplate;
import com.settings.CodigoColor;
import com.settings.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Root
 */
public class ControladorCajero {

    private ProductoDAO productoDao;
    private TiendaDAO tiendaDao;
    private Tienda tienda;
    private VistaCajero vistaCajero;
    private List<Producto> productosBD;
    private Ticket ticket;
    private Usuario usuario;

    public ControladorCajero(VistaCajero vistaCajero, Usuario usuario) {
        this.vistaCajero = vistaCajero;
        this.usuario = usuario;
        this.productoDao = new ProductoDAO();
        this.ticket = new Ticket();
        this.productosBD = productoDao.seleccionar();
        this.tiendaDao = new TiendaDAO();
        acciones();
        cargarInformacion();
    }

    private void acciones() {
        accionesBotones();
        //eventosTeclado();
    }

    private void cargarInformacion() {
        try {
            tienda = tiendaDao.traerUltimo();
            if (tienda != null) {
                vistaCajero.getJlNombreEmpresa().setText(tienda.getNombre());
                vistaCajero.getJlSloga().setText(tienda.getSlogan());
                vistaCajero.getJlgmail().setText(tienda.getEmail());
            }
            if (usuario != null) {
                PersonaDao personaDao = new PersonaDao();
                Persona p = personaDao.seleccionIndividual(new Persona(usuario.getIdPersona()));
                vistaCajero.getJlNombreCajero().setText("Atiende: \n" + p.getNombre() + " " + p.getApellidoPaterno());
            }
        } catch (Exception ex) {

        }
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
        try {
            DecimalFormat format = new DecimalFormat("0.00");
            vistaCajero.getJlTotal().setText("$" + String.valueOf(format.format(ticket.getTotal())));
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }

    }

    private void accionesBotones() {
        //btn Agregar
        vistaCajero.getBtnAgregar().addActionListener(e -> {
            try {
                System.out.println("\n\n------------------------Opcion de Agregar------------------");
                System.out.println("Entramos a la accion btn agregar");
                agregarProducto();
                actualizarPrecio();
                int pos = ticket.getSize() - 1;
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
                    ticket.productosEnTicket();
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
                    ticket.productosEnTicket();
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
                    ticket.productosEnTicket();
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
                    double pago = Double.parseDouble(JOptionPane.showInputDialog("Cantidad recibida: "));
                    //faltan validaciones
                    System.out.println(ticket.imprimirTicket(tienda, pago));
                    limpiarTabla();
                    this.productoDao = new ProductoDAO();
                    this.ticket = new Ticket();
                    this.productosBD = productoDao.seleccionar();
                    System.out.println("\n\n------------------------Imprimiendo el ticket------------------\n");
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
        //btnCerrarSesion 
        vistaCajero.getBtnCerrarSesion().addActionListener(e -> {
            vistaCajero.setVisible(false);
            vistaCajero.dispose();
            Runnable runApplication = new Runnable() {
                public void run() {
                    LoginTemplate login = new LoginTemplate();
                    login.getClass();
                }
            };
            SwingUtilities.invokeLater(runApplication);
        });

        eventosMouse(new Color(39, 54, 77), new Color(39, 54, 120), vistaCajero.getBtnAgregar());
        eventosMouse(new Color(39, 54, 77), new Color(39, 54, 120), vistaCajero.getBtnAumentar());
        eventosMouse(new Color(39, 54, 77), new Color(39, 54, 120), vistaCajero.getBtnCobrar());
        eventosMouse(new Color(39, 54, 77), new Color(39, 54, 120), vistaCajero.getBtnDecrementar());
        eventosMouse(new Color(39, 54, 77), new Color(39, 54, 120), vistaCajero.getBtnEliminar());
        eventosMouse(new Color(138, 0, 0), new Color(200, 0, 0), vistaCajero.getBtnCerrarSesion());
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

    private void eventosMouse(Color ant, Color pos, JButton btn) {
        //Agregando oyente de raton -  MouseListener
        MouseListener oyenteRaton = new MouseListener() {
            Insets margenOriginal; 
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(pos);
                    margenOriginal = btn.getMargin(); 
                    btn.setMargin(new Insets((margenOriginal.top + 1), (margenOriginal.left + 1), (margenOriginal.bottom + 1), (margenOriginal.right + 1)));
                    btn.revalidate();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn.isEnabled()) {
                    // regresarColor
                    btn.setBackground(ant);
                    btn.setMargin(margenOriginal);
                    btn.revalidate();
                }
            }
        };
        btn.addMouseListener(oyenteRaton);
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