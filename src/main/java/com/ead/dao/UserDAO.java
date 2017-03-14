package com.ead.dao;

import com.ead.pojo.User;

public interface UserDAO {

	public User logIn(User user);
	public boolean checkUserExists(User user);
	public boolean addUser(User user);
	
}
