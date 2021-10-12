package com.ecommerce.sportyshoes.service;

import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;

public interface UserService {
	/**
	 * User registration
	 * @param user
	 * @return Success message if registration successful else error message
	 */
	public Response registerUser(User user);

	/**
	 * User login
	 * @param user
	 * @return Success message if login successful else error message
	 */
	public Response loginUser(User user);
	
	/**
	 * access list of users
	 * @param user
	 * @return list of users if exist else error message
	 */
	public Response getUsers(User user);
	
	/**
	 * Change password
	 * @param user
	 * @return Response with status success if successfully changed or  else returns error Message.
	 */
	public Response changePassword(User user, String newPassword);
	
}
