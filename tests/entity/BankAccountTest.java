package entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testInitialCreation() {
		BankAccount bankAccount = new BankAccount();
		assertEquals(0, bankAccount.amount);
	}

	@Test
	public void testCredit() {
		BankAccount bankAccount = new BankAccount(1000000);

		assertEquals(1000000, bankAccount.amount());

		bankAccount.credit(1);
		assertEquals(1000001, bankAccount.amount());
	}

	@Test
	public void testDebit() {
		BankAccount bankAccount = new BankAccount(1000000);
		assertEquals(1000000, bankAccount.amount());

		bankAccount.debit(1);
		assertEquals(999999, bankAccount.amount());
	}

}
