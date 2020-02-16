package com.tweet.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web Security Config.
 * @author santh
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * {@inheritDoc}
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/index.js", "/home.js")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/index.html")
            .defaultSuccessUrl("/home.html", true)
            .loginProcessingUrl("/perform_login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

}
