package com.automindmap.logics.rules;

import com.automindmap.logics.ChankedObject;
import com.automindmap.logics.IGrammerRule;
import com.automindmap.models.Node;
import com.automindmap.repositories.UnitOfWork;

public class Rule_002 implements IGrammerRule {
	  UnitOfWork _unOfWork= new UnitOfWork();
	@Override
	public boolean IsMatch(ChankedObject chankedObject) {
		return chankedObject.passerTree.equals("NP VP NP");
	}

	@Override
	public void runRule(ChankedObject chankedObject) {
       Node node= new Node();
		
		// add first NP
		node.mapId=chankedObject.mapId;
		node.value=chankedObject.clearedChankedPhrases.get(0);
		node.parantId=0;		
		node.parantId=_unOfWork.node.addNode(node);
		
		//add VP		
		node.value=chankedObject.clearedChankedPhrases.get(1);	
		node.parantId=_unOfWork.node.addNode(node);
		
		//add second NP	
		node.value=chankedObject.clearedChankedPhrases.get(2);	
		node.parantId=_unOfWork.node.addNode(node);
	}

	

}
