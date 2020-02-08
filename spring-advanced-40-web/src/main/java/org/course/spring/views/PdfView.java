package org.course.spring.views;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

public class PdfView extends AbstractPdfView {
	
	@SuppressWarnings("unchecked")
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<String> words = (List<String>) model.get("wordList");
        for (int i = 0; i < words.size(); i++) {
            doc.add(new Paragraph((String) words.get(i)));
        }
    }
}
