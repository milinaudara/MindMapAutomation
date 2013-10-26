package com.automindmap.irepositories;

import com.automindmap.models.TestMind;

public interface ITestMindRepository {

	public int AddMindMap(TestMind testMind);
	public TestMind GetMindMap();
}
