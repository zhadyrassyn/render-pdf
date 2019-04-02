package alpha.rendertemplate.utils;

import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Component
public class PdfGeneratorUtil {

    public File generatePdf(String processedHtml) throws Exception {
        String fileName = UUID.randomUUID().toString();
        File outputFile = File.createTempFile(fileName, ".pdf");

        try(FileOutputStream os = new FileOutputStream(outputFile)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(os, false);
            renderer.finishPDF();

            System.out.println("PDF " + fileName + " generated!");
            return outputFile;
        }
    }
}
