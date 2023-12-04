/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.Interface;

import Controller.Pruebas.PruebasController;
import Model.ClienteCita;
import Model.Pruebas.Pruebas;
import View.View;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wendy
 */
public class FrmPruebas extends javax.swing.JInternalFrame implements View<Pruebas> {

    /**
     * Creates new form FrmPruebas
     */
    
    private PruebasController controllerPruebas;
    public FrmPruebas() {
        initComponents();
        controllerPruebas = new PruebasController(this);
       
        controllerPruebas.cargarDatosDesdeBaseDeDatos();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnCalificar = new javax.swing.JButton();
        btnAusente = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pruebas:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        btnCalificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/writing.png"))); // NOI18N
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });

        btnAusente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icons/close.png"))); // NOI18N
        btnAusente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAusenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel7)
                .addGap(168, 168, 168)
                .addComponent(btnCalificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAusente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCalificar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAusente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
//        int row = tabla.getSelectedRow();
//        Integer idCitaInteger = (Integer) tabla.getValueAt(row, 0);
//        controllercita.read(idCitaInteger.toString());
    }//GEN-LAST:event_tablaMouseClicked

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
       int selectedRow = tabla.getSelectedRow();

    if (selectedRow != -1) {
        try {
            // Obtenemos los datos de la fila seleccionada
            int idCita = (int) tabla.getValueAt(selectedRow, 0);
            String fechaCita = (String) tabla.getValueAt(selectedRow, 1);
            String hora = (String) tabla.getValueAt(selectedRow, 2);
            String cedulaCliente = (String) tabla.getValueAt(selectedRow, 3);
            String nombreCliente = (String) tabla.getValueAt(selectedRow, 4);

            // Muestra una ventana de entrada para ingresar la nota
            String notaStr = JOptionPane.showInputDialog(this, "Ingrese la nota:");

            // Convierte la nota a un entero
            int nota = Integer.parseInt(notaStr);

            // Muestra una ventana de entrada para ingresar las observaciones
            String observaciones = JOptionPane.showInputDialog(this, "Ingrese las observaciones:");

            // Crea una instancia de Pruebas para utilizar el método obtenerEstadoNota
            Pruebas prueba = new Pruebas(0, nota, observaciones, "");

            // Obtiene el estado y actualiza la tabla
            String estado = prueba.obtenerEstadoNota();

            // Actualiza la tabla de pruebas con los datos ingresados
            DefaultTableModel modelPruebas = (DefaultTableModel) tabla.getModel();
            modelPruebas.setValueAt(notaStr, selectedRow, 6);  // Columna de Nota
            modelPruebas.setValueAt(observaciones, selectedRow, 7);  // Columna de Observaciones
            modelPruebas.setValueAt(estado, selectedRow, 8);  // Columna de Estado

            // Crea una nueva instancia de Pruebas para enviar a la base de datos
            Pruebas nuevaPrueba = new Pruebas(0, nota, observaciones, estado);

            // Llama al método create del controlador para insertar la nueva prueba
            boolean success = controllerPruebas.create(nuevaPrueba);

            if (success) {
                JOptionPane.showMessageDialog(this, "Calificación enviada a la base de datos.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al enviar la calificación a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            // Si ocurre un error al convertir la nota a un entero
            JOptionPane.showMessageDialog(this, "Ingrese una nota válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Manejo adecuado de otras excepciones
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al calificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para calificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnCalificarActionPerformed

    private void btnAusenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAusenteActionPerformed
       int selectedRow = tabla.getSelectedRow();

if (selectedRow != -1) {
    String notaStr = "0";
    String observaciones = "AUSENTE";
    String estadoReprobado = "Reprobado";

    DefaultTableModel modelPruebas = (DefaultTableModel) tabla.getModel();
    modelPruebas.setValueAt(notaStr, selectedRow, 6);  
    modelPruebas.setValueAt(observaciones, selectedRow, 7); 
     modelPruebas.setValueAt(estadoReprobado, selectedRow, 8); 

    Pruebas nuevaPrueba = new Pruebas(0, Integer.parseInt(notaStr), observaciones, estadoReprobado);
    boolean success = controllerPruebas.create(nuevaPrueba);

    if (success) {
        JOptionPane.showMessageDialog(this, "Calificación de AUSENTE enviada a la base de datos como Reprobado.");
    } else {
        JOptionPane.showMessageDialog(this, "Error al enviar la calificación a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(this, "Seleccione una fila para marcar como AUSENTE.", "Aviso", JOptionPane.WARNING_MESSAGE);
}

    }//GEN-LAST:event_btnAusenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAusente;
    private javax.swing.JButton btnCalificar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

   
   @Override
    public void display(Pruebas obj) {
//        txtId.setText(String.valueOf(obj.getId()));
//        txtFecha1.setText(String.valueOf(obj.getFecha()));
//        txtHora.setText(String.valueOf(obj.getHora()));
//        txtIdCliente.setText(obj.getCustomer());
    
    }

    @Override
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        }
    

    @Override
    public void displayErrorMessage(String message) {
      JOptionPane.showMessageDialog(this, "Error: " + message, "Error", JOptionPane.ERROR_MESSAGE);
   }


    @Override
    public boolean displayConfirmMessage(String message) {
        JOptionPane.showConfirmDialog(this, message, "Confirmación", JOptionPane.YES_NO_OPTION);
        return false;
    }
    
    public void displayClientesYCitas(List<ClienteCita> citasConClientes) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Cita");
    model.addColumn("Fecha Cita");
    model.addColumn("Hora");
    model.addColumn("Cedula ");
    model.addColumn("Nombre");
    model.addColumn("IdPrueba");
    model.addColumn("Nota");
    model.addColumn("Observaciones");
    model.addColumn("Estado");

    for (ClienteCita citaClienteInfo : citasConClientes) {
        Object[] row = {
            citaClienteInfo.getIdCita(),
            citaClienteInfo.getFechaCita(),
            citaClienteInfo.getHora(),
            citaClienteInfo.getIdClienteFK(),
            citaClienteInfo.getNombreCliente(),
            citaClienteInfo.getIdPrueba(),
            citaClienteInfo.getNota(),
            citaClienteInfo.getObservaciones(),
            citaClienteInfo.getEstado(),
        };
        model.addRow(row);
    }

    tabla.setModel(model);
}


   public void clear() {
//        txtFecha1.setText("");
//        txtHora.setText("");
//        txtIdCliente.setText("");
    }
}