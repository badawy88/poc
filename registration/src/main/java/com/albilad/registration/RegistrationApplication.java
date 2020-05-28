package com.albilad.registration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.security.RolesAllowed;

@SpringBootApplication(scanBasePackages = "com.albilad.registration")
public class RegistrationApplication extends SpringBootServletInitializer {

    @Value("${messages.basename.path}")
    private String messagesBasename;

    @RolesAllowed("*")
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RegistrationApplication.class);
    }

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setFallbackToSystemLocale(false);
//        messageSource.setBasenames("file:" + messagesBasename);
//        return messageSource;
//    }
}
