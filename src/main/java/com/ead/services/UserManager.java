package com.ead.services;

import org.springframework.stereotype.Service;
import com.ead.pojo.User;

@Service
public class UserManager {
	
	public User login(User user){
		//
		return new User();
	}
	
	public boolean checkUserExists(User user){
		//
		return false;
	}
	
	public boolean registerUser(User user){
		//
		return true;
	}
	
}
