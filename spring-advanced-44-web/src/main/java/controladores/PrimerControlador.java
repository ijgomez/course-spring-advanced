/*
 * PrimerControlador.java
 *
 * Created on 10 de junio de 2007, 21:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controladores;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 *
 * @author user
 */
public class PrimerControlador implements Controller{
    
    /** Creates a new instance of PrimerControlador */
    public PrimerControlador() {
    }
    
    @SuppressWarnings("unchecked")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        WebApplicationContext ctx =  RequestContextUtils.getWebApplicationContext(httpServletRequest);
        FreeMarkerConfigurer f = (FreeMarkerConfigurer) ctx.getBean("freemarkerConfig");
        Configuration c = f.getConfiguration();
        Template temp = c.getTemplate("primera.ftl");
        Map root = new HashMap();
        root.put("controlador",getClass().getName());
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        out.flush();        
        ModelAndView mav = new ModelAndView();
        mav.addObject("controlador",getClass().getName());
        return mav;
    }
    
}
