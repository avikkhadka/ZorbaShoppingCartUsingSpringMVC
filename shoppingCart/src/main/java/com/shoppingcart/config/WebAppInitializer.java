package com.shoppingcart.config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class, SecurityConfig.class}; // root config: Hibernate
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class}; // servlet config: Spring MVC
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // map DispatcherServlet to "/"
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new DelegatingFilterProxy("springSecurityFilterChain")};
    }
}
