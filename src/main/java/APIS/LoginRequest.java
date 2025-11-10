/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APIS;

/**
 *
 * @author Laura
 */
public class LoginRequest {
    private String correoElectronico;
    private String contrasena;

    public LoginRequest(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getContrasena() { return contrasena; }
}
