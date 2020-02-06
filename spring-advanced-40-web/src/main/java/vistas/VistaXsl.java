/*
 * VistaXsl.java
 *
 * Created on 27 de junio de 2007, 13:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package vistas;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import org.springframework.web.servlet.view.xslt.AbstractXsltView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Administrador
 */
public class VistaXsl extends AbstractXsltView{
    
    /** Creates a new instance of VistaXsl */
    public VistaXsl() {
    }
    
    @Override
    protected Source createXsltSource(Map model, String rootName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = document.createElement(rootName);
        
        @SuppressWarnings("unchecked")
        List<String> words = (List<String>) model.get("wordList");
        for(String nextWord : words){
            Element wordNode = document.createElement("word");
            Text textNode = document.createTextNode(nextWord);
            wordNode.appendChild(textNode);
            root.appendChild(wordNode);
        }
        return new DOMSource(root);
        
    }
    
}
