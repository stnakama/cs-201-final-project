package edu.usc.RestaurantReviews;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@SpringBootApplication
public class RestaurantReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewsApplication.class, args);
	}

}
