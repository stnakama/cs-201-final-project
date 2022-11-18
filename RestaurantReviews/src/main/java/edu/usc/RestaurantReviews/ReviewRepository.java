package edu.usc.RestaurantReviews;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> findByRestaurantid(Long rId);
}