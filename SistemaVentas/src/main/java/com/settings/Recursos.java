/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.awt.Cursor;
import java.awt.Font;
import java.io.File;

public class Recursos {
    static private Recursos servicio;
    private Cursor cMano;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo, fontMediana, fontClasica;
    
    private Recursos(){
        this.crearCursores();
        this.crearFuentes();
    }
    
    public static Recursos getService(){
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
    
    private void crearFuentes() {
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("Rockwell Extra Bold", Font.PLAIN, 40);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 30);
        fontMediana = new Font("LuzSans-Book", Font.PLAIN, 15);
        fontClasica = new Font(null, Font.PLAIN, 20);
    }
    
    public Font getFontTPrincipal() {
        return fontTPrincipal;
    }

    public Font getFontTitulo() {
        return fontTitulo;
    }

    public Font getFontSubtitulo() {
        return fontSubtitulo;
    }
    
    public Font getFontMediana() {
        return fontMediana;
    }
    
    public Font getFontClasica() {
        return fontClasica;
    }
    
    public static String obtenerNombreArchivo(String directorio) {
        File folder = new File(directorio);
        File[] archivos = folder.listFiles();
        return (archivos.length == 1 && archivos[0].isFile()) ? archivos[0].getName() : null;
    }
}
