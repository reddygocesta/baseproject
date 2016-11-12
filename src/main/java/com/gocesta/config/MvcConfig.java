package com.gocesta.config;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Import({SecurityConfig.class})
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "com.gocesta.web.controller" })
@PropertySource("classpath:application.properties")
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Inject
	private Environment environment;
	
	private static final String DB_PASSWORD = "spring.datasource.password";
	private static final String DB_USERNAME = "spring.datasource.username";
	private static final String DB_JDBC_URL = "spring.datasource.url";
	private static final String DB_JDBC_DRIVER = "spring.datasource.driver-class-name";
	
    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
    
    @Bean(name = "jdbcTemlate")
	public JdbcTemplate getJdbcTemplate() throws NamingException {
		return new JdbcTemplate(getDataSource());
	}
    
    
    @Bean
	public DataSource getDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(environment.getProperty(DB_JDBC_URL));
		config.setUsername(environment.getProperty(DB_USERNAME));
		config.setPassword(environment.getProperty(DB_PASSWORD));
		config.setDriverClassName(environment.getProperty(DB_JDBC_DRIVER));
		config.setPoolName("Connection Pool");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }


}
