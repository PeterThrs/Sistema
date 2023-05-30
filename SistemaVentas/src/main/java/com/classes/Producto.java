package com.classes;

public class Producto {

    private String codigo;
    private int estatus;
    private String nombre;
    private String descripcion;
    private double precioCosto;
    private double ganancia;
    private double mayoreo;
    private int ocupaInventario;
    private double stock;
    private int idDepartamento;

    //atributos para poder manejar el apartado de ventas
    private int cantVenta;
    private double importe;
    private double precioFinal;
    private int existencia;

    public Producto() {
        this.cantVenta = 0;
        this.importe = 0;
        this.precioFinal = 0;
        this.existencia = 0;
    }

    public Producto(int ocupaInventario) {
        this();
        this.ocupaInventario = ocupaInventario;
    }

    public Producto(String nombre, String descripcion, double precioCosto, double ganancia, double mayoreo, int ocupaInventario, int estatus ,double cantidad, int idDepartamento) {
        this();
        this.estatus = estatus;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.stock = cantidad;
        this.idDepartamento = idDepartamento;
    }

    public Producto(String codigo, String nombre, String descripcion, double precioCosto, double ganancia, double mayoreo, int ocupaInventario, int estatus, double cantidad, int idDepartamento) {
        this();
        this.estatus = estatus;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.stock = cantidad;
        this.idDepartamento = idDepartamento;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getMayoreo() {
        return mayoreo;
    }

    public void setMayoreo(double mayoreo) {
        this.mayoreo = mayoreo;
    }

    public int getOcupaInventario() {
        return ocupaInventario;
    }

    public void setOcupaInventario(int ocupaInventario) {
        this.ocupaInventario = ocupaInventario;
    }

    public double getCantidad() {
        return stock;
    }

    public void setCantidad(double cantidad) {
        this.stock = cantidad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    //para poder manejar el aparatado de ventas
    private void actualizar() {
        calcularPrecioVenta();
        calcularImporte();
        calcularExistente();
    }
    
    public void reiniciar(){
        this.importe = 0; 
        this.cantVenta = 0; 
        this.existencia = (int) this.stock; 
    }
    
    public void setCantVenta(int cantVenta){
        this.cantVenta = cantVenta; 
    }

    public boolean modificarProducto(int cant) throws Exception{
        int actual = this.getCantVenta() + cant;
        if (cant > 0) {//sumamos
            if (actual <= this.stock) {
                this.setCantVenta(this.getCantVenta() + cant);
                actualizar();
                return true; 
            } else {
                throw new Exception("No hay stock disponible"); 
            }
        } else if (cant < 0) {//restamos
            if (actual >= 0) {
                this.setCantVenta(this.getCantVenta() + cant);
                actualizar();
                return true; 
            } else {
                System.out.println("es demasiado a restar");
                return false; 
            }
        } else {
            System.out.println("No es posible actualizar la cantidad");
            return false; 
        }
    }

    private void calcularPrecioVenta() {
        this.precioFinal = this.precioCosto + (this.precioCosto * (this.ganancia / 100));
    }

    private void calcularImporte() {
        this.importe = this.precioFinal * this.cantVenta;
    }

    private void calcularExistente() {
        this.existencia = (int) this.stock - this.cantVenta;
    }

    public int getCantVenta() {
        return cantVenta;
    }

    public double getImporte() {
        return importe;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public int getExistencia() {
        return existencia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioCosto=" + precioCosto + ", ganancia=" + ganancia + ", mayoreo=" + mayoreo + ", ocupaInventario=" + ocupaInventario + ", stock=" + stock + ", idDepartamento=" + idDepartamento + ", totalVender=" + cantVenta + ", importe=" + importe + ", precioFinal=" + precioFinal + ", existencia=" + existencia + '}';
    }

}
