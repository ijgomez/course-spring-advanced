package org.course.spring;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.course.spring.beans.Person;
import org.course.spring.beans.PersonImpl;
import org.course.spring.daos.PersonDao;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseTest {

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void init() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		log.info("Contexto cargado");
		
		DataSource datasource = (DataSource) ctx.getBean("dataSource");
		try (Connection connection = datasource.getConnection(); Statement statement = connection.createStatement();) {
            statement.execute("CREATE TABLE personas (id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(255), PRIMARY KEY (ID))");
            connection.commit();
        }
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	private PersonDao personDao;
	
	@Before
	public void beforeTest() {
		personDao = (PersonDao) ctx.getBean("personDao");
	}

	@Test
	public void testExercise() throws Exception {
		
        Person p = new PersonImpl();
        p.setNombre("nuevo" + System.currentTimeMillis());

        personDao.insertarPersona(p);
        log.info("Nueva persona insertada");
        
        log.info("{}", personDao.todas());
        
        p = personDao.buscarPersona(0);
        log.info("{}", p);

        
    }

	
	
}
