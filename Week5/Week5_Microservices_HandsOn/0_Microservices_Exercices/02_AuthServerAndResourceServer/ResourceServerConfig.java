package com.reethika.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 🔐 disable CSRF
                .authorizeRequests()
                .anyRequest().permitAll() // ✅ allow all without login
                .and()
                .httpBasic().disable() // ❌ no basic auth
                .formLogin().disable(); // ❌ no form login
    }
}
