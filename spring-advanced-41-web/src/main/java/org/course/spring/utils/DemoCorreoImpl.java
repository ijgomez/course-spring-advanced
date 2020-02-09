package org.course.spring.utils;

import java.io.Serializable;

import org.course.spring.beans.Person;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DemoCorreoImpl implements Serializable{

	private static final long serialVersionUID = 642714633341893848L;

	private MailSender enviadorCorreo;
    
    private SimpleMailMessage plantillaMensaje;

    public void enviarMensaje(Person persona){
        SimpleMailMessage mensaje = new SimpleMailMessage(plantillaMensaje);
        mensaje.setTo(persona.getCorreo());
        mensaje.setText("Prueba");
        enviadorCorreo.send(mensaje);
    }

	public MailSender getEnviadorCorreo() {
		return enviadorCorreo;
	}

	public void setEnviadorCorreo(MailSender enviadorCorreo) {
		this.enviadorCorreo = enviadorCorreo;
	}

	public SimpleMailMessage getPlantillaMensaje() {
		return plantillaMensaje;
	}

	public void setPlantillaMensaje(SimpleMailMessage plantillaMensaje) {
		this.plantillaMensaje = plantillaMensaje;
	}

}