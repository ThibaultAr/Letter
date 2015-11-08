package letter;

import letter.exception.NegativeAmmountException;
import content.Money;
import content.Text;
import entity.Inhabitant;

public class PromissoryNote extends Letter<Money> {

	public PromissoryNote(Money content, Inhabitant sender, Inhabitant receiver)
			throws Exception {
		super(content, sender, receiver);
		cost = super.cost() + (content.ammount() * 10 / 100);
	}

	public void verifyContent(Money content) throws NegativeAmmountException {
		if (content.ammount() < 0)
			throw new NegativeAmmountException(
					"you can't send a negative ammount of money");
	}

	@Override
	public void doOnReceive() {
		Text message = new Text("thanks for a promissory of "
				+ content.ammount());
		receiver.city().sendLetter(new SimpleLetter(message, receiver, sender));
	}

}
