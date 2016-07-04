package CajaAlumno;

import CajaPrincipal.Sistema;
import Modelos.Alumno;
import Modelos.Correo;
import Root.ConexionAlumno;
import Root.ConexionCorreo;
import java.util.ArrayList;
import javafx.geometry.Side;
import javax.swing.JOptionPane;

public class BuscarAlumno extends javax.swing.JInternalFrame {

    ModificarAlumno Ma;

    public BuscarAlumno() {
        initComponents();
        btnmodificar.disable();
        btneliminar.disable();
        combopata.addItem("Seleccione rut del alumno");
        BuscarA();
    }
    
        public void BuscarA() {

        ConexionAlumno cnn = new ConexionAlumno();

        ArrayList<Alumno> lista = cnn.Mostrar();

        if (lista == null) {

            JOptionPane.showMessageDialog(rootPane, "No hay usuarios");

        } else {

            for (int i = 0; i < lista.size(); i++) {

                String rut = lista.get(i).getRut();

                combopata.addItem(rut);

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcampo1 = new javax.swing.JLabel();
        txtcampo2 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        combopata = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Buscar Alumno");
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

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(combopata, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcampo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addComponent(txtcampo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(btnmodificar)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(combopata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtcampo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtcampo2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnmodificar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String rut = combopata.getSelectedItem().toString();
        

        ConexionAlumno cc = new ConexionAlumno();

        Alumno encontrado = cc.Buscar(rut);
        
        ConexionCorreo cnn = new ConexionCorreo();
        
        ArrayList<Correo> lis = cnn.Mostrarcorreos();

        if (combopata.getSelectedIndex()==0) {

            JOptionPane.showMessageDialog(rootPane, "Seleccione Un rut!", "Item", 1);
            
        } else if (encontrado == null) {

            JOptionPane.showMessageDialog(rootPane, "El alumno no esta registrado!", "Sin registro", 2);

            txtcampo1.setText("");
            txtcampo2.setText("");
            
        } else {
            
            

            txtcampo1.setText("El nombre de usuario registrado es: " + encontrado.getNombre() + " " + encontrado.getApellido());
            txtcampo2.setText("Su rut es " + encontrado.getRut() + " y tiene " + encontrado.getEdad() + " Años de edad.");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        String rut = combopata.getSelectedItem().toString();

        ConexionAlumno cnn = new ConexionAlumno();
        Alumno a = new Alumno(rut);

        if (combopata.getSelectedIndex()==0) {

            JOptionPane.showMessageDialog(rootPane, "Seleccione Un rut!");
        } else if (cnn.Verificador(a) > 0) {

            cnn.eliminar(a);
            cnn.Desconectar();
            JOptionPane.showMessageDialog(rootPane, "El usuario ha sido eliminado");
            txtcampo1.setText("");
            txtcampo2.setText("");
      

        } else {

            JOptionPane.showMessageDialog(rootPane, "El usuario no se encuentra");
            txtcampo1.setText("");
            txtcampo2.setText("");
        

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed

        String rut = combopata.getSelectedItem().toString();

        if (combopata.getSelectedIndex()==0) {

            JOptionPane.showMessageDialog(rootPane, "Seleccione Un rut!");
        } else {

            Alumno a = new Alumno(rut);
            ConexionAlumno cnn = new ConexionAlumno();

            if (cnn.Verificador(a) > 0) {
                
                Sistema.rutrip= rut;

                if (Ma == null || Ma.isClosed()) {
                    Ma = new ModificarAlumno();
                    CajaPrincipal.Sistema.Bigpanel.add(Ma);
                    Ma.show();
                }

                this.setVisible(false);
                Ma.setVisible(true);
          
                txtcampo1.setText("");
                txtcampo2.setText("");
                
                
            } else {

                JOptionPane.showMessageDialog(rootPane, "El alumno no esta registrado");

            }

        }

    }//GEN-LAST:event_btnmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox<String> combopata;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtcampo1;
    private javax.swing.JLabel txtcampo2;
    // End of variables declaration//GEN-END:variables
}
