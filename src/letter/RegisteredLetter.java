package letter;

import content.Content;

public class RegisteredLetter extends LetterDecorator {

	private RegisteredLetter(Letter<? extends Content> letter) {
		super(letter);
		cost = letter.cost() + 15;
	}

	public void doOnReceive() {
		super.doOnReceive();
		AknowledgmentOfReceipt aknoledgement = new AknowledgmentOfReceipt(
				receiver, sender, this);
		receiver.sendLetter(aknoledgement);
	}

	public String description() {
		return "a registered " + super.description();
	}

	public static RegisteredLetter createLetter(Letter<? extends Content> letter) {
		if (letter instanceof RegisteredLetter
				|| letter instanceof UrgentLetter)
			throw new IllegalArgumentException();
		return new RegisteredLetter(letter);
	}
}
