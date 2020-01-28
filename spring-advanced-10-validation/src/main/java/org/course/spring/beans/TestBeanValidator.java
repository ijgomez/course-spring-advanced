package org.course.spring.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TestBeanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TestBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TestBean test = (TestBean) target;
		if (test.getName().length() < 5) {
			errors.rejectValue("nombre", "corto", "El nombre debe tener más de cinco caracteres");
		}
	}
}
