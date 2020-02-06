package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Comercial implements Serializable {

	private static final long serialVersionUID = -3556065212206710949L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    
    @OneToMany(mappedBy = "comercial",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    private List<Contact> contacts;
    
    /** Creates a new instance of Comercial */
    public Comercial() {
    }
    
    public Comercial(String nombre) {
        this.nombre = nombre;
    }

}
