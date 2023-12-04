/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.Oficial;

import Dao.Dao;
import DaoBD.DaoBD;
import PersonaDTO.DtoOficial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wendy
 */
public class DaoBDOficial implements Dao<DtoOficial> {
    
    @Override
    public boolean create(DtoOficial obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call OficialInsert(?,?,?,?,?)"); // Nombre del procedimiento almacenado
        bd.set(1, obj.getCedula());
        bd.set(2, obj.getNombre());
        bd.set(3, obj.getFechaNacimiento());
        bd.set(4, obj.getTelefono());
        bd.set(5, obj.getCorreo());
        return bd.execute(false);
    }

    @Override
    public DtoOficial read(String id) {
        DaoBD bd = new DaoBD();
        bd.createStatement("call OficialRead(?)");
        bd.set(1, id);
        if (bd.execute(true)) {
            try {
                if (bd.getData().next()) {
                    DtoOficial user = new DtoOficial(bd.getData().getString(1), bd.getData().getString(2), bd.getData().getDate(3), bd.getData().getString(4), bd.getData().getString(5) );
                    return user;
                } else {
                    return null;
                }
            } catch (SQLException ex) {
                
            }
        }
        return null;
    }
    
    @Override
    public List<DtoOficial> readAll() {
    List<DtoOficial> oficiales = new ArrayList<>();
    DaoBD bd = new DaoBD();
    try {
        bd.createStatement("call SelectAll()");
        if (bd.execute(true)) {
            while (bd.getData().next()) {
                String cedula = bd.getData().getString(1);
                String nombre = bd.getData().getString(2);
                Date fechaNacimiento = bd.getData().getDate(3);
                String telefono = bd.getData().getString(4);
                String correo = bd.getData().getString(5);
                oficiales.add(new DtoOficial(cedula, nombre, fechaNacimiento, telefono, correo));
                System.out.println("Recuperado: " + cedula + ", " + nombre + ", " + fechaNacimiento + ", " + telefono + ", " + correo);

            }
        }
    } catch (SQLException e) {
        System.out.println("Error readAll: " + e.getMessage());
    }
    
    return oficiales;
    }
    
    @Override
    public boolean update(DtoOficial obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call OficialUpdate(?,?,?,?,?)");        
        bd.set(1, obj.getCedula());
        bd.set(2, obj.getNombre());
        bd.set(3, obj.getFechaNacimiento());
        bd.set(4, obj.getTelefono());
        bd.set(5, obj.getCorreo());
        return bd.execute(false);
    }
    
    @Override
    public boolean delete(DtoOficial obj) {
        if (obj == null) {
            return false;
        }
        DaoBD bd = new DaoBD();
        bd.createStatement("call deleteOficial(?)");
        bd.set(1, obj.getCedula());
        return bd.execute(false);
    }
    
}
