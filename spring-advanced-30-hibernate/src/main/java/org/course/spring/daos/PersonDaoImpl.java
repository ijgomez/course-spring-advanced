package org.course.spring.daos;

import java.sql.SQLException;
import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

    @SuppressWarnings("unchecked")
    @Override
	public List<Person> getPersonas() {
        return (List<Person>) getHibernateTemplate().find("from Person p order by p.nombre");
    }

    @Override
    public Person insert(Person person) {
        getHibernateTemplate().saveOrUpdate(person);
        return person;
    }

    @Override
    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

    @Override
    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

    @Override
    public Person read(Integer id) {
        return (Person)getHibernateTemplate().load(Person.class, id);
    }

    @Override
    public List<Person> findByName(final String nombre) {
    	return super.getHibernateTemplate().execute(new HibernateCallback<List<Person>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Person> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Person p where p.nombre like :nombre");
                    query.setString("nombre", "%" + nombre + "%");
                    return query.list();
			}
		});
    }

    @Override
    public Long countAll() {
        List<?> lista = 
            getHibernateTemplate().find("select count(*) from Person");
        return (Long)lista.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
	public List<Hobby> getAficiones(Integer id) {
        return (List<Hobby>) getHibernateTemplate().find("select p.aficionesInternas from Person p where p.id = ?", new Object[] { id });
    }

    @Override
	public List<Hobby> getAficionesDeOtraManera(final Integer id) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Hobby>>() {
			
			@Override
			public List<Hobby> doInHibernate(Session session) {
				Person p = (Person) session.load(Person.class, id);
				return p.getAficiones();
			}
		});
	}

    @Override
    public List<Hobby> getAficionesDeOtraManeraMas(Integer id) {
        Person p = (Person)getHibernateTemplate().load(Person.class,id);
        return p.getAficiones();
    }
}
