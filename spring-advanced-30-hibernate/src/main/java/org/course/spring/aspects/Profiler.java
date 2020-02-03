package org.course.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

@Aspect
public class Profiler {
	
	private static final Logger log = LoggerFactory.getLogger(Profiler.class);

    @Around("execution(* *..PersonService.read*(..))")
    public Object calcularTiempo(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch clock = new StopWatch("Calculando tiempo de ejecución...");
        try {
            clock.start(pjp.toShortString());
            return pjp.proceed();
        } finally {
            clock.stop();
            log.info(clock.prettyPrint());
        }
    }
}
