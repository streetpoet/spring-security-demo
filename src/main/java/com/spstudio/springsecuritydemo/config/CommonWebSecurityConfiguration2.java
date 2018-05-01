package com.spstudio.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(3)
@Configuration
public class CommonWebSecurityConfiguration2 extends WebSecurityConfigurerAdapter {

	// @formatter:off

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/userSetting2/**")
				.authorizeRequests()
					.anyRequest().authenticated()
					.and()
			.formLogin()
				.loginPage("/login2")
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.and();
	}
	// @formatter:on
}