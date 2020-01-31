package org.course.spring.beans;

import java.io.Serializable;


public class PersonaImpl implements Serializable, Persona {

	private static final long serialVersionUID = -7742078705286016552L;
	
	private String nombre;

    public PersonaImpl() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
