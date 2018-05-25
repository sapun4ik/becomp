package me.becomp.config;

import me.becomp.formatter.NameFormatter;
import me.becomp.service.l10n.MessageResourceService;
import me.becomp.web.utils.ArrayUtil;
import me.becomp.web.utils.DatabaseDrivenMessageSource;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Locale;

/**
 * Created by sapun4ik on 16.03.2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "me.becomp" })
public class WebMVCConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    @Autowired
    @Qualifier("messageResourceService")
    private MessageResourceService messageResourceService;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ViewResolver htmlViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(htmlTemplateResolver()));
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setViewNames(ArrayUtil.array("*.html"));
        return resolver;
    }

    private TemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect(new GroupingStrategy()));
        engine.addDialect(new Java8TimeDialect());
        engine.setTemplateResolver(templateResolver);
        engine.setTemplateEngineMessageSource(messageSource());
        return engine;
    }

    private ITemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("/security/login.html");
        registry.addViewController("/registration").setViewName("/security/registration.html");
        registry.addViewController("/forget").setViewName("/security/forget.html");
        registry.addViewController("/form").setViewName("/personal/form.html");
       // registry.addViewController("/account").setViewName("/personal/account.html");
    }

    @Bean()
    public DatabaseDrivenMessageSource messageSource() {
        DatabaseDrivenMessageSource resource = new DatabaseDrivenMessageSource(messageResourceService);
        ReloadableResourceBundleMessageSource databaseDrivenMessageSourceProperties = new ReloadableResourceBundleMessageSource();
        databaseDrivenMessageSourceProperties.setBasename("classpath:/locales/messages");
        databaseDrivenMessageSourceProperties.setDefaultEncoding("UTF-8");
        databaseDrivenMessageSourceProperties.setCacheSeconds(0);
        databaseDrivenMessageSourceProperties.setFallbackToSystemLocale(false);
        resource.setParentMessageSource(databaseDrivenMessageSourceProperties);
        return resource;
    }
    @Bean()
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(new Locale("ru", "RUSSIAN"));
        cookieLocaleResolver.setCookieMaxAge(100000);
        cookieLocaleResolver.setCookieName("i18n");
        return cookieLocaleResolver;
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    @Description("Custom Conversion Service")
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new NameFormatter());
    }
}
