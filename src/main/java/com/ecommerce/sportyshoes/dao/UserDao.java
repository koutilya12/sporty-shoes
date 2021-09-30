package com.ecommerce.sportyshoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.emailId = :emailId and u.password =  :password")
	User validateLogin(String emailId, String password);

}
