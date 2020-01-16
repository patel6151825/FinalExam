package com.johnabbott.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.simple.model.UserEntity;
import com.johnabbott.simple.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	//http://localhost:8080/UserLogin/adduser
	@RequestMapping(value = "adduser")
	public ModelAndView addUser() {

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new UserEntity());
		return mv;

	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("user") UserEntity user) {

		if (service.addUser(user))
			return "redirect:/loginpage";

		else {

			return "ErrorPage";

		}

	}
	
	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") UserEntity user) {

//		if (service.getUserById(user))
//			return "redirect:/home";
//
//		else {
//
//			return "redirect:/adduser";
//
//		}
		return "redirect:/adduser";

	}
	
	//http://localhost:8080/UserLogin/loginpage
	@RequestMapping(value = "loginpage")
	public ModelAndView ckeckUser() {

		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new UserEntity());
		return mv;

	}
	
	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)

	public ModelAndView getUser(@PathVariable("email") String email) {

		ModelAndView modelView = new ModelAndView("user");

		modelView.addObject("email", email);

		return modelView;

	}
}
