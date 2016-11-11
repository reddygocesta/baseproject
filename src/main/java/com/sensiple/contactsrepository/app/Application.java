package com.sensiple.contactsrepository.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.sensiple.contactsrepository.config.MvcConfig;

@Import(MvcConfig.class)
@SpringBootApplication
public class Application extends SpringBootServletInitializer  {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
