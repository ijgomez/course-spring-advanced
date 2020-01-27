package org.course.spring.lifecicle;

import org.course.spring.beans.User;
import org.springframework.beans.factory.ObjectFactory;

public class UserFactoryBean {

    private ObjectFactory<User> factory;

    public void setFactory(ObjectFactory<User> factory) {
        this.factory = factory;
    }
    
    public User getNewUser(){
        return (User) factory.getObject();
    }
}
