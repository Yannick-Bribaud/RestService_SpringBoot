package com.springBoot.restClient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.restClient.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);

}
