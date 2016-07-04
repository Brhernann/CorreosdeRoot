

package Modelos;


public class Correo {
    
    private int id;
    private String Email;
    private String rut;

    public Correo() {
    }
    
    

    public Correo(int id) {
        this.id = id;
    }

    public Correo(String rut) {
        this.rut = rut;
    }

    public Correo(int id, String Email) {
        this.id = id;
        this.Email = Email;
    }
    
    

    public Correo(int id, String Email, String rut) {
        this.id = id;
        this.Email = Email;
        this.rut = rut;
    }

    public Correo(String Email, String rut) {
        this.Email = Email;
        this.rut = rut;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    

}
