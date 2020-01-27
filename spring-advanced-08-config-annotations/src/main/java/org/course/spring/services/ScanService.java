package org.course.spring.services;

import java.io.Serializable;

import javax.annotation.Resource;

import org.course.spring.components.ComponenteBean;
import org.springframework.stereotype.Service;

@Service
public class ScanService implements Serializable {

	private static final long serialVersionUID = 7923368809014843736L;
	
	@Resource
    private ComponenteBean c;

    public ComponenteBean getC() {
        return c;
    }

    public void setC(ComponenteBean c) {
        this.c = c;
    }
}
