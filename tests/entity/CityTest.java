package entity;

import static org.junit.Assert.assertTrue;
import letter.Letter;
import letter.SimpleLetter;

import org.junit.Test;

import content.Text;

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
		assertTrue(city.postbox().contains(letter));
	}
}
