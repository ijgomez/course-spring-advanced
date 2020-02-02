package org.course.spring.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

/*
 * Probar con las otras dos estrategias: JOINED y TABLE_PER_CLASS
 * Toplink dice no soportar esta última, por ello estamos usando Hibernate
 */
@Entity(name = "PersonaSingleTable")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Person implements Serializable {

	private static final long serialVersionUID = 5449541123194643901L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	private String nombre;

}
