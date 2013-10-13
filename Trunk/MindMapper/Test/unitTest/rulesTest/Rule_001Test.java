package unitTest.rulesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.automindmap.logics.ChankedObject;
import com.automindmap.logics.rules.Rule_001;

public class Rule_001Test {

	@Test
	public void testIsMatch() {
		Rule_001 rule=new Rule_001();
		ChankedObject chankedObject= new ChankedObject();
		chankedObject.passerTree="NP NP"; 
		assertTrue("is matched", rule.IsMatch(chankedObject));
		
		
	}

	@Test
	public void testRunRule() {
		fail("Not yet implemented");
	}

}
