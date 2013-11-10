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





	public ChankedObject getChankedObject(String sentencetext){

		
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
		
		// Assign values to chanked object.
		
		ChankedObject chankedObject=new ChankedObject();
		chankedObject.passerTree=passerTree.trim();
		chankedObject.clearedChanks=clearedChanks;
		chankedObject.clearedChankedPhrases=clearedChankedPhrases;
        
		//console write for testing
		consoleWrite(sentencetext,chanks,chankedPhrases,clearedChankedPhrases,clearedChanks);
		// Return chankedobject object.
		return chankedObject;
	}

private void consoleWrite(String sentencetext,Span[] chanks,String[] chankedPhrases,ArrayList<String> clearedChankedPhrases,ArrayList<String> clearedChanks) {
	//full sentence	
	System.out.println(sentencetext);
	
	//full paser tree
	String outputPasertree = "";
    String  output = "";
		for (int i=0;i<chanks.length;i++)
		{
			outputPasertree += chanks[i].getType() + " ";
			output += chanks[i].getType() + " => ";
			output += chankedPhrases[i] + " , ";
			
		}
		
		System.out.println(outputPasertree);
		System.out.println(output); 
		
		
		output = "";
		outputPasertree = "";

		
		output = "";

		for (int i=0;i<clearedChanks.size();i++)
		{
			outputPasertree += clearedChanks.get(i) + " ";
			output += clearedChanks.get(i)+ " => ";
			output += clearedChankedPhrases.get(i) + " , ";
			
		}
		
		System.out.println(outputPasertree);
		System.out.println(output);
		output = "";
		for (String s : clearedChankedPhrases)
		{
			output += s + " ";
		}
		
		System.out.println(output);
		System.out.println("");
		System.out.println("");
	}
}
