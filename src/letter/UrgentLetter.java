package letter;

import content.Content;

public class UrgentLetter extends LetterDecorator {

	public UrgentLetter(Letter<? extends Content> letter) {
		super(letter);
		cost *= 2;
	}

	public String description() {
		return "an urgent ";
	}

}
