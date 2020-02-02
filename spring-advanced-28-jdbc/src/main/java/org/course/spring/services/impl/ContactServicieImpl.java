package org.course.spring.services.impl;

import org.course.spring.services.ContactServiceBase;

public class ContactServicieImpl extends ContactServiceBase{

	private static final long serialVersionUID = 3328921253239135164L;

	@Override
    protected String getIdentidad() {
        return "SELECT MAX(id) FROM contactos";
    }

}
