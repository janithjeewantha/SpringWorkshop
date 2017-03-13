package com.ead.registrationform;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ead.pojo.User;
import com.ead.services.UserManager;

@Controller
public class HomeController {
	
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String signUp(Model model,
			@ModelAttribute User user) {
		
		boolean signUpProcess = true;
		boolean signUpSuccess = false;
		
		boolean userExists = !userManager.checkUserExists(user);
		boolean userRegistered = userManager.registerUser(user);
		
		model.addAttribute("signUpProcess", signUpProcess );
		
		if(userExists && userRegistered){
			signUpSuccess = true;			
			model.addAttribute("signUpSuccess", signUpSuccess );
		}else {
			signUpSuccess = false;
			model.addAttribute("signUpSuccess", signUpSuccess );			
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session,
			@ModelAttribute User user) {
		
		String view = null;
		boolean logInProcess = true;
		boolean loginSuccess = false;
		boolean signUpProcess = false;
		
		User loggedUser = userManager.login(user);
		
		if(loggedUser != null){
			model.addAttribute("user", loggedUser);
			view = "profile";
		}else{
			loginSuccess = false;
			model.addAttribute("logInProcess", logInProcess );
			model.addAttribute("loginSuccess", loginSuccess );
			model.addAttribute("signUpProcess", signUpProcess );
			view = "home";
		}
				
		return view;
	}
	
}



