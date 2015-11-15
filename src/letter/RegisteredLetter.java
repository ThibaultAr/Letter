package letter;

import content.Content;

public class RegisteredLetter extends LetterDecorator {

	public RegisteredLetter(Letter<? extends Content> letter) {
		super(letter);
		cost += 15;
	}

	public void doOnReceive() {
		super.doOnReceive();
		AknowledgmentOfReceipt aknoledgement = new AknowledgmentOfReceipt(receiver, sender, this);
		receiver.city().sendLetter(aknoledgement);
	}

	public String description() {
		return "a registered ";
	}
}
