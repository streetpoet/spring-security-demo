package com.spstudio.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CommonWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// @formatter:off
	private final String[] WHITE_LIST = new String[] { "/", "/login" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(WHITE_LIST)
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
			.formLogin();
	}
	// @formatter:on
}