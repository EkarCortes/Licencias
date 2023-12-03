/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaDTO.Usuarios;

import Model.Usuario.Utilidades;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author wendy
 */
public class UsuarioDto {
    private String cedula;
    private String nombreUsuario;
    private String contrasena;

    public UsuarioDto(String cedula, String nombreUsuario, String contrasena) {
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public String getContrasena() {
        return contrasena;
    }


    public String getCedula() {
        return cedula;
    }

}

