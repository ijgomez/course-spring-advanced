/*
 * DemoCorreoImpl.java
 *
 * Created on 01-oct-2007, 13:22:17
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import comandos.ComandoPersona;
import java.io.Serializable;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author user
 */
public class DemoCorreoImpl implements Serializable{

    private MailSender enviadorCorreo;
    private SimpleMailMessage plantillaMensaje;

    public DemoCorreoImpl() {
    }

    
    public void setEnviadorCorreo(MailSender enviadorCorreo) {
        this.enviadorCorreo = enviadorCorreo;
    }

    public void setPlantillaMensaje(SimpleMailMessage plantillaMensaje) {
        this.plantillaMensaje = plantillaMensaje;
    }
    public void enviarMensaje(ComandoPersona persona){
        SimpleMailMessage mensaje = new SimpleMailMessage(plantillaMensaje);
        mensaje.setTo(persona.getCorreo());
        mensaje.setText("Prueba");
        enviadorCorreo.send(mensaje);
    }
}