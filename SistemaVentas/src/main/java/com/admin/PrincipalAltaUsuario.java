/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admin;

import com.admin.enumerador.Entrada;

/**
 *
 * @author Root
 */
public class PrincipalAltaUsuario {

    public static void main(String[] args) {
        VistaAltaUsuario vau = new VistaAltaUsuario(Entrada.AGREGAR, null, null);
        vau.setVisible(true);
    }

}
