package org.course.spring.commands;

import org.course.spring.utils.Command;

public class CommandOne implements Command {
    
	private Object status;

    @Override
    public void execute() {
    	System.out.println("Ejecutando el comado " + getClass().getName() + " con la información: " + status);
    }
    
    @Override
    public void setStatus(Object status) {
    	this.status = status;
    }

    public Command create() {
        return new CommandOne();
    }
}
