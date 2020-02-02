/*
 * PersonaImpl.java
 *
 * Created on 4 de junio de 2007, 11:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.beans;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class PersonaImpl implements Persona, Serializable {
    private Integer id;
    private String nombre;
    /** Creates a new instance of PersonaImpl */
    public PersonaImpl() {
    }
    
    public PersonaImpl(Integer id,String nombre) {
        setId(id);
        setNombre(nombre);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
