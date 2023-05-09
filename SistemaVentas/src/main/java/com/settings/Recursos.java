/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class Recursos {

    static private Recursos servicio;

    private Color colorPrincipal, colorGrisOscuro;
    private Cursor cMano;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo, fontMediana, fontClasica, fontTitulo2, fontSubtitulo2;
    private Border borderInferiorAzul;
    private ImageIcon iCerrar;

    private Recursos() {
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
}
