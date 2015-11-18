package letter;

import content.Content;

public class UrgentLetter extends LetterDecorator {

	private UrgentLetter(Letter<? extends Content> letter) {
		super(letter);
		cost = letter.cost() * 2;
	}

	public String description() {
		return "an urgent " + super.description();
	}

	public static UrgentLetter createLetter(Letter<? extends Content> letter) {
		if (letter instanceof UrgentLetter)
			throw new IllegalArgumentException();
		return new UrgentLetter(letter);
	}

}
