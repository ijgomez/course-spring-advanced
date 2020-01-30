package org.course.spring.beans

import org.course.spring.beans.Person
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("person")
class PersonaGroovy implements Person {
    
    @Autowired
	String nombre

    String datosPersonales(){
        "Mi nombre es $nombre"
    }
}

