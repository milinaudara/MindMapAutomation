package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.ISentenceRepository;
import com.automindmap.models.Sentence;

public class SentenceRepository implements ISentenceRepository {

	@Override
	public boolean addSentence(Sentence sentence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSentece(Sentence sentence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Sentence> getSentenceByMap(int mapId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getLastInsertId() {
		String query = "SELECT LAST_INSERT_ID() FROM sentence ";
		ResultSet resultSet = DBConnection.getDConnection().select(query);
		int id=0;
		try {
			if (resultSet.next()) {
				
				id=Integer.parseInt(resultSet.getString("LAST_INSERT_ID()"));
				
			}

		} catch (SQLException e) {				
			e.printStackTrace();	
		}
		return id;
	}
}
