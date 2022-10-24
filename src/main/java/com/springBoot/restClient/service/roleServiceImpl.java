package com.springBoot.restClient.service;

import java.util.Collection;
import java.util.stream.Stream;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.restClient.dao.RoleRepository;
import com.springBoot.restClient.model.Role;


@Service(value="roleService")
public class roleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByroleName(roleName);
	}

	@Override
	public Collection<Role> getAllRoleNames(){
		return IteratorUtils.toList(roleRepository.findAll().iterator());
	}

	@Override
	public Stream<Role> getAllRoleStream(){
		return roleRepository.getAllRolesStream();
	}

}
