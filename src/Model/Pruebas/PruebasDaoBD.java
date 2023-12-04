/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pruebas;

import Dao.Dao;
import Dao.DaoP;
import DaoBD.DaoBD;
import java.util.ArrayList;

/**
 *
 * @author ekard
 */
public class PruebasDaoBD implements DaoP<PruebasDTO> {

 @Override
public boolean create(PruebasDTO obj) {
    DaoBD daoBD = new DaoBD();
    daoBD.createStatement("INSERT INTO pruebas (IdPrueba, Nota, Observaciones, Estado) VALUES (?, ?, ?, ?)");
    daoBD.set(1, obj.getId());  
    daoBD.set(2, obj.getNota());
    daoBD.set(3, obj.getObservaciones());
    daoBD.set(4, obj.getEstado());

    boolean success = daoBD.execute(false);
    
    return success;
}


  
}
