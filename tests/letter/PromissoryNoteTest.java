package letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import content.Money;
import letter.exception.NegativeAmmountException;

public class PromissoryNoteTest extends LetterTest<Money> {

	public Letter<Money> createLetter() throws NegativeAmmountException {
		return (Letter<Money>) new PromissoryNote(new Money(10), null, null);
	}
	
	@Test @Override
	public void verifyCost() {
		Letter<Money> promissoryNote = createLetter();
		assertEquals(2, promissoryNote.cost());
		
		promissoryNote = new PromissoryNote(new Money(330), null, null);
		assertEquals(34, promissoryNote.cost());
	}
	
	
}
