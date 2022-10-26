package com.springBoot.restClient.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;


import javax.transaction.Transactional;

import org.apache.tomcat.util.net.TLSClientHelloExtractor.ExtractorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.restClient.model.Role;
import com.springBoot.restClient.model.User;
import com.springBoot.restClient.service.RoleService;
import com.springBoot.restClient.service.UserServices;

@Controller
@CrossOrigin(origins="http://localhost:8080",maxAge = 3600)
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServices userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value="/users")
	public ResponseEntity<Collection<User>>getAllUsers(){
	  Collection<User>users =userService.getAllUsers();
	  logger.info("Liste des utilisateurs:",users.toString());
	  return new ResponseEntity<Collection<User>>(users,HttpStatus.FOUND);
	}
	
	@PostMapping(value="/users")
	@Transactional
	public ResponseEntity<User>saveUser(@RequestBody User user){
		Set<Role>roles = new HashSet<Role>();
		Role roleUser = new Role("ROLE_USER");
		roles.add(roleUser);
		user.setRoles(roles);
		user.setActive(0);
		
		Set<Role>roleFromDB=extractRole_Java8(user.getRoles(),roleService.getAllRoleStream());
		user.getRoles().removeAll(user.getRoles());
		user.setRoles(roleFromDB);
		User userSave = userService.saveOrUpdateUser(user);
		logger.info("userSave: "+userSave.toString());
		
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/Users/{loginName}")
	public ResponseEntity<User>findByUserLogin(@PathVariable("loginName")String login){
		User user = userService.findByLogin(login);
		logger.debug("Utilisateur trouvé :" +user);
		
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	public ResponseEntity<User>updateUser(@PathVariable(value = "id")Long id,@RequestBody User user){
		User userToUpdate=userService.getUserById(id);
		
		if(userToUpdate==null) {
			logger.debug("l'utilisateur avec l'identifiant"+id+ "n'existe pas");
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		
		 logger.info("UPDATE ROLE: "+userToUpdate.getRoles().toString());
		 userToUpdate.setLogin(user.getLogin());
		 userToUpdate.setPassword(user.getPassword());
		 userToUpdate.setActive(user.getActive());
	     User userUpdated = userService.saveOrUpdateUser(userToUpdate);
		
		return new ResponseEntity<User>(userToUpdate,HttpStatus.OK);
	}
	
	
	
	private Set<Role>extractRole_Java8(Set<Role>rolesSetFromUser, Stream<Role>roleStreamFromDB){
		
		Set<String>uiRoleNames = rolesSetFromUser.stream()
				.map(Role::getRolename)
				.collect(Collectors.toCollection(HashSet::new));
		
		return roleStreamFromDB.filter(role->uiRoleNames.contains(role.getRolename()))
				.collect(Collectors.toSet());
	}
	
//	private Set<Role> extractRoleUsingCompareTo_Java8(Set<Role> rolesSetFromUser,
//			Stream<Role> roleStreamFromDB) {
//			 return roleStreamFromDB
//			 .filter(roleFromDB -> rolesSetFromUser.stream()
//			 .anyMatch( roleFromUser -> roleFromUser.compareTo(roleFromDB) == 0))
//			 .collect(Collectors.toCollection(HashSet::new));
//		 }
	
}
