package com.cashiers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Image;

import java.io.FileOutputStream;
import java.util.Map;

public class ReportePDF {
    
    public static void generarReporte(Map<String, String> dataReporte) {
        float ancho = 250f; // en unidades de puntos
        float altura = 540f; // en unidades de puntos
        Rectangle pageSize = new Rectangle(ancho, altura);
        
        // Crear el documento
        Document document = new Document(pageSize);

        try {
            // Crear el objeto PdfWriter
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dataReporte.get("nombreArchivo")));
            
            // Establecer los márgenes del documento (en puntos)
            document.setMargins(25, 25, 25, 25); // Izquierda, Derecha, Superior, Inferior
            
            // Abrir el documento
            document.open();
            
            Font fontNegrita = FontFactory.getFont(FontFactory.COURIER, 9);

            // Agregar una imagen centrada al documento
            //System.out.println("TIENDAS BODEGA AURRERA SA DE CV \n");
            Image imagen = Image.getInstance("src/main/resources/icono/BA.png");
            imagen.scaleToFit(100, 130); // Ajustar el tamaño de la imagen
            imagen.setAlignment(Image.ALIGN_CENTER); // Alinear la imagen al centro
            document.add(imagen);
            
            // Agregar una imagen al documento
            /*Image imagen = Image.getInstance("C:\\Users\\corte\\Documents\\4to Semestre\\Topicos Avanzados De Programacion\\Sistema De Ventas\\ProyectoFinal\\Proyecto F TAP\\Sistema\\SistemaVentas\\src\\main\\resources\\icono\\Bodega-Aurrera-Logo.png");
            imagen.scaleToFit(100, 130); // Ajustar el tamaño de la imagen
            document.add(imagen);*/
            
            // Agregar contenido al documento
            Paragraph paragraphNgrita = new Paragraph();
            paragraphNgrita.setFont(fontNegrita);
            paragraphNgrita.add(dataReporte.get("datos"));
           
            // Agregar contenido al documento
            /*Paragraph paragraph = new Paragraph("Este es un ejemplo de reporte utilizando iTextPDF.");
            Paragraph paragraph1 = new Paragraph("Producto");
            document.add(paragraph);
            document.add(paragraph1);*/
            document.add(paragraphNgrita);

            
            
            // Cerrar el documento
            document.close();

            // Cerrar el escritor
            writer.close();

            System.out.println("El reporte se ha generado correctamente.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}