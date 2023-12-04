package Model.Customer;

import Model.Persona;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author abiga
 */
public class Customer extends Persona {
    
    private int edad;

    public Customer(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        calcularEdad(fechaNacimiento.toLocalDate());
    }

    public Customer(String cedula, String nombre) {
        super(cedula, nombre);
    
 
    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    private void calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        this.edad = periodo.getYears();
    }
}
