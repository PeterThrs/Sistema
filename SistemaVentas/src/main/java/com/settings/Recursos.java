package com.settings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import java.math.BigDecimal;
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

    private static final String[] UNIDADES =
    {
        "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez",
        "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"
    };

    private static final String[] DECENAS =
    {
        "", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"
    };

    private static final String[] CENTENAS =
    {
        "", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos",
        "setecientos", "ochocientos", "novecientos"
    };

    private static final String[] MILLONES =
    {
        "", "millón", "millones", "millón", "millones", "billón", "billones", "billón", "billones",
        "trillón", "trillones", "trillón", "trillones", "cuatrillón", "cuatrillones", "cuatrillón", "cuatrillones"
    };

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

    public static String convertToWords(String numberText) {
        double number = Double.parseDouble(numberText);

        // Extraer la parte entera y la parte decimal del número
        long entero = (long) number;
        int decimal = (int) Math.round((number - entero) * 100);

        // Convertir la parte entera a palabras
        String enteroWords = convertNumberToWords(entero);

        // Convertir la parte decimal a palabras
        String decimalWords = convertNumberToWords(decimal);

        // Construir el resultado final
        StringBuilder result = new StringBuilder();
        result.append(enteroWords).append(" punto ").append(decimalWords);

        return result.toString();
    }

    private static String convertNumberToWords(long number) {
        if (number == 0)
        {
            return "cero";
        }

        StringBuilder words = new StringBuilder();

        if (number < 0)
        {
            words.append("menos ");
            number = -number;
        }

        if (number < 20)
        {
            words.append(UNIDADES[(int) number]);
        } else if (number < 100)
        {
            words.append(DECENAS[(int) (number / 10)]);
            long unidad = number % 10;
            if (unidad > 0)
            {
                words.append(" y ").append(UNIDADES[(int) unidad]);
            }
        } else if (number < 1000)
        {
            words.append(CENTENAS[(int) (number / 100)]);
            long decena = number % 100;
            if (decena > 0)
            {
                words.append(" ").append(convertNumberToWords(decena));
            }
        } else
        {
            int millonIndex = 0;
            while (number > 0)
            {
                if (number % 1000 != 0)
                {
                    String partialWords = convertNumberToWords(number % 1000);
                    words.insert(0, partialWords + " " + MILLONES[millonIndex] + " ");
                }
                number /= 1000;
                millonIndex += 2;
            }
        }

        return words.toString().trim();
    }
    
    public static String removeFirstCharacter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        return str.substring(1);
    }
}
