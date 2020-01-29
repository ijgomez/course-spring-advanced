package org.course.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.course.spring.beans.Persona;
import org.course.spring.beans.PersonaImpl;
import org.course.spring.beans.Usuario;
import org.course.spring.beans.UsuarioImpl;

public class SimpleProxy implements InvocationHandler {

	private Persona persona;
	private Usuario usuario;

	private SimpleProxy() {
		persona = new PersonaImpl();
		usuario = new UsuarioImpl();
	}

	public static Object crear(Class<?>... interfaces) {
		InvocationHandler handler = new SimpleProxy();
		ClassLoader loader = handler.getClass().getClassLoader();
		return Proxy.newProxyInstance(loader, interfaces, handler);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String metodo = method.getName();
		if (metodo.equals("getNombre")) {
			return persona.getNombre();
		} else if (metodo.equals("setNombre")) {
			persona.setNombre((String) args[0]);
			return null;
		}
		if (metodo.equals("getClave")) {
			return usuario.getClave();
		} else if (metodo.equals("setClave")) {
			usuario.setClave((String) args[0]);
			return null;
		} else {
			throw new IllegalAccessException("El método " + metodo + " no está definido");
		}
	}
}
