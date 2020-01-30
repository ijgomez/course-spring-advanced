package org.course.spring.beans;

public class PersonImpl implements Person {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String datosPersonales() {
        return "Mi nombre es " + nombre;
    }
}
