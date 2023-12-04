/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Pruebas;

import Controller.ControllerP;
import Model.Citas.CitaDaoBD;
import Model.ClienteCita;
import Model.Pruebas.Pruebas;
import Model.Pruebas.PruebasDTO;
import Model.Pruebas.PruebasDaoBD;
import View.Interface.FrmPruebas;
import java.util.List;

/**
 *
 * @author ekard
 */
public class PruebasController implements ControllerP<Pruebas> {

    
     private FrmPruebas viewC;
    

    public PruebasController(FrmPruebas viewC) {
        this.viewC = viewC;
    }
    
    @Override
    public boolean create(Pruebas pruebas) {
    PruebasDaoBD dao = new PruebasDaoBD();
    PruebasDTO pruebasDTO = new PruebasDTO(
       pruebas.getId(),  
       pruebas.getNota(),
       pruebas.getObservaciones(),
       pruebas.getEstado()
    );

    return dao.create(pruebasDTO);
}

 
   public void cargarDatosDesdeBaseDeDatos() {
    CitaDaoBD citaDao = new CitaDaoBD();
    List<ClienteCita> citasConClientes = citaDao.obtenerCitasConClientes();
    viewC.displayClientesYCitas(citasConClientes);
 }
}
