package com.ecommerce.sportyshoes;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.constants.UserStatus;
import com.ecommerce.sportyshoes.constants.UserType;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.service.UserService;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void registerUserTest() {
		User user = new User();
		user.setUserName("James");
		user.setMobileNum("990099008888");
		user.setEmailId("james@gmail.com");
		user.setPassword("james@user");
		user.setUserType(UserType.CUSTOMER);
		user.setStatus(UserStatus.ACTIVE);
		
		Response response = userService.registerUser(user);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));	
	}
	
	@Test
	public void loginUser() {
		User user = new User();
		user.setEmailId("james@gmail.com");
		user.setPassword("james@user");
		Response response = userService.loginUser(user);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));	
	}
	
	@Test
	public void getUsers() {
		User user = new User();
		user.setStatus(UserStatus.ACTIVE);
		Response response = userService.getUsers(user);
		System.out.println(response.getData());
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));	
	}
}
