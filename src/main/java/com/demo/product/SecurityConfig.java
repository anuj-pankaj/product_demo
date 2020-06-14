package com.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
/**
 * 
 * @author Anuj Pankaj
 * 
 * Spring security  configuration class to Role based access
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/productdemo/sold").access("hasRole('ROLE_ADMIN')")
         .and()
         .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
        auth.inMemoryAuthentication()
        .withUser("anuj").password("{noop}anuj@123").authorities("ROLE_USER")
		.and()
		.withUser("pankaj").password("{noop}pankaj@123").authorities("ROLE_USER","ROLE_ADMIN");
            
    }
}
