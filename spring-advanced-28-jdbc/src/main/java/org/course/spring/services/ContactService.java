package org.course.spring.services;

import java.io.Serializable;

import java.util.List;

import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;


public interface ContactService extends Serializable {
    List<Contact> getContactos() throws DataAccessException;
    void insertarContacto(Contact c) throws DataAccessException;
    void actualizarContacto(Contact c) throws DataAccessException;
}
