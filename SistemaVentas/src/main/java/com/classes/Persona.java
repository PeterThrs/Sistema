package com.classes;

public class Persona {
    
    private int idPersona; 
    private String nombre;
    private String apellidoPaterno; 
    private String apellidoMaterno;
    private String email; 
    private String telefono1;
    private String telefono2;
    private int edad;
    private String curp;
    private String RFC;
    private String sexo;
    private int codigoPostal;
    private String estado;
    private String municipio;
    private String colonia;
    private String calle;
    private int numCasa;
    
    public Persona()  {
    }
    
    public Persona(int idPersona){
        this.idPersona = idPersona; 
    }

    public Persona(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String telefono1, String telefono2, int edad, String curp, String RFC, String sexo, int codigoPostal, String estado, String municipio, String colonia, String calle, int numCasa) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.edad = edad;
        this.curp = curp;
        this.RFC = RFC;
        this.sexo = sexo;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calle = calle;
        this.numCasa = numCasa;
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String telefono1, String telefono2, int edad, String curp, String RFC, String sexo, int codigoPostal, String estado, String municipio, String colonia, String calle, int numCasa) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.edad = edad;
        this.curp = curp;
        this.RFC = RFC;
        this.sexo = sexo;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calle = calle;
        this.numCasa = numCasa;
    }
    
    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", edad=" + edad + ", curp=" + curp + ", RFC=" + RFC + ", sexo=" + sexo + ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", municipio=" + municipio + ", colonia=" + colonia + ", calle=" + calle + ", numCasa=" + numCasa + '}';
    }
    
}
