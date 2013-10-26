package com.automindmap.irepositories;

import com.automindmap.models.User;

public interface IUserRepository {

	public int addUser(User user);	
	public User getUserByID();
	public User getUserByName();	
	public int deleteUser(String name);
	
}
