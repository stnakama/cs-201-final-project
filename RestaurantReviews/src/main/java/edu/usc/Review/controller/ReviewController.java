package edu.usc.Review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.usc.Review.model.Review;
import edu.usc.Review.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {
	@Autowired
    ReviewService revService;
	
	@RequestMapping(value="/Review", method=RequestMethod.POST)
	public Review createReview(@RequestBody Review rev ) {
	    return revService.createReview(rev);
	}
	
	@RequestMapping(value="/Review", method=RequestMethod.GET)
	public List<Review> readReviews() {
	    return revService.readReview();
	}

	@RequestMapping(value="/Review/{userID}", method=RequestMethod.PUT)
	public Review readReviews(@PathVariable(value = "userID") Long userid, @RequestBody Review revDetails) {
	    return revService.updateReview(userid, revDetails);
	}

	@RequestMapping(value="/Review/{userID}", method=RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "userId") Long id) {
	    revService.deleteReview(id);
	}
	
}
