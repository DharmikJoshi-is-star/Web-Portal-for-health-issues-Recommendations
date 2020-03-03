package com.hashcoder.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hashcoder.enums.UserTypeEnum;
import com.hashcoder.model.HealthProffesional;
import com.hashcoder.model.Login;
import com.hashcoder.model.User;
import com.hashcoder.service.HealthProffesionalService;
import com.hashcoder.service.LoginService;
import com.hashcoder.service.UserService;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HealthProffesional healthProffesional;
	
	@Autowired
	HealthProffesionalService healthProffesionalService;
	
	@RequestMapping("/login-process")
	public String loginProcess(@Valid @ModelAttribute("login") Login login,
								BindingResult bindingResult, 
								HttpSession session,
								Model model) {
		
		User user = new User();
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("msg","");
			model.addAttribute("login",login);
			
			return "login";
		}
		
		try {
			if(loginService.checkCredentials(login)) {
				
				session.setAttribute("email", login.getEmail());
				session.setAttribute("password", login.getPassword());
				
				login = loginService.getLoginDetails(login);
				
				if(login.getType().equals(UserTypeEnum.HEALTH_PROFFESIONALIST.toString()))
					healthProffesional = healthProffesionalService.getHealthProffesionalDById(login.getC_id());
				else if(login.getType().equals(UserTypeEnum.USER.toString()))
					user = userService.getUserById(login.getC_id());
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("type", login.getType());
		return "redirect:home?user_id="+login.getC_id();
	}
}
