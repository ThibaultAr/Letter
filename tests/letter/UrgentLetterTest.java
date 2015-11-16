package letter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import content.Money;
import content.Text;
import entity.Inhabitant;

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

	@Test
	public void theContainedLetterShouldDoesSomethingOnReceive() {
		Inhabitant inhabitant = new Inhabitant("bob", null);
		LetterWhichDoesSomethingTestable letter = new LetterWhichDoesSomethingTestable(new Text("bu"), inhabitant, inhabitant);
		UrgentLetter urgentLetter = new UrgentLetter(letter);
		
		urgentLetter.doOnReceive();
		
		assertTrue(letter.somethingHasBeenDone());
	}
}
