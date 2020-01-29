package org.course.spring;

import org.course.spring.advices.TestAdvice;
import org.course.spring.beans.Person;
import org.course.spring.beans.PersonImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	@Test
	public void testExercise() {
		ProxyFactory factoria = new ProxyFactory(new PersonImpl());
        factoria.addInterface(Person.class);
        factoria.addAdvice(new TestAdvice());
        Object obj = factoria.getProxy();
        LOGGER.info("Clase del proxy: " + obj.getClass());
        
        Person p = (Person) obj;
        LOGGER.info("El nombre de la persona es " + p.getNombre());
	}

	
}
