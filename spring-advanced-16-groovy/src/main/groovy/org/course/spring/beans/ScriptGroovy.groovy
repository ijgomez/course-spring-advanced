package org.course.spring.beans

import org.course.spring.beans.Person

class PersonaGroovy implements Person {
    
    String nombre

    String datosPersonales(){
        "Mi nombre es $nombre"
    }
}

class OtraPersonaGroovy implements Person {
    String nombre
    Date fecha = new Date()

    String datosPersonales(){
        "Mi nombre es $nombre a fecha $fecha"
    }
}

def numero = Math.random()
println numero

if(numero < 0.5d)
    return new PersonaGroovy()
else
    return new OtraPersonaGroovy()
