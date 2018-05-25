package me.becomp.config.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by sapun4ik on 18.03.2018.
 */

public class ServletContextListener implements javax.servlet.ServletContextListener {

    @Autowired
    DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext rootContext =
                WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        System.out.println("Is rootContext null:" + (rootContext == null));

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

// ...
}
