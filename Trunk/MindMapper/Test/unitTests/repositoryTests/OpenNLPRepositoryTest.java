package unitTests.repositoryTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.automindmap.repositories.UnitOfWork;

public class OpenNLPRepositoryTest {
	UnitOfWork _unitofwork= new UnitOfWork();
	@Test
	public void testGetSentences() {
		String []sentences=_unitofwork.nlp.getSentences( "java is oop.");

		assertEquals("Sentence spliter", "java is oop.",sentences[0]);
	}

	@Test
	public void testGetTokerns() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPosTagging() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChankes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChunedPhrases() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClearedChunedPhrases() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClearedChankes() {
		fail("Not yet implemented");
	}

}
