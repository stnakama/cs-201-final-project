package edu.usc.RestaurantReviews;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired UserService uService;
	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User createRestaurant(@RequestBody User u) {
	    return uService.createUser(u);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> readRestaurants(){
		return uService.getUsers();
	}
	
	
}
