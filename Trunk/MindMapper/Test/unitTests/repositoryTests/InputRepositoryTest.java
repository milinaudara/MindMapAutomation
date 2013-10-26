package unitTests.repositoryTests;

import static org.junit.Assert.*;

import org.junit.Test;


import com.automindmap.models.Input;
import com.automindmap.repositories.UnitOfWork;

public class InputRepositoryTest {
	UnitOfWork _unitofwork= new UnitOfWork();

	@Test
	public void testAddInput() {
		Input input=new Input();
		input.mapId=1;
		input.userId=1;
		input.input="test Input";
		
		assertTrue("add input",_unitofwork.input.addInput(input)>0);
		assertEquals("delete input", 1,_unitofwork.input.deleteInput(input));
		
	}

}
