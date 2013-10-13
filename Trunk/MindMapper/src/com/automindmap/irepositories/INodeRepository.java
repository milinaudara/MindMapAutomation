package com.automindmap.irepositories;

import com.automindmap.models.Node;

public interface INodeRepository {

	public boolean addNode(Node node);
	
	public boolean updateNode(Node node);
	
	public int getLastInsertId();
	public int getNodeId(int map_id,String name);
	public int getParentName(int map_id,String name);
	
}
