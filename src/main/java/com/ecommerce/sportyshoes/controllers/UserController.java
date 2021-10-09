package com.ecommerce.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public @ResponseBody Response saveUser(@RequestBody User user) {
		System.out.println("yse i am here");
		return userService.registerUser(user);
	}
	
	@GetMapping("/getUsers")
	public @ResponseBody Response getUsers(@RequestBody User user) {
		return userService.getUsers(user);
	}
}
