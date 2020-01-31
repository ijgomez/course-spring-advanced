package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.course.spring.beans.EjemploIntroduccion;
import org.course.spring.beans.EjemploIntroduccionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectoIntroduccion {

	private static final Logger LOGGER = LoggerFactory.getLogger(AspectoIntroduccion.class);

	@DeclareParents(value = "org.course.spring.beans.*+", defaultImpl = EjemploIntroduccionImpl.class)
    public static EjemploIntroduccion mixin;

    @Before("execution(* *..Persona.set*(..)) && this(ejemploIntroduccion) && args(unNombre)")
    public void usoIntroduccion(EjemploIntroduccion ejemploIntroduccion, String unNombre) {
        ejemploIntroduccion.mensaje();
        LOGGER.info("El nombre de la persona es " + unNombre);
    }

}
