/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareas.gui;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tareas.dominio.Tarea;
import tareas.excepciones.TareaException;
import tareas.servicios.GestionTareas;

/**
 *
 * @author user
 */
public class MainFrame extends javax.swing.JFrame {

    JTable tablaTodo = new JTable();
    JTable tablaInProgress = new JTable();
    JTable tablaDone = new JTable();
    List<Tarea> tareasTodo, tareasInProgress, tareasDone;

    public MainFrame() {
        prepararTheme();
        initComponents();

        //Mis inicializaciones
        inicializarBD();
        //inicializamos leyendo de bd
        inicializarTablas();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTodoInProgress = new javax.swing.JButton();
        btnInProgressTodo = new javax.swing.JButton();
        btnDoneInProgress = new javax.swing.JButton();
        btnInProgressDone = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnCrearTarea = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trello fake");
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Tareas");

        btnTodoInProgress.setText("▶");
        btnTodoInProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodoInProgressActionPerformed(evt);
            }
        });

        btnInProgressTodo.setText("◀");
        btnInProgressTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInProgressTodoActionPerformed(evt);
            }
        });

        btnDoneInProgress.setText("◀");
        btnDoneInProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneInProgressActionPerformed(evt);
            }
        });

        btnInProgressDone.setText("▶");
        btnInProgressDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInProgressDoneActionPerformed(evt);
            }
        });

        btnCrearTarea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearTarea.setForeground(new java.awt.Color(153, 255, 153));
        btnCrearTarea.setText("Crear tarea");
        btnCrearTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTareaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DONE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("TO DO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("IN PROGRESS");

        jButton1.setText("🗘");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 153, 153));
        jButton2.setText("Eliminar tarea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTodoInProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInProgressTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInProgressDone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDoneInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnCrearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btnTodoInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnInProgressTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnInProgressDone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnDoneInProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 167, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearTarea))
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodoInProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodoInProgressActionPerformed
        if (tablaTodo.getSelectedRow() == -1) {
            return;
        }
        //Llevar tarea de TODO a IN PROGRESS
        int index = tablaTodo.getSelectedRow();
        Tarea tarea = tareasTodo.get(index);
        GestionTareas gt = new GestionTareas();
        try {
            //cogemos el index para saber el id de esa tarea 

            gt.modificarTarea(tarea.getIdTarea(), Tarea.IN_PROGRESS);
            //quitamos del array todo y metemos en progress
            tareasTodo.remove(index);
            tareasInProgress.add(tarea);
            //refrescamos desde ram, sin necesidad de leer de bd
            refreshTablas();

        } catch (TareaException | SQLException e) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
        }


    }//GEN-LAST:event_btnTodoInProgressActionPerformed

    private void btnInProgressTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInProgressTodoActionPerformed
        if (tablaInProgress.getSelectedRow() == -1) {
            return;
        }
        //Llevar tarea de IN PTOGRESS a TODO
        int index = tablaInProgress.getSelectedRow();
        Tarea tarea = tareasInProgress.get(index);
        GestionTareas gt = new GestionTareas();
        try {
            //cogemos el index para saber el id de esa tarea 
            gt.modificarTarea(tarea.getIdTarea(), Tarea.TODO);
            //quitamos del array todo y metemos en progress
            tareasInProgress.remove(index);
            tareasTodo.add(tarea);
            //refrescamos desde ram, sin necesidad de leer de bd
            refreshTablas();

        } catch (TareaException | SQLException e) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_btnInProgressTodoActionPerformed

    private void btnInProgressDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInProgressDoneActionPerformed
        if (tablaInProgress.getSelectedRow() == -1) {
            return;
        }
        //Llevar tarea de IN PROGRESS A DONE
        int index = tablaInProgress.getSelectedRow();
        Tarea tarea = tareasInProgress.get(index);
        GestionTareas gt = new GestionTareas();
        try {
            //cogemos el index para saber el id de esa tarea 
            gt.modificarTarea(tarea.getIdTarea(), Tarea.DONE);
            //quitamos del array todo y metemos en progress
            tareasInProgress.remove(index);
            tareasDone.add(tarea);
            //refrescamos desde ram, sin necesidad de leer de bd
            refreshTablas();

        } catch (TareaException | SQLException e) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnInProgressDoneActionPerformed

    private void btnDoneInProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneInProgressActionPerformed
        if (tablaDone.getSelectedRow() == -1) {
            return;
        }
        //Llevar tarea de DONE a IN PROGRESS
        int index = tablaDone.getSelectedRow();
        Tarea tarea = tareasDone.get(index);
        GestionTareas gt = new GestionTareas();
        try {
            //cogemos el index para saber el id de esa tarea 

            gt.modificarTarea(tarea.getIdTarea(), Tarea.IN_PROGRESS);
            //quitamos del array todo y metemos en progress
            tareasDone.remove(index);
            tareasInProgress.add(tarea);
            //refrescamos desde ram, sin necesidad de leer de bd
            refreshTablas();

        } catch (TareaException | SQLException e) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnDoneInProgressActionPerformed

    private void btnCrearTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTareaActionPerformed
        String input =  JOptionPane.showInputDialog(this, "Descripción: ");
        if (input != null) {
            crearTarea(input);
            inicializarTablas();
        }
    }//GEN-LAST:event_btnCrearTareaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inicializarTablas();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private static Connection inicializarBD() {
        try {
            System.out.println("Intentando cargar driver......");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargo OK el driver");

            //conectarnos con la bd coffeeshop -> click derecho properties en la conexion
            String url = "jdbc:derby://localhost:1527/Bank";
            //usuariio y clave no tiene
            System.out.println("conectando con la bd.......");

            Connection con = DriverManager.getConnection(url);

            System.out.println("OK conexion");
            return con;

        } catch (SQLException e) {

            System.out.println("Error conexion con bd " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {

            System.out.println("Error carga Driver: " + e.getMessage());
            return null;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearTarea;
    private javax.swing.JButton btnDoneInProgress;
    private javax.swing.JButton btnInProgressDone;
    private javax.swing.JButton btnInProgressTodo;
    private javax.swing.JButton btnTodoInProgress;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void inicializarTablas() {

        GestionTareas gt = new GestionTareas();
        try {
            //cargamos las 3 tablas con el modelo y las metemos en su scrollpane
            tareasTodo = gt.getTareasPorEstado(Tarea.TODO);
            tareasInProgress = gt.getTareasPorEstado(Tarea.IN_PROGRESS);
            tareasDone = gt.getTareasPorEstado(Tarea.DONE);
            //lo separo para que solo lea de bd para cargar la tabla la primera vez
            refreshTablas();

        } catch (TareaException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refreshTablas() {
        //refrescar las tablas sin leer en bd
        TareaModel model1 = new TareaModel(tareasTodo);
        TareaModel model2 = new TareaModel(tareasInProgress);
        TareaModel model3 = new TareaModel(tareasDone);
        tablaTodo.setModel(model1);
        tablaInProgress.setModel(model2);
        tablaDone.setModel(model3);
        jScrollPane1.setViewportView(tablaTodo);
        jScrollPane2.setViewportView(tablaInProgress);
        jScrollPane3.setViewportView(tablaDone);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    private void prepararTheme() {
        try {    
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.this);    
        this.pack();
    }

    private void crearTarea(String descripcion) {
         
        GestionTareas gt = new GestionTareas();      
        
        if (descripcion.length() > 30) {
            JOptionPane.showMessageDialog(this,
                                    "ATENCIÓN",
                                    "Has excedido el límite de caracteres (30)",
                                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            gt.insertarTarea(descripcion);
            JOptionPane.showMessageDialog(this, "Tarea creada");
        } catch (Exception e) {
            
            System.out.println("Error " + e.getMessage());
        }
        
        
        
    }
}