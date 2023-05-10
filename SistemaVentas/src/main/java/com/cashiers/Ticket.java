package com.cashiers;

import com.classes.Producto;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Root
 */
public class Ticket {

    private List<Producto> productos;
    private Date fecha;
    private double total;

    public Ticket() {
        this.total = 0;
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
            if (producto.getCantVenta() == 1 && cant < 0 ) {
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
        }else {
            this.total = 0; 
        }
    }

    public double getTotal() {
        return this.total;
    }
    
    public boolean vacio(){
        return productos.isEmpty(); 
    }
    
    public void realizarVenta(){
        System.out.println("Realizamos la resta a los productos que tenemos en el ticket respecto a su stok");
        productos.forEach(p -> {
            System.out.println("p.getCantidad() = " + p.getCantidad());
            System.out.println("p.getCantVenta() = " + p.getCantVenta());
            p.setCantidad(p.getCantidad() - p.getCantVenta());
        });
    }
    
    public Producto getProducto(int pos){
        if(!productos.isEmpty() && pos >= 0 && pos < productos.size()){
            return productos.get(pos); 
        }
        return null; 
    }
    
    public int getSize(){
        return productos.size(); 
    }
    
    public void imprimirProductos() {
        // Imprimir encabezado de la tabla
        System.out.println(String.format("%-20s%-20s%-20s", "Descripción", "Cantidad", "Importe"));

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
            System.out.println(String.format("%-20s%-20s%-20s", descripcion, cantidad, importe));
        }
    }
    
    public void imprimirTicket(){
        System.out.println("----------Ticket de venta----------");
        imprimirProductos(); 
    }

}
