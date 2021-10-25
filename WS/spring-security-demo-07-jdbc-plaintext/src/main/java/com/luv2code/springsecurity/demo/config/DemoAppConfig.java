package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc // provide similar functionality to <mvc:annotation-driven>
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
// read the properties file using @PropertySource from src/main/resources
// src/main/resources is a standard maven directory and during the maven build files will automatically copied to the classpath
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// set up a variable to hold the properties
	// this env holds the data read from properties file (Environment is a helper
	// class from spring framework)
	@Autowired
	private Environment env;

	// setup a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());

	// define a bean for view resolver
	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// define a bean for for our security datasource
	@Bean
	public DataSource securityDataSource() {

		// create a connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// setup the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// log the connection props
		// for sanity's sake
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.driver"));
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.user"));

		// set db connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;

	}

	// need a helper method
	// read env. property and convert to int
	private int getIntProperty(String propName) {
		String propertyValue = env.getProperty(propName);
		return Integer.parseInt(propertyValue);
	}
}
