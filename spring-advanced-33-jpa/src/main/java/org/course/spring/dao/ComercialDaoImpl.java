package org.course.spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ComercialDaoImpl implements ComercialDao {
    
	@PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Comercial> getTodosLosComerciales() throws DataAccessException{
        Query query = em.createQuery("select c from Comercial as c");
        return query.getResultList();
    }

    @Override
    public Long insertarComercial(Comercial c) throws DataAccessException {
        em.persist(c);
        return c.getId();
    }

    @Override
    public void asignarContacto(Comercial comercial, Contact contact) throws DataAccessException {
        comercial.setContacts(new ArrayList<>());
    	comercial.getContacts().add(contact);
        contact.setComercial(comercial);
        em.persist(comercial);
    }

    @Override
    public Comercial getComercial(Long id) throws DataAccessException {
        return em.find(Comercial.class,id);
    }
}
