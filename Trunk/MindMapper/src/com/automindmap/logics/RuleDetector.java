package com.automindmap.logics;

import java.util.ArrayList;
import java.util.List;

import com.automindmap.logics.rules.Rule_001;
import com.automindmap.logics.rules.Rule_002;
import com.automindmap.logics.rules.Rule_003;
import com.automindmap.logics.rules.Rule_004;


public class RuleDetector {
	private  List<IGrammerRule> _grammerRules= new ArrayList<IGrammerRule>();
	
	public RuleDetector(){
		_grammerRules.add(new Rule_001());
		_grammerRules.add(new Rule_002());
		_grammerRules.add(new Rule_004());
		_grammerRules.add(new Rule_003());
	}
	public void applyRule(ChankedObject chankedObject){
		forloop:
		for (IGrammerRule grammerRule : _grammerRules) {

			if(grammerRule.IsMatch(chankedObject)){
			   grammerRule.runRule(chankedObject);
			   break forloop;
			}
		}

	}
}
