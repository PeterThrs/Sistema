package com.main;

import com.classes.Sesion;
import javax.swing.SwingUtilities;

public class Ejecucion {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                Login login = new Login();
                login.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
}
