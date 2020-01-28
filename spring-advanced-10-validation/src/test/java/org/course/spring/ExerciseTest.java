package org.course.spring;

import java.util.List;

import org.course.spring.beans.TestBean;
import org.course.spring.beans.TestBeanValidator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void init() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}

	@Test
	public void testExercise() {
		TestBean test = (TestBean) ctx.getBean("testBean");
        TestBeanValidator testValidator = (TestBeanValidator) ctx.getBean("testBeanValidator");
        Errors e = new BeanPropertyBindingResult(test, "testBean");
        testValidator.validate(test, e);
        LOGGER.info("Validación concluida ");
        List<FieldError> lista = e.getFieldErrors();
        for (FieldError fieldError : lista) {
        	LOGGER.info(fieldError.toString());
        }
	}

	
}
