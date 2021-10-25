package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	// here adding logout support using .and().logout().permitAll()
	// antMatchers is your path and hasRole is the role who has access to this path
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				/* .anyRequest().authenticated() */ // commenting because we are resricting the user on the basis of
													// roles
				// ** means all sub directories
				.antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN").and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll()
				// adding a custom "Access Denied Page"
				.and().exceptionHandling().accessDeniedPage("/access-denied"); /// access-denied request mapping path in
																				/// controller
	}

}
