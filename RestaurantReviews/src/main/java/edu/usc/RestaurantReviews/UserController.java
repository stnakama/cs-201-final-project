package edu.usc.RestaurantReviews;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(maxAge = 3600)
public class UserController {
	
	@Autowired UserService uService;
	@Autowired ReviewService revService;
	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User createUser(@RequestBody User u) {
	    return uService.createUser(u);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> readUsers(){
		return uService.getUsers();
	}
	
	@RequestMapping(value="/users/{userID}", method=RequestMethod.GET)
	public User readReview(@PathVariable(value = "userID") Long userID) {
		List<User> list = uService.getUsers();
		for(User u : list) {
			if(u.getId() == userID) {
				return u;
			}
		}
		return null;
	}
	
	@RequestMapping(value="users/username/{username}", method=RequestMethod.GET)
	public User findByUsername(@PathVariable(value="username") String username) {
		return uService.findByUsername(username);
	}
	
	@RequestMapping(value="/users/{userID}/reviews", method=RequestMethod.GET)
	public List<Review> getUserReviews(@PathVariable(value = "userID") Long userID) {
		return revService.findByUserID(userID);
	}
		
	@PostMapping("/process_register")
	public String processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    uService.createUser(user);
	     
	    return "register_success";

	}
}
