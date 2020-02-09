package org.course.spring.beans;

import lombok.Data;

@Data
public class Persona {

    private String nombre;

    private String apellido;
    
    private Integer dni;

    /** Creates a new instance of ComandoPersona */
    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

}
