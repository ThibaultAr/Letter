package content;

public class Money implements Content {
	protected int ammount;

	public Money(int money) {
		this.ammount = money;
	}

	public int ammount() {
		return ammount;
	}
}
