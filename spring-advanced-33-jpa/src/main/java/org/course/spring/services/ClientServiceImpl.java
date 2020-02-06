package org.course.spring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.course.spring.dao.ComercialDao;
import org.course.spring.dao.ContactDao;
import org.springframework.dao.DataAccessException;


public class ClientServiceImpl implements ClientService {

    private ContactDao contactDao;
    
    private ComercialDao comercialDao;

    @Override
    public Collection<Comercial> getTodosLosComerciales() throws DataAccessException {
        return comercialDao.getTodosLosComerciales();
    }

    @Override
    public Long insertarComercial(Comercial c) throws DataAccessException {
        comercialDao.insertarComercial(c);
        return c.getId();
    }

    @Override
    public Collection<Contact> getTodosLosContactos() throws DataAccessException {
        return contactDao.getTodosLosContactos();
    }

    @Override
    public Long insertarContacto(Contact c) throws DataAccessException {
        contactDao.insertarContacto(c);
        return c.getId();
    }

    @Override
    public void asignarContacto(Comercial comercial, Contact contacto) throws DataAccessException {
        comercialDao.asignarContacto(comercial, contacto);
    }

    @Override
    public List<Contact> getContactosDeUnComercial(Comercial comercial) throws DataAccessException {
        List<Contact> lista = new ArrayList<Contact>();
        lista.addAll(comercialDao.getComercial(comercial.getId()).getContacts());
        return lista;

    }

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public ComercialDao getComercialDao() {
		return comercialDao;
	}

	public void setComercialDao(ComercialDao comercialDao) {
		this.comercialDao = comercialDao;
	}
    
    
}
