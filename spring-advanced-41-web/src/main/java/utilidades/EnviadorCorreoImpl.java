/*
 * EnviadorCorreoImpl.java
 *
 * Created on 01-oct-2007, 13:05:23
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author user
 */
public class EnviadorCorreoImpl extends JavaMailSenderImpl implements InitializingBean {

    private Properties javaMailProperties;

    @Override
    public void setJavaMailProperties(Properties javaMailProperties) {
        this.javaMailProperties = javaMailProperties;
    }

    public void afterPropertiesSet() throws Exception {
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(javaMailProperties.getProperty("mail.smtp.user"), javaMailProperties.getProperty("mail.smtp.password"));
            }
        };
        if (javaMailProperties != null && getSession() != null) {
            Properties properties = getSession().getProperties();
            properties.putAll(javaMailProperties);
            setSession(Session.getInstance(properties,auth));
            return;
        }
        if (javaMailProperties != null) {
            super.setJavaMailProperties(javaMailProperties);
        }
    }
}