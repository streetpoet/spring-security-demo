package com.spstudio.springsecuritydemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spstudio.springsecuritydemo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByUsername(String username);
}
