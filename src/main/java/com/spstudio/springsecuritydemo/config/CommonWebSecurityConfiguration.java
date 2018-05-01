package com.spstudio.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@Configuration
public class CommonWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// @formatter:off

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/")
			.antMatcher("/login")
			.authorizeRequests()
				.anyRequest()
				.permitAll()
				.and();
	}
	// @formatter:on
}