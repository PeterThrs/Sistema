
package com.conexion;

import static com.conexion.Conexion.*;
import com.classes.CatalogoDeSexo;
import java.sql.*;
import java.util.*;

public class CatalogoDeSexoDAO {

    private static final String SQL_SELECT = "SELECT id_cat_sexo,tipo FROM persona";
    private static final String SQL_INSERT = "INSERT INTO CatalogoDeSexo (tipo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE CatalogoDeSexo SET tipo=? WHERE id_cat_sexo=?";
    private static final String SQL_DELETE = "DELETE FROM CatalogoDeSexo WHERE id_cat_sexo = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM CatalogoDeSexo WHERE id_cat_sexo = ?";
    
    public static List<CatalogoDeSexo> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CatalogoDeSexo c_s = null;
        List<CatalogoDeSexo> cs = new ArrayList<>();

        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id_cat_sexo = rs.getInt("id_cat_sexo");
                String tipo = rs.getString("tipo");
                
                c_s = new CatalogoDeSexo (id_cat_sexo, tipo);
                cs.add(c_s);
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
        return cs;
    }

    public static int insertar(CatalogoDeSexo c_s) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setString(1, c_s.getTipo()); 
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

    public static int actualizar(CatalogoDeSexo c_s) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, c_s.getTipo());
            stmt.setInt(2, c_s.getId_cat_sexo());

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

    public static int eliminar(CatalogoDeSexo c_s) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, c_s.getId_cat_sexo());
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

    public static CatalogoDeSexo seleccionIndividual(CatalogoDeSexo c_s) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, c_s.getId_cat_sexo());
            rs = stmt.executeQuery();

            if(rs.next())
            {
                System.out.println("sii");
                
                int id_cat_sexo = rs.getInt("id_cat_sexo");
                String tipo = rs.getString("tipo");
                
                return new CatalogoDeSexo(id_cat_sexo, tipo);
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