package org.course.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamLeader extends Employee implements BeanFactoryAware {

	private static final long serialVersionUID = -7476117582010173041L;

	private Employee advisor;

    public TeamLeader() {
    }

    public TeamLeader(String name, int salary) {
        super(name, salary);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aviso desde la factoria: " + beanFactory.getClass().getName());
    }
}
