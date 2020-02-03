/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne

/**
 *
 * @author jose maria
 */
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

