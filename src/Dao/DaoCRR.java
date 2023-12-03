/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;

/**
 *
 * @author ekard
 */
public interface DaoCRR  <Class> {
    public boolean create(Class obj);
    public Class read(String id);
    public List <Class> readAll();
}
