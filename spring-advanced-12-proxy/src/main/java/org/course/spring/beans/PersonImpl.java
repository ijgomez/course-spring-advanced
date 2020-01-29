package org.course.spring.beans;

public class PersonImpl implements Person {

    private String nombre = "Un nombre cualquiera";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
