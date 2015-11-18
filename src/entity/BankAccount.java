package entity;

/**
 * The bank account of an inhabitant can be credited or debited
 * 
 */
public class BankAccount {
	protected int amount;

	public BankAccount() {
		amount = 0;
	}

	public BankAccount(int amount) {
		this.amount = amount;
	}

	public int amount() {
		return amount;
	}

	public void credit(int amount) {
		this.amount += amount;
	}

	public void debit(int amount) {
		this.amount -= amount;
	}

	public String balanceToString() {
		return "balance is now " + amount;
	}
}
