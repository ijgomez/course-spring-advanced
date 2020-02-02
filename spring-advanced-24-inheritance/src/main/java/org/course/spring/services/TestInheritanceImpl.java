package org.course.spring.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.course.spring.beans.Employee;
import org.course.spring.beans.Company;
import org.course.spring.beans.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestInheritanceImpl implements TestInheritance {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestInheritanceImpl.class);

    @PersistenceContext
    private EntityManager em;

    public void test() {
        Company company = new Company();
        Employee employee =new Employee();
        company.setEmployees(new ArrayList<>());
        company.getEmployees().add(employee);
        employee.setCompany(company);
        em.persist(company);
        List<Person> todos = em.createQuery("select p from PersonaSingleTable as p", Person.class).getResultList();
        for (Person p : todos) {
        	LOGGER.info(p.getClass().getSimpleName());
        }
    }
}
