package com.conexion;

import com.classes.CuentaFinanciera;
import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author juanj
 */
public class CuentasDAO {

    private static final String SQL_SELECT = "SELECT id_cuentaDia, fecha, ganancia, perdida, inversion FROM cuenta_dia";
    private static final String SQL_INSERT = "INSERT INTO cuenta_dia (fecha, ganancia, perdida, inversion) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cuenta_dia SET fecha=?, ganancia=?, perdida=?, inversion=? WHERE id_cuentaDia=?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM cuenta_dia WHERE id_cuentadia = ?";
    private static final String SQL_SELECT_LAST = "SELECT * FROM cuenta_dia ORDER BY id_cuentaDia DESC LIMIT 1;";

    public static List<CuentaFinanciera> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CuentaFinanciera> cuentas = new ArrayList<>();
        
        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id_cuentaDia = rs.getInt("id_cuentaDia");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                double ganancia = rs.getDouble("ganancia");
                double perdida = rs.getDouble("perdida");
                double inversion = rs.getDouble("inversion");

                cuentas.add(new CuentaFinanciera(id_cuentaDia, fecha, ganancia, perdida, inversion));
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
        return cuentas;
    }

    public static int insertar(CuentaFinanciera cuenta) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);

            stmt.setDate(1, java.sql.Date.valueOf(cuenta.getFecha()));
            stmt.setDouble(2, cuenta.getGanancia());
            stmt.setDouble(3, cuenta.getPerdida());
            stmt.setDouble(4, cuenta.getInversion());

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

    public static int actualizar(CuentaFinanciera cuenta) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);

            stmt.setDate(1, java.sql.Date.valueOf(cuenta.getFecha()));
            stmt.setDouble(2, cuenta.getGanancia());
            stmt.setDouble(3, cuenta.getPerdida());
            stmt.setDouble(4, cuenta.getInversion());

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

    public static CuentaFinanciera traerUltimo() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_LAST);
            rs = stmt.executeQuery();

            if (rs.next())
            {
                int id_cuentaDia = rs.getInt("id_cuentaDia");
                return new CuentaFinanciera(id_cuentaDia);
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

    public static CuentaFinanciera seleccionIndividual(CuentaFinanciera cuenta) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, cuenta.getId_cuentaDi());
            rs = stmt.executeQuery();

            if (rs.next())
            {
                int id_cuentaDia = rs.getInt("id_cuentaDia");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                double ganancia = rs.getDouble("ganancia");
                double perdida = rs.getDouble("perdida");
                double inversion = rs.getDouble("inversion");
                
                return new CuentaFinanciera(id_cuentaDia, fecha, ganancia, perdida, inversion);
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
    
    public List<Double> obtenerGananciasPorSemana(Connection connection) throws SQLException {
        List<Double> gananciasPorSemana = new ArrayList<>();

        // Obtener la fecha mínima y máxima de la base de datos
        String fechaMinimaQuery = "SELECT MIN(fecha) FROM ganancias";
        String fechaMaximaQuery = "SELECT MAX(fecha) FROM ganancias";
        Date fechaMinima = obtenerFecha(connection, fechaMinimaQuery);
        Date fechaMaxima = obtenerFecha(connection, fechaMaximaQuery);

        // Obtener las ganancias por semana
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaMinima);

        while (calendar.getTime().before(fechaMaxima)) {
            Date fechaInicio = (Date) calendar.getTime();
            calendar.add(Calendar.DAY_OF_WEEK, 6); // Avanzar al final de la semana
            Date fechaFin = (Date) calendar.getTime();

            String gananciasQuery = "SELECT SUM(ganancia) FROM ganancias WHERE fecha >= ? AND fecha <= ?";
            double gananciaSemana = obtenerGananciaSemana(connection, gananciasQuery, fechaInicio, fechaFin);
            gananciasPorSemana.add(gananciaSemana);

            calendar.add(Calendar.DAY_OF_WEEK, 1); // Avanzar al inicio de la siguiente semana
        }

        return gananciasPorSemana;
    }

    private Date obtenerFecha(Connection connection, String query) throws SQLException {
        Date fecha = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                fecha = resultSet.getDate(1);
            }
        }
        return fecha;
    }

    private double obtenerGananciaSemana(Connection connection, String query, Date fechaInicio, Date fechaFin)
            throws SQLException {
        double gananciaSemana = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            statement.setDate(2, new java.sql.Date(fechaFin.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                gananciaSemana = resultSet.getDouble(1);
            }
        }
        return gananciaSemana;
    }
}
