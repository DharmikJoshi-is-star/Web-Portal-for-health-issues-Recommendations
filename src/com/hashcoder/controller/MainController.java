package com.hashcoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hashcoder.model.Login;

@Controller
public class MainController {

	@Autowired
	Login login;
	
	@RequestMapping("/")
	public String returnIndex(Model model) {
		
		model.addAttribute("msg","");
		model.addAttribute("login",login);
		
		return "login";
	}
	
}
