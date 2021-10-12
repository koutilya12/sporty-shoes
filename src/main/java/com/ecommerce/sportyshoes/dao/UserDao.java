package com.ecommerce.sportyshoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.emailId = :emailId and u.password =  :password")
	User validateLogin(String emailId, String password);
	
	@Modifying
	@Query("UPDATE User u set u.password = :newPassword WHERE u.password = :oldPassword")
	int changePassword(String newPassword, String oldPassword);
	
	@Query("SELECT u FROM User u WHERE u.userId = :userId AND u.password = :oldPassword")
	User validateChangePassword(Long userId, String oldPassword);
}
