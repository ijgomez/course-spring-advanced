package org.course.spring.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl implements ContactDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Contact> getTodosLosContactos() throws DataAccessException{
        Query query = em.createQuery("select c from Contact as c");
        return query.getResultList();
    }

    @Override
    public Long insertarContacto(Contact c) throws DataAccessException {
        em.persist(c);
        return c.getId();
    }
}
