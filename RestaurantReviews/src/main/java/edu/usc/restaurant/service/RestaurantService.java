package edu.usc.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usc.restaurant.model.Restaurant;
import edu.usc.restaurant.repository.RestaurantRepository;

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
