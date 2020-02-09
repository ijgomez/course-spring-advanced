package org.course.spring.beans;

import lombok.Data;

@Data
public class Person {

    private String nombre;
    
    private String apellido;
    
    private Integer dni;
    
    private String correo;

    public Person() {
    	
    }

    public Person(String nombre, String apellido, Integer dni, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
    }

}