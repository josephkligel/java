package com.ninja.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.beltexam.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	public List<Role> findAll();
	
	public List<Role> findByName(String name);
}
