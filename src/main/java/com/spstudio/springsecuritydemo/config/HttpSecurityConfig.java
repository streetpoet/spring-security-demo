package com.spstudio.springsecuritydemo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spstudio.springsecuritydemo.entity.User;
import com.spstudio.springsecuritydemo.repository.UserRepository;

@EnableWebSecurity
public class HttpSecurityConfig {

	@Bean
	UserDetailsService jpaUserDetailsService() {
		return new UserDetailsService() {

			@Autowired
			UserRepository repository;

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				List<User> users = repository.findByUsername(username);
				if (CollectionUtils.isEmpty(users)) {
					throw new UsernameNotFoundException(String.format("Username {%s} not found", username));
				}
				return users.iterator().next();
			}
		};
	}

	@Configuration
	@Order(1)
	public static class LoginConfig extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.antMatcher("/login")
				.authorizeRequests()
					.anyRequest()
					.permitAll()
					.and()
				.formLogin();
			// @formatter:on
		}
	}
	
	@Configuration
	@Order(2)
	public static class LoginConfig2 extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.antMatcher("/login2")
				.authorizeRequests()
					.anyRequest()
					.permitAll()
					.and()
				.formLogin();
			// @formatter:on
		}
	}

	@Configuration
	@Order(3)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.antMatcher("/userSetting/**")
				.authorizeRequests()
					.anyRequest()
					.hasRole("SPECIAL")
					.and()
				.formLogin();
			// @formatter:on
		}
	}

	@Configuration
	@Order(4)
	public static class FormLoginWebSecurityConfigurerAdapter2 extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.antMatcher("/userSetting2/**")
				.authorizeRequests()
					.anyRequest()
					.authenticated()
					.and()
				.formLogin()
					.loginPage("/login2");
			// @formatter:on
		}
	}
	
}