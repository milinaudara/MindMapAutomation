package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.IInputRepository;
import com.automindmap.models.Input;



public class InputRepository implements IInputRepository {

	@Override
	public int addInput(Input input) {
		String query = "INSERT INTO input(map_id, user_id, input)"
				+ " VALUES ('" + input.mapId+"','"+input.userId+"','"+input.input
				+ "')";

		return DBConnection.getDConnection().insert(query);	
	}

	@Override
	public List<Input> GetInputs(int MapID) {
		List<Input> inputs= new ArrayList<Input>();
		String query = "SELECT * FROM input WHERE id="+MapID;
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		try {
			while (resultSet.next()) {
				Input input = new Input();
				input.id=Integer.parseInt(resultSet.getString("id"));
				input.mapId=Integer.parseInt(resultSet.getString("map_id"));
				input.userId=Integer.parseInt(resultSet.getString("user_id"));
				input.input=resultSet.getString("input").toString();

			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}

		return  inputs;
	}

	@Override
	public int deleteInput(Input input) {
		String query = "DELETE FROM input WHERE " +
				"map_id='"+input.mapId+"'and" +
				" user_id='"+input.userId+"'and" +
				" input='"+input.input+"'";

		return DBConnection.getDConnection().update(query);	
	}

	


}
