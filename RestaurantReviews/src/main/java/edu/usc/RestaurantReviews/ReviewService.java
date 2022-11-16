package edu.usc.RestaurantReviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
	@Autowired
    ReviewRepository revRepository; 
	
	//CRUD operations
	//Create
	public Review createReview(Review r ) {
		return revRepository.save(r);
	}
	
	//Read
	public List<Review> readReview() {
		return revRepository.findAll();
	}
	
	//Update
	public Review updateReview(Long userID, Review reviewDetails) {
	        Review rev = revRepository.findById(userID).get();
	        rev.setReviewID(reviewDetails.getReviewID());
	        rev.setUserID(reviewDetails.getUserID());
	        rev.setRestID(reviewDetails.getRestID());
	        rev.setTextRev(reviewDetails.getTextRev());
	        rev.setTimePosted(reviewDetails.getTimePosted());
	        
	        return revRepository.save(rev);                                
	}
	
	//Delete
	public void deleteReview(Long userID) {
	    revRepository.deleteById(userID);
	}
}

