/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.daos;

import java.util.List;

import org.course.spring.beans.Persona;

/**
 *
 * @author Administrador
 */
public interface PersonaDao {

    Persona buscarPersona(Integer id);

    Integer insertarPersonaDevolviendoLaClave(Persona persona);

    void insertarPersona(Persona persona);

    List todas();
}
