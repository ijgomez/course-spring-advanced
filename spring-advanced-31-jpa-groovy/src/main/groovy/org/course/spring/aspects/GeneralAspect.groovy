package org.course.spring.aspects

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import org.aspectj.lang.annotation.AfterThrowing;

@Component
@Aspect
class GeneralAspect {
    @Before("execution(* servicios.EjemploServicio.*(..)))")
    def traza(JoinPoint p) {
        println "Se va a ejecutar el método: ${p.getSignature().toLongString()}".toUpperCase()
    }

    @AfterThrowing(pointcut = "execution(* servicios.EjemploServicio.get*(..)))", throwing = "e")
    def logExcepcion(JoinPoint p, Exception e) {
        println "Ha ocurrido el error ${e.getMessage()} al ejecutar el método ${p.getSignature().toShortString()}"
    }
}

