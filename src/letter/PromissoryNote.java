package letter;

import content.Money;
import entity.Inhabitant;

/**
 * A PromissoryNote is a Letter which contains {@link Money}. 
 * The promissory note cost is increased by 10% of its amount. 
 */
public class PromissoryNote extends Letter<Money> {

	public PromissoryNote(Money content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
		cost = super.cost() + (content.amount() * 10 / 100);
	}

	/**
	 * When a promissory note is received, thereceiver automaticaly send a {@link ThanksLetter}
	 */
	public void doOnReceive() {
		ThanksLetter thanks = new ThanksLetter(receiver, sender, this);
		receiver.sendLetter(thanks);

		sender.debit(content.amount());
		receiver.credit(content.amount());
	}

	public String description() {
		return "a promissory note " + super.description();
	}
}
