package org.course.spring;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Collection;

import javax.sql.DataSource;

import org.course.spring.beans.Person;
import org.course.spring.beans.PersonImpl;
import org.course.spring.daos.PersonDao;
import org.course.spring.exceptions.PersonException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

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
		ejecutarJdbcSpring();
        ejecutarInsercionDevolviendoLaClavePrimaria();
    }

	private void ejecutarJdbcSpring() throws PersonException {
        final int MAX_PERSONAS = 5;
        
        log.info("Insertando algunas personas en la base de datos...");
        for(int i = 0; i < MAX_PERSONAS; i++){
            personDao.insertarPersona(new PersonImpl(i,"nombre"+i));
        }
        log.info("Se han encontrado {} personas en la base de datos.",personDao.contarPersonas());
        log.info("Se han encontrado {} personas en la base de datos cuyo nombre empieza por {}",personDao.contarPersonasUsandoParametros("n"),"n");
        final Integer id = 3;
        log.info("Buscando una persona con Id = " + id);
        Person p;
        try {
            p = personDao.encontrarPersona(id);
            log.info("Id {}. Nombre {}",p.getId(),p.getNombre());
        } catch (DataAccessException ex) {
            log.info("No se ha encontrado a nadie con el identificador " + id);
        }
        try {
            personDao.actualizarPersona(new PersonImpl(id,"Nuevo nombre") );
            personDao.borrarPersona(new PersonImpl(id + 1,"Da igual") );
        } catch (DataAccessException ex) {
            log.info("Ha ocurrido un error: " + ex.getMessage());
        }
        log.info("Lista de todas las personas en la base de datos");
        try {
            Collection<Person> todos = personDao.encontrarTodos();
            log.info("Se han encontrado {} persona(s) en la base de datos.",todos.size());
            for (Person persona : todos) {
            	log.info("Id {}. Nombre {}",persona.getId(),persona.getNombre());
            }
        } catch (DataAccessException ex) {
            log.info("Ha ocurrido un error: " + ex.getMessage());
        }
    }
    
    private void ejecutarInsercionDevolviendoLaClavePrimaria() {
        
        try {
            Integer clave = personDao.insertarPersonaDevolviendoLaClavePrimaria(new PersonImpl(null,"Clave primaria"));
            log.info("La clave primaria es " + clave);
        } catch (DataAccessException ex) {
            log.info("Ha ocurrido un error: " + ex.getMessage());
        }
    }
	
}
