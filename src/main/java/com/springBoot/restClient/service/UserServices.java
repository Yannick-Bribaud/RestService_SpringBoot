package com.springBoot.restClient.service;

import java.util.Collection;

import com.springBoot.restClient.model.User;

public interface UserServices{
	
	
	Collection<User>getAllUsers();
	
	User getByUserById(Long id);
	
	User findByLogin(String login);
	
	User saveOrUpdateUser(User user);
	
	void deleteUser(Long id);
	
	
	
	
	
}
