package Model.Citas;

import Dao.DaoCRR;
import DaoBD.DaoBD;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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

     public boolean desactivarCita(int idCita) {
       
        return false;
       
    }
      public boolean isFechaCitaValida(Date fechaCita) {
        // Obtener la fecha actual
        Date fechaActual = new Date(System.currentTimeMillis());
        
        // Verificar si la fecha de la cita es mayor a la fecha actual
        return fechaCita.after(fechaActual);
    }
      
}
