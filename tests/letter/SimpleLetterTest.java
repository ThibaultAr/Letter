package letter;

import static org.junit.Assert.*;

import org.junit.*;

import content.Text;

public class SimpleLetterTest extends LetterTest<Text> {
	protected SimpleLetter letter;

	public Letter<Text> createLetter() {
		return new SimpleLetter(new Text("Bonjour"), null, null);
	}

	@Test
	public void testLetterShouldHavePositiveCost() {
		assertTrue(letter.cost() > 0);
	}
	
	@Test
	public void testSimpleLetterShouldAlwaysHaveATextContent (){
		assertEquals(new Text("Bonjour").getText(), letter.content().getText());
		
		letter = new SimpleLetter(new Text(), null, null);
		assertEquals(new Text().getText(), letter.content().getText());
	}

}
