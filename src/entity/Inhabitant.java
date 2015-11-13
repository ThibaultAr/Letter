package entity;

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
}
