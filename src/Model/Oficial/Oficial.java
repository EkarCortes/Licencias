/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Oficial;

import Model.Persona;
import java.sql.Date;

public class Oficial extends Persona {

    private double salario;

    public Oficial(double salario,String cedula, String nombre, Date fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.salario = salario;
    }

    public double deducciones() {
        double deduccionesSeguridadSocial = salario * (5.5 + 3.84 + 1 + 3.3) / 100;
        double impuestoRenta = impuestoSobreRenta();
        return deduccionesSeguridadSocial + impuestoRenta;
    }

    private double impuestoSobreRenta() {
        if (salario <= 817000) {
            return 0;
        } else if (salario <= 1226000) {
            return (salario - 817000) * 0.10;
        } else {
            return (salario - 1226000) * 0.15 + 40500; // 10% de 817000 a 1226000 = 40500
        }
    }

    public double salarioNeto() {
        return salario - deducciones();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }    
}
