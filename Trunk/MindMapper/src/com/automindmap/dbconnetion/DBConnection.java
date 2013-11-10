package com.automindmap.dbconnetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private static DBConnection _dbConnection = new DBConnection();

	private DBConnection() {
	}

	public static DBConnection getDConnection() {
		return _dbConnection;
	}

	public Connection getDatabaseConnetion() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3309/";
		String dbName = "automindmap_db";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "123";

		try {
			Class.forName(driver).newInstance();
			connection = (Connection) DriverManager.getConnection(url + dbName,
					userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public int insert(String query) {
	
		int lastId=-1;

		try {
			Statement statement = getDatabaseConnetion().createStatement();
			statement.execute(query,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
	        if (rs.next()){
	        	lastId=rs.getInt(1);
	        }
	        getDatabaseConnetion().close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}

	public int update(String query) {
		int isexecuted = 0;

		try {
			Statement statement = getDatabaseConnetion().createStatement();
			isexecuted = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isexecuted;
	}

	public ResultSet select(String query) {
		ResultSet resultSet = null;

		try {
			Statement statement = (Statement) getDatabaseConnetion()
					.createStatement();
			resultSet = (ResultSet) statement.executeQuery(query);
		    getDatabaseConnetion().close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
}
