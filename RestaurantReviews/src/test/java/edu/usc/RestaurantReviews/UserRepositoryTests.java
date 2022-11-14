package edu.usc.RestaurantReviews;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class UserRepositoryTests {
	
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;

	@Test
	public void testCreateUser() {
	    User user = new User();
	    user.setUsername("username123");
	    user.setPassword("password123");
	    
	    User savedUser = repo.save(user);
	     
	    User existUser = entityManager.find(User.class, savedUser.getId());
	     
	    assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
	     
	}

}
