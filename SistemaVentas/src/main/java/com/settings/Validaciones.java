/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validaciones {
    static private Validaciones validacion;

    public Validaciones() {
        //validacion = getValidacion();
    }
    
    public static Validaciones getValidacion() {
        if (validacion == null)
        {
            validacion = new Validaciones();
        }
        return validacion;
    }
    
    public static boolean validarEmail(String email) throws Exception {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (email.matches(regex))
        {
            return true;
        }
        throw new Exception("Formato de email incorrecto");
    }

    public static boolean validarCadena(String c) throws Exception {
        if (!c.isEmpty())
        {
            return true;
        }
        throw new Exception("Campos vacios");
    }

    public static boolean validarTelefono(String t) throws Exception {
        //forma correcta de un numero = +52-9511911329
        String regex = "^\\+\\d{1,3}-\\d{10}$";
        if (t.matches(regex))
        {
            return true;
        }
        throw new Exception("El telefono no cumple con el formato solicitado");
    }

    public static boolean validarCodPostal(int codPostal) throws Exception {
        if (codPostal >= 0)
        {
            return true;
        }
        throw new Exception("El codigo postal no puede ser negativo");
    }

    public static boolean validarNumCasa(int num) throws Exception {
        if (num > 0)
        {
            return true;
        }
        throw new Exception("El numero de casa no puede ser negativo");

    }

    public static boolean validarNegativo(Double n) throws Exception {
        if (n > 0) {
            return true;
        }
        throw new Exception("No puede haber numero negativo");
    }
    
    public static boolean validarContrasenia(String pass,String contrasenia, String confirmacion) throws Exception {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);
        if (matcher.matches()) {
            if (contrasenia.equals(confirmacion)) {
                return true;
            } else {
                throw new Exception("Las contraseñas no coinciden");
            }
        }
        throw new Exception("La contraseña no cumple el formato");
    }
    
    public static boolean validarEdad(int edad) throws Exception {
        if (edad >= 18 && edad <= 70) {
            return true;
        }
        throw new Exception("Edad no admitida");
    }
}
