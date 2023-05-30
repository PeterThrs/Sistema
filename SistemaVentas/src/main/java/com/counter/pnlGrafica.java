package com.counter;

import com.classes.CuentaFinanciera;
import com.conexion.CuentasDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class pnlGrafica extends javax.swing.JPanel {

    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private List<CuentaFinanciera> cuentas;

    public pnlGrafica() {
        initComponents();
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.setLayout(gbl);
        cuentasPorDía();
        cuentasPorSemana();
        cuentasPorMes();
        cuentasPorAño();
    }

    public void cuentasPorDía() {
        cuentas = CuentasDAO.seleccionar();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        int n = cuentas.size();
        for (int i = 0; i < 7;)
        {
            if (cuentas.size() <= 7 && i < cuentas.size())
            {
                datos.setValue(cuentas.get(i).getGanancia(), "Ganancia", cuentas.get(i).getFecha());
                datos.setValue(cuentas.get(i).getPerdida(), "Perdida", cuentas.get(i).getFecha());
                datos.setValue(cuentas.get(i).getInversion(), "Inversion", cuentas.get(i).getFecha());
                i++;
            } else
            {
                cuentas.remove(0);
            }
        }

        JFreeChart grafico_barras = ChartFactory.createBarChart(
                "Reporte de finanzas por día",
                "Fecha",
                "$$$",
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = grafico_barras.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        // Configurar las líneas horizontales
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK); // Establecer color de las líneas horizontales

        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(new Dimension(500, 200));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        //gbc.gridheight = 5;
        gbc.ipadx = 100;
        gbc.ipady = 100;
        this.add(panel, gbc);
        repaint();
    }

    public void cuentasPorSemana() {
        try
        {
            List<Double> gananciasPorSemana = CuentasDAO.obtenerValoresPorSemana("ganancia");
            List<Double> perdidasPorSemana = CuentasDAO.obtenerValoresPorSemana("perdida");
            List<Double> inversionesPorSemana = CuentasDAO.obtenerValoresPorSemana("inversion");

            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            rellenarGraficas(gananciasPorSemana, perdidasPorSemana, inversionesPorSemana, datos);

            JFreeChart grafico_barras = ChartFactory.createBarChart(
                    "Reporte de finanzas por semana",
                    "Ultimas 7 semanas",
                    "$$$",
                    datos,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            CategoryPlot plot = grafico_barras.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            // Configurar las líneas horizontales
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK); // Establecer color de las líneas horizontales

            ChartPanel panel = new ChartPanel(grafico_barras);
            panel.setMouseWheelEnabled(false);
            panel.setPreferredSize(new Dimension(500, 200));

            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            //gbc.gridheight = 5;
            gbc.ipadx = 100;
            gbc.ipady = 100;
            this.add(panel, gbc);
            repaint();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void cuentasPorMes() {
        try
        {
            List<Double> gananciasPorMes = CuentasDAO.obtenerValoresPorMes("ganancia");
            List<Double> perdidasPorMes = CuentasDAO.obtenerValoresPorMes("perdida");
            List<Double> inversionesPorMes = CuentasDAO.obtenerValoresPorMes("inversion");

            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            rellenarGraficas(gananciasPorMes, perdidasPorMes, inversionesPorMes, datos);

            JFreeChart grafico_barras = ChartFactory.createBarChart(
                    "Reporte de finanzas por mes",
                    "Ultimos 7 meses",
                    "$$$",
                    datos,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            CategoryPlot plot = grafico_barras.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            // Configurar las líneas horizontales
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK); // Establecer color de las líneas horizontales

            ChartPanel panel = new ChartPanel(grafico_barras);
            panel.setMouseWheelEnabled(false);
            panel.setPreferredSize(new Dimension(500, 200));

            gbc.gridx = 0;
            gbc.gridy = 20;
            gbc.gridwidth = 1;
            //gbc.gridheight = 5;
            gbc.ipadx = 100;
            gbc.ipady = 100;
            this.add(panel, gbc);
            repaint();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void cuentasPorAño() {
        try
        {
            List<Double> gananciasPorAnio = CuentasDAO.obtenerValoresPorAnio("ganancia");
            List<Double> perdidasPorAnio = CuentasDAO.obtenerValoresPorAnio("perdida");
            List<Double> inversionesPorAnio = CuentasDAO.obtenerValoresPorAnio("inversion");

            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            rellenarGraficas(gananciasPorAnio, perdidasPorAnio, inversionesPorAnio, datos);

            JFreeChart grafico_barras = ChartFactory.createBarChart(
                    "Reporte de finanzas por año",
                    "Ultimos 7 años",
                    "$$$",
                    datos,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            CategoryPlot plot = grafico_barras.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            // Configurar las líneas horizontales
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK); // Establecer color de las líneas horizontales

            ChartPanel panel = new ChartPanel(grafico_barras);
            panel.setMouseWheelEnabled(false);
            panel.setPreferredSize(new Dimension(500, 200));

            gbc.gridx = 2;
            gbc.gridy = 20;
            gbc.gridwidth = 1;
            //gbc.gridheight = 5;
            gbc.ipadx = 100;
            gbc.ipady = 100;
            this.add(panel, gbc);
            repaint();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    private void rellenarGraficas(List<Double> ganancias, List<Double> perdidas, List<Double> inversiones, DefaultCategoryDataset datos) {
        int cont = 0;
        for (int i = 0; i < 7;)
        {
            if (ganancias.size() <= 7 && perdidas.size() <= 7 && inversiones.size() <= 7 && i < ganancias.size())
            {
                datos.setValue(ganancias.get(i), "Ganancias", Integer.toString(cont++));
                datos.setValue(perdidas.get(i), "Perdidas", Integer.toString(cont++));
                datos.setValue(inversiones.get(i), "Inversiones", Integer.toString(cont++));
                i++;
            } else if (ganancias.size() > 7)
            {
                ganancias.remove(0);
                perdidas.remove(0);
                inversiones.remove(0);
            } else
            {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
