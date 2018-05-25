package me.becomp.config;

import me.becomp.security.dto.ActiveUserStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by sapun4ik on 18.03.2018.
 */
@Configuration
@PropertySource(value = "classpath:util.properties") //<context:property-placeholder location=".." />
@ComponentScan({ "me.becomp.persistence" })
public class ApplicationConfig {
    /**
     * @PropertySource annotation does not automatically
     * register a PropertySourcesPlaceholderConfigurer with Spring.
     * So we need to initialize this bean.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     *  Java Mail Configuration
     */
    @Value("${java.mail.username}") String mailUsername;
    @Value("${java.mail.password}") String mailPassword;
    @Value("${java.mail.host}") String mailHost;

    /**
     *  <bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
     */
    @Bean(name = "mailSender")
    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        javaMailSender.setPort(465);

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.starttls.required", true);
        javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.put("mail.smtp.host", mailHost);

        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }

    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }
}
