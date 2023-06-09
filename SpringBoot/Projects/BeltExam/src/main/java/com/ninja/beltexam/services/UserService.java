package com.ninja.beltexam.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ninja.beltexam.models.LoginUser;
import com.ninja.beltexam.models.User;
import com.ninja.beltexam.repositories.RoleRepository;
import com.ninja.beltexam.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepo, RoleRepository roleRepo,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepo.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		userRepo.save(user);
	}
	
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
    
//    public User register(User newUser, BindingResult result) {
//    
//    	
//        // Hash and set password, save user to database
//    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
//    	// Checking if user with email is already in database
//    	if(potentialUser.isPresent()) {
//    		// This means email was found in database
//    		result.rejectValue("email", "Matches", "Email is already in use!");
//    	}
//    	// Also checking if password and confirm password fields match
//    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
//    		// This means they do not match
//			result.rejectValue("confirm", "Matches", "The Confirm Password must match password!");
//		}
//    	
//    	// Check for errors. If present return null
//    	if(result.hasErrors()) {
//    		return null;
//    	}
//    	// Else register the user
//    	String hashed = BCrypt.hashpw(newUser.getPassword(), 
//    			BCrypt.gensalt());
//    	newUser.setPassword(hashed);
//    	return userRepo.save(newUser);
//        
//    }
//
//    // This method will be called from the controller
//    // whenever a user submits a login form.
//       public User login(LoginUser newLogin, BindingResult result) {
//        
//	       Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
//	       User user;
//	       // If user not found reject
//	       if(!potentialUser.isPresent()) {
//	    	   result.rejectValue("email", "Matches", "User's email not found!");
//	    	  user = null;
//	    	  // If user found check password
//	       } else {
//	       
//		       // Hash password
//		       String hashed = BCrypt.hashpw(newLogin.getPassword(), BCrypt.gensalt());
//		       // Create user from potential user
//		       user = potentialUser.get();
//		       // Check if hashed password is the same as password in database. If not reject
//		       if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
//		    	   result.rejectValue("password", "Matches", "Password is not correct");
//		       }
//	       }
//	       
//	       if(result.hasErrors()) {
//	    	   return null;
//	       }
//	       
//	       return user;
//      
//    }

	
	
}
