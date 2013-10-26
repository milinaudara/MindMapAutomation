package com.automindmap.actions.map;

import java.util.List;

import com.automindmap.models.Map;
import com.automindmap.repositories.UnitOfWork;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {

	private List<Map> maps;
	private int user_Id;
	
	@Override
	public String execute() throws Exception {
		
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> getMindMaps() {
		UnitOfWork _unitofwork= new UnitOfWork();
		return _unitofwork.mindMap.getMapByUser(getUser_Id());
	}

	public void setMindMaps(List<Map> maps) {
		this.maps = maps;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

}
