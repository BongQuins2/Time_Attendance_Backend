package com.accenture.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class Application {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(Constants.SHIFT_VIEWALL).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.SHIFT_SAVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.SHIFT_UPDATE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.SHIFT_REMOVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPLOYEE_VIEWALL).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPLOYEE_SAVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPLOYEE_UPDATE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPLOYEE_REMOVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPSHIFT_VIEWALL).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPSHIFT_SAVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPSHIFT_UPDATE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPSHIFT_REMOVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.TIMETRACKER_VIEWALL).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.TIMETRACKER_VIEWBYEMPLOYEE).allowedOrigins(Constants.LOCALHOST);
//                registry.addMapping(Constants.TIMETRACKER_VIEWBYEMPDATE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.LOGIN_VIEWALL).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.LOGIN_UPDATE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.LOGIN_SAVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.LOGIN_REMOVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.LOGIN_COUNTUSERNAME).allowedOrigins("http://localhost:8000");
                registry.addMapping(Constants.CHECKUSERNAMEPASSWORD).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.USER_TIMETRACKER).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.EMPLOYEE_GETEMPID).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.TIMETRACKER_SAVE).allowedOrigins(Constants.LOCALHOST);
                registry.addMapping(Constants.FIND_TIMETRACKER).allowedOrigins(Constants.LOCALHOST);
                
            }
        };
    }
     public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
