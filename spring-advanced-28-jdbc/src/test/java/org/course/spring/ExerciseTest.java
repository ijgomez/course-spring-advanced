package org.course.spring;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.course.spring.beans.ContactImpl;
import org.course.spring.beans.Contact;
import org.course.spring.services.ContactService;
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
            statement.execute("CREATE TABLE contactos (id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(255), comentario VARCHAR(255), PRIMARY KEY (ID))");
            connection.commit();
        }
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	private ContactService contactService;

	@Before
	public void beforeTest() {
		contactService = (ContactService) ctx.getBean("contactService");
	}

	@Test
	public void testExercise() throws Exception {
		cargarDatosPrueba();
		mostrarContactos();
		actualizarContacto();
		mostrarContactos();
	}

	private void mostrarContactos() {
		
		List<Contact> lista = contactService.getContactos();
		if (lista.size() == 0) {
			log.info("No se han encontrado contactos en la base de datos");
		} else {
			log.info("Se han encontrado " + lista.size() + " contactos");
			for (Contact c : lista) {
				log.info("Id del contacto: {}. Nombre: {}. Comentario: {}", new Object[] {c.getId(), c.getNombre(), c.getComentario()});
			}
		}
	}

	private void cargarDatosPrueba() {

		for (int i = 0; i < 5; i++) {
			contactService.insertarContacto(new ContactImpl("Nombre " + i, "Comentario " + i));
		}
	}

	private void actualizarContacto() {
		Contact c = new ContactImpl("Cambiado", "Cambiado");
		c.setId(1);

		contactService.actualizarContacto(c);
	}

}
