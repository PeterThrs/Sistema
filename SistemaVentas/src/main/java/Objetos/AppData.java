package Objetos;

import java.awt.Image;
import java.awt.Toolkit;

public class AppData {
    private final String APPNOMBRE = "Sistema De Ventas"; 
    private final String VERSION = "v.1.0"; 
    private final Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/images/icono/austronauta.png");

    public String getAppNombre() {
        return APPNOMBRE;
    }

    public String getVersion() {
        return VERSION;
    }

    public Image getIcono() {
        return image;
    }
    
    
}
