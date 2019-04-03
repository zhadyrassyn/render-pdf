package alpha.rendertemplate.service;

import java.io.File;

public interface TemplateService {
    String getHtmlTemplate();

    File getPdfTemplate() throws Exception;

    String getHtmlTemplate2();

    File getPdfTemplate2() throws Exception;
}
