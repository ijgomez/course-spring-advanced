package org.course.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.course.spring.annotations.Fiscalizable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect()
public class FiscalAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(FiscalAspect.class);

	@Before("@annotation(fiscalizable) && args(cliente,cuenta,importe)")
	public void ejecutarAspectoError(Fiscalizable fiscalizable, Client cliente, Account cuenta, Double importe) {
		LOGGER.info("Operación registrada por un importe de " + importe + " euros.");
		if (importe > fiscalizable.importe()) {
			LOGGER.info("Esta operación requiere avisar a Hacienda, ya que su importe (" + importe + ") euros, es mayor que el lídmite legal de " + fiscalizable.importe());
		}
	}
}
