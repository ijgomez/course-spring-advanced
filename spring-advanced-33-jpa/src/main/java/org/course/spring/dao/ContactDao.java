package org.course.spring.dao;

import java.util.Collection;

import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;

public interface ContactDao {
    
	Collection<Contact> getTodosLosContactos() throws DataAccessException;
    
	Long insertarContacto(Contact c) throws DataAccessException;    
}
