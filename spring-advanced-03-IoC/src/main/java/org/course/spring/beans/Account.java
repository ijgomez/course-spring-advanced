package org.course.spring.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {

	private static final long serialVersionUID = -5056295092631377327L;
	
	private Double amount;
	
}
