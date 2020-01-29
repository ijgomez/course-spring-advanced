package org.course.spring.advices;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class TestAdvice implements MethodBeforeAdvice{

	private static final Logger LOGGER = LoggerFactory.getLogger(TestAdvice.class);

    public void before(Method method, Object[] args, Object target) throws Throwable {
        LOGGER.info("Advice invocado en " + target.getClass());
    }

}
