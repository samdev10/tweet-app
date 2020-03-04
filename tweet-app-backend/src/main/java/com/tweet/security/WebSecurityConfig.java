package com.tweet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tweet.security.jwt.JwtConfigurer;
import com.tweet.security.jwt.JwtTokenProvider;
import com.tweet.service.impl.MongoUserDetailsService;

/**
 * Web Security Config.
 * @author santh
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MongoUserDetailsService userDetailsService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.httpBasic()
            .disable()
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/index*", "/*.js", "/*.json", "/*.ico")
            .permitAll()
            .antMatchers("/auth/signin", "/")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .apply(new JwtConfigurer(jwtTokenProvider));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    /**
     * @return password encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
