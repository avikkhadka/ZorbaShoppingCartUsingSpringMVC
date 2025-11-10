package com.shoppingcart.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class}; // root config: Hibernate
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class}; // servlet config: Spring MVC
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // map DispatcherServlet to "/"
    }
}
