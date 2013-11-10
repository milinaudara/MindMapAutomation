package com.automindmap.irepositories;

import java.util.List;

import com.automindmap.models.Node;

public interface INodeRepository {

	public int addNode(Node node);
	
	public boolean updateNode(Node node);
	
	
	public int getNodeId(int map_id,String value);
	public int getParentName(int map_id,String name);

	public Node getPerantNode(int mapId);

	public List<Node> getChildNodes(int id);
	
}
