package Root;

import Modelos.Correo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionCorreo {

    Connection cnn;
    Statement state;
    ResultSet res;
    PreparedStatement ps;



    public ConexionCorreo() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nosequees?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnn() {

        return cnn;

    }

    public void Desconectar() {

        try {
            cnn.close();
            cnn = null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //QUERY'S____CORREOS_:___Verificar___Insertar____Eliminar____Modificar____Buscar____Todos____
    public int Verificador(Correo c) {

        try {
            String query = "select * from correo where id=" + c.getId() + "";
            state = cnn.createStatement();
            res = state.executeQuery(query);

            if (res.next()) {

                return 1;
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public int Insertar(Correo c) {

        int saber = 0;

        String query = "insert into correo (id, email, rut)" + "values (" + c.getId() + ",'" + c.getEmail() + "','" + c.getRut() + "')";

        try {
            state = cnn.createStatement();
            saber = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saber;
    }

    public int eliminar(Correo c) {

        int saber = 0;

        try {

            String query = "delete  from correo where id = " + c.getId() + "";
            state = cnn.createStatement();
            saber = state.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saber;
    }

    public boolean Modificar(Correo c) {
        int saber = 0;

        try {
            String query = "update correo set email='" + c.getEmail() + "', rut= '" + c.getRut() + "'  where id=" + c.getId() + "";
            state = cnn.createStatement();
            saber = state.executeUpdate(query);

            if (saber > 0) {

                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Correo Buscar(int id) {

        Correo a = null;

        try {

            String query = "SELECT * FROM correo WHERE id= " + id + "";

            state = cnn.createStatement();

            res = state.executeQuery(query);

            if (res.next()) {

                a = new Correo(res.getInt("id"), res.getString("email"), res.getString("rut"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);

        }

        return a;
    }

    //_______________________

    //SELECT a.nombre, c.email FROM alumno a JOIN correo c on (a.rut=c.rut)
        public ArrayList<Correo> Mostrarcorreos() {

        ArrayList<Correo> listaC = new ArrayList<>();

        try {

            String query = "SELECT c.id, c.email, c.rut FROM alumno a JOIN correo c on (a.rut=c.rut)";
            state = cnn.createStatement();
            res = state.executeQuery(query);

            while (res.next()) {

                int id= res.getInt(1);
                String email = res.getString(2);
                String rut = res.getString(3);

                listaC.add(new Correo(id, email, rut));

            }

            return listaC;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaC;
    }


    //______________

    public ArrayList<Correo> Mostrar() {

        ArrayList<Correo> listaC = new ArrayList<>();

        try {

            String query = "select * from correo";
            state = cnn.createStatement();
            res = state.executeQuery(query);

            while (res.next()) {

                listaC.add(new Correo(res.getInt("id"), res.getString("email"), res.getString("rut")));

            }

            return listaC;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaC;
    }

}
