package edu.usc.RestaurantReviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
	
	@Autowired UserRepository uRepo;
	
	// CREATE 
	public String createUser(User u) {
	    try { 
	    	uRepo.save(u);
	    }
	    catch(DataIntegrityViolationException e) {
	    	return "false";
	    }
	    
	    return "true";
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
