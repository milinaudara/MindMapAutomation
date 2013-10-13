package com.automindmap.irepositories;

import java.util.List;

import com.automindmap.models.Sentence;

public interface ISentenceRepository {

	public boolean addSentence(Sentence sentence);
	
	public boolean updateSentece(Sentence sentence);
	
	public int getLastInsertId();
	public List<Sentence> getSentenceByMap(int mapId);
}
