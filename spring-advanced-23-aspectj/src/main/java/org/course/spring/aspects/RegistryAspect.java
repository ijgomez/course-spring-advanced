package org.course.spring.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.course.spring.annotations.Registrable;

import lombok.extern.slf4j.Slf4j;

@Aspect()
@Slf4j
public class RegistryAspect {

	@After("@annotation(registrable) && args(..,importe)")
	public void ejecutarAspectoError(Registrable registrable, Double importe) {
		log.info("Operación registrada por un importe de " + importe + " euros.");
		if (registrable.siHayError()) {
			log.info("Esta operación debe registrarse en otro sitio en caso de que falle");
		}
	}
}
