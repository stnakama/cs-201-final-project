package edu.usc.RestaurantReviews;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(maxAge = 3600)
public class RestaurantController {
	
	@Autowired RestaurantService rService;
	@Autowired ReviewService revService;
	
	
	@RequestMapping(value="/restaurants", method=RequestMethod.POST)
	public Restaurant createRestaurant(@RequestBody Restaurant r) {
	    return rService.createRestaurant(r);
	}
	
	@RequestMapping(value="/restaurants", method=RequestMethod.GET)
	public List<Restaurant> readRestaurants(){
		return rService.getRestaurants();
	}
	
	@RequestMapping(value="/restaurants/{restaurantID}", method=RequestMethod.GET)
	public Restaurant readRestaurant(@PathVariable(value = "restaurantID") Long restaurantID) {
		List<Restaurant> list = rService.getRestaurants();
		for(Restaurant r : list) {
			if(r.getId() == restaurantID) {
				return r;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/restaurants/cuisine/{cuisineType}", method=RequestMethod.GET)
	public List<Restaurant> getByCuisine(@PathVariable(value = "cuisineType") String cuisineType) {
		List<Restaurant> list = rService.getRestaurants();
		List<Restaurant> list2 = new ArrayList<Restaurant>();
		for(Restaurant r : list) {
			if(r.getCuisineType().toLowerCase().equals(cuisineType.toLowerCase())) {
				list2.add(r);
			}
		}
		return list2;
	}
	
	@RequestMapping(value="/restaurants/name/{name}", method=RequestMethod.GET)
	public Restaurant getByName(@PathVariable(value = "name") String name) {
		return rService.findByName(name);
	}
	
	@RequestMapping(value="/restaurants/{restaurantID}/reviews", method=RequestMethod.GET)
	public List<Review> getRestaurantReviews(@PathVariable(value = "restaurantID") Long restaurantID) {
		return revService.findByRestaurantID(restaurantID);
	}
	
	
}
