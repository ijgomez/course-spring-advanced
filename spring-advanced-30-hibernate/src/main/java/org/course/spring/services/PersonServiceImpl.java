package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.course.spring.daos.PersonDao;

public class PersonServiceImpl implements PersonService {
   
	private PersonDao personaDao;

	@Override
    public List<Person> getPersonas() {
        return personaDao.getPersonas();
    }

	@Override
    public Person insert(Person person) {
        return personaDao.insert(person);
    }

	@Override
    public void update(Person person) {
        personaDao.update(person);
    }

	@Override
    public void delete(Person person) {
        personaDao.delete(person);
    }

	@Override
    public Person read(Integer id) {
        return personaDao.read(id);
    }

	@Override
    public List<Person> findByName(String nombre) {
        return personaDao.findByName(nombre);
    }

	@Override
    public Long countAll() {
        return personaDao.countAll();
    }

	@Override
    public List<Hobby> getAficiones(Integer id) {
        return personaDao.getAficiones(id);
    }

	@Override
    public List<Hobby> getAficionesDeOtraManera(Integer id) {
        return personaDao.getAficionesDeOtraManera(id);
    }

	@Override
    public List<Hobby> getAficionesDeOtraManeraMas(Integer id) {
        return personaDao.getAficionesDeOtraManeraMas(id);
    }
	
	public PersonDao getPersonaDao() {
		return personaDao;
	}
	
	public void setPersonaDao(PersonDao personaDao) {
		this.personaDao = personaDao;
	}
}
