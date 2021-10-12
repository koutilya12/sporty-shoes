package com.ecommerce.sportyshoes.controllers;

import java.net.http.HttpRequest;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
	
	@PostMapping("/changePassword") 
	public @ResponseBody  Response changePassword(@RequestBody ObjectNode  requestMap) {
		User user= null;
		String newPassword = null;
		System.out.println(requestMap.toString());
		if(requestMap.get("user") != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				user  = mapper.treeToValue(requestMap.get("user"), User.class);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//user = (User) requestMap.get("user");

		if(requestMap.get("newPassword") != null) {
			newPassword  = requestMap.get("newPassword").asText();
		}
		
		System.out.println("ss"+ user.toString());
		System.out.print("qwq"+newPassword);
		return userService.changePassword(user, newPassword);
	}
}
