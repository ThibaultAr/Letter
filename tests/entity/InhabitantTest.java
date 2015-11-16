package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class InhabitantTest {

	City tourcoing = new City("Tourcoing");
	City perenchies = new City("Perenchies");
	Inhabitant clement = new Inhabitant("Clement", tourcoing);
	Inhabitant lucette = new Inhabitant("Lucette", tourcoing);

	
	@Test
	public void testInhabitant() {
		assertNotNull(clement);		
	}

	@Test
	public void testCity() {
		assertEquals(tourcoing, clement.city());
		assertNotEquals(perenchies, clement.city());
	}

	@Test
	public void testName() {
		assertEquals("Clement",clement.name());
		assertNotEquals("Clement",lucette.name());

	}

	@Test
	public void testBankAccount() {
		assertNotNull(clement.bankAccount());
	}

	@Test
	public void testCreditDebit() {
		clement.credit(200);
		assertEquals(200,clement.bankAccount().amount());
		clement.debit(10);
		assertEquals(190,clement.bankAccount().amount());
	}


}
