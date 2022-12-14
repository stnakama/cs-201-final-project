package edu.usc.RestaurantReviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(maxAge = 3600)
public class UserAuthController {
	
	@Autowired UserService uService;

	//don't need this page - use endpoint for something else?
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		//TODO: same with process_register, we need to change the return value
		return "logout";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "signup_form";
	}
	
	@PostMapping("/process_register")
	@ResponseBody
	public String processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    return uService.createUser(user);
	    
	}
	
	@GetMapping("/isAuthorized")
	@ResponseBody
	public boolean isUserLoggedIn(){	
		return !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser");
	}
	
	@GetMapping("/getUsername")
	@ResponseBody
	public String getUsername(){	
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
