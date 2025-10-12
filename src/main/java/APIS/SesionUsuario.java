/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APIS;

/**
 *
 * @author Laura
 */
public class SesionUsuario {
    private static String correoUsuario;

    
    public static void setCorreo(String correo) {
        correoUsuario = correo;
    }

   
    public static String getCorreo() {
        return correoUsuario;
    }

   
    public static void cerrarSesion() {
        correoUsuario = null;
    }
}
