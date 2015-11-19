package entity;

import letter.Letter;
import displayer.Displayer;

/**
 * The inhabitant is represented by his name, the city where he lives and his
 * bank account.
 */
public class Inhabitant {
	protected String name;

	protected City city;
	protected BankAccount bankAccount;

	public Inhabitant(String name, City city) {
		this.name = name;
		this.city = city;
		this.bankAccount = new BankAccount();
	}

	public Inhabitant(String name, City city, int amount) {
		this(name, city);
		this.bankAccount = new BankAccount(amount);
	}

	public City city() {
		return city;
	}

	public String name() {
		return name;
	}

	public BankAccount bankAccount() {
		return bankAccount;
	}

	/**
	 * Credits the inhabitant's bank account with amount
	 * 
	 * @param amount
	 */
	public void credit(int amount) {
		bankAccount.credit(amount);
		Displayer.getDisplayer().display("\t+" 
				+ name + " account is credited with " 
				+ amount + " euro"+
				((amount>1)?"s":"")+", its "
				+ bankAccount.balanceToString() + "\n");
	}

	/**
	 * Debits the inhabitant's bank account with amount
	 * 
	 * @param amount
	 */
	public void debit(int amount) {
		bankAccount.debit(amount);
		Displayer.getDisplayer().display("\t-" 
				+ amount + " euro" +
				((amount>1)?"s":"")+ "are debited from " 
				+ name + " whose " 
				+ bankAccount.balanceToString() + "\n");
	}

	public void sendLetter(Letter<?> letter) {
		city.sendLetter(letter);
	}
}
