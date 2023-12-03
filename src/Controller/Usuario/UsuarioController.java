/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Usuario;

import Controller.UsuarioLogin;
import Dao.Usuario.DaoBDUsuario;
import Model.Usuario.Usuario;
import PersonaDTO.Usuarios.UsuarioDto;
import View.View;
import java.util.List;

/**
 *
 * @author wendy
 */
public class UsuarioController implements UsuarioLogin {

    private DaoBDUsuario daoUsuario;
    private View view;

    public UsuarioController(DaoBDUsuario daoUsuario, View view) {
        this.daoUsuario = daoUsuario;
        this.view = view;
    }

    @Override
    public boolean crearUsuario(UsuarioDto usuario) {
        if (daoUsuario.create(usuario)) {
            view.displayMessage("Usuario creado correctamente.");
            return true;
        } else {
            view.displayErrorMessage("Error al crear el usuario.");
            return false;
        }
    }

    @Override
    public UsuarioDto obtenerUsuario(String nombreUsuario) {
        UsuarioDto usuario = daoUsuario.read(nombreUsuario);
        if (usuario != null) {
            view.display(UsuarioDto.class); // Asumiendo que tienes un método para mostrar la información del usuario
            return usuario;
        } else {
            view.displayErrorMessage("Usuario no encontrado.");
            return null;
        }
    }

    @Override
    public List<UsuarioDto> obtenerTodosLosUsuarios() {
        List<UsuarioDto> usuarios = daoUsuario.readAll();
        view.display(usuarios.getClass()); // Asumiendo que puedes mostrar una lista de usuarios
        return usuarios;
    }

    @Override
    public boolean actualizarUsuario(UsuarioDto usuario) {
        if (daoUsuario.update(usuario)) {
            view.displayMessage("Usuario actualizado correctamente.");
            return true;
        } else {
            view.displayErrorMessage("Error al actualizar el usuario.");
            return false;
        }
    }

    @Override
    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        UsuarioDto usuario = daoUsuario.read(nombreUsuario);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) { // Debería ser una comparación de hash
            view.displayMessage("Inicio de sesión exitoso.");
            return true;
        } else {
            view.displayErrorMessage("Nombre de usuario o contraseña incorrecta.");
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        if (usuario == null) {
            view.displayErrorMessage("El usuario proporcionado es nulo.");
            return false;
        }
        UsuarioDto usuarioDto = new UsuarioDto(
                usuario.getCedula(),
                usuario.getNombreUsuario(),
                usuario.getContrasena()
        );
        if (daoUsuario.delete(usuarioDto)) {
            view.displayMessage("Usuario eliminado correctamente.");
            return true;
        } else {
            view.displayErrorMessage("Error al eliminar el usuario.");
            return false;
        }
    }
}
