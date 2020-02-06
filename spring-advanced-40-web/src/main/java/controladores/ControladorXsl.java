/*
 * ControladorXsl.java
 *
 * Created on 27 de junio de 2007, 13:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Administrador
 */
public class ControladorXsl implements Controller{
    
    /** Creates a new instance of ControladorXsl */
    public ControladorXsl() {
    }
    
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        List<String> wordList = new ArrayList<String>();
        
        wordList.add("Primera frase");
        wordList.add("Segunda frase");
        
        map.put("wordList", wordList);
        
        return new ModelAndView("segunda", map);
        
    }
    
}
