package com.automindmap.repositories;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.ITestMindRepository;
import com.automindmap.models.TestMind;

public class TestMindRepository implements ITestMindRepository {
	public int AddMindMap(TestMind testMind) {
		
		String query = "insert into TestMap set data='" +testMind.id + "', title='"+ testMind.data + "'";

		return DBConnection.getDConnection().insert(query);	
	}
	public TestMind GetMindMap() {
		TestMind testMind=new TestMind();
		return testMind;
		
	}
	
}
