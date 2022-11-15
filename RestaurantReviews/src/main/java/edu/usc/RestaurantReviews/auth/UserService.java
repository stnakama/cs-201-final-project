package edu.usc.RestaurantReviews.auth;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
	
	@Autowired AppUserRepository uRepo;
	
    public String login(String username, String password) {
        Optional user = uRepo.login(username,password);
        if(user.isPresent()){
            String token = UUID.randomUUID().toString();
            AppUser u = (AppUser) user.get();
            u.setToken(token);
            uRepo.save(u);
            return token;
        }

        return StringUtils.EMPTY;
    }

    public Optional findByToken(String token) {
        Optional user= uRepo.findByToken(token);
        if(user.isPresent()){
        	AppUser curr = (AppUser) user.get();
        	User securityUser = new User(curr.getUsername(), curr.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(securityUser);
        }
        return  Optional.empty();
    }
	
	// CREATE 
	public AppUser createUser(AppUser u) {
	    return uRepo.save(u);
	}

	// READ
	public List<AppUser> getUsers() {
	    return uRepo.findAll();
	}

	// DELETE
	public void deleteUser(Long rId) {
	    uRepo.deleteById(rId);
	}

}
