package com.automindmap.logics;

public interface IGrammerRule {
	 
	boolean IsMatch( ChankedObject chankedObject);     
	 
	 void runRule( ChankedObject chankedObject);
}
