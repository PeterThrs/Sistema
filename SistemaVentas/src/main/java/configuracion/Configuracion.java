package configuracion;

import Objetos.Sesion;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Configuracion {
    
    
    public static <T extends JFrame> void styles(T t){
        t.setExtendedState(t.MAXIMIZED_BOTH);
        t.setTitle(Sesion.app.getAppNombre());
        t.setLocationRelativeTo(null);
        t.setIconImage(Sesion.app.getIcono());
    }
    
    public static <T extends JDialog> void styles(T t){
        t.setTitle(Sesion.app.getAppNombre());
        t.setLocationRelativeTo(null);
        t.setIconImage(Sesion.app.getIcono());
    }
    
    public static <T extends JComponent> void normal(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setFont(new Font("Verdana", Font.PLAIN, 13));
        } 
    }
    
    public static <T extends JComponent> void titulo(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setFont(new Font("Roboco ligt", Font.BOLD, 18));
        } 
    }
    
}
