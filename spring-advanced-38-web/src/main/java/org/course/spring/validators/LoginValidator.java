package org.course.spring.validators;

import org.course.spring.beans.Login;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NOMBRE_OBLIGATORIO", "El nombre de usuario es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clave", "NOMBRE_OBLIGATORIO", "La clave de acceso es obligatoria.");
    }
}
