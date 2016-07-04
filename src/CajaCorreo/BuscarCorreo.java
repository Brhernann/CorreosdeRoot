package CajaCorreo;

import CajaAlumno.*;
import CajaPrincipal.Sistema;
import Modelos.Alumno;
import Modelos.Correo;
import Root.ConexionAlumno;
import Root.ConexionCorreo;
import java.util.ArrayList;
import javafx.geometry.Side;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarCorreo extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo;
    ModificarCorreo Mc;

    public BuscarCorreo() {
        initComponents();
        comborut.addItem("Seleccione rut del alumno");
        BuscarA();
    }

    public void Clear() {
        for (int i = 0; i < tablaEmail.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void llenar() {
        
               if (comborut.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(rootPane, "Seleccione un Item!");
        } else {

            String rut = this.comborut.getSelectedItem().toString();

            ConexionAlumno cnn = new ConexionAlumno();

            Alumno a = cnn.Buscar(rut);

            txtmostrar.setText(a.getNombre() + " " + a.getApellido());

        }
    }

    public void BuscarA() {

        ConexionAlumno cnn = new ConexionAlumno();

        ArrayList<Alumno> lista = cnn.Mostrar();

        if (lista == null) {

            JOptionPane.showMessageDialog(rootPane, "No hay usuarios");

        } else {

            for (int i = 0; i < lista.size(); i++) {

                String rut = lista.get(i).getRut();

                comborut.addItem(rut);

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmail = new javax.swing.JTable();
        comborut = new javax.swing.JComboBox<>();
        txtmostrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Buscar Correo");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rut");

        tablaEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email","Id"
            }
        ));
        jScrollPane1.setViewportView(tablaEmail);

        txtmostrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setText("Ingrese id:");

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comborut, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(comborut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        llenar();
        Clear();
        String rut = (String) comborut.getSelectedItem();

        modelo = (DefaultTableModel) tablaEmail.getModel();

        ConexionCorreo cnn = new ConexionCorreo();

        ArrayList<Correo> lista = cnn.Mostrarcorreos();

        if (rut.trim().equals("") || rut == null) {

            JOptionPane.showMessageDialog(rootPane, "Los campos estan vacios!", "Capos Vacios", 1);

        } else if (lista.size() == 0) {

            JOptionPane.showMessageDialog(rootPane, "No tiene correos registrados!", "sin correos", 1);

        } else {

            modelo = (DefaultTableModel) tablaEmail.getModel();

            for (int i = 0; i < lista.size(); i++) {

                if (rut.equals(lista.get(i).getRut())) {

                    modelo.addRow(new Object[]{lista.get(i).getEmail(), lista.get(i).getId()});

                }

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String viejoid = txtid.getText();

        ConexionCorreo cnn = new ConexionCorreo();

        if (viejoid.trim().equals("") || viejoid == null) {

            JOptionPane.showMessageDialog(rootPane, "Ingrese ID en el campo");
        } else {

            int id = 0;
            int val = 0;

            try {
                id = Integer.parseInt(viejoid);

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(rootPane, "Ingrese ID valido");
                val = 1;

            }

            if (val == 0) {

                Correo c = new Correo(id);

                if (cnn.Verificador(c) > 0) {

                    cnn.eliminar(c);
                    JOptionPane.showMessageDialog(rootPane, "Haz eliminado correctamente el correo");
                } else {

                    JOptionPane.showMessageDialog(rootPane, "ID Incorrecto");
                }

            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


     String idold = txtid.getText();
     
        if (idold.trim().equals("")|| idold == null) {
            
            JOptionPane.showMessageDialog(rootPane, "Los campos estan vacios");
        }
        else{
            
          int id = 0;
          int var = 0;
          
            try {
                id = Integer.parseInt(idold);
            } catch (NumberFormatException e) {
                
                JOptionPane.showMessageDialog(rootPane, "Ingrese ID valido");
                var = 1;
            }
            
            if (var==0) {
                
                Correo c = new Correo(id);
                
                ConexionCorreo cnn = new ConexionCorreo();
                
                if (cnn.Verificador(c)>0) {
                    
                 Sistema.idd = id;
                 
                    if (Mc == null || Mc.isClosed()) {
                        
                        Mc = new ModificarCorreo();
                        CajaPrincipal.Sistema.Bigpanel.add(Mc);
                        Mc.show();
                    }
                    this.setVisible(false);
                    Mc.setVisible(true);
                    txtid.setText("");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "El ID no exite");
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comborut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaEmail;
    private javax.swing.JTextField txtid;
    private javax.swing.JLabel txtmostrar;
    // End of variables declaration//GEN-END:variables
}
