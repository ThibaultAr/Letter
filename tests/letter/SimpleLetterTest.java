package letter;

import static org.junit.Assert.*;

import org.junit.*;

import content.Text;

public class SimpleLetterTest extends LetterTest {
	protected SimpleLetter letter;

	@Before
	public void createLetter() {
		letter = new SimpleLetter(new Text("Bonjour"), null, null);
	}

	@Test
	public void testLetterShouldHavePositiveCost() {
		assertTrue(letter.getCost() > 0);
	}
	
	@Test
	public void testSimpleLetterShouldAlwaysHaveATextContent (){
		assertEquals(new Text("Bonjour").getText(), letter.getContent().getText());
		
		letter = new SimpleLetter(new Text(), null, null);
		assertEquals(new Text().getText(), letter.getContent().getText());
	}

}
