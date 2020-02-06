/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class LoginController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public void login() throws Exception {

        logger.info("@RequestMapping:/login.do");
    }
}
