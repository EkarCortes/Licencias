/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaDTO;
import java.sql.Date;

public class DtoOficial extends PersonaDTO {
  
    private double salario;

    public DtoOficial(double salario,String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
    super(cedula, nombre, fechaNacimiento, telefono, correo);
    this.salario = salario;
}
   
    public double getSalario() {
        return salario;
    }
}
