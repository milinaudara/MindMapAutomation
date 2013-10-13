package com.automindmap.irepositories;

import com.automindmap.models.User;

public interface IUserRepository {

	public boolean addUser(User user);
	
	public User getUserByID();
	public User getUserByName();
	
	public int getLastInsertId();
	public int deleteUser(String name);
	
}
