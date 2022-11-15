package edu.usc.RestaurantReviews.auth;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	@Query(value = "SELECT u FROM User u where u.userName = ?1 and u.password = ?2 ")
    Optional login(String username,String password);
    Optional findByToken(String token);
    
}
