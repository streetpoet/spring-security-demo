package com.spstudio.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(2)
@Configuration
public class CommonWebSecurityConfiguration1 extends WebSecurityConfigurerAdapter {

	// @formatter:off

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/userSetting/**")
				.authorizeRequests()
					.anyRequest().authenticated()
					.and()
			.formLogin()
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.and();
	}
	// @formatter:on
}