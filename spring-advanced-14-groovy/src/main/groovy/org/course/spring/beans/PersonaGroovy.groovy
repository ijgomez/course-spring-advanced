package org.course.spring.beans

import org.course.spring.beans.Person

class PersonaGroovy implements Person {
	
	String nombre

    String datosPersonales(){
        "Mi nombre es $nombre"
    }
}

