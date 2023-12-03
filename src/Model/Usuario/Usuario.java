/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Usuario;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wendy
 */
public class Usuario {
    private String cedula;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String cedula, String nombreUsuario, String contrasena) {
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }


    public void encriptarContrasena() {
        try {
            this.contrasena = Utilidades.encriptarContrasena(this.contrasena);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No se pudo encriptar la contrasena");
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCedula() {
        return cedula;
    }

}

