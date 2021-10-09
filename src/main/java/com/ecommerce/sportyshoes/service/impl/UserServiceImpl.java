package com.ecommerce.sportyshoes.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.dao.UserDao;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.helpers.Validator;
import com.ecommerce.sportyshoes.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public Response registerUser(User user) {
		System.out.println("hi");
		String errorMessage = Validator.validateUser(user);
		if (errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		userDao.save(user);
		if (user.getUserId() == null) {
			return new Response(SportyShoesConstants.FAILED, "Registration Failed");
		}
		return new Response(SportyShoesConstants.SUCCESS);
	}

	@Override
	public Response loginUser(User user) {
		String errorMessage = Validator.validateLogin(user);
		if (errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		if(userDao.validateLogin(user.getEmailId(),user.getPassword()) != null) {
			return new Response(SportyShoesConstants.SUCCESS);
		}else {
			return new Response(SportyShoesConstants.FAILED, "Invalid credentials");
		}
	}

	@Override
	public Response getUsers(User user) {
		String errorMessage = Validator.validateGetUsers(user);
		if(errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		List<User> users = null;
		Example<User> example = Example.of(user);
		users = userDao.findAll(example);	
	    return new Response(SportyShoesConstants.SUCCESS, users);
	}
}

   

