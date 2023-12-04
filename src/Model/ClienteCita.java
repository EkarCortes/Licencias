/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ekard
 */
public class ClienteCita {
    private int idCita;
    private String fechaCita;
    private String hora;
    private String idClienteFK;
    private String cedulaCliente;
    private String nombreCliente;
    private int idPrueba;
    private String nota;
    private String observaciones;
    private String Estado;

    public ClienteCita(int idCita, String fechaCita, String hora, String idClienteFK, String cedulaCliente, String nombreCliente, int idPrueba, String nota, String observaciones, String Estado) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.idClienteFK = idClienteFK;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.idPrueba = idPrueba;
        this.nota = nota;
        this.observaciones = observaciones;
        this.Estado = Estado;
    }

    
    
    public String getEstado() {
        return Estado;
    }

    
    
    
    public int getIdPrueba() {
        return idPrueba;
    }

    public String getNota() {
        return nota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    
    public int getIdCita() {
        return idCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public String getHora() {
        return hora;
    }

    public String getIdClienteFK() {
        return idClienteFK;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    

}
