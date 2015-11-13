package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.BankAccount;

public class BankAccountTest {
	protected BankAccount bankAccount;

	@Before
	public void createBankAcocunt() {
		this.bankAccount = new BankAccount(1000000);
	}

	@Test
	public void testCredit() {
		assertEquals(1000000, bankAccount.getAmount());

		bankAccount.credit(1);
		assertEquals(1000001, bankAccount.getAmount());
	}

	@Test
	public void testDebit() {
		assertEquals(1000000, bankAccount.getAmount());

		bankAccount.debit(1);
		assertEquals(999999, bankAccount.getAmount());
	}

}
