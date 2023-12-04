/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pruebas;

/**
 *
 * @author wendy
 */
public class PruebasDTO {
  private int id;
  private int nota;
  private String observaciones;
  private String estado;
  private boolean ausente;

    public PruebasDTO(int id, int nota, String observaciones, String estado) {
        this.id = id;
        this.nota = nota;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    

    public int getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    
    
    

  
  
  
  
}