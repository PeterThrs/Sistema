/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

/**
 *
 * @author juanj
 */
public class sGraficosAvanzados {

    static sGraficosAvanzados sgAvanzados;
    
    public sGraficosAvanzados(){}
    
     public static sGraficosAvanzados getService() {
        if (sgAvanzados == null)
        {
            sgAvanzados = new sGraficosAvanzados();
        }
        return sgAvanzados;
    }
    
    public Border DibujarBordeRedondeado(
            Color colorBorde, int radio, boolean esLineal, boolean esSolido, Image imagenFondo
    ) {
        Border bordeRedondeado = new Border() {

            @Override
            public void paintBorder(
                    Component c, Graphics g, int x, int y, int ancho, int alto
            ) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
                );
                Area area;
                Component padreContenedor = c.getParent();
                RoundRectangle2D rectanguloBordeado = new RoundRectangle2D.Double();
                rectanguloBordeado.setRoundRect(
                        x, y, ancho - 1, alto - 1, radio, radio
                );
                if (esLineal)
                {
                    dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
                    if (esSolido)
                    {
                        g2.setColor(c.getBackground());
                        g2.fill(rectanguloBordeado);
                    }
                    area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, rectanguloBordeado);
                } else
                {
                    area = dibujarBorde(c, g2, colorBorde, x, y, ancho, alto, rectanguloBordeado);
                    dibujarFondo(c, padreContenedor, imagenFondo, g2, ancho, alto);
                }
                g2.setClip(null);
                g2.draw(area);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(2, 2, 2, 2);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        };
        return bordeRedondeado;
    }

    private Area dibujarBorde(
            Component c, Graphics2D g2, Color color, int x, int y, int ancho, int alto, RectangularShape figura
    ) {
        if (color == null)
        {
            g2.setPaint(c.getBackground());
        } else
        {
            g2.setPaint(color);
        }
        Area area = new Area(figura);
        Rectangle rectangulo = new Rectangle(0, 0, ancho, alto);
        Area regionBorde = new Area(rectangulo);
        regionBorde.subtract(area);
        g2.setClip(regionBorde);
        return area;
    }

    private void dibujarFondo(
            Component c, Component padreContenedor, Image imagen, Graphics2D g2, int ancho, int alto
    ) {
        if (imagen != null)
        {
            g2.drawImage(
                    imagen,
                    0, 0,
                    imagen.getWidth(null), imagen.getHeight(null),
                    c.getX(), c.getY(),
                    imagen.getWidth(null) + c.getX(),
                    imagen.getHeight(null) + c.getY(),
                    c
            );
        } else
        {
            g2.setColor(padreContenedor.getBackground());
            g2.fillRect(0, 0, ancho, alto);
        }
    }
}
