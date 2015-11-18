package letter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import content.Money;
import entity.City;
import entity.Inhabitant;
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
	
	@Test
	public void shouldSendAThanksLetterOnReceive() {
		City city = new City("city");
		City city2 = new City("city2");
		Inhabitant inhabitant = new Inhabitant("inhabitant-1", city);
		Inhabitant inhabitant2 = new Inhabitant("inhabitant-2", city2);
		
		PromissoryNote promissoryNote = new PromissoryNote(new Money(10), inhabitant, inhabitant2);
		
		city.sendLetter(promissoryNote);
		
		assertEquals(1, city.postbox().size());
		assertEquals(0, city2.postbox().size());

		city.distributeLetter();
		
		assertEquals(0, city.postbox().size());
		assertEquals(1, city2.postbox().size());
		// TODO Beaucoup trop de dépendance, à revoir (bis)
	}
	
}
