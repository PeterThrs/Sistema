package com.conexion;

import static com.conexion.Conexion.*;
import com.classes.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDao {

    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellidoP, apellidoM, email, telefono1, telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio, colonia, calle, numCasa FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellidoP, apellidoM, email, telefono1, telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio, colonia, calle, numCasa) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?))";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellidoP=?, apellidoM=?, email=?, telfono1=?, telefono2=?, edad=?, curp=?, rfc=?, sexo=?, codigoPostal=?, estado=?, municipio=?, colonia=?, calle=?, numCasa=? WHERE idPersona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";

    public List<Persona> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String email = rs.getString("email");
                String telfono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                int edad = rs.getInt("edad");
                String curp = rs.getString("curp");
                String rfc = rs.getString("rfc");
                String sexo = rs.getString("sexo");
                int codigoPostal = rs.getInt("CodigoPostal");
                String estado = rs.getString("estado");
                String municipio = rs.getString("municipio");
                String colonia = rs.getString("colonia");
                String calle = rs.getString("calle");
                int numCasa = rs.getInt("numCasa");
                persona = new Persona(idPersona, nombre, apellidoP, apellidoM, email, telfono1,
                        telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio,
                        colonia, calle, numCasa);
                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }
    
    public int insertar(Persona persona){
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0; 
        try{
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2,persona.getApellidoPaterno());
        }catch(SQLException ex){
            
        }
        return 0; 
    }
    
}
