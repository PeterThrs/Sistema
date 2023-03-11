package Objetos;

public class Producto {
    private Departamento departamento; 
    public Producto(Departamento departamento){
        this.departamento = departamento; 
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}
