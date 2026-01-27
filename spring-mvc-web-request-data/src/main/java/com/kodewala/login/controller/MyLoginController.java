package com.kodewala.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyLoginController
{
	@RequestMapping("/showLogin")
 public String showLoginPage()
 {
	 System.out.println("MyLoginController.showLoginPage()::::::::::::::");
	 
	 return "login";
 }
	@RequestMapping("/validationLogin")
	public String dologin(@RequestParam ("userName") String userName, @RequestParam ("password") String password)
	{
		System.out.println("MyLoginController.dologin().................");
		
		System.err.println("User name is : " + userName);
		System.out.println("Password : " + password);
		return "loginSuccessful";
	}
}
