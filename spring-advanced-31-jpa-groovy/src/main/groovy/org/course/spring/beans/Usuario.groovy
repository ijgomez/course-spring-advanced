package org.course.spring.beans

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import javax.persistence.FetchType

@Entity
class Usuario {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    @OneToMany(mappedBy="usuario",cascade=[CascadeType.ALL],fetch=FetchType.LAZY)
    List<Rol> roles = []

    String nombre

    String toString(){
         "${this.class.simpleName} Mi nombre es $nombre"
    }
}

