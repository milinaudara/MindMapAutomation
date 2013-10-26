package com.automindmap.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.automindmap.dbconnetion.DBConnection;
import com.automindmap.irepositories.ISentenceRepository;
import com.automindmap.models.Sentence;

public class SentenceRepository implements ISentenceRepository {

	@Override
	public int addSentence(Sentence sentence) {
		// TODO Auto-generated method stub
		return -1;
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
	
}
