package com.springBoot.restClient.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springBoot.restClient.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	 Role findByroleName(String rolename);	
	
	 
	 @Query("Select role from Role role")
	
	 Stream<Role>getAllRolesStream();
}
