package me.becomp.config.listener;

import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebListener;

/**
 * Created by sapun4ik on 18.03.2018.
 */
@Configuration
@WebListener
public class RequestContextListener extends org.springframework.web.context.request.RequestContextListener {
}
