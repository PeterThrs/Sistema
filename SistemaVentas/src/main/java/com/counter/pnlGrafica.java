package com.counter;

import com.classes.CuentaFinanciera;
import com.conexion.CuentasDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author juanj
 */
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
        cuentas.forEach(cuenta ->
        {
            datos.setValue(cuenta.getGanancia(), "Ganancia", cuenta.getFecha());
            datos.setValue(cuenta.getPerdida(), "Perdida", cuenta.getFecha());
            datos.setValue(cuenta.getInversion(), "Inversion", cuenta.getFecha());
        }
        );
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
        cuentas = CuentasDAO.seleccionar();
        List<CuentaFinanciera> cuentasSemana = new ArrayList<>();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        cuentas.forEach(cuenta ->
        {
            if(cuentasSemana.size()==0){
                cuentasSemana.add(cuenta);
            } else{
                
            }
            datos.setValue(cuenta.getGanancia(), "Ganancia", cuenta.getFecha());
            datos.setValue(cuenta.getPerdida(), "Perdida", cuenta.getFecha());
            datos.setValue(cuenta.getInversion(), "Inversion", cuenta.getFecha());
        });
        cuentas.forEach(cuenta ->
        {
            datos.setValue(cuenta.getGanancia(), "Ganancia", cuenta.getFecha());
            datos.setValue(cuenta.getPerdida(), "Perdida", cuenta.getFecha());
            datos.setValue(cuenta.getInversion(), "Inversion", cuenta.getFecha());
        }
        );
        JFreeChart grafico_barras = ChartFactory.createBarChart(
                "Reporte de finanzas por semana",
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

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        //gbc.gridheight = 5;
        gbc.ipadx = 100;
        gbc.ipady = 100;
        this.add(panel, gbc);
        repaint();
    }

    public void cuentasPorMes() {
        cuentas = CuentasDAO.seleccionar();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        cuentas.forEach(cuenta ->
        {
            datos.setValue(cuenta.getGanancia(), "Ganancia", cuenta.getFecha());
            datos.setValue(cuenta.getPerdida(), "Perdida", cuenta.getFecha());
            datos.setValue(cuenta.getInversion(), "Inversion", cuenta.getFecha());
        }
        );
        JFreeChart grafico_barras = ChartFactory.createBarChart(
                "Reporte de finanzas por mes",
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
        gbc.gridy = 20;
        gbc.gridwidth = 1;
        //gbc.gridheight = 5;
        gbc.ipadx = 100;
        gbc.ipady = 100;
        this.add(panel, gbc);
        repaint();
    }

    public void cuentasPorAño() {
        cuentas = CuentasDAO.seleccionar();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        cuentas.forEach(cuenta ->
        {
            datos.setValue(cuenta.getGanancia(), "Ganancia", cuenta.getFecha());
            datos.setValue(cuenta.getPerdida(), "Perdida", cuenta.getFecha());
            datos.setValue(cuenta.getInversion(), "Inversion", cuenta.getFecha());
        }
        );
        JFreeChart grafico_barras = ChartFactory.createBarChart(
                "Reporte de finanzas por año",
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

        gbc.gridx = 2;
        gbc.gridy = 20;
        gbc.gridwidth = 1;
        //gbc.gridheight = 5;
        gbc.ipadx = 100;
        gbc.ipady = 100;
        this.add(panel, gbc);
        repaint();
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
