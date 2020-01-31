package org.course.spring.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {

    private String plate;

    @Override
    public String toString() {
        return "La matrícula es " + this.plate;
    }
}
