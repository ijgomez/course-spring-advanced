package org.course.spring.services;

import org.course.spring.beans.Login;

public class LoginServiceImpl implements LoginService {

	@Override
	public Boolean autenticacionOk(Login unLogin) {
		return (unLogin.getNombre().equalsIgnoreCase("curso") && unLogin.getClave().equalsIgnoreCase("curso"));
	}
}
