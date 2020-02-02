package org.course.spring;

import java.util.List;

import org.course.spring.beans.Contacto;
import org.course.spring.beans.IContacto;
import org.course.spring.services.IServicioContactos;
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
		cargarDatosPrueba();
		mostrarContactos();
		actualizarContacto();
		mostrarContactos();
	}

	private void mostrarContactos() {
		IServicioContactos servicio = (IServicioContactos) ctx.getBean("servicioContactos");
		List<IContacto> lista = servicio.getContactos();
		if (lista.size() == 0) {
			log.info("No se han encontrado contactos en la base de datos");
		} else {
			log.info("Se han encontrado " + lista.size() + " contactos");
			for (IContacto c : lista) {
				System.out.printf("Id del contacto: %d. Nombre: %s. Comentario: %s\n", c.getId(), c.getNombre(),
						c.getComentario());
			}
		}
	}

	private void cargarDatosPrueba() {
		IServicioContactos servicio = (IServicioContactos) ctx.getBean("servicioContactos");
		for (int i = 0; i < 5; i++) {
			servicio.insertarContacto(new Contacto("Nombre " + i, "Comentario " + i));
		}
	}

	private void actualizarContacto() {
		IContacto c = new Contacto("Cambiado", "Cambiado");
		c.setId(1);
		IServicioContactos servicio = (IServicioContactos) ctx.getBean("servicioContactos");
		servicio.actualizarContacto(c);
	}

}
