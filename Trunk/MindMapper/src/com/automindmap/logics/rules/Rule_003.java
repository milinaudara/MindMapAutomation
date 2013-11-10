package com.automindmap.logics.rules;

import com.automindmap.logics.ChankedObject;
import com.automindmap.logics.IGrammerRule;
import com.automindmap.models.Node;
import com.automindmap.repositories.UnitOfWork;

public class Rule_003 implements IGrammerRule {
	  UnitOfWork _unOfWork= new UnitOfWork();
	@Override
	public boolean IsMatch(ChankedObject chankedObject) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void runRule(ChankedObject chankedObject) {
		 Node node= new Node();
		       // add first NP
				node.mapId=chankedObject.mapId;
				node.value=chankedObject.clearedChankedPhrases.get(0);
				node.parantId=0;		
				node.parantId=_unOfWork.node.addNode(node);
				
				int NPParent=node.parantId;
				int VPParent=node.parantId;
				for (int i = 1; i < chankedObject.clearedChankedPhrases.size(); i++) {
					if(chankedObject.clearedChanks.get(i).equals("NP")){
						node.parantId=NPParent;
						node.value=chankedObject.clearedChankedPhrases.get(i);
						node.parantId=_unOfWork.node.addNode(node);
					}
					if(chankedObject.clearedChanks.get(i).equals("VP")){
						node.parantId=VPParent;
						node.value=chankedObject.clearedChankedPhrases.get(i);
						NPParent=_unOfWork.node.addNode(node);
					}
					
				}
				
				
				
			
	}

	

}
