package com.cts.projectmanagementportalbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("Sam").password(passwordEncoder().encode("aaaa")).roles("admin");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","MEMBER")
			.antMatchers(HttpMethod.POST,"/api/user/userSignUp").hasAnyRole("ADMIN","MEMBER")
			.antMatchers(HttpMethod.POST,".api/project/**").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.PUT,".api/project/**").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/story/**").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.PUT,"/api/story/**").hasAnyRole("ADMIN","MEMBER")
			.antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN");
		
		http.cors().disable();
		http.csrf().disable();
		super.configure(http);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	/*
	 * This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		web
			.ignoring()
			.antMatchers("/h2-console/**");
	}
	
}
