/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Citas;


import Controller.Controller;
import Controller.ControllerCRR;
import Controller.Customer.CustomerController;
import Model.Citas.Cita;
import Model.Citas.CitaDTO;
import Model.Citas.CitaDaoBD;
import Model.Customer.CustomerDaoBD;
import View.Interface.FrmCitas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ekard
 */
public class CitaController implements ControllerCRR<Cita> {

    private FrmCitas view;
    private CustomerController customercontroller;
    private static CitaController instance;

    public CitaController(FrmCitas view) {
        this.view = view;
    }
   
   

    
   @Override
    public boolean create(Cita cita) {
    CitaDaoBD dao = new CitaDaoBD();

    
    if (!dao.isFechaCitaValida(cita.getFecha())) {
        view.displayErrorMessage(" La fecha de la cita debe ser mayor a la fecha actual.");
        return false;
    }

    if (dao.clienteTieneCita(cita.getCustomer())) {
        view.displayErrorMessage("El cliente ya tiene una cita activa.");
        return false; 
    }
    
    if (!verificarExistenciaCliente(cita.getCustomer())) {
        return false;
    }

    if (dao.citasEnFechaYHora(cita.getFecha(), cita.getHora())) {
        view.displayErrorMessage("Ya existen cuatro citas registradas en la misma fecha y hora.");
        return false; 
    
    }
    
    CitaDTO dto = new CitaDTO(
        cita.getId(),
        cita.getFecha(),
        cita.getHora(),
        cita.getCustomer()
         
    );

    boolean success = dao.create(dto);

    if (success) {
        view.displayMessage("Cita agregada exitosamente.");
        readAll();
    } else {
        view.displayErrorMessage("No se pudo agregar la cita. Por favor, inténtalo de nuevo.");
    }

    return success;
}




    @Override
    public Cita read(String id) {
       CitaDaoBD dao = new CitaDaoBD();
        CitaDTO citaDto = dao.read(id);

        if (citaDto != null) {
            Cita cita = new Cita(
                    citaDto.getId(),
                    citaDto.getFecha(),
                    citaDto.getHora(),
                    citaDto.getCustomer()
            );

            view.display(cita);
        } else {
            view.displayErrorMessage("Cita no encontrada");
        }
        return null;
    
    }
    @Override
    public List<Cita> readAll() {
    CitaDaoBD dao = new CitaDaoBD();
    ArrayList<CitaDTO> lista = dao.readAll();
    if (lista != null) {
            view.DisplayAll(lista);
    }
       return null;
    
    }

    
   private boolean verificarExistenciaCliente(String idCliente) {
    CustomerDaoBD dao = new CustomerDaoBD();

    if (dao.read(idCliente) == null) {
        view.displayErrorMessage("El Id del cliente no existe.");
        return false;
    }
    return true;
}
    
           
}
