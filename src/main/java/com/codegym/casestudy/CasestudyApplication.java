package com.codegym.casestudy;

import com.codegym.casestudy.service.UserService;
import com.codegym.casestudy.service.impl.UserServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CasestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("ValidationMessages");
        return messageSource;
    }

    @Bean
    public UserService customerService() {
        return new UserServiceImpl();
    }

    @Configuration
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {
            private  ApplicationContext appconfig;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appconfig=applicationContext;

        }


    }
}