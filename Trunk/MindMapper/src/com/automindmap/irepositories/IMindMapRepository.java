package com.automindmap.irepositories;

import java.util.List;

import com.automindmap.models.Map;

public interface IMindMapRepository {

	public int addMap(Map map);
	
	public boolean updateMap(Map map);
	
	
	public Map getMapById(int map_id);
	public List<Map> getMapByUser(int user_id);
	public List<Map> getMapByName(String name);
	
}
