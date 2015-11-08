package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import content.Content;

public abstract class LetterTest<C extends Content> {

	public abstract Letter<C> createLetter();

	@Test
	public void testLetterShouldHavePositiveCost(){
		Letter<C> letter = createLetter();
		assertTrue(letter.cost() >= 0);
	}

}
