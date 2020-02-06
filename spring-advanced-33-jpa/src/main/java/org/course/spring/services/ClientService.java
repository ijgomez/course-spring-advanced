package org.course.spring.services;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;

public interface ClientService {
    void asignarContacto(Comercial comercial, Contact contacto) throws DataAccessException;

    List<Contact> getContactosDeUnComercial(Comercial comercial) throws DataAccessException;

    Collection<Comercial> getTodosLosComerciales() throws DataAccessException;

    Collection<Contact> getTodosLosContactos() throws DataAccessException;

    Long insertarComercial(Comercial c) throws DataAccessException;

    Long insertarContacto(Contact c) throws DataAccessException;    
}
