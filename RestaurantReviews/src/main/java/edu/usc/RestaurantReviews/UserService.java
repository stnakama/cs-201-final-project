package edu.usc.RestaurantReviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	
	@Autowired UserRepository uRepo;
	
	// CREATE 
	public User createUser(User u) {
	    return uRepo.save(u);
	}

	// READ
	public List<User> getUsers() {
	    return uRepo.findAll();
	}

	// DELETE
	public void deleteUser(Long rId) {
	    uRepo.deleteById(rId);
	}
	
	public User findByUsername(String username) {
		return uRepo.findByUsername(username);
	}
}
