/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Recursos {

    static private Recursos servicio;

    private Color colorPrincipal, colorGrisOscuro;
    private Cursor cMano;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo, fontMediana, fontClasica, fontTitulo2, fontSubtitulo2;
    private Border borderInferiorAzul, bRedondeado;
    private ImageIcon iCerrar;
    
    private sGraficosAvanzados sgAvanzados;

    private Recursos() {
        sgAvanzados = sGraficosAvanzados.getService();
        
        this.crearColores();
        this.crearFuentes();
        this.crearCursores();
        this.crearBordes();
        this.crearImagenes();
    }

    public static Recursos getService() {
        if (servicio == null)
        {
            servicio = new Recursos();
        }
        return servicio;
    }

    private void crearCursores() {
        cMano = new Cursor(Cursor.HAND_CURSOR);
    }

    public Cursor getCMano() {
        return cMano;
    }

    private void crearColores() {
        colorPrincipal = new Color(60, 78, 120);
        colorGrisOscuro = new Color(80, 80, 80);
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorGrisOscuro() {
        return colorGrisOscuro;
    }

    private void crearFuentes() {
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("Rockwell Extra Bold", Font.PLAIN, 40);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 30);
        fontMediana = new Font("LuzSans-Book", Font.PLAIN, 15);
        fontClasica = new Font(null, Font.PLAIN, 20);

        //fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo2 = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        fontSubtitulo2 = new Font("Forte", Font.PLAIN, 13);
    }

    public Font getFontTPrincipal() {
        return fontTPrincipal;
    }

    public Font getFontTitulo() {
        return fontTitulo;
    }

    public Font getFontTitulo2() {
        return fontTitulo2;
    }

    public Font getFontSubtitulo() {
        return fontSubtitulo;
    }

    public Font getFontSubtitulo2() {
        return fontSubtitulo2;
    }

    public Font getFontMediana() {
        return fontMediana;
    }

    public Font getFontClasica() {
        return fontClasica;
    }

    private void crearBordes() {
        borderInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorPrincipal);
        bRedondeado = sgAvanzados.DibujarBordeRedondeado(null, 40, false, false, null);
    }

    public Border getBorderRedondeado() {
        return bRedondeado;
    }
    
    public Border getBorderInferiorAzul() {
        return borderInferiorAzul;
    }

    private void crearImagenes() {
        iCerrar = new ImageIcon("src/main/resources/newLogin/cerrar.png");
    }

    public ImageIcon getICerrar() {
        return iCerrar;
    }

    public static String obtenerNombreArchivo(String directorio) {
        File folder = new File(directorio);
        File[] archivos = folder.listFiles();
        return (archivos.length == 1 && archivos[0].isFile()) ? archivos[0].getName() : null;
    }
    
    public static void buscarEnTabla(JTable tabla, String textoABuscar) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);

        if (textoABuscar.trim().isEmpty())
        {
            sorter.setRowFilter(null);
        } else
        {
            RowFilter<DefaultTableModel, Object> filtro = RowFilter.regexFilter("(?i)" + Pattern.quote(textoABuscar));
            sorter.setRowFilter(filtro);
        }

        resaltarCoincidencias(tabla, textoABuscar);
        
        if (tabla.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "No se encuentra");
        }
    }
    
    private static void resaltarCoincidencias(JTable tabla, String textoABuscar) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value != null && value.toString().toLowerCase().contains(textoABuscar.toLowerCase()))
                {
                    value = resaltarCoincidencias(value.toString(), textoABuscar);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        tabla.setDefaultRenderer(Object.class, renderer);
    }

    private static String resaltarCoincidencias(String texto, String textoABuscar) {
        String resaltado = texto.replaceAll("(?i)" + Pattern.quote(textoABuscar), "<span style='background-color: yellow;'>$0</span>");
        return "<html>" + resaltado + "</html>";
    }
}