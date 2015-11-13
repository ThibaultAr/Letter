package letter;

import content.Money;
import entity.Inhabitant;

public class PromissoryNote extends Letter<Money>{

	public PromissoryNote(Money content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
		cost = super.cost() + (content.amount() * 10 / 100);
	}

	public void doOnReceive() {
		ThanksLetter thanks = new ThanksLetter(receiver, sender, this);
		receiver.city().sendLetter(thanks);
		super.doOnReceive();
		sender.debit(content.amount());
		receiver.credit(content.amount());
	}

	public String toString() {
		return "a promissory note "+super.toString()+"whose content is "+content.toString();
	}
}
