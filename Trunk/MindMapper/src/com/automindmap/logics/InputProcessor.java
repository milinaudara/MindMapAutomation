package com.automindmap.logics;

import java.util.ArrayList;

import opennlp.tools.util.Span;

import com.automindmap.models.Input;
import com.automindmap.models.Sentence;
import com.automindmap.repositories.UnitOfWork;

public class InputProcessor {

	UnitOfWork _unitofwork= new UnitOfWork();

	public void mainProcess(int mapId,int userID,String inputText){

		//Insert input in to database.
		Input input= new Input();
		input.mapId=mapId;
		input.userId=userID;
		input.input=inputText;

		input.id=_unitofwork.input.addInput(input);
		


		// Get sentences of the input.
		String[]  sentences=_unitofwork.nlp.getSentences(inputText);

		Sentence sentence= new Sentence();
		sentence.inputId=input.id;
		sentence.mapId=mapId;
		// Iterate through each sentence. 
		for (String sentencetext : sentences) {			
			sentence.sentence=sentencetext;

			//Add sentences in to database.
			_unitofwork.sentecs.addSentence(sentence);

			//Get cleared chanked pharases and cleared chankes.

			ChankedObject chankedObject=	getChankedObject(sentencetext);
			chankedObject.mapId=mapId;

			//Find and apply rule.
			RuleDetector ruleDetector= new RuleDetector();
			ruleDetector.applyRule(chankedObject);

		}
	}





	private ChankedObject getChankedObject(String sentencetext){

		
		String [] tockens=_unitofwork.nlp.getTokerns(sentencetext);		
		String [] posTags=_unitofwork.nlp.getPosTagging(tockens);		
		Span[] chanks=_unitofwork.nlp.getChankes(tockens, posTags);
		String[] chankedPhrases=_unitofwork.nlp.getChunedPhrases(chanks, tockens);		
		ArrayList<String> clearedChankedPhrases=_unitofwork.nlp.getClearedChunedPhrases(chankedPhrases);		
		ArrayList<String> clearedChanks=_unitofwork.nlp.getClearedChankes(chanks, chankedPhrases);
		
	

		//Generate passer tree as string.
		String passerTree = "";

		for (String s : clearedChanks)
		{
			passerTree += s + " ";
		}
		System.out.println(passerTree);
		// Assign values to chanked object.
		
		ChankedObject chankedObject=new ChankedObject();
		chankedObject.passerTree=passerTree.trim();
		chankedObject.clearedChanks=clearedChanks;
		chankedObject.clearedChankedPhrases=clearedChankedPhrases;

		// Return chankedobject object.
		return chankedObject;
	}

}
