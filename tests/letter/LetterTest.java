package letter;

import org.junit.Test;

public abstract class LetterTest {

	public abstract void createLetter();

	@Test
	public abstract void testLetterShouldHavePositiveCost();

}
