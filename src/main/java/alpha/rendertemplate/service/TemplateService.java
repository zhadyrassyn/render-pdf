package alpha.rendertemplate.service;

import java.io.File;

public interface TemplateService {
    public String getHtmlTemplate();

    public File getPdfTemplate() throws Exception;
}
