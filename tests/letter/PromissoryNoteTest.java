package letter;

import letter.exception.NegativeAmmountException;
import content.Money;

public class PromissoryNoteTest extends LetterTest<Money>{

	public Letter<Money> createLetter() throws NegativeAmmountException {
			return (Letter<Money>) new PromissoryNote(new Money(10), null, null);
	}

}
