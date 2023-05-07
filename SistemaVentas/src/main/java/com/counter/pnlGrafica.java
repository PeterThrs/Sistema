/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.counter;

import com.classes.CuentaFinanciera;
import com.conexion.CuentasDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author juanj
 */
public class pnlGrafica extends javax.swing.JPanel {

    public pnlGrafica() {
        initComponents();
        cuentas();
    }

    public void cuentas() {
        List<CuentaFinanciera> cuentas = CuentasDAO.seleccionar();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        cuentas.forEach(cuenta ->
        {
            datos.setValue(cuenta.getGanancia(), "Ganancia", cuenta.getFecha());
            datos.setValue(cuenta.getPerdida(), "Perdida", cuenta.getFecha());
            datos.setValue(cuenta.getInversion(), "Inversion", cuenta.getFecha());
        }
        );
        JFreeChart grafico_barras = ChartFactory.createBarChart(
                "Reporte de finanzas",
                "Fecha",
                "$$$",
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(new Dimension(400, 700));
        
        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.NORTH);
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
