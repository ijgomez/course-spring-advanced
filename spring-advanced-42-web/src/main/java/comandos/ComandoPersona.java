/*
 * ComandoPersona.java
 *
 * Created on 28 de junio de 2007, 14:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package comandos;

/**
 *
 * @author Administrador
 */
public class ComandoPersona {

    private String nombre;
    private String apellido;
    private Integer dni;

    /** Creates a new instance of ComandoPersona */
    public ComandoPersona() {
    }

    public ComandoPersona(String nombre, String apellido, Integer dni) {
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
