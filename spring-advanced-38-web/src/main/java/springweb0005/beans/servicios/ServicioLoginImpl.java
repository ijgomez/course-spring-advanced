package springweb0005.beans.servicios;

import springweb0005.beans.Login;

public class ServicioLoginImpl implements ServicioLogin {
    public ServicioLoginImpl() {
    }

    public Boolean autenticacionOk(Login unLogin) {
        if (unLogin.getNombre().equalsIgnoreCase("curso") && 
            unLogin.getClave().equalsIgnoreCase("curso")) {
            return true;
        } else {
            return false;
        }
    }
}
