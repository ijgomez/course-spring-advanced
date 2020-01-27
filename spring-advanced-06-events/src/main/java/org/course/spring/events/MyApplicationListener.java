package org.course.spring.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		LOGGER.info("Capturado el evento " + applicationEvent.getClass().getName());
	}

}
