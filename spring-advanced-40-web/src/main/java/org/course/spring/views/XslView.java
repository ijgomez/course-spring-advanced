package org.course.spring.views;

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

public class XslView extends AbstractXsltView{
    
    /** Creates a new instance of VistaXsl */
    public XslView() {
    }
    
    @Override
    protected Source createXsltSource(Map<String, Object> model, String rootName, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
