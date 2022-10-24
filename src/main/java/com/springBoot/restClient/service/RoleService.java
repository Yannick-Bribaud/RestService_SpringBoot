package com.springBoot.restClient.service;

import java.util.Collection;
import java.util.stream.Stream;

import com.springBoot.restClient.model.Role;

public interface RoleService {
	
	Role findByRoleName(String roleName);
	
	Collection<Role>getRoleNames();
	
	Stream<Role>getAllRoleStream();
}
