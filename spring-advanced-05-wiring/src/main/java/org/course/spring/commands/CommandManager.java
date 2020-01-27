package org.course.spring.commands;

import org.course.spring.utils.Command;

public abstract class CommandManager {
    
    public void execute(Object status) {
        Command command = create();
        command.setStatus(status);
        command.execute();
    }

    public abstract Command create();
    
    public void otherMethod(){
        System.out.println("Ejecutando desde " + getClass().getName());
    }
}
