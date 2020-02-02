package org.course.spring.daos;

import java.util.Collection;

import org.course.spring.beans.Person;
import org.course.spring.exceptions.PersonException;
import org.springframework.dao.DataAccessException;

public interface PersonDao {
	
	void insertarPersona(Person person) throws DataAccessException, PersonException;

	void actualizarPersona(Person person) throws DataAccessException;

	void borrarPersona(Person person) throws DataAccessException;

	Integer contarPersonas() throws DataAccessException;

	Integer contarPersonasUsandoParametros(String name) throws DataAccessException;

	Person encontrarPersona(Integer id) throws DataAccessException;

	Collection<Person> encontrarTodos() throws DataAccessException;

	Integer insertarPersonaDevolviendoLaClavePrimaria(Person person) throws DataAccessException;
	
}
