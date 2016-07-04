package Root;

import Modelos.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionAlumno {

    Connection cnn;
    Statement state;
    ResultSet res;
    PreparedStatement ps;

    public ConexionAlumno() {

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

    //QUERY'S ALUMNOS : Verificar, Insertar, Eliminar, Modificar, Buscar, Todos.
    public int Verificador(Alumno u) {

        int caca = 0;

        try {
            String query = "select * from alumno where rut='" + u.getRut() + "'";
            state = cnn.createStatement();
            res = state.executeQuery(query);

            if (res.next()) {

                return 1;
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    //_______________________________________________________
    public int Insertar(Alumno u) {

        int saber = 0;

        String query = "insert into alumno (rut, nombre, apellido, edad )" + "values ('" + u.getRut() + "','" + u.getNombre() + "','" + u.getApellido() + "'," + u.getEdad() + ")";

        try {
            state = cnn.createStatement();
            saber = state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saber;
    }

    //_______________________________________________________
    public int eliminar(Alumno u) {
        int saber = 0;

        try {

            String query = "delete  from alumno where rut = '" + u.getRut() + "'";
            state = cnn.createStatement();
            saber = state.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saber;
    }

    //_______________________________________________________
    public boolean Modificar(Alumno u) {
        int saber = 0;

        try {
            String query = "update alumno set nombre='" + u.getNombre() + "', apellido= '" + u.getApellido() + "', edad=" + u.getEdad() + " where rut='" + u.getRut() + "'";
            state = cnn.createStatement();
            saber = state.executeUpdate(query);

            if (saber > 0) {

                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    //_______________________________________________________
    public Alumno Buscar(String rut) {

        Alumno a = null;

        try {

            String query = "SELECT * FROM alumno WHERE rut= '" + rut + "'";

            state = cnn.createStatement();

            res = state.executeQuery(query);

            if (res.next()) {

                a = new Alumno(res.getString("rut"), res.getString("nombre"), res.getString("apellido"), res.getInt("edad"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);

        }

        return a;
    }

    //_______________________________________________________
    public ArrayList<Alumno> Mostrar() {

        ArrayList<Alumno> listaU = new ArrayList<>();

        try {

            String query = "select * from alumno";
            state = cnn.createStatement();
            res = state.executeQuery(query);

            while (res.next()) {

                listaU.add(new Alumno(res.getString("rut"), res.getString("nombre"), res.getString("apellido"), res.getInt("edad")));

            }

            return listaU;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaU;
    }

}
