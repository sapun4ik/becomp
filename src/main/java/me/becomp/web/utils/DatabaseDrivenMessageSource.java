package me.becomp.web.utils;

import me.becomp.persistence.model.l10n.MessageResource;
import me.becomp.service.l10n.MessageResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by sapun4ik on 17.03.2018.
 */
public class DatabaseDrivenMessageSource extends AbstractMessageSource implements ResourceLoaderAware {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    private final Map properties = new HashMap<>();

    @Autowired
    private MessageResourceService messageResourceService;

    public DatabaseDrivenMessageSource() {
        reload();
    }

    public DatabaseDrivenMessageSource(MessageResourceService messageResourceService) {
        this.messageResourceService = messageResourceService;
        reload();
    }
    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String msg = getText(code, locale);
        MessageFormat result = createMessageFormat(msg, locale);
        return result;
    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        return getText(code, locale);
    }

    private String getText(String code, Locale locale) {
        Map<String, String> localized = (Map<String, String>) properties.get(code);
        String textForCurrentLanguage = null;
        if (localized != null) {
            textForCurrentLanguage = localized.get(locale.getLanguage());
            if (textForCurrentLanguage == null) {
                textForCurrentLanguage = localized.get(Locale.FRANCE.getLanguage());
            }
        }
        if (textForCurrentLanguage==null) {
            logger.debug("Fallback to properties message");
            try {
                textForCurrentLanguage = getParentMessageSource().getMessage(code, null, locale);
            } catch (Exception e) {
                logger.error("Cannot find message with code: " + code);
            }
        }
        return textForCurrentLanguage != null ? textForCurrentLanguage : code;
    }

    public void reload() {
        properties.clear();
        properties.putAll(loadTexts());
    }

    protected Map<String, Map<String, String>> loadTexts() {
        log.debug("loadTexts");
        Map<String, Map<String, String>> m = new HashMap<>();
        List<MessageResource> texts = messageResourceService.findAll();
        for (MessageResource text : texts) {
            Map<String, String> v = new HashMap<>();
            v.put("en", text.getEnglish());
            v.put("ru", text.getRussian());
            m.put(text.getMessageKey(), v);
        }
        return m;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = (ResourceLoader)(resourceLoader != null?resourceLoader:new DefaultResourceLoader());
    }

}