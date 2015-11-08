package entity;

public class BankAccount {
	protected int amount;

	public BankAccount() {
		amount = 0;
	}

	public BankAccount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void credit(int amount) {
		this.amount += amount;
	}

	public void debit(int amount) {
		this.amount -= amount;
	}
}
