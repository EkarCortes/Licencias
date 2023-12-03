package Controller.Customer;

import Controller.Controller;
import Model.Customer.Customer;
import Model.Customer.CustomerDaoBD;
import PersonaDTO.DtoCustomer;
import View.Interface.FrmClientes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abiga
 */

public class CustomerController implements Controller<Customer> {

   private FrmClientes viewC;
    

    public CustomerController(FrmClientes viewC) {
        this.viewC = viewC;
    }
    
    @Override
public boolean create(Customer customer) {
    CustomerDaoBD dao = new CustomerDaoBD();
    DtoCustomer customerdto = new DtoCustomer(
        customer.getCedula(),
        customer.getNombre(),
        customer.getFechaNacimiento(),
        customer.getTelefono(),
        customer.getCorreo()
    );

    boolean success = dao.create(customerdto);

    if (success) {
        viewC.displayMessage("Cliente creado exitosamente.");
        readAll();
    } else {
        viewC.displayErrorMessage("No se pudo crear el cliente. Por favor, inténtalo de nuevo.");
    }

    return success;
}


    @Override
    public Customer read(String id) {
      
        CustomerDaoBD dao = new CustomerDaoBD();
        DtoCustomer Dto = dao.read(id);

        if (Dto != null) {
            Customer cust = new Customer(
                    Dto.getCedula(),
                    Dto.getNombre(),
                    Dto.getFechaNacimiento(),
                    Dto.getTelefono(),
                    Dto.getCorreo()
            );

            viewC.display(cust);
        } else {
            viewC.displayErrorMessage("Cita no encontrada");
        }
       return null;
    }

  
    @Override
    public List<Customer> readAll() {
    CustomerDaoBD dao = new CustomerDaoBD();
    ArrayList<DtoCustomer> lista = dao.readAll();
    if (lista != null) {
            viewC.DisplayAll(lista);
    }
       return null;
    
    }
 

    @Override
    public boolean update(Customer obj) {
          CustomerDaoBD dao = new CustomerDaoBD();
          DtoCustomer dto = new DtoCustomer(
                obj.getCedula(),
                obj.getNombre(),
                obj.getFechaNacimiento(),
                obj.getTelefono(),
                obj.getCorreo()
        );

        boolean exito = dao.update(dto);

        if (exito) {
            viewC.display(obj);
            viewC.displayMessage("Cita modificada correctamente");
            readAll();
        } else {
        }
       return false;
    }

    @Override
    public boolean delete(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

