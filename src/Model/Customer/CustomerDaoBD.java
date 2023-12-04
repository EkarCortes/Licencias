package Model.Customer;


import Dao.DaoCUS;
import DaoBD.DaoBD;
import Model.Citas.CitaDaoBD;
import PersonaDTO.DtoCustomer;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abiga
 */

public class CustomerDaoBD implements DaoCUS<DtoCustomer> {
    
    private static CustomerDaoBD customerInstance;
    private DaoBD bd;
    
    
      public CustomerDaoBD() {
        this.bd = new DaoBD();
    }
    public static CustomerDaoBD getInstance(){
    if (customerInstance==null) {
       customerInstance=new CustomerDaoBD();
     }
    return customerInstance;
   }
    
    @Override
    public boolean create(DtoCustomer customer) {
        if (customer == null) {
            return false;
        }
        
        bd.createStatement("call CustomerInsert(?,?,?,?,?)");
        bd.set(1, customer.getCedula());
        bd.set(2, customer.getNombre());
        bd.set(3, customer.getFechaNacimiento());
        bd.set(4, customer.getTelefono());
        bd.set(5, customer.getCorreo());
        return bd.execute(false);
    }

    @Override
    public DtoCustomer read(String id) {
        try {
            DaoBD bd = new DaoBD();
            bd.createStatement("call CustomerRead(?)");
            bd.set(1, id);
            bd.execute(true);

            if (bd.getData().next()) {
                String nombre = bd.getData().getString("NombreCliente");
                Date fechanacimiento = bd.getData().getDate("Fecha_de_NacimientoCliente");
                String telefono = bd.getData().getString("Telefono");
                String correo = bd.getData().getString("Correo");

                return new DtoCustomer(id,nombre, fechanacimiento,telefono,correo);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<DtoCustomer> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CustomerReadAll()"); 

        ArrayList<DtoCustomer> customerList = new ArrayList<>();

        try {
            if (bd.execute(true)) {
                while (bd.getData().next()) {
                      DtoCustomer customer = new DtoCustomer(
                            bd.getData().getString(1),
                            bd.getData().getString(2),
                            bd.getData().getDate(3),
                            bd.getData().getString(4),
                            bd.getData().getString(5)
                    );
                    customerList.add(customer);
                }
            }
        } catch (SQLException ex) {
        }

        return customerList;
    }

   @Override
  public boolean update(DtoCustomer customer) {
      bd.createStatement("UPDATE clientes SET NombreCliente = ?, Fecha_de_NacimientoCliente = ?, Telefono = ?, Correo = ? WHERE Cedula = ?");
      bd.set(1, customer.getNombre());
      bd.set(2, customer.getFechaNacimiento());
      bd.set(3, customer.getTelefono());
      bd.set(4, customer.getCorreo());
      bd.set(5, customer.getCedula());

    return bd.execute(false);
}


  
   public List<Customer> obtenerClientes() {
        List<Customer> clientes = new ArrayList<>();
        DaoBD dao = new DaoBD();

        try {
            dao.createStatement("SELECT Cedula, NombreCliente FROM clientes");
            dao.execute(true);

            while (dao.getData().next()) {
                String cedula = dao.getData().getString("Cedula");
                String nombreCliente = dao.getData().getString("NombreCliente");

                Customer cliente = new Customer(cedula, nombreCliente);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }

        return clientes;
    }
  

}
