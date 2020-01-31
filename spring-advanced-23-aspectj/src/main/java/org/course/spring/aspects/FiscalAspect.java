package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.course.spring.annotations.Fiscalizable;
import org.course.spring.beans.Account;
import org.course.spring.beans.Client;

import lombok.extern.slf4j.Slf4j;

@Aspect()
@Slf4j
public class FiscalAspect {

	@Before("@annotation(fiscalizable) && args(cliente,cuenta,importe)")
	public void ejecutarAspectoError(Fiscalizable fiscalizable, Client cliente, Account cuenta, Double importe) {
		log.info("Operación registrada por un importe de " + importe + " euros.");
		if (importe > fiscalizable.importe()) {
			log.info("Esta operación requiere avisar a Hacienda, ya que su importe (" + importe + ") euros, es mayor que el lídmite legal de " + fiscalizable.importe());
		}
	}
}
