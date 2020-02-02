package org.course.spring.beans;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "EmpleadoSingleTable")
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = -6303379602247067789L;

	private Company company;

    private Double salary;

    
}
