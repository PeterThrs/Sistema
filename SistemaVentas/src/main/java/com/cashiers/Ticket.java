package com.cashiers;

import com.classes.Producto;
import com.classes.Tienda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Root
 */
public class Ticket {

    private List<Producto> productos;
    private Date fecha;
    private double total;
    private double pago;
    private double cambio;

    public Ticket() {
        this.total = 0;
        this.fecha = new Date();
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cant) throws Exception {
        boolean v = false;
        if (producto == null) {
            throw new Exception("Producto nulo");
        } else if (!existente(producto)) {
            System.out.println("Agregar Nuevo Producto");
            v = producto.modificarProducto(cant);
            if (v) {
                productos.add(producto);
                calcularTotal();
            }
        } else if (existente(producto)) {
            System.out.println("Modificar Producto");
            producto = recuperarProducto(producto.getCodigo());
            if (producto.getCantVenta() == 1 && cant < 0) {
                eliminarProducto(producto);
            } else {
                v = producto.modificarProducto(cant);
                if (v) {
                    calcularTotal();
                }
            }
        }
    }

    public boolean eliminarProducto(Producto producto) {
        producto = recuperarProducto(producto.getCodigo());
        boolean b = false;
        if (producto != null) {
            b = productos.remove(producto);
            if (b) {
                producto.reiniciar();
                calcularTotal();
                return b;
            }
        }
        if (productos.isEmpty()) {
            this.total = 0;
        }
        return b;
    }

    public Object[][] matrizTabla() {
        Object[][] objetos = new Object[this.productos.size()][6];
        int cont = 0;
        for (Producto p : this.productos) {
            //codigo, descripción, precioVenta, cant, importe, existencia
            objetos[cont][0] = p.getCodigo();
            objetos[cont][1] = p.getDescripcion();
            objetos[cont][2] = p.getPrecioFinal();
            objetos[cont][3] = p.getCantVenta();
            objetos[cont][4] = p.getImporte();
            objetos[cont][5] = p.getExistencia();
            cont++;
        }
        return objetos;
    }

    public Producto recuperarProducto(String codigo) {
        Producto producto = null;
        if (!codigo.isEmpty()) {
            producto = productos.stream().filter(p -> (p.getCodigo().equals(codigo))).findFirst().orElse(null);
        }
        return producto;
    }

    public boolean existente(Producto producto) {
        if (!productos.isEmpty()) {
            return this.productos.stream().anyMatch(p -> (p.getCodigo().equals(producto.getCodigo())));
        }
        return false;
    }

    public void setFecha() {
        //this.fecha = new Date(); 
    }

    public void calcularTotal() {
        if (!productos.isEmpty()) {
            this.total = productos.stream().mapToDouble(Producto::getImporte).sum();
            System.out.println("total = " + total);
        } else {
            this.total = 0;
        }
    }

    public double getTotal() {
        return this.total;
    }

    public boolean vacio() {
        return productos.isEmpty();
    }

    public void realizarVenta() {
        System.out.println("Realizamos la resta a los productos que tenemos en el ticket respecto a su stok");
        productos.forEach(p -> {
            System.out.println("p.getCantidad() = " + p.getCantidad());
            System.out.println("p.getCantVenta() = " + p.getCantVenta());
            p.setCantidad(p.getCantidad() - p.getCantVenta());
        });
    }

    public Producto getProducto(int pos) {
        if (!productos.isEmpty() && pos >= 0 && pos < productos.size()) {
            return productos.get(pos);
        }
        return null;
    }

    public int getSize() {
        return productos.size();
    }

    public String productosEnTicket() {
        StringBuilder sb = new StringBuilder();
        // Imprimir encabezado de la tabla
        sb.append(String.format("%-20s%-20s%-20s", "Descripción", "Cantidad", "Importe")).append("\n");

        // Imprimir los productos
        for (Producto p : productos) {
            String descripcion = p.getDescripcion();
            String cantidad = String.valueOf(p.getCantVenta());
            String importe = String.valueOf(p.getImporte());

            // Ajustar la longitud de la descripción si es necesario
            if (descripcion.length() > 20) {
                descripcion = descripcion.substring(0, 17) + "...";
            }

            // Imprimir fila de la tabla
            sb.append(String.format("%-20s%-20s%-20s", descripcion, cantidad, importe)).append("\n");
        }
        return sb.toString();
    }

    public String imprimirTicket(Tienda tienda, double pago) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = formatoFecha.format(this.fecha);
        sb.append("----------Ticket de venta----------").append("\n")
                .append("Fecha: ").append(fechaFormateada).append("\n")
                .append("Empresa: ").append(tienda.getNombre()).append("\n")
                .append("\t").append(tienda.getSlogan()).append("\n")
                .append("Email: ").append(tienda.getEmail()).append("\n\n")
                .append("\tLista de Compra").append("\n")
                .append(productosEnTicket()).append("\n\n")
                .append("Total a pagar: ").append(this.total).append("\n\n")
                .append("Pago con: ").append(pago).append("\n")
                .append("Cambio: ").append(pago-this.total).append("\n\n");
        
        return sb.toString(); 
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

}