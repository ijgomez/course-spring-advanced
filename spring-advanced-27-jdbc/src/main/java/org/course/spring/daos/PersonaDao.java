/*
 * PersonaDao.java
 *
 * Created on 4 de junio de 2007, 11:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.daos;

import java.util.Collection;

import org.course.spring.beans.Persona;
import org.course.spring.exceptions.PersonaException;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author user
 */
public interface PersonaDao {
    void insertarPersona(Persona persona) throws DataAccessException, PersonaException;
    void actualizarPersona(Persona persona) throws DataAccessException;
    void borrarPersona(Persona persona) throws DataAccessException;
    Integer contarPersonas() throws DataAccessException;
    Integer contarPersonasUsandoParametros(String nombre) throws DataAccessException;
    Persona encontrarPersona(Integer id) throws DataAccessException;
    Collection<Persona> encontrarTodos() throws DataAccessException;
    Integer insertarPersonaDevolviendoLaClavePrimaria(Persona persona) throws DataAccessException;
}
