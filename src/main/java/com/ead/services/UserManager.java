package com.ead.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ead.dao.UserDAOImpl;
import com.ead.pojo.User;

@Service
@Transactional
public class UserManager {
	
	@Autowired
	private UserDAOImpl dao;
	
	public User login(User user){		
		return dao.logIn(user);
	}
	
	public boolean checkUserExists(User user){		
		return dao.checkUserExists(user);
	}
	
	public boolean registerUser(User user){		
		return dao.addUser(user);
	}
	
}
