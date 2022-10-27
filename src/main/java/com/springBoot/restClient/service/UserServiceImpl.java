package com.springBoot.restClient.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springBoot.restClient.dao.UserRepository;
import com.springBoot.restClient.model.User;

@Service(value="userService")//déclaration de cette class comme un bean de service
public class UserServiceImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Collection<User> getAllUsers(){
		return IteratorUtils.toList(userRepository.findAll().iterator());
	}

	@Override
	public User getUserById(Long id){
		Optional<User> userfindById = userRepository.findById(id);
		
		if(!userfindById.isPresent()) {
			return null;
		}
		
		User NewUserfindById = userfindById.get();
		return NewUserfindById;
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login) ;
	}

	@Override
	@Transactional(readOnly=false)
	public User saveOrUpdateUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
