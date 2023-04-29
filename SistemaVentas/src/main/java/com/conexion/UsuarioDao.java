/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import com.classes.Usuario;
import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdRyz
 */
public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT idUsuario, nombreUsuario, contrasenia, idPersona, idRol FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (nombreUsuario, contrasenia, idPersona, idRol) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombreUsuario=?, contrasenia=?, idPersona=?, idRol=? WHERE idUsuario=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idUsuario = ?";

    public List<Usuario> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String nombreUsuario = rs.getString("nombreUsuario");
                String contrasenia = rs.getString("contrasenia");
                int idPersona = rs.getInt("idPersona");
                int idRol = rs.getInt("idRol");
          
                usuario = new Usuario(idUsuario, nombreUsuario, contrasenia, idPersona, idRol);
                usuarios.add(usuario);
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
        return usuarios;
    }

    public static int insertar(Usuario usuario) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNomUsuario());
            stmt.setString(2, usuario.getContrasenia());
            stmt.setInt(3, usuario.getIdPersona());
            stmt.setInt(4, usuario.getIdRol());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int actualizar(Usuario usuario) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNomUsuario());
            stmt.setString(2, usuario.getContrasenia());
            stmt.setInt(3, usuario.getIdUsuario());
            stmt.setInt(4, usuario.getIdRol());
            
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int eliminar(Usuario usuario) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.executeUpdate(); 
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros; 
    }
}