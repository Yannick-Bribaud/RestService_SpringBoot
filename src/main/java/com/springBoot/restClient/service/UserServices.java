package com.springBoot.restClient.service;

import java.util.Collection;
import java.util.Optional;

import com.springBoot.restClient.exception.BusinessResourceException;
import com.springBoot.restClient.model.User;

public interface UserServices{
	
	
	Collection<User>getAllUsers();
	
	User getUserById(Long id)throws BusinessResourceException;
	
	User findByLogin(String login)throws BusinessResourceException;
	
	User saveOrUpdateUser(User user)throws BusinessResourceException;
	
	void deleteUser(Long id)throws BusinessResourceException;
	
	
	
	
	
}
