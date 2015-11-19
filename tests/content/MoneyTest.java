package content;

import static org.junit.Assert.*;

import org.junit.Test;

import letter.exception.NegativeAmmountException;

public class MoneyTest {

	@Test(expected = NegativeAmmountException.class)
	public void amountOfMoneyShouldNotBeNegative() throws NegativeAmmountException {
		@SuppressWarnings("unused")
		Money money = new Money(-2);
	}

	@Test
	public void constructMoney() throws NegativeAmmountException {
		Money money = new Money(10);
		assertEquals(10, money.amount());
	}

	@Test
	public void moneyAmountCanBeZero() throws NegativeAmmountException {
		Money money = new Money(0);
		assertEquals(0, money.amount());
	}

	@Test
	public void moneyToString() {
		Money money = new Money(10);
		assertEquals("a money content (10) ", money.description());
	}
}
