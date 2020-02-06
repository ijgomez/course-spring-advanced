package org.course.spring.dao;

import java.util.Collection;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;

public interface ComercialDao {

	Collection<Comercial> getTodosLosComerciales() throws DataAccessException;

	Long insertarComercial(Comercial c) throws DataAccessException;

	void asignarContacto(Comercial comercial, Contact contacto) throws DataAccessException;

	Comercial getComercial(Long id) throws DataAccessException;
}
