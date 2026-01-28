package com.dailyShop.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dailyShop.bean.ReSellerProfile;
import com.dailyShop.hibernate.connection.HibernateCfg;

@Controller
public class ProfileController {

	String oldEmail;
	String oldPassword;

	@RequestMapping("/showRe-sellerProfile")
	public String showProfilePage() {
		System.out.println("Displaying profile page to client/user");
		return "profile";
	}

	@PostMapping("/createReSellerProfile")
	public String createResellerProfile(@ModelAttribute ReSellerProfile reSellerProfile, Model model) {
		System.out.println("First Name : " + reSellerProfile.getFirstName());
		System.out.println("Last Name : " + reSellerProfile.getLastName());
		System.out.println("Email : " + reSellerProfile.getEmail());
		System.out.println("Mobile : " + reSellerProfile.getMobile());
		System.out.println("Password : " + reSellerProfile.getPassword());

		HibernateCfg hibernateCfg = new HibernateCfg();

		Session session = hibernateCfg.hibernateconfigure();

		Transaction transaction = session.beginTransaction();
		
		session.save(reSellerProfile);
		transaction.commit();
		this.oldEmail = reSellerProfile.getEmail();
		this.oldPassword = reSellerProfile.getPassword();
		String email = reSellerProfile.getEmail();
		String mobile = reSellerProfile.getMobile();

		String userId = generateUserId(email, mobile);

		model.addAttribute("userId", userId);

		System.out.println(" Generated user id is :::::::::::: " + userId);
		return "signup-success";
	}

	public static String generateUserId(String email, String mobile) {
		String username = email.split("@")[0];
		String first4 = username.length() >= 4 ? username.substring(0, 4) : username;
		String last4 = mobile.substring(mobile.length() - 4);
		return first4 + last4;
	}

	@PostMapping("/validateUser")
	public String validateReSeller(@RequestParam("email") String email, @RequestParam("password") String password) {
		boolean result = validateEmailPassword(email, password);

		if (result == true) {
			return "mainPage";
		} else {
			return "login-fail";
		}
	}

	public boolean validateEmailPassword(String email, String password) {
		if (oldEmail.equals(email) && oldPassword.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
