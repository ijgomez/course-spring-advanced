package org.course.spring.daos;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;

public interface PersonDao {
    List<Person> getPersonas();

    Person insert(Person una);

    void update(Person una);

    void delete(Person una);

    Person read(Integer id);

    List<Person> findByName(String nombre);

    Long countAll();
    
    List<Hobby> getAficiones(Integer id);

    List<Hobby> getAficionesDeOtraManera(Integer id);

    List<Hobby> getAficionesDeOtraManeraMas(Integer id);
}
