package letter;

import static org.junit.Assert.fail;

import content.Money;
import letter.exception.NegativeAmmountException;

public class PromissoryNoteTest extends LetterTest<Money>{

	public Letter<Money> createLetter() {
		try {
			return (Letter<Money>) new PromissoryNote(new Money(10), null, null);
		} catch (NegativeAmmountException e) {
			fail("Money should not throws exception, we just check");
		}
		return null; // TODO check this 
	}

}
