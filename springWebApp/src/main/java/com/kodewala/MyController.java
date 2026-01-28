package com.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("LoginController.login()......!");

		ModelAndView mv = new ModelAndView();

		mv.setViewName("displayLogin");
		return mv;
	}
	
	@RequestMapping("/logincred")
	public ModelAndView loginSucc() {
		System.out.println("LoginController.loginSucc()......!");

		ModelAndView mv = new ModelAndView();

		mv.setViewName("loginsuccess");
		return mv;
	}


}
