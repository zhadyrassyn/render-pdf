package alpha.rendertemplate.controller;

import alpha.rendertemplate.service.TemplateService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

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

    @GetMapping(value = "/template", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity getPdfTemplate() throws Exception {

        File pdfTemplateByteStream = templateService.getPdfTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(new FileInputStream(pdfTemplateByteStream)));
    }
}
