/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.services;

/**
 *
 * @author user
 */
public class ServicioContactosDerby extends ServicioContactos{

    @Override
    protected String getIdentidad() {
        return "values IDENTITY_VAL_LOCAL()";
    }

}
