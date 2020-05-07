package com.ymm.fetchParams.config;

import com.ymm.fetchParams.Filters.MyAccessAuthorityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private MyAccessAuthorityFilter myAccessAuthorityFilter;

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(myAccessAuthorityFilter);
        registration.addUrlPatterns("/auth/*");
        registration.setName("myAccessAuthorityFilter");
        return registration;
    }

}