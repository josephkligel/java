package com.ninja.beltexam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.beltexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);
}
