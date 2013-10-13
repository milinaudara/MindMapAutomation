package com.automindmap.irepositories;

import java.util.List;

import com.automindmap.models.Input;

public interface IInputRepository {

	public boolean addInput(Input input);
	
	public List<Input> GetInputs(int MapID);
	
	public int getLastInsertId();
	
	public int deleteInput(Input input);
}
