package alpha.rendertemplate.service.impl;

import alpha.rendertemplate.service.TemplateService;
import alpha.rendertemplate.utils.HtmlGeneratorUtil;
import alpha.rendertemplate.utils.PdfGeneratorUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class TemplateServiceImpl implements TemplateService {

    private HtmlGeneratorUtil htmlGeneratorUtil;
    private PdfGeneratorUtil pdfGeneratorUtil;

    public TemplateServiceImpl(PdfGeneratorUtil pdfGeneratorUtil,
                               HtmlGeneratorUtil htmlGeneratorUtil) {
        this.htmlGeneratorUtil = htmlGeneratorUtil;
        this.pdfGeneratorUtil = pdfGeneratorUtil;
    }

    @Override
    public String getHtmlTemplate() {
        Map<String, String> map = new HashMap<>();
//        map.put("name", "Yerbol");
        return htmlGeneratorUtil.generateHtml("mytemplate", map);
    }

    @Override
    public File getPdfTemplate() throws Exception {
        return pdfGeneratorUtil.generatePdf(getHtmlTemplate());
    }

    @Override
    public String getHtmlTemplate2() {
        Map<String, String> map = new HashMap<>();
        return htmlGeneratorUtil.generateHtml("mytemplate2", map);
    }

    @Override
    public File getPdfTemplate2() throws Exception {
        return pdfGeneratorUtil.generatePdf(getHtmlTemplate2());
    }
}
