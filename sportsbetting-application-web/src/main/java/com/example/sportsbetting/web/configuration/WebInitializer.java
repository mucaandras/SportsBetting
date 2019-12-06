package com.example.sportsbetting.web.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {
        try(AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext()){

            webApplicationContext.register(WebConfig.class);
            webApplicationContext.setServletContext(container);
            ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/");
        }
    }
}
