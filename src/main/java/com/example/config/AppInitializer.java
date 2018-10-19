package com.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    private static final String CONFIG_LOCATION = "com.example.config";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println("Initializing Application for " + servletContext.getServerInfo());

        // Create ApplicationContext
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", new DispatcherServlet(context));

        servlet.addMapping("/api/*");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
    }
}
