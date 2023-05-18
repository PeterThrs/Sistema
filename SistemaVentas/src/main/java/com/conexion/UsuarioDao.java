package com.conexion;

import com.classes.Usuario;
import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private static final String SQL_SELECT = "SELECT idUsuario, foto, nombreUsuario, contrasenia, idPersona, idRol FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (foto, nombreUsuario, contrasenia, idPersona, idRol) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET foto=?, nombreUsuario=?, contrasenia=?, idPersona=?, idRol=? WHERE idUsuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM usuario WHERE idUsuario = ?";
    
    public static List<Usuario> seleccionar() {
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
                InputStream imagen = rs.getBinaryStream("foto");
                String nombreUsuario = rs.getString("nombreUsuario");
                String contrasenia = rs.getString("contrasenia");
                int idPersona = rs.getInt("idPersona");
                int idRol = rs.getInt("idRol");
          
                usuario = new Usuario(idUsuario,imagen, nombreUsuario, contrasenia, idPersona, idRol);
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
            stmt.setBinaryStream(1,usuario.getImagen());
            stmt.setString(2, usuario.getNomUsuario());
            stmt.setString(3, usuario.getContrasenia());
            stmt.setInt(4, usuario.getIdPersona());
            stmt.setInt(5, usuario.getIdRol());

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
            stmt.setBinaryStream(1,usuario.getImagen());
            stmt.setString(2, usuario.getNomUsuario());
            stmt.setString(3, usuario.getContrasenia());
            stmt.setInt(4, usuario.getIdPersona());
            stmt.setInt(5, usuario.getIdRol());
            stmt.setInt(6, usuario.getIdUsuario());
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
    
    public static Usuario seleccionIndividual(Usuario usuario) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, usuario.getIdUsuario());
            rs = stmt.executeQuery();

            if(rs.next())
            {
                int idUsuario = rs.getInt("idUsuario");
                InputStream imagen = rs.getBinaryStream("foto");
                String nomUsuario = rs.getString("nombreUsuario");
                String contrasenia = rs.getString("contrasenia");
                int idPersona = rs.getInt("idPersona");
                int idRol = rs.getInt("idRol");
                return new Usuario(idUsuario, imagen, nomUsuario, contrasenia, idPersona, idRol);
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