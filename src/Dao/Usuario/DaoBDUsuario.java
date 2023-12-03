/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Usuario;

import Dao.Dao;
import DaoBD.DaoBD;
import PersonaDTO.Usuarios.UsuarioDto;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wendy
 */
public class DaoBDUsuario implements Dao<UsuarioDto> {

    @Override
    public boolean create(UsuarioDto obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call UsuarioInsert(?,?,?)");
        bd.set(1, obj.getCedula());
        bd.set(2, obj.getNombreUsuario());
        bd.set(3, obj.getContrasena());
        return bd.execute(false);
    }

    @Override
    public UsuarioDto read(String nombreUsuario) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call UsuarioRead(?)");
        bd.set(1, nombreUsuario);
        if (bd.execute(true)) {
            try {
                if (bd.getData().next()) {
                    return new UsuarioDto(
                            bd.getData().getString(1),
                            bd.getData().getString(2),
                            bd.getData().getString(3)
                    );
                }
            } catch (SQLException ex) {
                System.out.println("Error en read: " + ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<UsuarioDto> readAll() {
        DaoBD bd = new DaoBD();
        List<UsuarioDto> usuarios = new ArrayList<>();
        bd.createStatement("call UsuarioReadAll()");
        if (bd.execute(true)) {
            try {
                while (bd.getData().next()) {
                    usuarios.add(new UsuarioDto(
                            bd.getData().getString(1),
                            bd.getData().getString(2),
                            bd.getData().getString(3)
                    ));
                }
            } catch (SQLException e) {
                System.out.println("Error en readAll: " + e.getMessage());
            }
        }
        return usuarios;
    }

    @Override
    public boolean update(UsuarioDto obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call UsuarioUpdate(?,?,?)");
        bd.set(1, obj.getCedula());
        bd.set(2, obj.getNombreUsuario());
        bd.set(3, obj.getContrasena());
        return bd.execute(false);
    }

    @Override
    public boolean delete(UsuarioDto obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call UsuarioDelete(?)");
        bd.set(1, obj.getNombreUsuario());
        return bd.execute(false);
    }
}
