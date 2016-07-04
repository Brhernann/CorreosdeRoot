package CajaAlumno;

import Modelos.Alumno;
import Root.ConexionAlumno;
import javax.swing.JOptionPane;

public class CrearAlumno extends javax.swing.JInternalFrame {

    public CrearAlumno() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtrut = new javax.swing.JTextField();
        crearA = new javax.swing.JButton();
        txtedad = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Crear Alumno");
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel4.setText("Rut");

        jLabel3.setText("Edad");

        crearA.setText("Crear");
        crearA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txtapellido)
                            .addComponent(txtrut)
                            .addComponent(txtedad)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(crearA)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(crearA)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAActionPerformed

        String rut = txtrut.getText();
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String edadS = txtedad.getText();

        if (rut.trim().equals("") || nombre.trim().equals("") || apellido.trim().equals("") || edadS.trim().equals("")) {

            JOptionPane.showMessageDialog(rootPane, "Los campos estan vacios");

        } else {

            int edad = 0;
            int validar = 0;
            try {
                edad = Integer.parseInt(edadS);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Ingrese Numero valido");
                validar = 1;
            }

            if (validar == 0) {

                ConexionAlumno cnn = new ConexionAlumno();
                Alumno a = new Alumno(rut);

                if (cnn.Verificador(a) > 0) {

                    JOptionPane.showMessageDialog(rootPane, "Ya estas registrado!", "Error de existencia", 3);
                } else {

                    int confirm = JOptionPane.showConfirmDialog(rootPane, "Estas a punto de crear un nuevo Alumno llamado " + nombre + " " + apellido, "Confirme Regitro", 1);

                    if (confirm == JOptionPane.YES_OPTION) {

                        cnn.Insertar(new Alumno(rut, nombre, apellido, edad));
                        cnn.Desconectar();
                        JOptionPane.showMessageDialog(rootPane, "A creado un nuevo Alumno", "Alumno  nuevo", 2);
                        txtrut.setText("");
                        txtnombre.setText("");
                        txtapellido.setText("");
                        txtedad.setText("");
                        this.setVisible(false);
                    } else if (confirm == JOptionPane.NO_OPTION) {

                    }

                }

            }

        }


    }//GEN-LAST:event_crearAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrut;
    // End of variables declaration//GEN-END:variables
}
