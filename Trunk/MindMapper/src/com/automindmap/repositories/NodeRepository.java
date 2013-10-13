package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.INodeRepository;
import com.automindmap.models.Node;

public class NodeRepository implements INodeRepository {

	@Override
	public boolean addNode(Node node) {
	
		String query = "INSERT INTO node(map_id, value,parent_id)"
				+ " VALUES ('" + node.mapId+"','"+node.value+"','"+node.parantId
				+ "')";

		return DBConnection.getDConnection().insert(query);	
	}

	@Override
	public boolean updateNode(Node node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNodeId(int map_id, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getParentName(int map_id, String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getLastInsertId() {
		String query = "SELECT LAST_INSERT_ID() FROM node ";
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
}
