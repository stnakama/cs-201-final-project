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
public class RestaurantController {
	
	@Autowired RestaurantService rService;
	
	
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
	
}
