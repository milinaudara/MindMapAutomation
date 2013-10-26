package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.IMindMapRepository;
import com.automindmap.models.Map;

public class MindMapRepository implements IMindMapRepository {

	@Override
	public int addMap(Map map) {
		String query = "INSERT INTO map(name, user_id)"
				+ " VALUES ('" + map.name+"','"+map.userId
				+ "')";

		return DBConnection.getDConnection().insert(query);	
	}

	@Override
	public boolean updateMap(Map map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map getMapById(int MapID) {
		Map map = new Map();
		String query = "SELECT * FROM map WHERE id="+MapID;
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				
				map.id=Integer.parseInt(resultSet.getString("id"));				
				map.userId=Integer.parseInt(resultSet.getString("user_id"));
				map.name=resultSet.getString("name").toString();

			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}

		return map;
	}
	
	@Override
	public List<Map> getMapByUser(int user_id) {
		List<Map> maps=new ArrayList<Map>() ;
		String query="SELECT * FROM map WHERE user_id="+user_id;
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				
				Map map=new Map();
				map.id=resultSet.getInt("id");				
				map.userId=resultSet.getInt("user_id");
				map.name=resultSet.getString("name");
				
				maps.add(map);
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}

		return maps;
	}

	@Override
	public List<Map> getMapByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
