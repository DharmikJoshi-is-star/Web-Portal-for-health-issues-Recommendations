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

import com.hashcoder.model.Login;
import com.hashcoder.model.User;
import com.hashcoder.service.LoginService;
import com.hashcoder.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	User user;
	
	@Autowired
	Login login;
	
	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", user);
		
		return "register";
	}
	
	@RequestMapping("/register-process")
	public String registerFormProcess(@Valid @ModelAttribute("login") User user,
										BindingResult bindingResult, 
										HttpSession session,
										Model model) {
		
		try {
			loginService.registerUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		login.setEmail(user.getEmail());
		model.addAttribute("login", login);
		return "login";
	}
}
