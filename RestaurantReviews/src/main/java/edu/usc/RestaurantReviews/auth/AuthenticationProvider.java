package edu.usc.RestaurantReviews.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	UserService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

	}
	
	//TODO template code had error
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) 
			throws AuthenticationException {
		Object token = authentication.getCredentials();
		  
		try {
			return (UserDetails) Optional
			   .ofNullable(token)
			   .map(String::valueOf)
			   .flatMap(userService::findByToken)		   
			   .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("Cannot find user with authentication token=" + token);
	}

}
