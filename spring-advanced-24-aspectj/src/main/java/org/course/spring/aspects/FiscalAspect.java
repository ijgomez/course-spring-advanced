package org.course.spring.aspects;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.course.spring.annotations.Fiscalizable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Acount;

@Aspect()
@Slf4j
public class FiscalAspect {

    @Before("@annotation(fiscalizable) && args(cliente,cuenta,importe)")
    public void ejecutarAspectoError(Fiscalizable fiscalizable, Client cliente, Acount cuenta, Double importe){
        log.info("Operación registrada por un importe de " + importe + " euros.");
        if (importe > fiscalizable.importe()) {
            log.info("Esta operación requiere avisar a Hacienda, ya que su importe (" + importe + ") euros, es mayor que el límite legal de " + fiscalizable.importe());
        }
    }
}
