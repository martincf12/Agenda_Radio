package Ventanas;

import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import Clases.CellRenderer;
import Clases.Persona;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Principal extends javax.swing.JFrame {
    
    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir")+barra+"Funcionarios"+barra; 
    DefaultTableModel model;
    int Seleccion,Seleccion_eliminar;
    boolean Sel_verda = false;
    
    public Principal() {
        initComponents();       
        MostrarFuncionarios();
    }
    
    public void setCellRender(JTable table) {
    Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    
    private void Editar()
    {
        try
        {
            try (FileWriter permite_escrito = new FileWriter(ubicacion+nya_edit.getText()+".txt")) 
            {
                String Nomb = "NombreyAp=";
                String Profe = "Profesion=";
                String Tel = "Haber=";
                PrintWriter guardar = new PrintWriter(permite_escrito);
                guardar.println(Nomb+nya_edit.getText());
                guardar.println(Profe+prof_edit.getText());
                guardar.println(Tel+num_edit.getText());
            }
            JOptionPane.showMessageDialog(null, "Editado con éxito.");
        } 
        catch (IOException e) 
        {
        }  
    }
    
    private void MostrarFuncionarios()
    {
        File contenedor = new File(ubicacion);
        File[] registros = contenedor.listFiles();
        String data[][]={};
        String col[] = {"Nombre y Apellido","Profesión","Teléfono"};
        model = new DefaultTableModel(data,col);
        Tabla_Funcionarios.setModel(model);
        setCellRender(Tabla_Funcionarios);
        
        for (File registro : registros) 
        {
            File url = new File(ubicacion + registro.getName());
            try
            {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                String filas [] = {mostrar.getProperty("NombreyAp"),mostrar.getProperty("Profesion")
                        ,mostrar.getProperty("Telefono")};
                model.addRow(filas);
            }
            catch(IOException e)
            {                
            }
        }     
    }
    
    private void Eliminar()
    {
        String btns [] ={"Si","Cancelar"};
        File url = new File(ubicacion+barra+Tabla_Funcionarios.getValueAt(Seleccion, 0)+".txt");
        try {
            FileInputStream cerrar = new FileInputStream(url);
            cerrar.close();
            System.gc();
            
            int seguro = JOptionPane.showOptionDialog(rootPane, "Esta seguro de eliminar a "+Tabla_Funcionarios.getValueAt(Seleccion_eliminar, 0)+"?", "Eliminacion", 0, 0, null, btns, null);
            
            if (seguro == JOptionPane.YES_OPTION)
            {
                url.delete();
                JOptionPane.showMessageDialog(rootPane, "Eliminado.");
            }        
        } catch (HeadlessException | IOException e) 
        {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pestania_Principal = new javax.swing.JTabbedPane();
        TablaMuestra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Funcionarios = new javax.swing.JTable();
        FiltroBusqueda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Boton_editar = new javax.swing.JButton();
        Boton_elimi = new javax.swing.JButton();
        Boton_agregar = new javax.swing.JButton();
        FiltrodeBusqueda_n_o_p = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Pesta_Edi = new javax.swing.JPanel();
        Panel_A_y_E = new javax.swing.JPanel();
        palabra_editar = new javax.swing.JLabel();
        Palabra_agregar = new javax.swing.JLabel();
        Panel_agregar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nya_agre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        prof_agre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        num_agre = new javax.swing.JTextField();
        Boton_agregar_listo = new javax.swing.JButton();
        Panel_editar = new javax.swing.JPanel();
        prof_edit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nya_edit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        num_edit = new javax.swing.JTextField();
        Boton_editar_listo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Radio");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/IconoDefinitivo.png")).getImage());
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        Pestania_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Pestania_Principal.setEnabled(false);
        Pestania_Principal.setMaximumSize(new java.awt.Dimension(800, 600));
        Pestania_Principal.setMinimumSize(new java.awt.Dimension(800, 600));

        TablaMuestra.setMaximumSize(new java.awt.Dimension(795, 572));
        TablaMuestra.setMinimumSize(new java.awt.Dimension(795, 572));
        TablaMuestra.setRequestFocusEnabled(false);
        TablaMuestra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_Funcionarios.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        Tabla_Funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Funcionarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Funcionarios.getTableHeader().setReorderingAllowed(false);
        Tabla_Funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_FuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Funcionarios);

        TablaMuestra.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 775, 470));

        FiltroBusqueda.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        FiltroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FiltroBusquedaKeyTyped(evt);
            }
        });
        TablaMuestra.add(FiltroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 400, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconito_buscar.png"))); // NOI18N
        TablaMuestra.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        Boton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EditButton.png"))); // NOI18N
        Boton_editar.setBorder(null);
        Boton_editar.setBorderPainted(false);
        Boton_editar.setContentAreaFilled(false);
        Boton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_editarActionPerformed(evt);
            }
        });
        TablaMuestra.add(Boton_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 47, 40, 40));

        Boton_elimi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonelimi.png"))); // NOI18N
        Boton_elimi.setBorder(null);
        Boton_elimi.setBorderPainted(false);
        Boton_elimi.setContentAreaFilled(false);
        Boton_elimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_elimiActionPerformed(evt);
            }
        });
        TablaMuestra.add(Boton_elimi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 47, 40, 40));

        Boton_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_agregar.png"))); // NOI18N
        Boton_agregar.setBorder(null);
        Boton_agregar.setBorderPainted(false);
        Boton_agregar.setContentAreaFilled(false);
        Boton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_agregarActionPerformed(evt);
            }
        });
        TablaMuestra.add(Boton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 47, 40, 40));

        FiltrodeBusqueda_n_o_p.setBackground(new java.awt.Color(204, 255, 204));
        FiltrodeBusqueda_n_o_p.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        FiltrodeBusqueda_n_o_p.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Profesión" }));
        FiltrodeBusqueda_n_o_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TablaMuestra.add(FiltrodeBusqueda_n_o_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel8.setText("Buscar por :");
        TablaMuestra.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 25));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_radio.png"))); // NOI18N
        TablaMuestra.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 290, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        TablaMuestra.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 820, 600));

        Pestania_Principal.addTab("Funcionarios", TablaMuestra);

        Pesta_Edi.setMaximumSize(new java.awt.Dimension(795, 572));
        Pesta_Edi.setMinimumSize(new java.awt.Dimension(795, 572));
        Pesta_Edi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_A_y_E.setBackground(new java.awt.Color(0, 153, 51));
        Panel_A_y_E.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        palabra_editar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 48)); // NOI18N
        palabra_editar.setForeground(new java.awt.Color(255, 255, 255));
        palabra_editar.setText("Editar:");
        Panel_A_y_E.add(palabra_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -5, -1, -1));

        Palabra_agregar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 48)); // NOI18N
        Palabra_agregar.setForeground(new java.awt.Color(255, 255, 255));
        Palabra_agregar.setText("Agregar :");
        Panel_A_y_E.add(Palabra_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -5, -1, -1));

        Pesta_Edi.add(Panel_A_y_E, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 240, 60));

        Panel_agregar.setBackground(new java.awt.Color(0, 153, 51));
        Panel_agregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre y Apellido :");
        Panel_agregar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        nya_agre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Panel_agregar.add(nya_agre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 300, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Profesión :");
        Panel_agregar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        prof_agre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Panel_agregar.add(prof_agre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 300, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Número :");
        Panel_agregar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        num_agre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Panel_agregar.add(num_agre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 300, 30));

        Boton_agregar_listo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mobile.terra.com.png"))); // NOI18N
        Boton_agregar_listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_agregar_listoActionPerformed(evt);
            }
        });
        Panel_agregar.add(Boton_agregar_listo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 90, 30));

        Pesta_Edi.add(Panel_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 630, 200));

        Panel_editar.setBackground(new java.awt.Color(0, 153, 51));
        Panel_editar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prof_edit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Panel_editar.add(prof_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 300, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profesión :");
        Panel_editar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre y Apellido :");
        Panel_editar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        nya_edit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Panel_editar.add(nya_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 300, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número :");
        Panel_editar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        num_edit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Panel_editar.add(num_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 300, 30));

        Boton_editar_listo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mobile.terra.com.png"))); // NOI18N
        Boton_editar_listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_editar_listoActionPerformed(evt);
            }
        });
        Panel_editar.add(Boton_editar_listo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 90, 30));

        Pesta_Edi.add(Panel_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 630, 200));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Pesta_Edi.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo2.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        Pesta_Edi.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 580));

        Pestania_Principal.addTab("Agregar / Editar", Pesta_Edi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestania_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestania_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_agregarActionPerformed
        Pestania_Principal.setSelectedComponent(Pesta_Edi);     
        Panel_agregar.setVisible(true);
        Palabra_agregar.setVisible(true);
        Panel_editar.setVisible(false);
        palabra_editar.setVisible(false);
    }//GEN-LAST:event_Boton_agregarActionPerformed

    private void Boton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_editarActionPerformed
        if (Sel_verda != false)
        {
            Pestania_Principal.setSelectedComponent(Pesta_Edi);
            nya_edit.requestFocus();
            Panel_agregar.setVisible(false);           
            Palabra_agregar.setVisible(false);
            Panel_editar.setVisible(true);
            palabra_editar.setVisible(true);
        }else
        {
            JOptionPane.showMessageDialog(null, "Elegi primero que vas a editar!");
        }
    }//GEN-LAST:event_Boton_editarActionPerformed

    private void Tabla_FuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_FuncionariosMouseClicked
        Seleccion = Tabla_Funcionarios.getSelectedRow();
        Seleccion_eliminar = Tabla_Funcionarios.getSelectedRow();
        Sel_verda = true;
        nya_edit.setText((String) Tabla_Funcionarios.getValueAt(Seleccion, 0));
        prof_edit.setText((String) Tabla_Funcionarios.getValueAt(Seleccion, 1));
        num_edit.setText((String) Tabla_Funcionarios.getValueAt(Seleccion, 2));
    }//GEN-LAST:event_Tabla_FuncionariosMouseClicked
    TableRowSorter ts;
    private void FiltroBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiltroBusquedaKeyTyped
        FiltroBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
               if (FiltrodeBusqueda_n_o_p.getSelectedItem() == "Nombre")
               { 
                ts.setRowFilter(RowFilter.regexFilter("(?i)"+FiltroBusqueda.getText(),0));
               }else
               {
                ts.setRowFilter(RowFilter.regexFilter("(?i)"+FiltroBusqueda.getText(),1));
               }               
            }        
        });      
        ts = new TableRowSorter(model);
        Tabla_Funcionarios.setRowSorter(ts);
    }//GEN-LAST:event_FiltroBusquedaKeyTyped

    private void Boton_elimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_elimiActionPerformed
        if (Sel_verda != false)
        {
            Eliminar(); 
            Principal Nueva = new Principal();
            Nueva.setLocationRelativeTo(null);
            Nueva.setVisible(true);
            this.dispose();
            Sel_verda = false;
        }else
        {
            JOptionPane.showMessageDialog(null, "Elegi primero que vas a eliminar!");
        }
    }//GEN-LAST:event_Boton_elimiActionPerformed

    private void Boton_editar_listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_editar_listoActionPerformed
        if (Sel_verda)
        {
            Editar();
            Sel_verda = false;
        }
    }//GEN-LAST:event_Boton_editar_listoActionPerformed

    private void Boton_agregar_listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_agregar_listoActionPerformed
        if (!"".equals(nya_agre.getText()))
        {
            Persona nueva = new Persona(nya_agre.getText(),prof_agre.getText(),num_agre.getText());
            nueva.Guardar();
            nya_agre.setText("");prof_agre.setText("");num_agre.setText("");   
        }else
        {
            JOptionPane.showMessageDialog(null, "Agrega un Nombre y Apellido");
        }
    }//GEN-LAST:event_Boton_agregar_listoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal Nueva = new Principal();           
        Nueva.setLocationRelativeTo(null);
        Nueva.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_agregar;
    private javax.swing.JButton Boton_agregar_listo;
    private javax.swing.JButton Boton_editar;
    private javax.swing.JButton Boton_editar_listo;
    private javax.swing.JButton Boton_elimi;
    private javax.swing.JTextField FiltroBusqueda;
    private javax.swing.JComboBox<String> FiltrodeBusqueda_n_o_p;
    private javax.swing.JLabel Palabra_agregar;
    private javax.swing.JPanel Panel_A_y_E;
    private javax.swing.JPanel Panel_agregar;
    private javax.swing.JPanel Panel_editar;
    private javax.swing.JPanel Pesta_Edi;
    private javax.swing.JTabbedPane Pestania_Principal;
    private javax.swing.JPanel TablaMuestra;
    private javax.swing.JTable Tabla_Funcionarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField num_agre;
    private javax.swing.JTextField num_edit;
    private javax.swing.JTextField nya_agre;
    private javax.swing.JTextField nya_edit;
    private javax.swing.JLabel palabra_editar;
    private javax.swing.JTextField prof_agre;
    private javax.swing.JTextField prof_edit;
    // End of variables declaration//GEN-END:variables
}
