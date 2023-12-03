/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.Oficial.Interface;

/**
 *
 * @author wendy
 */
public interface Contrasena {
    public boolean autenticar (int id, String obj);
    public boolean cambiarContrasena(int id, String contrasenaActual, String nuevaContrasena);
}
