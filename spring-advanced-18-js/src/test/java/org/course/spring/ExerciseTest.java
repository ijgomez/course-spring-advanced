package org.course.spring;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	@Test
	public void testEvaluarArchivoJavaScript() throws ScriptException {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("demo.js");
		Reader reader = new BufferedReader(new InputStreamReader(inputStream));
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");

		engine.eval(reader);

	}

	@Test
	public void testEvaluarTextoJavaScript() throws ScriptException {

		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		engine.eval("println('Texto JavaScript')");

	}

	@Test
	public void testEvaluarYEjecutarFuncionJavaScript() throws Exception {

		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		engine.eval("function mensaje(texto){ return 'El mensaje es ' + texto;}");
		Invocable invocable = (Invocable) engine;
		Object object = invocable.invokeFunction("mensaje", "abc");
		LOGGER.info("{}", object);

	}

}
