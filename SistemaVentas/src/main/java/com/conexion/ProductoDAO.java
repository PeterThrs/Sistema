
package com.conexion;

import com.classes.Producto;
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
 * @author corte
 */

public class ProductoDAO {

    private static final String SQL_SELECT = "SELECT codigo, nombre, descripcion, precioCosto, ganancia, mayoreo, ocupaInventario, cantidad, idDepartamento FROM producto";
    private static final String SQL_INSERT = "INSERT INTO producto (codigo,nombre, descripcion, precioCosto, ganancia, mayoreo, ocupaInventario, cantidad, idDepartamento) values (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre=?, descripcion=?, precioCosto=?, ganancia=?, mayoreo=?, ocupaInventario=?, cantidad=?, idDepartamento=? WHERE codigo=?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE codigo = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM producto WHERE codigo = ?";

    public static List<Producto> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();

        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precioCosto = rs.getDouble("precioCosto");
                double ganancia = rs.getDouble("ganancia");
                double mayoreo = rs.getDouble("mayoreo");
                int ocupaInventario = rs.getInt("ocupaInventario");
                double cantidad = rs.getDouble("cantidad");
                int idDepartamento = rs.getInt("idDepartamento");

                productos.add(new Producto(codigo, nombre, descripcion, precioCosto, ganancia, mayoreo, ocupaInventario, cantidad, idDepartamento));
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
        return productos;
    }

    public static int insertar(Producto producto) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);

            stmt.setString(0, producto.getCodigo());
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecioCosto());
            stmt.setDouble(4, producto.getGanancia());
            stmt.setDouble(5, producto.getMayoreo());
            stmt.setInt(6, producto.getOcupaInventario());
            stmt.setDouble(7, producto.getCantidad());
            stmt.setInt(8, producto.getIdDepartamento());

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

    public static int actualizar(Producto producto) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);

            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecioCosto());
            stmt.setDouble(4, producto.getGanancia());
            stmt.setDouble(5, producto.getMayoreo());
            stmt.setInt(6, producto.getOcupaInventario());
            stmt.setDouble(7, producto.getCantidad());
            stmt.setInt(8, producto.getIdDepartamento());

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

    public static int eliminar(Producto producto) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getCodigo());
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

    public static Producto seleccionIndividual(Producto producto) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setString(1, producto.getCodigo());
            rs = stmt.executeQuery();

            if (rs.next())
            {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precioCosto = rs.getDouble("precioCosto");
                double ganancia = rs.getDouble("ganancia");
                double mayoreo = rs.getDouble("mayoreo");
                int ocupaInventario = rs.getInt("ocupaInventario");
                double cantidad = rs.getDouble("cantidad");
                int idDepartamento = rs.getInt("idDepartamento");

                return new Producto(codigo, nombre, descripcion, precioCosto, ganancia, mayoreo, ocupaInventario, cantidad, idDepartamento);
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
