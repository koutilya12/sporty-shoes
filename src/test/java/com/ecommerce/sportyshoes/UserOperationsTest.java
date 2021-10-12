package com.ecommerce.sportyshoes;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.constants.UserStatus;
import com.ecommerce.sportyshoes.controllers.UserController;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserOperationsTest {
	@Autowired
	private MockMvc mockMvc; 

	@MockBean
	private UserService service;
	
	@Ignore 
	@Test
	public void saveUsersTest() throws Exception {
		User user = prepareUserObject();
		String requestBody = convertObjectToJsonString(user);
		Response response = new Response(SportyShoesConstants.SUCCESS);
		when(service.registerUser(Mockito.any(user.getClass()))).thenReturn(response);
		this.mockMvc.perform(post("/saveUser").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(convertObjectToJsonString(response))));
	}

	private User prepareUserObject() {		
		User user = new User();
		user.setUserId(4l);
		user.setPassword("mkt@new123");
		return user;
	}

	private String convertObjectToJsonString(Object object) {
        ObjectMapper Obj = new ObjectMapper();
		try {
			return Obj.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void changePasswordTest() throws Exception {
		User user = prepareUserObject();
		String newPassword =  "mkt@new123";
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("newPassword" , newPassword);
		requestMap.put("user", user);
		String requestBody = convertObjectToJsonString(requestMap);
		Response response = new Response(SportyShoesConstants.SUCCESS);
		when(service.changePassword(Mockito.any(user.getClass()),Mockito.any(String.class))).thenReturn(response);
		this.mockMvc.perform(post("/changePassword").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(convertObjectToJsonString(response))));
	}
}

	
