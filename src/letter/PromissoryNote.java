package letter;

import content.Money;
import entity.Inhabitant;

public class PromissoryNote extends Letter<Money> implements LetterWithSpecificActionOnReceive {

	public PromissoryNote(Money content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
		cost = super.cost() + (content.amount() * 10 / 100);
	}

	@Override
	public void doOnReceive() {
		ThanksLetter thanks = new ThanksLetter(receiver, sender, this);
		receiver.city().sendLetter(thanks);
	}

	public String toString() {
		return "a promissory note "+super.toString()+"whose content is "+content.toString();
	}
}
