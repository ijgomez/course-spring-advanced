package org.course.spring.services;

import org.course.spring.beans.Login;

public interface LoginService {
	
    Boolean autenticacionOk(Login unLogin);
}
