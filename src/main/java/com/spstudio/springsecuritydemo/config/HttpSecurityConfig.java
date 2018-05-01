package com.spstudio.springsecuritydemo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

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

}