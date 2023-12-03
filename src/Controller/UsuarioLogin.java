/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import Model.Usuario.Usuario;
import PersonaDTO.Usuarios.UsuarioDto;
import java.util.List;

/**
 *
 * @author wendy
 */
public interface UsuarioLogin   {
    boolean crearUsuario(UsuarioDto usuario);

    UsuarioDto obtenerUsuario(String nombreUsuario);

    List<UsuarioDto> obtenerTodosLosUsuarios();

    boolean actualizarUsuario(UsuarioDto usuario);

    boolean eliminarUsuario(Usuario usuario);

    boolean iniciarSesion(String nombreUsuario, String contrasena);
}
