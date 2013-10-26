package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.IUserRepository;
import com.automindmap.models.User;

public class UserRepository implements IUserRepository {

	@Override
	public int addUser(User user) {
		String query = "INSERT INTO user(user_name)"
				+ " VALUES ('" + user.userName
				+ "')";
				
		return DBConnection.getDConnection().insert(query);	
	}

	@Override
	public int deleteUser(String name) {
		String query = "DELETE FROM user WHERE user_name='"+name+"'";
				
		return DBConnection.getDConnection().update(query);	
	}
	@Override
	public User getUserByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public boolean checkUserLogin(String username, String password)
			throws SQLException {
		boolean correctuser = false;
		String query = "SELECT username FROM user WHERE username ='" + username
				+ "'" + "AND password ='" + password + "'";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		while (resultSet.next()) {
			String pw = resultSet.getString("username");
			correctuser = true;
			System.out.println(pw);
		}
		return correctuser;
	}
	
	public HashMap<String, String> getUserList(){
		HashMap<String, String> userDetail = new HashMap<String, String>();
		String query = "SELECT username,email FROM user";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				userDetail.put(username, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetail;
	}
	
	public String getUserNameByID(int id) {
		String query = "SELECT user_name FROM user WHERE id="+id;
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				return resultSet.getString("user_name");
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ss";
	}

	
	
	
	
}
