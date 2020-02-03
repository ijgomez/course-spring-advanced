package org.course.spring.daos;

import java.util.List;
import java.util.Map;

import org.course.spring.beans.Person;

public interface PersonDao {

    Person buscarPersona(Integer id);

    Integer insertarPersonaDevolviendoLaClave(Person person);

    void insertarPersona(Person person);

    List<Map<String, Object>> todas();
}
