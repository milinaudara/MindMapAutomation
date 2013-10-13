package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.automindmap.logics.InputProcessor;

public class InputProcessorTest {

	@Test
	public void test() {
		InputProcessor inputprocess= new InputProcessor();
		inputprocess.mainProcess(1,1,"java is language.");
	}

}
