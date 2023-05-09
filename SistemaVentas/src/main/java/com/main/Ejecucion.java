package com.main;

import com.newLogin.LoginTemplate;
import javax.swing.SwingUtilities;

public class Ejecucion {

    public static void main(String[] args) {
//        Runnable runApplication = new Runnable() {
//            public void run() {
//                Login login = new Login();
//                login.getClass();
//            }
//        };
//        SwingUtilities.invokeLater(runApplication);
        Runnable runApplication = new Runnable() {
            public void run() {
                LoginTemplate login = new LoginTemplate();
                login.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
}
