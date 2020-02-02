package org.course.spring.services;

public class ServicioContactosMySQL extends ServicioContactos {
    public ServicioContactosMySQL() {
    }
    @Override
    protected String getIdentidad(){
        return "select last_insert_id()";
    }
}
