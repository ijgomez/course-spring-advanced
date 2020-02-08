package springweb0005.beans.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springweb0005.beans.Login;

public class LoginValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NOMBRE_OBLIGATORIO", "El nombre de usuario es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clave", "NOMBRE_OBLIGATORIO", "La clave de acceso es obligatoria.");
    }
}
