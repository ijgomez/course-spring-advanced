package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.course.spring.dao.PersonDao;

public class PersonServiceImpl implements PersonService {
   
	private PersonDao personDao;

	@Override
    public List<Person> getPersonas() {
        return personDao.getPersonas();
    }

	@Override
    public Person insert(Person person) {
        return personDao.insert(person);
    }

	@Override
    public void update(Person person) {
        personDao.update(person);
    }

	@Override
    public void delete(Person person) {
        personDao.delete(person);
    }

	@Override
    public Person read(Integer id) {
        return personDao.read(id);
    }

	@Override
    public List<Person> findByName(String nombre) {
        return personDao.findByName(nombre);
    }

	@Override
    public Long countAll() {
        return personDao.countAll();
    }

	@Override
    public List<Hobby> getAficiones(Integer id) {
        return personDao.getAficiones(id);
    }

	@Override
    public List<Hobby> getAficionesDeOtraManera(Integer id) {
        return personDao.getAficionesDeOtraManera(id);
    }

	@Override
    public List<Hobby> getAficionesDeOtraManeraMas(Integer id) {
        return personDao.getAficionesDeOtraManeraMas(id);
    }
	
	public PersonDao getPersonDao() {
		return personDao;
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
