package org.course.spring;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.course.spring.services.PersonService;
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
		
//		DataSource datasource = (DataSource) ctx.getBean("dataSource");
//		try (Connection connection = datasource.getConnection(); Statement statement = connection.createStatement();) {
//            statement.execute("CREATE TABLE personas (id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(255), PRIMARY KEY (ID))");
//            connection.commit();
//        }
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	private PersonService personService;
	
	@Before
	public void beforeTest() {
		personService = (PersonService)ctx.getBean("servicioPersona");
	}

	@Test
	public void testExercise() throws Exception {

    }
	
	@Test
	public void testAccesoDatos() throws Exception {
        
        log.info("Hay {} personas en la base de datos", personService.countAll());
        log.info("************************************************");
        log.info("Personas en la base de datos");
        for (Person una: personService.getPersonas()) {
            log.info("{}", una);
        }
        log.info("************************************************");
        log.info("Personas en la base de datos cuyo nombre contiene la letra 'p'");
        for (Person una: personService.findByName("p")) {
            log.info("{}", una);
        }
        log.info("************************************************");
        log.info("Datos de la persona con id 1");
        Person p = personService.read(1);
        log.info("{}", p);
        log.info("************************************************");
        log.info("Borrando a aa persona con id = 1");
        personService.delete(p);
        log.info("************************************************");
        log.info("Aficiones de la persona con id 2");
        List<Hobby> aficiones = personService.getAficiones(2);
        for (Hobby aficion: aficiones) {
            log.info("{}", aficion);
        }
        log.info("************************************************");
        log.info("Aficiones de la persona con id 2 obtenidas de otra manera");
        aficiones = personService.getAficionesDeOtraManera(2);
        for (Hobby aficion: aficiones) {
            log.info("{}", aficion);
        }
        log.info("************************************************");
        log.info("Aficiones de la persona con id 2 de una tercera forma");
        aficiones = personService.getAficionesDeOtraManeraMas(2);
        for (Hobby aficion: aficiones) {
            log.info("{}", aficion);
        }
        log.info("************************************************");
    }

	@Test
	public void testCargarDatosPrueba() throws Exception {
        log.info("Servicio de personas encontrado");
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setNombre("pepe" + i);
            Hobby a = new Hobby();
            a.setNombre("Afición" + i);
            a.setPersona(p);
            p.getAficionesInternas().add(a);
            personService.insert(p);
        }
        log.info("************************************************");
    }

	@Test
	public void testAspectoRecuperacion() throws Exception {
        log.info("Probando el aspecto de recuperación...");
        try {
            personService.read(20000);
        } catch (DataAccessException e) {
            log.info("Excepción de tipo DataAccessException");
        }
    }

	
	
}
