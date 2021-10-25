package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication

		// in 5.0.2 security version User.withDefaultPasswordEncoder() has been
		// deprecated
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(users.username("shubham").password("helu@1234").roles("ADMIN", "EMPLOYEE"))
				.withUser(users.username("payal").password("helu@1234").roles("MANAGER", "EMPLOYEE"))
				.withUser(users.username("shreya").password("helu@1234").roles("EMPLOYEE"));
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
