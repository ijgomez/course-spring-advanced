/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.config;

import org.course.spring.services.TestServicio;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class TestConfigurable {

    private String nombre;
    
    private TestServicio testServicio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public TestServicio getTestServicio() {
        return testServicio;
    }

    public void setTestServicio(TestServicio testServicio) {
        this.testServicio = testServicio;
    }
}

