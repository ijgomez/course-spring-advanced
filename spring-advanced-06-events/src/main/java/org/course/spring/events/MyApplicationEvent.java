package org.course.spring.events;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent{

	private static final long serialVersionUID = -4452637392193873585L;

    public MyApplicationEvent(Object source) {
        super(source);
    }
    
}
