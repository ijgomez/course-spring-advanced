package org.course.spring.aspects;

public aspect MyAspect {
	
	pointcut ejecucionset() : call(* set*(..));
	
	after(): ejecucionset() {
		 System.out.println("se ha ejecutado un método set: " + thisJoinPoint);
	}

}
