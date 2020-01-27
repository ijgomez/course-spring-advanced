package org.course.spring.utils;

public interface Command {

	void execute();
	
	void setStatus(Object status);
}
