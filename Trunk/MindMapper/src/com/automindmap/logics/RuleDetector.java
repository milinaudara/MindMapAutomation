package com.automindmap.logics;

import java.util.ArrayList;
import java.util.List;

import com.automindmap.logics.rules.Rule_001;

public class RuleDetector {
	private  List<IGrammerRule> _grammerRules= new ArrayList<IGrammerRule>();
	
	public RuleDetector(){
		_grammerRules.add(new Rule_001());
	}
	public void applyRule(ChankedObject chankedObject){
		for (IGrammerRule grammerRule : _grammerRules) {

			if(grammerRule.IsMatch(chankedObject)){

				
				grammerRule.runRule(chankedObject);
			}
		}

	}
}
