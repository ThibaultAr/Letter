package entity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import content.Text;
import letter.Letter;
import letter.SimpleLetter;

public class CityTest {

	@Test(expected = IllegalArgumentException.class)
	public void testAddNullInhabitantShouldThrowsException() {
		City city = new City("SmallVille");
		city.addInhabitant(null);
	}

	@Test
	public void testAddInhabitant() {
		City city = new City("PortReal");
		Inhabitant tyrion = new Inhabitant("Tyrion", city);
		city.addInhabitant(tyrion);

		assertTrue(city.inhabitants().contains(tyrion));
	}

	@Test
	public void testSendLetter() {
		City city = new City("Winterfell");
		Inhabitant geoffrey = new Inhabitant("Geoffrey", city);
		Inhabitant ned = new Inhabitant("Ned", city);

		Letter<Text> letter = new SimpleLetter(new Text("you've been beheaded, Best Regards. Geoffrey"), geoffrey, ned);

		city.sendLetter(letter);
		assertTrue(city.box().contains(letter));
	}
	
	@Test
	public void testDistributeLetter() {
		City hobbitbourg = new City("Hobbitbourg");
				
		Inhabitant gandalf = new Inhabitant("Gandalf", hobbitbourg);
		Inhabitant bilbo = new Inhabitant("Bilbo", hobbitbourg);
		
		SimpleLetter simpleLetter = new SimpleLetter(new Text("Bien le bonjour"), bilbo, gandalf);
		
		hobbitbourg.sendLetter(simpleLetter);
		hobbitbourg.distributeLetter();
		
		assertFalse(hobbitbourg.postbox().contains(simpleLetter));
	}
}
