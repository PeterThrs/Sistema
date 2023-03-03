package Objetos;

public class Persona {
    private int id;
    private String nomUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int numTelefono;
    private String correoElectronico;
    private String nacionalidad;
    private String calle;

    public Persona(int id, String nomUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, int numTelefono, String correoElectronico, String nacionalidad, String calle) {
        this.id = id;
        this.nomUsuario = nomUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numTelefono = numTelefono;
        this.correoElectronico = correoElectronico;
        this.nacionalidad = nacionalidad;
        this.calle = calle;
    }
    
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
}
