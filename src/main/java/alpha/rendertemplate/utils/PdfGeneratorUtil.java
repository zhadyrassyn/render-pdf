package alpha.rendertemplate.utils;

import com.lowagie.text.pdf.BaseFont;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.UUID;

@Component
public class PdfGeneratorUtil {

    public File generatePdf(String processedHtml) throws Exception {
        String fileName = UUID.randomUUID().toString();
        File outputFile = File.createTempFile(fileName, ".pdf");

        try(FileOutputStream os = new FileOutputStream(outputFile)) {
            ITextRenderer renderer = new ITextRenderer();

            renderer.getFontResolver().addFont("/home/daniyar/IdeaProjects/render-template/src/main/resources/static/fonts/times-new-roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            renderer.getFontResolver().addFont("/home/daniyar/IdeaProjects/render-template/src/main/resources/static/fonts/times-new-roman-bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(os, false);
            renderer.finishPDF();

            return outputFile;
        }
    }
}
