/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package View;

/*
 * @author wendy
 */
public interface View <Class> {
    public void display(Class obj);
    public void displayErrorMessage(String message);
    public void displayMessage(String message);
    public boolean displayConfirmMessage(String message);
    
}
