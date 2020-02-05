package org.course.spring.beans

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne

@Entity
class Rol {
   
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    String nombre

    @ManyToOne
    Usuario usuario
    
    String toString(){
      "${this.class.simpleName} Mi nombre es $nombre"  
    }
}

