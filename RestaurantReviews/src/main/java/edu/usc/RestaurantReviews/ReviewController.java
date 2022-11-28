package edu.usc.RestaurantReviews;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(maxAge = 3600)
public class ReviewController {
	
	@Autowired ReviewService revService;
	@Autowired UserService uService;
	@Autowired RestaurantService restService;
	
	@RequestMapping(value="/reviews", method=RequestMethod.POST)
	public Review createReview(@RequestBody Review rev ) {
	    Review r = revService.createReview(rev);
	    
	    // Set username
	    List<User> users = uService.getUsers();
	    for(User u : users) {
	    	if(u.getId() == r.getUserID()) {
	    		r.setUsername(u.getUsername());
	    		break;
	    	}
	    }
	    
	    // Set restaurantName
	    List<Restaurant> restaurants = restService.getRestaurants();
	    for(Restaurant rest : restaurants) {
	    	if(rest.getId() == r.getRestID()) {
	    		r.setRestaurantName(rest.getName());
	    		break;
	    	}
	    }
	    
	    return r;
	}
	
	@RequestMapping(value="/reviews", method=RequestMethod.GET)
	public List<Review> readReviews() {
	    return revService.readReview();
	}
	
	
	@RequestMapping(value="/reviews/{reviewID}", method=RequestMethod.GET)
	public Review readReview(@PathVariable(value = "reviewID") Long reviewID) {
		List<Review> list = revService.readReview();
		for(Review r : list) {
			if(r.getReviewID() == reviewID) {
				return r;
			}
		}
		return null;
	}

	
	
	/*
	@RequestMapping(value="/reviews/{reviewID}", method=RequestMethod.PUT)
	public Review readReviews(@PathVariable(value = "reviewID") Long reviewid, @RequestBody Review revDetails) {
	    return revService.updateReview(reviewid, revDetails);
	}

	@RequestMapping(value="/reviews/{reviewID}", method=RequestMethod.DELETE)
	public void deleteReviews(@PathVariable(value = "reviewId") Long id) {
	    revService.deleteReview(id);
	}*/
	
}
