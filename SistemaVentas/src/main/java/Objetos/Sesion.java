package Objetos;

public class Sesion {
    
    public static Persona user; 
    public static AppData app = new AppData();
    public static Seguridad seguridad; 
    //public static Login login = new Login(); 
    
    public static boolean validar(String user, String password){
        seguridad = new Seguridad(user, password); 
        return seguridad.validar();
    }
}
