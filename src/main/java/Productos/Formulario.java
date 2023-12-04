/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Productos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Formulario extends javax.swing.JFrame {

    String jdbcUrl = "jdbc:mysql://localhost:3306/formulario";
    String username = "root";
    String password = "";

    DefaultTableModel modelo = new DefaultTableModel();

    ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

    public Formulario() {

        initComponents();
        this.setTitle("Formulario");

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CIUDAD");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("EPS");
        modelo.addColumn("OCUPACION");
        modelo.addColumn("SUELDO");
        modelo.addColumn("ESTADO");

        refrescartabla();
        consultar();
    }

    public void consultar() {

        listaEmpleados = new ArrayList<>();
        modelo.setNumRows(0);
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String selectQuery = "SELECT * FROM empleados";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Empleado empleado = new Empleado();

                empleado.setDocumento("" + resultSet.getInt("documento"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setApellido(resultSet.getString("apellido"));
                empleado.setEps(resultSet.getString("eps"));
                empleado.setDireccion(resultSet.getString("direccion"));
                empleado.setCiudad(resultSet.getString("ciudad"));
                empleado.setOcupacion(resultSet.getString("ocupacion"));
                empleado.setSueldo(resultSet.getString("sueldo"));

                listaEmpleados.add(empleado);

                String[] item = {
                    empleado.getDocumento(),
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getCiudad(),
                    empleado.getDireccion(),
                    empleado.getEps(),
                    empleado.getOcupacion(),
                    empleado.getSueldo(),
                    "1"
                };

                modelo.addRow(item);

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tbEmpleados.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Apellido = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        Productos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Panel2 = new javax.swing.JPanel();
        Nombre = new javax.swing.JLabel();
        edtNombre = new javax.swing.JTextField();
        edtApellido = new javax.swing.JTextField();
        Documento = new javax.swing.JLabel();
        edtDocumento = new javax.swing.JTextField();
        ddlTd = new javax.swing.JComboBox<>();
        ciudad = new javax.swing.JLabel();
        ddlCiudad = new javax.swing.JComboBox<>();
        Eps = new javax.swing.JLabel();
        Direccion = new javax.swing.JLabel();
        edtDireccion = new javax.swing.JTextField();
        ddlEps = new javax.swing.JComboBox<>();
        Ocupacion = new javax.swing.JLabel();
        edtOcupacion = new javax.swing.JTextField();
        Sueldo = new javax.swing.JLabel();
        edtSueldo = new javax.swing.JTextField();
        Estado = new javax.swing.JLabel();
        estado = new javax.swing.JCheckBox();
        apellidos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Salir = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        Apellido.setText("Apellido");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel1.setBackground(new java.awt.Color(0, 102, 153));

        Productos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Productos.setForeground(new java.awt.Color(255, 255, 255));
        Productos.setText("DATOS PERSONAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Productos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Productos)
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Panel2.setBackground(new java.awt.Color(204, 204, 204));
        Panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        Nombre.setText("Nombre");

        edtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNombreActionPerformed(evt);
            }
        });

        Documento.setText("Documento");

        ddlTd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "....", "TI", "CC" }));

        ciudad.setText("Ciudad");

        ddlCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "....", "Cali", "Bogota", "Medellin", "Barranquilla" }));

        Eps.setText("Eps");

        Direccion.setText("Direccion");

        ddlEps.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "....", "Coomeva", "Compensar", "Sanitas", "Famisanar", "Nueva eps" }));

        Ocupacion.setText("Ocupacion");

        Sueldo.setText("Sueldo");

        Estado.setText("Estado");

        estado.setText("Activo");

        apellidos.setText("Apellido");

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ciudad)
                    .addComponent(Direccion)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addComponent(apellidos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addComponent(Nombre)
                                        .addGap(41, 41, 41)
                                        .addComponent(edtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(87, 87, 87)
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ocupacion)
                                    .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Estado)
                                        .addComponent(Sueldo))))
                            .addGroup(Panel2Layout.createSequentialGroup()
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Documento)
                                    .addComponent(Eps))
                                .addGap(20, 20, 20)
                                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ddlEps, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ddlCiudad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(Panel2Layout.createSequentialGroup()
                                        .addComponent(ddlTd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(edtDireccion))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estado)))))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(edtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ocupacion)
                    .addComponent(edtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sueldo)
                    .addComponent(edtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Documento)
                    .addComponent(edtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlTd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Estado)
                    .addComponent(estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ciudad)
                    .addComponent(ddlCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(edtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eps)))
        );

        Salir.setText("Salir");

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbEmpleados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(Guardar)
                        .addGap(18, 18, 18)
                        .addComponent(Salir)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(Guardar)
                    .addComponent(Salir))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Panel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int row = tbEmpleados.getSelectedRow();

        Empleado e = listaEmpleados.get(row);

        int input = JOptionPane.showConfirmDialog(null, "Seguro quiere eliminar el empleado " + e.getDocumento());

        System.out.println("input " + input);

        if (input == 0) {

            eliminar(e.getDocumento());

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private boolean existeEmpleado(String documento) {

        boolean existe = false;

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String selectQuery = "SELECT * FROM empleados where documento = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setInt(1, Integer.parseInt(documento));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                existe = true;
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        Empleado empleado = new Empleado();

        empleado.setNombre(edtNombre.getText());
        empleado.setApellido(edtApellido.getText());
        empleado.setDocumento(edtDocumento.getText());
        empleado.setTipoDoc(ddlTd.getSelectedItem().toString());
        empleado.setDireccion(edtDireccion.getText());
        empleado.setEps(ddlEps.getSelectedItem().toString());
        empleado.setCiudad(ddlCiudad.getSelectedItem().toString());
        empleado.setOcupacion(edtOcupacion.getText());
        empleado.setSueldo(edtSueldo.getText());

        if (existeEmpleado(empleado.getDocumento())) {

            actualizarEmpleado(empleado);

            return;
        }

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "INSERT INTO empleados"
                    + " (documento,"
                    + " nombre,"
                    + " apellido,"
                    + " ciudad,"
                    + " direccion,"
                    + " eps,"
                    + " ocupacion,"
                    + " sueldo)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, Integer.parseInt(empleado.getDocumento()));
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getApellido());
            preparedStatement.setString(4, empleado.getCiudad());
            preparedStatement.setString(5, empleado.getDireccion());
            preparedStatement.setString(6, empleado.getEps());
            preparedStatement.setString(7, empleado.getOcupacion());
            preparedStatement.setString(8, empleado.getSueldo());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        edtNombre.setText("");
        edtApellido.setText("");
        edtDocumento.setText("");

        edtDireccion.setText("");
        edtOcupacion.setText("");
        edtSueldo.setText("");

        consultar();

    }//GEN-LAST:event_GuardarActionPerformed

    private void edtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNombreActionPerformed

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked

        try {

            int row = tbEmpleados.rowAtPoint(evt.getPoint());

            Empleado e = listaEmpleados.get(row);

            edtNombre.setText(e.getNombre());
            edtApellido.setText(e.getApellido());
            edtDocumento.setText(e.getDocumento());

            edtDireccion.setText(e.getDireccion());
            edtOcupacion.setText(e.getOcupacion());
            edtSueldo.setText(e.getSueldo());

        } catch (Exception err) {

            err.printStackTrace();

        }


    }//GEN-LAST:event_tbEmpleadosMouseClicked
    public void refrescartabla() {
        /*    while(modelo.getRowCoun()>0){
        modelo.removeRow(0);
       
    }
    for (Formulario formulario : listaformulario) {
        object a[]=new object[7];
        
    }
    tblFormulario.setModel(modelo);
         */
    }

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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Direccion;
    private javax.swing.JLabel Documento;
    private javax.swing.JLabel Eps;
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Ocupacion;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JLabel Productos;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Sueldo;
    private javax.swing.JLabel apellidos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel ciudad;
    private javax.swing.JComboBox<String> ddlCiudad;
    private javax.swing.JComboBox<String> ddlEps;
    private javax.swing.JComboBox<String> ddlTd;
    private javax.swing.JTextField edtApellido;
    private javax.swing.JTextField edtDireccion;
    private javax.swing.JTextField edtDocumento;
    private javax.swing.JTextField edtNombre;
    private javax.swing.JTextField edtOcupacion;
    private javax.swing.JTextField edtSueldo;
    private javax.swing.JCheckBox estado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbEmpleados;
    // End of variables declaration//GEN-END:variables

    private void eliminar(String documento) {

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String deleteQuery = "DELETE FROM empleados WHERE documento = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, Integer.parseInt(documento));

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        edtNombre.setText("");
        edtApellido.setText("");
        edtDocumento.setText("");

        edtDireccion.setText("");
        edtOcupacion.setText("");
        edtSueldo.setText("");

        consultar();

    }

    private void actualizarEmpleado(Empleado empleado) {

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "UPDATE empleados SET "
                    + " nombre = ?,"
                    + " apellido = ?,"
                    + " ciudad = ?,"
                    + " direccion = ?,"
                    + " eps = ?,"
                    + " ocupacion = ?,"
                    + " sueldo = ? "
                    + " WHERE documento = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getApellido());
            preparedStatement.setString(3, empleado.getCiudad());
            preparedStatement.setString(4, empleado.getDireccion());
            preparedStatement.setString(5, empleado.getEps());
            preparedStatement.setString(6, empleado.getOcupacion());
            preparedStatement.setString(7, empleado.getSueldo());
            preparedStatement.setInt(8, Integer.parseInt(empleado.getDocumento()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        edtNombre.setText("");
        edtApellido.setText("");
        edtDocumento.setText("");

        edtDireccion.setText("");
        edtOcupacion.setText("");
        edtSueldo.setText("");

        consultar();

    }
}
