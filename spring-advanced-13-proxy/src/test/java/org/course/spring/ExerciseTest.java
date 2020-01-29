package org.course.spring;

import org.course.spring.beans.Persona;
import org.course.spring.beans.Usuario;
import org.course.spring.proxy.SimpleProxy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	@Test
	public void testExercise() {
		Object obj = SimpleProxy.crear(Persona.class, Usuario.class);
        Persona persona = (Persona) obj;
        persona.setNombre("abc");
        LOGGER.info("El nombre es " + persona.getNombre());
       
        Usuario usuario = (Usuario) obj;
        usuario.setClave("xyz");
        LOGGER.info("La clave es " + usuario.getClave());

	}

	
}
