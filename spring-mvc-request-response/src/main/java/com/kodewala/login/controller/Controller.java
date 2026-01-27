package com.kodewala.login.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodewala.login.controller.bean.UserLogin;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping ("/showLogin")
	public String showLoginPage()
	{;
		System.out.println("Controller.showLogin()");
		return "login";
	}
		@PostMapping("/createProfile") // requestmapping + method type = post
		public String createUserProfile(@ModelAttribute UserLogin userLogin, Model model) {

			System.out.println(" First Name : " + userLogin.getFirstName());
			System.out.println(" Last Name : " + userLogin.getLastName());
			System.out.println(" Email Name : " + userLogin.getEmail());
			System.out.println(" mobile : " + userLogin.getPhoneNumber());

			String email = userLogin.getEmail();
			String mobile = userLogin.getPhoneNumber();
			
			String userId = generateUserId(email, mobile);

			model.addAttribute("userID", userId);
			
			System.out.println(" Generated user id is :::::::::::: " + userId);
			return "success";
		}

		public static String generateUserId(String email, String mobile) {
			String username = email.split("@")[0];
			String first4 = username.length() >= 4 ? username.substring(0, 4) : username;
			String last4 = mobile.substring(mobile.length() - 4);
			return first4 + last4;
		}

	}
