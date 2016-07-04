package CajaCorreo;

import Modelos.Alumno;
import Modelos.Correo;
import Root.ConexionAlumno;
import Root.ConexionCorreo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CrearCorreo extends javax.swing.JInternalFrame {

    public CrearCorreo() {
        initComponents();
        comborut.addItem("Seleccione rut del alumno");
        BuscarA();

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comborut = new javax.swing.JComboBox<>();
        txtcorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        correolabel = new javax.swing.JLabel();
        txtmostrar = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Crear Correo");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setText("Seleccione usuario");

        jLabel2.setText("Ingrese correo");

        comborut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comborutItemStateChanged(evt);
            }
        });
        comborut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comborutActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        correolabel.setText("@Hijodedios.com");

        txtmostrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton2.setText("Mostrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo para: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(comborut, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correolabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comborut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correolabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txtmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comborutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comborutActionPerformed


    }//GEN-LAST:event_comborutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String correoo = txtcorreo.getText() ;
        String rut = (String) comborut.getSelectedItem();

        if (correoo.trim().equals("") || comborut.getSelectedIndex()==0) {

            JOptionPane.showMessageDialog(rootPane, "Ingrese datos en el campo");
            
        } else {
            
            String correo = correoo+ correolabel.getText();

            ConexionCorreo cnn = new ConexionCorreo();

            ArrayList<Correo> lis = cnn.Mostrar();

            int var = 0;

            for (int i = 0; i < lis.size(); i++) {

                if (correo.equals(lis.get(i).getEmail())) {

                    JOptionPane.showMessageDialog(rootPane, "El correo ya existe");
                    var = 1;
                }

            }

            if (var == 0) {

                cnn.Insertar(new Correo(correo, rut));

                JOptionPane.showMessageDialog(rootPane, "Ah agregado un correo al usuario");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comborutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comborutItemStateChanged


    }//GEN-LAST:event_comborutItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llenar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comborut;
    private javax.swing.JLabel correolabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JLabel txtmostrar;
    // End of variables declaration//GEN-END:variables
}
