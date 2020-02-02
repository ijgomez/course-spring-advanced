package org.course.spring.services;

import java.io.Serializable;

import java.util.List;

import org.course.spring.beans.IContacto;
import org.springframework.dao.DataAccessException;


public interface IServicioContactos extends Serializable {
    List<IContacto> getContactos() throws DataAccessException;
    void insertarContacto(IContacto c) throws DataAccessException;
    void actualizarContacto(IContacto c) throws DataAccessException;
}
