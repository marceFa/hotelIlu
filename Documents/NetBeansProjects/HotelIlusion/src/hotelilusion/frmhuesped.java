/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelilusion.vistas;

import hotelilusion.modelo.Conexion;
import hotelilusion.modelo.Huesped;
import hotelilusion.modelo.HuespedData;
import static java.nio.file.Files.delete;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static org.eclipse.persistence.tools.file.FileUtil.delete;

/**
 *
 * @author agus
 */
public class frmhuesped extends javax.swing.JInternalFrame {
    
    private Conexion con;
    private HuespedData huespedData;
    DefaultTableModel model=new DefaultTableModel();

    /**
     * Creates new form frmhuesped
     */
    public frmhuesped() {
        initComponents();
        String url = "jdbc:mysql://localhost/hotelilusion";
        String usuario = "root";
        String password = "";
        try {
            con=new Conexion(url,usuario,password);
            huespedData=new HuespedData(con);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmhuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addColumn("Id");
        model.addColumn("NombreyApellido");
        model.addColumn("NumeroDocumento");
        model.addColumn("Direccion");
        model.addColumn("NumerodeTelefono");
        model.addColumn("E-mail");
        this.tabladatos.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelid = new javax.swing.JLabel();
        jLabelnombreape = new javax.swing.JLabel();
        jLabeldni = new javax.swing.JLabel();
        jLabeldireccion = new javax.swing.JLabel();
        jLabeltelefono = new javax.swing.JLabel();
        jLabelmail = new javax.swing.JLabel();
        txtnombreapellido = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtdire = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        txbuscar = new javax.swing.JTextField();
        btnlimpiar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Huésped", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tempus Sans ITC", 1, 18), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabelid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabelid.setText("Id");
        jLabelid.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));

        jLabelnombreape.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabelnombreape.setText("Nombre y Apellido");
        jLabelnombreape.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));

        jLabeldni.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabeldni.setText("Número Documento");
        jLabeldni.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));

        jLabeldireccion.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabeldireccion.setText("Dirección");
        jLabeldireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));

        jLabeltelefono.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabeltelefono.setText("Número de Teléfono");
        jLabeltelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));

        jLabelmail.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabelmail.setText("E-mail");
        jLabelmail.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));

        txtnombreapellido.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N

        txtdni.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N

        txtdire.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N

        txttel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N

        txtcorreo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N

        txtid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        btnagregar.setBackground(new java.awt.Color(0, 0, 255));
        btnagregar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnagregar.setForeground(new java.awt.Color(255, 255, 255));
        btnagregar.setText("Agregar");
        btnagregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(0, 0, 255));
        btnnuevo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setText("Nuevo");
        btnnuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnborrar.setBackground(new java.awt.Color(0, 0, 255));
        btnborrar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnborrar.setForeground(new java.awt.Color(255, 255, 255));
        btnborrar.setText("Borrar");
        btnborrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(0, 0, 255));
        btneditar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setText("Editar");
        btneditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(0, 0, 255));
        btnsalir.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setText("Salir");
        btnsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tabladatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabladatos.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre y Apellido", "Número Documento", "Dirección", "Teléfono", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(tabladatos);

        btnbuscar.setBackground(new java.awt.Color(0, 0, 255));
        btnbuscar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        txbuscar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        txbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbuscarActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(0, 0, 255));
        btnlimpiar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 204), null, null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelnombreape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabeldni, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addComponent(jLabeldireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabeltelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelmail, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txttel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdire, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdni, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombreapellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnborrar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(btneditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelid)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar)
                    .addComponent(btnnuevo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnombreape)
                    .addComponent(txtnombreapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnborrar)
                            .addComponent(btneditar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeldni)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeldireccion)
                            .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbuscar)
                            .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeltelefono)
                            .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir)
                            .addComponent(btnlimpiar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelmail)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        
        String [] agregar=new String[6];
        agregar [0]=txtid.getText();
        agregar [1]=txtnombreapellido.getText();
        agregar [2]=txtdni.getText();
        agregar [3]=txtdire.getText();
        agregar [4]=txttel.getText();
        agregar [5]=txtcorreo.getText();
        model.addRow(agregar);
        
        String nombre=txtnombreapellido.getText();
        long dni=Long.parseLong(txtdni.getText());
        String direccion=txtdire.getText();
        long telefono=Long.parseLong(txttel.getText());
        String email=txtcorreo.getText();
        Huesped huesped=new Huesped(nombre, dni, direccion, telefono, email);
        huespedData.guardarHuesped(huesped);
        
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
        // TODO add your handling code here:
        
        
        long dni= Long.parseLong(txtdni.getText());
        huespedData.borrarHuesped(dni);
        
        int elitotal=tabladatos.getRowCount();
        for (int i=elitotal-1; i>=0; i--) {
            model.removeRow(i);
        }
        
    }//GEN-LAST:event_btnborrarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        
        txtid.setText("");
        txtnombreapellido.setText("");
        txtdni.setText(""); 
        txtdire.setText("");
        txttel.setText("");
        txtcorreo.setText("");
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        if (txtid.getText()!=null) {
            String nombre_apellido = txtnombreapellido.getText();
            long numero_documento = Long.parseLong(txtdni.getText());
            String direccion = txtdire.getText();
            int telefono = Integer.parseInt(txttel.getText());
            String email = txtcorreo.getText();
            
            Huesped huesped = new Huesped(nombre_apellido, numero_documento, direccion, telefono, email);
       huespedData.actualizarHuesped(huesped);
            
        }
        
        
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        int id_huesped = Integer.parseInt(txtid.getText());
        huespedData.buscarHuesped(id_huesped);
        Huesped huesped = huespedData.buscarHuesped(id_huesped);
        
        if (null!= huesped) {
            txtid.setText(huesped.getId_huesped()+ "");
            txtnombreapellido.setText(huesped.getNombre_apellido()+ "");
            txtdni.setText(huesped.getNumero_documento()+ "");
            txtdire.setText(huesped.getDireccion()+ "");
            txttel.setText(huesped.getTelefono()+ "");
            txtcorreo.setText(huesped.getEmail()+ "");
        
    }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbuscarActionPerformed
        // TODO add your handling code here:
        txbuscar.transferFocus();
    }//GEN-LAST:event_txbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmhuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmhuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmhuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmhuesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmhuesped().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabeldireccion;
    private javax.swing.JLabel jLabeldni;
    private javax.swing.JLabel jLabelid;
    private javax.swing.JLabel jLabelmail;
    private javax.swing.JLabel jLabelnombreape;
    private javax.swing.JLabel jLabeltelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdire;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombreapellido;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables

   
    


}