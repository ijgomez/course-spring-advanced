package org.course.spring.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = -6303379602247067789L;

	@ManyToOne
    @JoinColumn
	private Company company;

    private Double salary;

    
}
