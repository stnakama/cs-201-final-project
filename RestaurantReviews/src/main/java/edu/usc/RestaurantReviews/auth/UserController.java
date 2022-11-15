package edu.usc.RestaurantReviews.auth;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired UserService uService;
	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public AppUser createUser(@RequestBody AppUser u) {
	    return uService.createUser(u);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<AppUser> readUsers(){
		return uService.getUsers();
	}
	
	@RequestMapping(value="/token", method=RequestMethod.POST)
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
       String token= uService.login(username,password);
       if(StringUtils.isEmpty(token)){
           return "no token found";
       }
       return token;
    }
	
}
