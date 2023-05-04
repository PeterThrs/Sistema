
package com.conexion;

import static com.conexion.Conexion.*;
import com.classes.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDao {

    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellidoP, apellidoM, email, telefono1, telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio, colonia, calle, numCasa FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellidoP, apellidoM, email, telefono1, telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio, colonia, calle, numCasa) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellidoP=?, apellidoM=?, email=?, telefono1=?, telefono2=?, edad=?, curp=?, rfc=?, sexo=?, codigoPostal=?, estado=?, municipio=?, colonia=?, calle=?, numCasa=? WHERE idPersona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM persona WHERE idPersona = ?";
    private static final String SQL_SELECT_LAST = "SELECT * FROM persona ORDER BY idPersona DESC LIMIT 1;";
    
    public static List<Persona> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next())
            {
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

        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                close(rs);
                close(stmt);
                close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public static int insertar(Persona persona) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidoPaterno());
            stmt.setString(3, persona.getApellidoMaterno());
            stmt.setString(4, persona.getEmail());
            stmt.setString(5, persona.getTelefono1());
            stmt.setString(6, persona.getTelefono2());
            stmt.setInt(7, persona.getEdad());
            stmt.setString(8, persona.getCurp());
            stmt.setString(9, persona.getRFC());
            stmt.setString(10, persona.getSexo());
            stmt.setInt(11, persona.getCodigoPostal());
            stmt.setString(12, persona.getEstado());
            stmt.setString(13, persona.getMunicipio());
            stmt.setString(14, persona.getColonia());
            stmt.setString(15, persona.getCalle());
            stmt.setInt(16, persona.getNumCasa());

            registros = stmt.executeUpdate();

        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int actualizar(Persona persona) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidoPaterno());
            stmt.setString(3, persona.getApellidoMaterno());
            stmt.setString(4, persona.getEmail());
            stmt.setString(5, persona.getTelefono1());
            stmt.setString(6, persona.getTelefono2());
            stmt.setInt(7, persona.getEdad());
            stmt.setString(8, persona.getCurp());
            stmt.setString(9, persona.getRFC());
            stmt.setString(10, persona.getSexo());
            stmt.setInt(11, persona.getCodigoPostal());
            stmt.setString(12, persona.getEstado());
            stmt.setString(13, persona.getMunicipio());
            stmt.setString(14, persona.getColonia());
            stmt.setString(15, persona.getCalle());
            stmt.setInt(16, persona.getNumCasa());
            stmt.setInt(17, persona.getIdPersona());

            registros = stmt.executeUpdate();

        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int eliminar(Persona persona) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            stmt.executeUpdate();

        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static Persona seleccionIndividual(Persona persona) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, persona.getIdPersona());
            rs = stmt.executeQuery();

            if(rs.next())
            {
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
                return new Persona(idPersona, nombre, apellidoP, apellidoM, email, telfono1,
                        telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio,
                        colonia, calle, numCasa);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return null;
    }
    
    public static Persona traerUltimo() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_LAST);
            rs = stmt.executeQuery();

            if(rs.next())
            {
                int idPersona = rs.getInt("idPersona");
                return new Persona(idPersona);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return null;
    }
}
