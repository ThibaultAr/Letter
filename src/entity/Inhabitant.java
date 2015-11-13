package entity;

import displayer.Displayer;

public class Inhabitant {
	protected String name;

	protected City city;
	protected BankAccount bankAccount;

	public Inhabitant(String name, City city) {
		this.name = name;
		this.city = city;
		this.bankAccount = new BankAccount();
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

	public void credit(int amount) {
		bankAccount.credit(amount);
		Displayer.getDisplayer().display("+ " + name +" account is credited with" + amount +" euros, its " +bankAccount.balanceToString());
	}
	
	public void debit(int amount) {
		bankAccount.credit(amount);
		Displayer.getDisplayer().display("- " + amount + " euro are debited from " + name +" whose "+bankAccount.balanceToString());
	}
}
