package org.course.spring.utils;

import java.util.HashMap;
import java.util.Map;

import org.course.spring.commands.CargarContextoCommand;
import org.course.spring.commands.InstanciarBeanCommand;
import org.course.spring.commands.InyectarBeanCommand;

public class CommandFactory {

	private static CommandFactory instance;

	public static CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		return instance;
	}

	private Map<CommandType, Command> map;

	/**
	 * New Instance
	 */
	private CommandFactory() {

	}

	private void inicializarOrdenes() {
		getMap().put(CommandType.LOAD_CONTEXT, new CargarContextoCommand());
		getMap().put(CommandType.INSTANCE_BEAN, new InstanciarBeanCommand());
		getMap().put(CommandType.INYECTION_BEAN, new InyectarBeanCommand());
	}

	public Command getCommand(CommandType type) {
		return getMap().get(type);
	}

	private Map<CommandType, Command> getMap() {
		if (map == null) {
			map = new HashMap<>();
			inicializarOrdenes();
		}
		return map;
	}
}
