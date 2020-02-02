package org.course.spring;

import java.util.Collection;

import org.course.spring.beans.Persona;
import org.course.spring.beans.PersonaImpl;
import org.course.spring.daos.PersonaDao;
import org.course.spring.exceptions.PersonaException;
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
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	@Before
	public void beforeTest() {
	
	}

	@Test
	public void testExercise() throws Exception {
		ejecutarJdbcSpring();
        ejecutarInsercionDevolviendoLaClavePrimaria();
    }

	private void ejecutarJdbcSpring() throws PersonaException {
        final int MAX_PERSONAS = 5;
        PersonaDao personaDao = (PersonaDao) ctx.getBean("personaDao");
        log.info("Insertando algunas personas en la base de datos...");
        for(int i = 0; i < MAX_PERSONAS; i++){
            personaDao.insertarPersona(new PersonaImpl(i,"nombre"+i));
        }
        System.out.printf("Se han encontrado %d personas en la base de datos\n",personaDao.contarPersonas());
        System.out.printf("Se han encontrado %d personas en la base de datos cuyo nombre empieza por %s\n",personaDao.contarPersonasUsandoParametros("n"),"n");
        final Integer id = 3;
        log.info("Buscando una persona con Id = " + id);
        Persona p;
        try {
            p = personaDao.encontrarPersona(id);
            System.out.printf("Id %d. Nombre %s\n",p.getId(),p.getNombre());
        } catch (DataAccessException ex) {
            log.info("No se ha encontrado a nadie con el identificador " + id);
        }
        try {
            personaDao.actualizarPersona(new PersonaImpl(id,"Nuevo nombre") );
            personaDao.borrarPersona(new PersonaImpl(id + 1,"Da igual") );
        } catch (DataAccessException ex) {
            log.info("Ha ocurrido un error: " + ex.getMessage());
        }
        log.info("Lista de todas las personas en la base de datos");
        try {
            Collection<Persona> todos = personaDao.encontrarTodos();
            System.out.printf("Se han encontrado %d persona(s) en la base de datos\n",todos.size());
            for (Persona persona : todos) {
                System.out.printf("Id %d. Nombre %s\n",persona.getId(),persona.getNombre());
            }
        } catch (DataAccessException ex) {
            log.info("Ha ocurrido un error: " + ex.getMessage());
        }
    }
    
    private void ejecutarInsercionDevolviendoLaClavePrimaria() {
        PersonaDao personaDao = (PersonaDao) ctx.getBean("personaDao");
        try {
            Integer clave = personaDao.insertarPersonaDevolviendoLaClavePrimaria(new PersonaImpl(null,"Clave primaria"));
            log.info("La clave primaria es " + clave);
        } catch (DataAccessException ex) {
            log.info("Ha ocurrido un error: " + ex.getMessage());
        }
    }
	
}
