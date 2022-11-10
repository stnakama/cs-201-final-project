package edu.usc.Review.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usc.Review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}