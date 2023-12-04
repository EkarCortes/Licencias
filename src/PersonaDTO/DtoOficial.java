/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaDTO;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
public class DtoOficial extends PersonaDTO {
    private int edad;
    private double salario;
    public DtoOficial(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
    super(cedula, nombre, fechaNacimiento, telefono, correo);
    this.salario=salario;
     calcularEdad(fechaNacimiento.toLocalDate());

}

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public DtoOficial(String cedula, String nombre, Date fechaNacimiento, String telefono, String correo, int edad) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.edad = edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

