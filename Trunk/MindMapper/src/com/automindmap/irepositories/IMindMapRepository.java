package com.automindmap.irepositories;

import java.util.List;

import com.automindmap.models.MindMap;

public interface IMindMapRepository {

	public boolean addMap(MindMap mindMap);
	
	public boolean updateMap(MindMap mindMap);
	
	public int getLastInsertId();
	public MindMap getMapById(int map_id);
	public List<MindMap> getMapByUser(int user_id);
	public List<MindMap> getMapByName(String name);
	
}
