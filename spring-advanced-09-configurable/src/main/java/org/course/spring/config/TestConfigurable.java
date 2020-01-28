package org.course.spring.config;

import org.course.spring.services.TestServicio;
import org.springframework.beans.factory.annotation.Configurable;

import lombok.Getter;
import lombok.Setter;

@Configurable
@Getter
@Setter
public class TestConfigurable {

    private String nombre;
    
    private TestServicio testServicio;

}

