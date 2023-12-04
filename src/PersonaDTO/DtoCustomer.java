package PersonaDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author abiga
 */

public class DtoCustomer extends PersonaDTO {
    private int edad;

    public DtoCustomer(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        calcularEdad(fechaNacimiento.toLocalDate());
    }

    public int getEdad() {
        return edad;
    }

    private void calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        this.edad = periodo.getYears();
    }
    
}

