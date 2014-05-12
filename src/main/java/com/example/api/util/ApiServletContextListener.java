package com.example.api.util;


import com.wordnik.swagger.converter.ModelConverters;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApiServletContextListener implements ServletContextListener {
    ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        context = contextEvent.getServletContext();
        ModelConverters.addConverter(new ApiSpecModelConverter(), true);
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        context = contextEvent.getServletContext();
    }
}
