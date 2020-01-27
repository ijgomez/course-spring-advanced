package org.course.spring;

import org.course.spring.beans.Departament;
import org.course.spring.beans.Employee;
import org.course.spring.beans.TeamLeader;
import org.course.spring.beans.User;
import org.course.spring.commands.CommandManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	
	@Test
	public void testCargarContexto() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" })) {
			LOGGER.info("Contexto vacío cargado");
		}
    }

	@Test
	public void testCargarContextoPersona() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "beansContext.xml" })) {
			LOGGER.info("Contexto con factoría cargado");
	        User defecto = (User)ctx.getBean("personaDefecto");
	        LOGGER.info("{}", defecto);
	        User factoria = (User)ctx.getBean("personaFactoria");
	        LOGGER.info("{}", factoria);
		}
    }

	@Test
	public void testCargarContextoPersonaSingleton() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "beansContext.xml" })) {
	        LOGGER.info("Contexto usando singletons cargado");
	        User defecto1 = (User)ctx.getBean("personaDefecto");
	        LOGGER.info("{},{}\n", defecto1, defecto1.hashCode());
	        User defecto2 = (User)ctx.getBean("personaDefecto");
	        LOGGER.info("{},{}\n", defecto2, defecto2.hashCode());
		}
    }

	@Test
	public void testCargarContextoPersonaPrototipo() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "beansContext.xml" })) {
			LOGGER.info("Contexto usando prototipos cargado");
	        User defecto1 = (User)ctx.getBean("personaPrototipo");
	        LOGGER.info("{},{}\n", defecto1, defecto1.hashCode());
	        User defecto2 = (User)ctx.getBean("personaPrototipo");
	        LOGGER.info("{},{}\n", defecto2, defecto2.hashCode());
		}
        
    }

	@Test
	public void testCargarContextoInyectar() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "beansContext.xml" })) {
			LOGGER.info("Contexto usando inyección cargado");
	        Employee defecto1 = (Employee)ctx.getBean("empleadoUno");
	        LOGGER.info("{}", defecto1);
	        Employee defecto2 = (Employee)ctx.getBean("empleadoDos");
	        LOGGER.info("{}", defecto2);
	        Departament departamento = (Departament)ctx.getBean("departamento");
	        LOGGER.info("{}", departamento);
		}
    }

	@Test
	public void testCargarContextoAuto() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "autoContext.xml" })) {
			LOGGER.info("Contexto usando auto enlace cargado");
	        TeamLeader jefe1 = (TeamLeader)ctx.getBean("jefeUno");
	        LOGGER.info("{}", jefe1);
		}

    }

	@Test
	public void testCargarContextoInyectarMetodo() {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "metodoContext.xml" })) {
			LOGGER.info("Contexto usando inyección de métodos cargado");
	        CommandManager gestorComandos = (CommandManager)ctx.getBean("gestorComandos");
	        gestorComandos.execute("Esta orden");
	        gestorComandos.otherMethod();
	        CommandManager gestorComandos1 = (CommandManager)ctx.getBean("gestorComandos1");
	        gestorComandos1.execute("Aquella orden");
	        gestorComandos1.otherMethod();
		}

    }

}
