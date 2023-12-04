package Model.Citas;

import Dao.DaoCRR;
import DaoBD.DaoBD;
import Model.ClienteCita;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaDaoBD implements DaoCRR<CitaDTO> {

    private DaoBD daoBD;
    private static CitaDaoBD cita;
  
    public CitaDaoBD() {
        this.daoBD = new DaoBD();
    }

  public static CitaDaoBD getInstance(){
    if (cita==null) {
       cita=new CitaDaoBD();
     }
    return cita;
   }
  
   @Override
   public boolean create(CitaDTO citaDTO) {
    if (!isFechaCitaValida(citaDTO.getFecha())) {
        System.out.println("Error: La fecha de la cita debe ser mayor a la fecha actual.");
        return false;
    }

    boolean activo = true;
    daoBD.createStatement("INSERT INTO citas (FechaCita, Hora, IdClienteFK, Activa  ) VALUES (?, ?, ?, ?)");
    daoBD.set(1, citaDTO.getFecha());
    daoBD.set(2, citaDTO.getHora());
    daoBD.set(3, citaDTO.getCustomer());
    daoBD.set(4, activo);

    return daoBD.execute(false);
}


    @Override
public CitaDTO read(String id) {
    try {
        DaoBD bd = new DaoBD();

        bd.createStatement("call CitaRead(?)");
        bd.set(1, id);
        boolean executionResult = bd.execute(true);

        if (executionResult && bd.getData() != null && bd.getData().next()) {
            int idcita = Integer.parseInt(id);
            Date fecha = bd.getData().getDate("FechaCita");
            String hora = bd.getData().getString("Hora");
            String idcliente = bd.getData().getString("IdClienteFK");

            return new CitaDTO(idcita, fecha, hora, idcliente);
        } else {
            return null;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
}



    @Override
    public ArrayList<CitaDTO> readAll() {
        DaoBD bd = new DaoBD();
        bd.createStatement("call CitasReadAll()"); 
        ArrayList<CitaDTO> List = new ArrayList<>();

        try {
            if (bd.execute(true)) {
                while (bd.getData().next()) {
                      CitaDTO cita = new CitaDTO(
                            bd.getData().getInt(1),
                            bd.getData().getDate(2),
                            bd.getData().getString(3),
                            bd.getData().getString(4)
                            
                           
                    );
                    List.add(cita);
                }
            }
        } catch (SQLException ex) {
        }

        return List;
    }

    
    

    public boolean clienteTieneCita(String idCliente) {
    DaoBD bd = new DaoBD();
    boolean tieneCita = false;
    
    try {
        bd.createStatement("SELECT COUNT(*) FROM citas WHERE IdClienteFK = ?");
        bd.set(1, idCliente);
        bd.execute(true);

        if (bd.getData().next()) {
            int count = bd.getData().getInt(1);
            tieneCita = count > 0;
        }
        
        if (tieneCita) {
            System.out.println("El cliente ya tiene una cita activa.");
        }

    } catch (SQLException ex) {
        ex.printStackTrace(); 
    }

    return tieneCita;
}
public boolean citasEnFechaYHora(Date fecha, String hora) {
    DaoBD bd = new DaoBD();
    try {
        String consulta = "SELECT COUNT(*) FROM citas WHERE FechaCita = ? AND Hora = ?";
        System.out.println("Consulta SQL: " + consulta);

        bd.createStatement(consulta);
        bd.set(1, fecha);
        bd.set(2, hora);
        bd.execute(true);

        if (bd.getData().next()) {
            int count = bd.getData().getInt(1);
            return count >= 4; 
        }
    } catch (SQLException ex) {
        System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
    
    }

    return false;
}

      public boolean isFechaCitaValida(Date fechaCita) {
        Date fechaActual = new Date(System.currentTimeMillis());
        return fechaCita.after(fechaActual);
    }
      
      public List<Cita> obtenerCitas() {
        List<Cita> citas = new ArrayList<>();
        DaoBD dao = new DaoBD();
        try {
            dao.createStatement("SELECT IdCita, FechaCita, Hora, IdClienteFK FROM citas");
            dao.execute(true);

            while (dao.getData().next()) {
                int idCita = dao.getData().getInt("IdCita");
                String fechaCita = dao.getData().getString("FechaCita");
                String hora = dao.getData().getString("Hora");
                String cliente = dao.getData().getString("IdClienteFK");

                Cita cita = new Cita(idCita, fechaCita, hora,cliente);
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }

        return citas;
    }

      public List<ClienteCita> obtenerCitasConClientes() {
    List<ClienteCita> citasConClientes = new ArrayList<>();
    DaoBD dao = new DaoBD();

    try {
        dao.createStatement("SELECT c.IdCita, c.FechaCita, c.Hora, c.IdClienteFK, cl.Cedula, cl.NombreCliente, p.IdPrueba, p.Nota, p.Observaciones, p.Estado FROM citas c INNER JOIN clientes cl ON c.IdClienteFK = cl.Cedula LEFT JOIN pruebas p ON c.IdCita = p.IdCitaFK");
        dao.execute(true);

        while (dao.getData().next()) {
            int idPrueba = dao.getData().getInt("IdPrueba");
            String nota = dao.getData().getString("Nota");
            String observaciones = dao.getData().getString("Observaciones");
            int idCita = dao.getData().getInt("IdCita");
            String fechaCita = dao.getData().getString("FechaCita");
            String hora = dao.getData().getString("Hora");
            String idClienteFK = dao.getData().getString("IdClienteFK");
            String cedulaCliente = dao.getData().getString("Cedula");
            String nombreCliente = dao.getData().getString("NombreCliente");
            String estado = dao.getData().getString("Estado");
            

            ClienteCita citaClienteInfo = new ClienteCita(idCita, fechaCita, hora, idClienteFK, cedulaCliente, nombreCliente, idPrueba, nota, observaciones, estado);
            citasConClientes.add(citaClienteInfo);
        }
    } catch (SQLException e) {
        e.printStackTrace();  
    }

    return citasConClientes;
}

      

      
}
