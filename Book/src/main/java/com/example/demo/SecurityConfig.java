package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal1(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic()
		.disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/books").permitAll()
		.antMatchers(HttpMethod.GET,"/books/*").permitAll()
		.antMatchers(HttpMethod.POST,"/books").hasRole("ADMIN")
		.antMatchers(HttpMethod.PATCH,"/books/*").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/books/*").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.csrf().disable();
	}
	
	
}