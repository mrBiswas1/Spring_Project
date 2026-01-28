package com.zepto.password.reset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.password.reset.bean.UserProfile;
import com.zepto.password.reset.service.UserService;

	@RestController
	@RequestMapping("/RESTful-password-reset-api")
	public class UserController {

	    @Autowired
	    UserService userService;

	    @PostMapping("/register")
	    public String createAccount(@RequestBody UserProfile userProfile) {

	        // calling service to register user
	        String result = userProfile.getUserName(userProfile.get);

	        return result;   // return success / error message
	    }

	    @PostMapping("/resetPassword")
	    public ResponseEntity<String> resetPassword(@RequestBody UserProfile profile) {
	        boolean success = userService.resetPassword(profile.getUserName(), profile.getPassword());
	        if (success)
	            return ResponseEntity.ok("Password reset successful");
	        else
	            return ResponseEntity.badRequest().body("Password reset failed: last 3 chars cannot be reused");
	    }
	}


}
