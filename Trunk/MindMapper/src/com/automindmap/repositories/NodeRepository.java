package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.INodeRepository;
import com.automindmap.models.Input;
import com.automindmap.models.Node;

public class NodeRepository implements INodeRepository {

	@Override
	public int addNode(Node node) {
	
	
		if(node.parantId==0){
		int id=getNodeId(node.mapId, node.value);
		if(id!=0){
			return id;
			}
		}else {
			int id=getNodeId(node.mapId, node.value,node.parantId);
			if(id!=0){
				return id;
				}	
		}
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
	public int getNodeId(int map_id, String value) {
		String query = "SELECT id FROM node WHERE map_id= "+map_id+" and value='"+value+"'";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			if (resultSet.next()) {
				return resultSet.getInt("id");				
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}
		return 0;
	}
	public int getNodeId(int map_id, String value, int parentId) {
		String query = "SELECT * FROM node WHERE map_id= "+map_id+" and value='"+value+"' and parent_id='"+parentId+"'";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			if (resultSet.next()) {
				return resultSet.getInt("id");				
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}
		return 0;
	}
	@Override
	public int getParentName(int map_id, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Node getPerantNode(int mapId) {
		Node node =new	Node();
		String query = "SELECT * FROM node WHERE map_id= "+mapId+" and parent_id=0";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			if (resultSet.next()) {
				node.id=resultSet.getInt("id");
				node.mapId=resultSet.getInt("map_id");
				node.value=resultSet.getString("value");
				node.parantId=resultSet.getInt("parent_id");
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}

		return node;
	}

	@Override
	public List<Node> getChildNodes(int id) {
		List<Node> nodeList=new ArrayList<Node>();
		String query = "SELECT * FROM node WHERE parent_id="+id;
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				Node node= new Node();
				node.id=resultSet.getInt("id");
				node.mapId=resultSet.getInt("map_id");
				node.value=resultSet.getString("value");
				node.parantId=resultSet.getInt("parent_id");
				nodeList.add(node);
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}

		return nodeList;
	}

	
	
	
}
