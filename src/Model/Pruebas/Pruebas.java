/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pruebas;

import java.util.Date;

/**
 *
 * @author wendy
 */
public class Pruebas {
  private int id;
  private int nota;
  private String observaciones;
  private String estado;
  private boolean ausente;

    public Pruebas(int id, int nota, String observaciones, String estado) {
        this.id = id;
        this.nota = nota;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

  public String obtenerEstadoNota() {
    int notaNumerica = 0;
    try {
        notaNumerica = Integer.parseInt(String.valueOf(nota));
    } catch (NumberFormatException e) {
    }

    if (notaNumerica >= 80) {
        return "Aprobado";
    } else {
        return "Reprobado";
    }
}

  
  
    
}