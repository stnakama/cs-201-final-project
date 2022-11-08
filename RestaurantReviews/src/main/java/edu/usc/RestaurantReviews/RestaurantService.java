package edu.usc.RestaurantReviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
	
	@Autowired RestaurantRepository rRepo;
	
	// CREATE 
	public Restaurant createRestaurant(Restaurant r) {
	    return rRepo.save(r);
	}

	// READ
	public List<Restaurant> getRestaurants() {
	    return rRepo.findAll();
	}

	// DELETE
	public void deleteRestaurant(Long rId) {
	    rRepo.deleteById(rId);
	}
}
