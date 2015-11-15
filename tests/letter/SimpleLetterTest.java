package letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import content.Text;

public class SimpleLetterTest extends LetterTest<Text> {

	public Letter<Text> createLetter() {
		return (Letter<Text>) new SimpleLetter(new Text("Bonjour"), null, null);
	}

	@Test @Override
	public void verifyCost() {
		Letter<Text> simpleLetter = createLetter();
		assertEquals(1, simpleLetter.cost());
	}
}
