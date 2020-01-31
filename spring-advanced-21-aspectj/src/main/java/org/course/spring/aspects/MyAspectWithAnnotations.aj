package org.course.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspectWithAnnotations {

    @Pointcut("call(* get*(..))")
    public void test() {
    	
    }
    
    @Before("test()")
    public void printTest(JoinPoint p){
    	System.out.println("[annotation] Se va a ejecutar un método get: " + p);
    }
}
