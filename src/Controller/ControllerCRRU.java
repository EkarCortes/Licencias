/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import java.util.List;

/**
 *
 * @author ekard
 */
public interface ControllerCRRU <Class>  {
    public boolean create(Class obj);
    public Class read(String id);
    public List <Class> readAll();
    public boolean update(Class obj);
}