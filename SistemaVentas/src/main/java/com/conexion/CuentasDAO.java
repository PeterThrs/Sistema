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

    //Ganancias por semanas
    public static List<Double> obtenerValoresPorSemana(String obtener) throws SQLException {
        try
        {
            Connection connection = Conexion.getConnection();
            List<Double> gananciasPorSemana = new ArrayList<>();

            // Obtener la fecha mínima y máxima de la base de datos
            String fechaMinimaQuery = "SELECT MIN(fecha) FROM cuenta_dia";
            String fechaMaximaQuery = "SELECT MAX(fecha) FROM cuenta_dia";
            java.util.Date fechaMinima = obtenerFecha(connection, fechaMinimaQuery);
            java.util.Date fechaMaxima = obtenerFecha(connection, fechaMaximaQuery);
            System.out.println("Dentro " + fechaMinima + " " + fechaMaxima);
            // Obtener las ganancias por semana
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaMinima);

            while (calendar.getTime().before(fechaMaxima))
            {
                java.util.Date fechaInicio = calendar.getTime();
                calendar.add(Calendar.DAY_OF_WEEK, 6); // Avanzar al final de la semana
                java.util.Date fechaFin = calendar.getTime();
                String gananciasQuery = "SELECT SUM(" + obtener + ") FROM cuenta_dia WHERE fecha >= ? AND fecha <= ?";
                double gananciaSemana = obtenerValores(connection, gananciasQuery, fechaInicio, fechaFin);
                gananciasPorSemana.add(gananciaSemana);

                calendar.add(Calendar.DAY_OF_WEEK, 1); // Avanzar al inicio de la siguiente semana
            }
            Conexion.close(connection);
            return gananciasPorSemana;
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    //Ganancias por mes
    public static List<Double> obtenerValoresPorMes(String obtener) throws SQLException {
        try
        {
            Connection connection = Conexion.getConnection();
            List<Double> gananciasPorMes = new ArrayList<>();

            // Obtener la fecha mínima y máxima de la base de datos
            String fechaMinimaQuery = "SELECT MIN(fecha) FROM cuenta_dia";
            String fechaMaximaQuery = "SELECT MAX(fecha) FROM cuenta_dia";
            java.util.Date fechaMinima = obtenerFecha(connection, fechaMinimaQuery);
            java.util.Date fechaMaxima = obtenerFecha(connection, fechaMaximaQuery);

            // Obtener las ganancias por mes
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaMinima);
            calendar.set(Calendar.DAY_OF_MONTH, 1); // Establecer el primer día del mes

            while (calendar.getTime().before(fechaMaxima))
            {
                java.util.Date fechaInicio = calendar.getTime();
                calendar.add(Calendar.MONTH, 1); // Avanzar al siguiente mes
                calendar.set(Calendar.DAY_OF_MONTH, 1); // Establecer el primer día del siguiente mes
                java.util.Date fechaFin = calendar.getTime();

                String gananciasQuery = "SELECT SUM(" + obtener + ") FROM cuenta_dia WHERE fecha >= ? AND fecha < ?";
                double gananciaMes = obtenerValores(connection, gananciasQuery, fechaInicio, fechaFin);
                gananciasPorMes.add(gananciaMes);
            }
            Conexion.close(connection);
            return gananciasPorMes;
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    //Ganancias por año
    public static List<Double> obtenerValoresPorAnio(String obtener) throws SQLException {
        try
        {
            Connection connection = Conexion.getConnection();
            List<Double> gananciasPorAnio = new ArrayList<>();

            // Obtener la fecha mínima y máxima de la base de datos
            String fechaMinimaQuery = "SELECT MIN(fecha) FROM cuenta_dia";
            String fechaMaximaQuery = "SELECT MAX(fecha) FROM cuenta_dia";
            java.util.Date fechaMinima = obtenerFecha(connection, fechaMinimaQuery);
            java.util.Date fechaMaxima = obtenerFecha(connection, fechaMaximaQuery);

            // Obtener las ganancias por año
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaMinima);
            calendar.set(Calendar.MONTH, 0); // Establecer el primer mes del año
            calendar.set(Calendar.DAY_OF_MONTH, 1); // Establecer el primer día del mes

            while (calendar.getTime().before(fechaMaxima))
            {
                java.util.Date fechaInicio = calendar.getTime();
                calendar.add(Calendar.YEAR, 1); // Avanzar al siguiente año
                calendar.set(Calendar.MONTH, 0); // Establecer el primer mes del siguiente año
                calendar.set(Calendar.DAY_OF_MONTH, 1); // Establecer el primer día del mes
                java.util.Date fechaFin = calendar.getTime();

                String gananciasQuery = "SELECT SUM(" + obtener + ") FROM cuenta_dia WHERE fecha >= ? AND fecha < ?";
                double gananciaAnio = obtenerValores(connection, gananciasQuery, fechaInicio, fechaFin);
                gananciasPorAnio.add(gananciaAnio);
            }
            Conexion.close(connection);
            return gananciasPorAnio;
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public static List<Double> obtenerGananciasUltimos7Dias(Connection connection) throws SQLException {
        List<Double> gananciasUltimos7Dias = new ArrayList<>();

        // Obtener la fecha actual
        java.sql.Date fechaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        // Obtener la fecha hace 7 días
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        java.sql.Date fechaInicio = new java.sql.Date(calendar.getTime().getTime());

        // Consulta SQL para obtener las ganancias de los últimos 7 días
        String query = "SELECT SUM(ganancia) FROM cuenta_dia WHERE fecha BETWEEN ? AND ?";

        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setDate(1, fechaInicio);
            statement.setDate(2, fechaActual);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                double ganancia = resultSet.getDouble(1);
                gananciasUltimos7Dias.add(ganancia);
            }
        }

        return gananciasUltimos7Dias;
    }

    public static List<Double> obtenerGananciasUltimas7Semanas(Connection connection) throws SQLException {
        List<Double> gananciasUltimas7Semanas = new ArrayList<>();

        // Obtener la fecha mínima y máxima de la base de datos
        String fechaMaximaQuery = "SELECT MAX(fecha) FROM cuenta_dia";
        java.util.Date fechaMaxima = obtenerFecha(connection, fechaMaximaQuery);

        // Obtener la fecha 7 semanas atrás
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaMaxima);
        calendar.add(Calendar.WEEK_OF_YEAR, -7);
        java.util.Date fechaInicio = calendar.getTime();

        // Obtener las ganancias por semana desde la fecha de inicio hasta la fecha máxima
        while (fechaInicio.before(fechaMaxima))
        {
            calendar.setTime(fechaInicio);
            calendar.add(Calendar.DAY_OF_WEEK, 6); // Avanzar al final de la semana
            java.util.Date fechaFin = calendar.getTime();

            String gananciasQuery = "SELECT SUM(ganancia) FROM cuenta_dia WHERE fecha >= ? AND fecha <= ?";
            double gananciaSemana = obtenerValores(connection, gananciasQuery, fechaInicio, fechaFin);
            gananciasUltimas7Semanas.add(gananciaSemana);

            calendar.add(Calendar.DAY_OF_WEEK, 1); // Avanzar al inicio de la siguiente semana
            fechaInicio = calendar.getTime();
        }

        return gananciasUltimas7Semanas;
    }

    private static java.util.Date obtenerFecha(Connection connection, String query) throws SQLException {
        java.util.Date fecha = null;
        try (Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
            {
                fecha = resultSet.getDate(1);
            }
        }
        return fecha;
    }

    private static double obtenerValores(Connection connection, String query, java.util.Date fechaInicio, java.util.Date fechaFin)
            throws SQLException {
        double gananciaSemana = 0;
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            statement.setDate(2, new java.sql.Date(fechaFin.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                gananciaSemana = resultSet.getDouble(1);
            }
            Conexion.close(statement);
        }
        return gananciaSemana;
    }
}
