package com.automindmap.irepositories;
import java.util.ArrayList;

import opennlp.tools.util.Span;


public interface INLPRepository {

	// Sentences Detector 
	//parameters paragraph
	// return string  array of sentences
	public  String[] getSentences(String phrese);

	// Tokenization Paragraphs
	// parameters  paragraph 
	// return string array
	public  String[] getTokerns(String sentence);

	//Find POS tags 
	//parameters token array
	//return pos tag array
	public  String[] getPosTagging(String[] WordArr);

	// Chank tags and postags
	//parameteres string array tags and string arraya POS tags
	public Span[] getChankes(String[] tags, String[] posTag);

	//get extracted key words
	//parameters span chanker string arrya tags
	//return keywords
	public String[] getChunedPhrases(Span[] chunker, String[] tags);

	//remove stop list
	// string array chanked phraeses
	//return array list fo candidate keys		
	public ArrayList<String> getClearedChunedPhrases(String[] ChankedPhreases);
	
	
		 
	//remove chuned related to stop lis
	//span array of chankes amd string array of chanked phreases
	//return span of chanks
	public ArrayList<String> getClearedChankes(Span[] chankes,String[] ChankedPhreases);
}
