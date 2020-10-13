package org.course.spring.validations;

import org.course.spring.beans.Persona;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonaValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return Persona.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Persona persona = (Persona) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.vacio", "El nombre está vacío");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "apellido.vacio", "El apellido está vacío");        
        if (persona.getNombre().length() < 3) {
            errors.rejectValue("nombre", "nombre.corto", "El nombre es demasiado corto");
        }
        if (persona.getApellido().length() < 3) {
            errors.rejectValue("apellido", "apellido.corto", "El apellido es demasiado corto");
        }
    }

}