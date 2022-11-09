package com.cts.projectmanagementportalbackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.security.UserDetailsServiceImpl;
import com.cts.projectmanagementportalbackend.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
//	@Autowired
//	UserService userService;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		log.info("inside HttpSecurity configure of WebSecurityConfig");
		
		auth.inMemoryAuthentication().withUser("Sam").password(passwordEncoder().encode("aaaa")).roles("admin");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		auth.authenticationProvider(authProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		log.info("inside HttpSecurity configure of WebSecurityConfig");
		http.authorizeRequests()
//			.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN")
//			.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
//			.antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","MEMBER")
//			.antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
			
//			.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","MEMBER")
			
//			
//			.antMatchers(HttpMethod.GET,"/api/v1.0/user/getAllProjects").hasAnyRole("ADMIN")
//			.antMatchers(HttpMethod.GET,"/api/v1.0/user/getProjectById/{projectId}").hasAnyRole("ADMIN")
//			.antMatchers(HttpMethod.POST,"/api/v1.0/project/registerProject").hasAnyRole("ADMIN")
//			
//			.antMatchers(HttpMethod.GET,"/api/v1.0/story/getAllStories").hasAnyRole("ADMIN")
//			.antMatchers(HttpMethod.POST,"/api/v1.0/story/registerStory").hasAnyRole("ADMIN")
//			.antMatchers(HttpMethod.PUT,"/api/v1.0/story/updateStory/**").hasAnyRole("ADMIN","MEMBER")
//			.antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
			
//			.antMatchers(HttpMethod.POST,"/api/v1.0/user/getUserById/{userId}").access("@userSecurity.hasUserId(authenticate,#userId)")
			.antMatchers(HttpMethod.GET,"/api/v1.0/user/helloWorld").permitAll()
			.antMatchers(HttpMethod.GET,"/api/v1.0/user/getAllUsers/**").permitAll()
			.antMatchers(HttpMethod.POST,"/api/v1.0/user/login1").permitAll()
			.antMatchers(HttpMethod.POST,"/api/v1.0/user/userSignUp").permitAll()
			.antMatchers(HttpMethod.POST,"/api/v1.0/user/login/**").permitAll()
//			.anyRequest().authenticated().and().httpBasic()
//			.and().formLogin().defaultSuccessUrl("/welcome",true)
		;
		
		http.cors();
		http.csrf().disable();
//		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated().and().httpBasic();
		super.configure(http);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("inside PasswordEncoder passwordEncoder of WebSecurityConfig");
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		log.info("inside PasswordEncoder encoder BCryptPasswordEncoder of WebSecurityConfig");
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public DaoAuthenticationProvider authProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
	
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		return new UserDetailsServiceImpl();
//	}
	
	
	/*
	 * This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		log.info("inside WebSecurity configure of WebSecurityConfig");
		web
			.ignoring()
			.antMatchers("/h2-console/**")
			.antMatchers("/swagger");
	}
}