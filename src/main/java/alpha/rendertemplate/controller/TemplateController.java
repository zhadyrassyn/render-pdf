package alpha.rendertemplate.controller;

import alpha.rendertemplate.service.TemplateService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/api")
public class TemplateController {

    private TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping(value = "/template", produces = MediaType.TEXT_HTML_VALUE)
    public String getHtmlTemplate() {
        return templateService.getHtmlTemplate();
    }

    @GetMapping(value = "/template/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getPdfTemplate(HttpServletResponse response) throws Exception {

        File pdfTemplateByteStream = templateService.getPdfTemplate();

        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=report.pdf");

        OutputStream outputStream = response.getOutputStream();
        FileInputStream inputStream = new FileInputStream(pdfTemplateByteStream);

        IOUtils.copy(inputStream, outputStream);
        outputStream.close();
        inputStream.close();

        pdfTemplateByteStream.delete();
    }
}
