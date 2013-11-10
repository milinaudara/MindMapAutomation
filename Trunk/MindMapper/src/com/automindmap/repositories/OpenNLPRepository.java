package com.automindmap.repositories;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.automindmap.irepositories.INLPRepository;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;


public class OpenNLPRepository implements INLPRepository {

	//String stopList = "a’s |able |about |above |according |accordingly |across |actually |after |afterwards |again |against |ain’t |all |allow |allows |almost |alone |along |already |also |although |always |am |among |amongst |an |and |another |any |anybody |anyhow |anyone |anything |anyway |anyways |anywhere |apart |appear |appreciate |appropriate |are |aren’t |around |as |aside |ask |asking |associated |at |available |away |awfully |be |became |because |become |becomes |becoming |been |before |beforehand |behind |being |believe |below |beside |besides |best |better |between |beyond |both |brief |but |by |c’mon |c’s |came |can |can’t |cannot |cant |cause |causes |certain |certainly |changes |clearly |co |com |come |comes |concerning |consequently |consider |considering |contain |containing |contains |corresponding |could |couldn’t |course |currently |definitely |described |despite |did |didn’t |different |do |does |doesn’t |doing |don’t |done |down |downwards |during |each |edu |eg |eight |either |else |elsewhere |enough |entirely |especially |et |etc |etc. |even |ever |every |everybody |everyone |everything |everywhere |ex |exactly |example |except |far |few |fifth |first |five |followed |following |follows |for |former |formerly |forth |four |from |further |furthermore |get |gets |getting |given |gives |go |goes |going |gone |got |gotten |greetings |had |hadn’t |happens |hardly |has |hasn’t |have |haven’t |having |he |he’s |hello |help |hence |her |here |here’s |hereafter |hereby |herein |hereupon |hers |herself |hi |him |himself |his |hither |hopefully |how |howbeit |however |i’d |i’ll |i’m |i’ve |i |ie |if |ignored |immediate |in |inasmuch |inc |indeed |indicate |indicated |indicates |inner |insofar |instead |into |inward |is |isn’t |it |it’d |it’ll |it’s |its |itself |just |keep |keeps |kept |know |knows |known |last |lately |later |latter |latterly |least |less |lest |let |let’s |like |liked |likely |little |look |looking |looks |ltd |mainly |many |may |maybe |me |mean |meanwhile |merely |might |more |moreover |most |mostly |much |must |my |myself |name |namely |nd |near |nearly |necessary |need |needs |neither |never |nevertheless |new |next |nine |no |nobody |non |none |noone |nor |normally |not |nothing |novel |now |nowhere |obviously |of |off |often |oh |ok |okay |old |on |once |one |ones |only |onto |or |other |others |otherwise |ought |our |ours |ourselves |out |outside |over |overall |own |particular |particularly |per |perhaps |placed |please |plus |possible |presumably |probably |provides |que |quite |qv |rather |rd |re |really |reasonably |regarding |regardless |regards |relatively |respectively |right |said |same |saw |say |saying |says |second |secondly |see |seeing |seem |seemed |seeming |seems |seen |self |selves |sensible |sent |serious |seriously |seven |several |shall |she |should |shouldn’t |since |six |so |some |somebody |somehow |someone |something |sometime |sometimes |somewhat |somewhere |soon |sorry |specified |specify |specifying |still |sub |such |sup |sure |t’s |take |taken |tell |tends |th |than |thank |thanks |thanx |that |that’s |thats |the |their |theirs |them |themselves |then |thence |there |there’s |thereafter |thereby |therefore |therein |theres |thereupon |these |they |they’d |they’ll |they’re |they’ve |think |third |this |thorough |thoroughly |those |though |three |through |throughout |thru |thus |to |together |too |took |toward |towards |tried |tries |truly |try |trying |twice |two |un |under |unfortunately |unless |unlikely |until |unto |up |upon |us |use |used |useful |uses |using |usually |value |various |very |via |viz |vs |want |wants |was |wasn’t |way |we |we’d |we’ll |we’re |we’ve |welcome |well |went |were |weren’t |what |what’s |whatever |when |whence |whenever |where |where’s |whereafter |whereas |whereby |wherein |whereupon |wherever |whether |which |while |whither |who |who’s |whoever |whole |whom |whose |why |will |willing |wish |with |within |without |won’t |wonder |would |would |wouldn’t |yes |yet |you |you’d |you’ll |you’re |you’ve |your |yours |yourself |yourselves |zero";
	 String stopList = "a’s |able |about |above |according |accordingly |across |actually |after |afterwards |again |against |ain’t |all |allow |allows |almost |alone |along |already |also |although |always |am |among |amongst |an |and |another |any |anybody |anyhow |anyone |anything |anyway |anyways |anywhere |apart |appear |appreciate |appropriate |are |aren’t |around |as |aside |ask |asking |associated |at |available |away |awfully |be |became |because |become |becomes |becoming |been |before |beforehand |behind |being |believe |below |beside |besides |best |better |between |beyond |both |brief |but |by |c’mon |c’s |came |can |can’t |cannot |cant |cause |causes |certain |certainly |changes |clearly |co |com |come |comes |concerning |consequently |consider |considering |contain |containing |contains |corresponding |could |couldn’t |course |currently |definitely |described |despite |did |didn’t |different |do |does |doesn’t |doing |don’t |done |down |downwards |during |each |edu |eg |eight |either |else |elsewhere |enough |entirely |especially |et |etc |etc. |even |ever |every |everybody |everyone |everything |everywhere |ex |exactly |example |except |far |few |fifth |first |five |followed |following |follows |for |former |formerly |forth |four |from |further |furthermore |get |gets |getting |given |gives |go |goes |going |gone |got |gotten |greetings |had |hadn’t |happens |hardly |has |hasn’t |have |haven’t |having |he |he’s |hello |help |hence |her |here |here’s |hereafter |hereby |herein |hereupon |hers |herself |hi |him |himself |his |hither |hopefully |how |howbeit |however |i’d |i’ll |i’m |i’ve |i |ie |if |ignored |immediate |in |inasmuch |inc |indeed |indicate |indicated |indicates |inner |insofar |instead |into |inward |is |isn’t |it |it’d |it’ll |it’s |its |itself |just |keep |keeps |kept |know |knows |known |last |lately |later |latter |latterly |least |less |lest |let |let’s |like |liked |likely |little |look |looking |looks |ltd |mainly |many |may |maybe |me |mean |meanwhile |merely |might |more |moreover |most |mostly |much |must |my |myself |name |namely |nd |near |nearly |necessary |need |needs |neither |never |nevertheless |new |next |nine |no |nobody |non |none |noone |nor |normally |not |nothing |novel |now |nowhere |obviously |of |off |often |oh |ok |okay |old |on |once |one |ones |only |onto |or |other |others |otherwise |ought |our |ours |ourselves |out |outside |over |overall |own |particular |particularly |per |perhaps |placed |please |plus |possible |presumably |probably |provides |que |quite |qv |rather |rd |re |really |reasonably |regarding |regardless |regards |relatively |respectively |right |said |same |saw |say |saying |says |second |secondly |see |seeing |seem |seemed |seeming |seems |seen |self |selves |sensible |sent |serious |seriously |seven |several |shall |she |should |shouldn’t |since |six |so |some |somebody |somehow |someone |something |sometime |sometimes |somewhat |somewhere |soon |sorry |specified |specify |specifying |still |sub |such |sup |sure |t’s |take |taken |tell |tends |th |than |thank |thanks |thanx |that |that’s |thats |the |their |theirs |them |themselves |then |thence |there |there’s |thereafter |thereby |therefore |therein |theres |thereupon |these |they |they’d |they’ll |they’re |they’ve |think |third |this |thorough |thoroughly |those |though |three |through |throughout |thru |thus |to |together |too |took |toward |towards |tried |tries |truly |try |trying |twice |two |un |under |unfortunately |unless |unlikely |until |unto |up |upon |us |use |used |useful |uses |using |usually |value |various |very |via |viz |vs |want |wants |was |wasn’t |way |we |we’d |we’ll |we’re |we’ve |welcome |well |went |were |weren’t |what |what’s |whatever |when |whence |whenever |where |where’s |whereafter |whereas |whereby |wherein |whereupon |wherever |whether |which |while |whither |who |who’s |whoever |whole |whom |whose |why |will |willing |wish |with |within |without |won’t |wonder |would |would |wouldn’t |yes |yet |you |you’d |you’ll |you’re |you’ve |your |yours |yourself |yourselves |zero";
	// Sentences Detector 
	//parameters paragraph
	// return string  array of sentences
	public  String[] getSentences(String phrese)  {
		try {
			
			InputStream modelIn = new FileInputStream("en-sent.bin");			
			SentenceModel model = new SentenceModel(modelIn);
			SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
			String sentences[] = sentenceDetector.sentDetect(phrese);
			//reArrayList.addAll(Arrays.asList(sentences));
			return sentences;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}



	// Tokenization Paragraphs
	// parameters  paragraph 
	// return string array
	public  String[] getTokerns(String sentence)  {
		try {
			InputStream modelIn = new FileInputStream("en-token.bin");
			TokenizerModel model = new TokenizerModel(modelIn);
			Tokenizer tokenizer = new TokenizerME(model);
			String tokens[] = tokenizer.tokenize(sentence);

			return tokens;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}



	//Find POS tags 
	//parameters token array
	//return pos tag array

	public  String[] getPosTagging(String[] WordArr) {
		InputStream modelIn = null;

		try {
			modelIn = new FileInputStream("en-pos-maxent.bin");
			POSModel model = new POSModel(modelIn);
			POSTaggerME tagger = new POSTaggerME(model);
			String[] tags = tagger.tag(WordArr);
			return tags;
		} catch (IOException e) {
			// Model loading failed, handle the error
			e.printStackTrace();
			return null;
		}

	}

	// Chank tags and postags
	//parameteres string array tags and string arraya POS tags
	//
	public Span[] getChankes(String[] tags, String[] posTag) {
		InputStream modelIn = null;
		ChunkerModel model = null;

		try {
			modelIn = new FileInputStream("en-chunker.bin");
			model = new ChunkerModel(modelIn);
			ChunkerME chunker = new ChunkerME(model);			
			Span[] span = chunker.chunkAsSpans(tags, posTag);

			return span;

		} catch (IOException e) {
			// Model loading failed, handle the error
			e.printStackTrace();
			return null;
		}
	}

	//get extracted key words
	//parameters span chanker string arrya tags
	//return keywords
	public String[] getChunedPhrases(Span[] chunker, String[] tags) {

		String[] ChunedPhrases = new String[chunker.length];
		int index = 0;
		boolean firstNP = true;

		for (Span chunk : chunker) {			
			int start = chunk.getStart();
			int end = chunk.getEnd();
			for (int x = start; x < end; x++) {
				if (firstNP) {
					ChunedPhrases[index] = tags[x];
					firstNP = false;
				} else {
					ChunedPhrases[index] = ChunedPhrases[index].concat(" "+ tags[x]);
				}
			}
			firstNP = true;
			index++;			

		}

		return ChunedPhrases;
	}
	
	
	//remove stop list
	// string array chanked phraeses
	//return array list for candidate keys
	
	public ArrayList<String> getClearedChunedPhrases(String[] ChankedPhreases){

		ArrayList<String> reKeywords= new ArrayList<String>();
		for (String string : ChankedPhreases) {
			if(!stopList.contains(string)){
				reKeywords.add(string);
			}
		}

		return reKeywords;
	}



	@Override
	public ArrayList<String> getClearedChankes(Span[] chankes, String[] ChankedPhreases) {
		ArrayList<String> clearedchankeslist= new ArrayList<String>();
		
		for(int i=0;i<ChankedPhreases.length;i++){
			if(!stopList.contains(ChankedPhreases[i])){
				clearedchankeslist.add(chankes[i].getType());
			}
			
		}
		
		
		return clearedchankeslist;
	}
}
