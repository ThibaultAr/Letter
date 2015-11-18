package letter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import content.Money;
import content.Text;
import entity.City;
import entity.Inhabitant;

public class RegisteredLetterTest extends LetterDecoratorTest {

	@Test @Override
	public void constructorLetterDecorator() {
		SimpleLetter simpleLetter = new SimpleLetter(new Text("Bonjour"), null, null);
		RegisteredLetter registeredLetter= RegisteredLetter.createLetter(simpleLetter);
		
		assertNotNull(registeredLetter.letter());
	}
	
	@Test
	public void verifyCost() {
		SimpleLetter simpleLetter = new SimpleLetter(new Text("Bonjour"), null, null);
		RegisteredLetter registeredLetter= RegisteredLetter.createLetter(simpleLetter);
		
		assertEquals(16, registeredLetter.cost());
		
		PromissoryNote promissoryNote = new PromissoryNote(new Money(850), null, null);
		registeredLetter = RegisteredLetter.createLetter(promissoryNote);
		
		assertEquals(101, registeredLetter.cost());
	}
	
	@Test
	public void testDoOnReceive() {
		City city = new City("city");
		City city2 = new City("city2");
		Inhabitant inhabitant = new Inhabitant("inhabitant-1", city);
		Inhabitant inhabitant2 = new Inhabitant("inhabitant-2", city2);
		
		SimpleLetter simpleLetter = new SimpleLetter(new Text("Bonjour"), inhabitant, inhabitant2);
		RegisteredLetter registeredLetter= RegisteredLetter.createLetter(simpleLetter);
		
		city.sendLetter(registeredLetter);
		
		assertEquals(1, city.postbox().size());
		assertEquals(0, city2.postbox().size());
		
		city.distributeLetter();
		
		assertEquals(0, city.postbox().size());
		assertEquals(1, city2.postbox().size());
		
		// TODO Beaucoup trop de dépendance, à revoir
	}
	

}
