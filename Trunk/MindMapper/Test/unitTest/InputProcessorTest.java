package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.automindmap.logics.InputProcessor;
import com.automindmap.repositories.UnitOfWork;

public class InputProcessorTest {

	@Test
	public void test() {
		//String para="Java is a computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.  Java applications are typically compiled to bytecode that can run on any Java virtual machine regardlessa of computer architecture. Java is, as of 2012, one of the most popular programming languages in use, particularly for client-server web applications, with a reported 9 million developers.[10][11] Java was originally developed by James Gosling at Sun Microsystems and released in 1995 as a core component of Sun Microsystems Java platform. The language derives much of its syntax from C and C++  but it has fewer low-level facilities than either of them.";
		
		//String para="Java is software which is develped by sun.";
		String para="Google include software like gmail, yahoo, ebay, and facebook.";
		
		UnitOfWork _unitofwork=new UnitOfWork();
		String []sentences=_unitofwork.nlp.getSentences(para);
		InputProcessor inputprocess= new InputProcessor();
		for (String string : sentences) {
			inputprocess.getChankedObject(string);
		}
		
	}

}
