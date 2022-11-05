package edu.usc.RestaurantReviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestaurantReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewsApplication.class, args);
	}

}


@RestController
class Test {
	@GetMapping("/")
	public String msg() {
		return "Test Message: CSCI201 Group Project - RestaurantReviews";
	}
}
