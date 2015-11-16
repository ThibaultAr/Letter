package content;

import letter.exception.NegativeAmmountException;

public class Money implements Content {
	protected int amount;

	public Money(int money) throws NegativeAmmountException {
		if (money < 0)
			throw new NegativeAmmountException();
		this.amount = money;
	}

	public int amount() {
		return amount;
	}

	public String description() {
		return "a money content (" + amount + ") ";
	}
}
