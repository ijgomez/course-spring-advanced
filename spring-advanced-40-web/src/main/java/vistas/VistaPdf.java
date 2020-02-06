/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author jose maria
 */
public class VistaPdf extends AbstractPdfView {

    protected void buildPdfDocument(Map model, Document doc, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List words = (List) model.get("wordList");
        for (int i = 0; i < words.size(); i++) {
            doc.add(new Paragraph((String) words.get(i)));
        }
    }
}
