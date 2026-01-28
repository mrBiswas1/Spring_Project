package com.kodewala.mmt.profile.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodewala.mmt.profile.bean.UserProfile;

@Controller
public class ProfileController {
	
    @RequestMapping("/showProfilePage")
	public String showProfilePage()
	{
    	System.out.println("Displaying profile page to the client/user");
		return "profile";
	}
    @PostMapping ("/createProfile")
    public String createUserProfile(@ModelAttribute UserProfile userProfile)
    {
    	System.out.println("First Name : " +userProfile.getFirstName());
    	System.out.println("Last Name :" +userProfile.getLastName());
    	System.out.println("Email :" +userProfile.getEmail());
    	System.out.println("Mobile :" +userProfile.getMobile());
    	return "profile-success";
    }
}
