package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class FileUpload implements Serializable {

	private static final long serialVersionUID = -5795455719527329364L;

	private String nombre;
    
    private Long longitud;
    
    private List<String> archivos;

    
}