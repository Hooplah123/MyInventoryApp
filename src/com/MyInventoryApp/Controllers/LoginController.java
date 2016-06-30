package com.MyInventoryApp.Controllers;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MyInventoryApp.DTO.User;
import com.MyInventoryApp.Service.IUserService;

@Controller
public class LoginController {

	@Inject
	public IUserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleLoginRequest(User user, ModelMap model) {
		if (!userService.validateUser(user)) {
			model.put("error", "Invalid User Credentials! Please Try Again:");
			return "login";
		}
		model.put("name", user.getUsername());
		model.put("password", user.getPassword());
		return "inventory";
	}
	
	String retrieveLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
	
}
