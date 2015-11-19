package letter;

import content.Content;

/**
 * An RegisteredLetter can contain every letter except a RegisteredLetter and an
 * UrgentLetter. Its cost is increased by 15.
 *
 */
public class RegisteredLetter extends LetterDecorator {

	private RegisteredLetter(Letter<? extends Content> letter) {
		super(letter);
		cost = letter.cost() + 15;
	}

	public void doOnReceive() {
		super.doOnReceive();
		AknowledgmentOfReceipt aknoledgement = new AknowledgmentOfReceipt(receiver, sender, this);
		receiver.sendLetter(aknoledgement);
	}

	public String description() {
		return "a registered " + super.description();
	}

	/**
	 * Creates an RegisteredLetter only if the letter contained isn't an
	 * {@link UrgentLetter} or a RegisteredLetter. This method replace the
	 * constructor
	 * 
	 * @param letter
	 * @return an RegisteredLetter
	 */
	public static RegisteredLetter createLetter(Letter<? extends Content> letter) {
		if (letter instanceof RegisteredLetter || letter instanceof UrgentLetter)
			throw new IllegalArgumentException();
		return new RegisteredLetter(letter);
	}
}
