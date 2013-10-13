package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.IMindMapRepository;
import com.automindmap.models.MindMap;

public class MindMapRepository implements IMindMapRepository {

	@Override
	public boolean addMap(MindMap mindMap) {
		String query = "INSERT INTO map(name, user_id)"
				+ " VALUES ('" + mindMap.name+"','"+mindMap.userId
				+ "')";

		return DBConnection.getDConnection().insert(query);	
	}

	@Override
	public boolean updateMap(MindMap mindMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MindMap getMapById(int MapID) {
		MindMap mindMap = new MindMap();
		String query = "SELECT * FROM input WHERE id="+MapID;
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				
				mindMap.id=Integer.parseInt(resultSet.getString("id"));				
				mindMap.userId=Integer.parseInt(resultSet.getString("user_id"));
				mindMap.name=resultSet.getString("name").toString();

			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}

		return null;
	}
	
	@Override
	public int getLastInsertId() {
		String query = "SELECT LAST_INSERT_ID() FROM map ";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		int id=0;
		try {
			if (resultSet.next()) {
				
				id=Integer.parseInt(resultSet.getString("LAST_INSERT_ID()"));
				
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}
		return id;
	}
	@Override
	public List<MindMap> getMapByUser(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MindMap> getMapByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
