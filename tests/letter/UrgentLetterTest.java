package letter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import content.Money;
import content.Text;

public class UrgentLetterTest extends LetterDecoratorTest {

	@Test @Override
	public void constructorLetterDecorator() {
		Letter<Text> simpleLetter = new SimpleLetter(new Text("Bonjour"), null, null);
		LetterDecorator urgentLetter = new UrgentLetter(simpleLetter);
		
		assertNotNull(urgentLetter.letter());
	}

	@Test
	public void verifyCost() {
		Letter<Text> simpleLetter = new SimpleLetter(new Text("Bonjour"), null, null);
		LetterDecorator urgentLetter = new UrgentLetter(simpleLetter);
		
		assertEquals(2, urgentLetter.cost());
		
		Letter<Money> promissoryNoteLetter = new PromissoryNote(new Money(530), null, null);
		urgentLetter = new UrgentLetter(promissoryNoteLetter);
		
		assertEquals(108, urgentLetter.cost());
	}

}
