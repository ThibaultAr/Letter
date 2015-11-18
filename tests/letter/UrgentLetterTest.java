package letter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import content.Money;
import content.Text;
import entity.Inhabitant;

public class UrgentLetterTest extends LetterDecoratorTest {

	@Test
	@Override
	public void constructorLetterDecorator() {
		Letter<Text> simpleLetter = new SimpleLetter(new Text("Bonjour"), null,
				null);
		LetterDecorator urgentLetter = UrgentLetter.createLetter(simpleLetter);

		assertNotNull(urgentLetter.letter());
	}

	@Test
	public void verifyCost() {
		Letter<Text> simpleLetter = new SimpleLetter(new Text("Bonjour"), null,
				null);
		LetterDecorator urgentLetter = UrgentLetter.createLetter(simpleLetter);

		assertEquals(2, urgentLetter.cost());

		Letter<Money> promissoryNoteLetter = new PromissoryNote(new Money(530),
				null, null);
		urgentLetter = UrgentLetter.createLetter(promissoryNoteLetter);

		assertEquals(108, urgentLetter.cost());
	}

	@Test
	public void theContainedLetterShouldDoesSomethingOnReceive() {
		Inhabitant inhabitant = new Inhabitant("bob", null);
		LetterWhichDoesSomethingTestable letter = new LetterWhichDoesSomethingTestable(
				new Text("bu"), inhabitant, inhabitant);
		UrgentLetter urgentLetter = UrgentLetter.createLetter(letter);

		urgentLetter.doOnReceive();

		assertTrue(letter.somethingHasBeenDone());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createDoubleUrgentLetterShouldThrowsException() {
		SimpleLetter simpleLetter = new SimpleLetter(new Text("jambon"), null, null);
		UrgentLetter urgentLetter = UrgentLetter.createLetter(simpleLetter);
		UrgentLetter.createLetter(urgentLetter);
	}
}
