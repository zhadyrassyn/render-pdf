package alpha.rendertemplate.utils;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Component
public class HtmlGeneratorUtil {
    private TemplateEngine templateEngine;

    public HtmlGeneratorUtil(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateHtml(Map<String, String> map) {
        Context context = new Context();
        if (map != null) {
            map.forEach(context::setVariable);
        }

        return templateEngine.process("mytemplate", context);
    }
}
