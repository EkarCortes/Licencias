/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.Interface;

import Controller.Oficial.OficialController;
import Dao.Dao;
import Dao.Oficial.DaoBDOficial;
import Model.Oficial.Oficial;
import PersonaDTO.DtoOficial;
import View.Table;
import View.View;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wendy
 */
public class FrmOficial extends javax.swing.JInternalFrame implements View<Oficial> {
    Dao<DtoOficial> oficialDao = new DaoBDOficial();
    OficialController oficialController = new OficialController(this, oficialDao);

    public FrmOficial() {
        initComponents();
        oficialController.readAll();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        txtCorreo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JFormattedTextField();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();

        jLabel13.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel13.setText("Salario:");

        jLabel11.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel11.setText("Correo");

        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\wendy\\Downloads\\addthelist_añadir_3477.png")); // NOI18N
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel14.setText("Actualizar oficial:");

        jLabel5.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jLabel5.setText("Datos del Oficial:");

        jLabel15.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel15.setText("Eliminar Oficial:");

        jLabel8.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel8.setText("Nombre");

        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel6.setText("Registro de oficiales");

        txtFechaNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtFechaNacimiento.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel7.setText("Identificacion");

        jLabel9.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel9.setText("Fecha De Nacimiento");

        jLabel10.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel10.setText("Telefono");

        jLabel12.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel12.setText("Añadir Oficial:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Salario", "Cedula", "Nombre", "Fecha Nacimiento", "Edad", "Telefono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel8))
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(76, 76, 76)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(238, 238, 238)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(78, 78, 78)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)))
                    .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(209, 209, 209)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6)
                    .addGap(0, 244, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificacion)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(455, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            Object cedulaObj = tabla.getValueAt(row, 1);
            String cedula = cedulaObj.toString();
            Oficial oficial = oficialController.read(cedula);
            if (oficial != null) {
                int confirmacion = JOptionPane.showConfirmDialog(
                        this,
                        "¿Estás seguro de eliminar al oficial con cédula " + cedula + "?",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    boolean success = oficialController.delete(oficial);
                    if (success) {
                        this.displayMessage("Oficial eliminado correctamente.");
                    } else {
                        this.displayErrorMessage("Error al eliminar el oficial. Por favor, inténtalo de nuevo.");
                    }
                }
            } else {
                displayErrorMessage("Oficial no encontrado.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        try {
            Oficial nuevoOficial = new Oficial(
                    Double.parseDouble(txtSalario.getText()),
                    txtIdentificacion.getText(),
                    txtNombre.getText(),
                    new java.sql.Date(((Date) txtFechaNacimiento.getValue()).getTime()),
                    txtTelefono.getText(),
                    txtCorreo.getText()
            );
            boolean success = oficialController.create(nuevoOficial);
            clear();
            if (success) {
                this.displayMessage("Oficial agregado correctamente.");
            } else {
                this.displayErrorMessage("Error al agregar el oficial. Por favor, inténtalo de nuevo.");
            }
        } catch (NumberFormatException ex) {
            this.displayErrorMessage("Error en el formato del salario. Por favor, verifica e inténtalo de nuevo.");
        } catch (Exception e) {
            e.printStackTrace();
            this.displayErrorMessage("Error al agregar el oficial. Por favor, inténtalo de nuevo.");
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            Object cedulaObj = tabla.getValueAt(row, 1);
            String cedula = cedulaObj.toString();
            Oficial oficial = oficialController.read(cedula);
            if (oficial != null) {
                display(oficial);
            } else {
                displayErrorMessage("Oficial no encontrado.");
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        Table.filter(this.tabla, txtFiltro.getText());
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
          try {
        Oficial oficialActualizado = new Oficial(
            Double.parseDouble(txtSalario.getText()),
            txtIdentificacion.getText(),
            txtNombre.getText(),
            new java.sql.Date(((Date) txtFechaNacimiento.getValue()).getTime()),
            txtTelefono.getText(),
            txtCorreo.getText()
        );
        
        boolean success = oficialController.update(oficialActualizado);
        if (success) {
            this.displayMessage("Oficial actualizado correctamente.");
            clear(); // Limpiar campos después de la actualización
        } else {
            this.displayErrorMessage("Error al actualizar el oficial. Por favor, inténtalo de nuevo.");
        }
    } catch (NumberFormatException ex) {
        this.displayErrorMessage("Error en el formato del salario. Por favor, verifica e inténtalo de nuevo.");
    } catch (Exception e) {
        e.printStackTrace();
        this.displayErrorMessage("Error al actualizar el oficial. Por favor, inténtalo de nuevo.");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JFormattedTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFiltro;
    public static javax.swing.JTextField txtIdentificacion;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtSalario;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(Oficial obj) {
        if (obj != null) {
            txtSalario.setText(String.valueOf(obj.getSalario()));
            txtNombre.setText(obj.getNombre());
            txtIdentificacion.setText(obj.getCedula());
            txtFechaNacimiento.setText(String.valueOf(obj.getFechaNacimiento()));
            txtTelefono.setText(obj.getTelefono());
            txtCorreo.setText(obj.getCorreo());
        } else {
            displayErrorMessage("No se encontró el oficial");
        }
    }

    @Override
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Sucessful", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public boolean displayConfirmMessage(String message) {
        int option = JOptionPane.showConfirmDialog(this, message, "Confirmación", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }
    
   public void clear() {
        txtNombre.setText("");
        txtIdentificacion.setText("");
        txtFechaNacimiento.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtSalario.setText("");
    }
   
   public void displayAll(List<Oficial> list) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            System.out.println("Actualizando tabla con " + list.size() + " oficiales");
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0); 
            for (Oficial oficial : list) {
                int edad = oficial.getEdad();
                Object[] row = {
                    oficial.getSalario(),
                    oficial.getCedula(),
                    oficial.getNombre(),
                    oficial.getFechaNacimiento(),
                    edad,
                    oficial.getTelefono(),
                    oficial.getCorreo()
                };

                model.addRow(row);
            }
        }
    });

        }

    }
