package letter;

import content.Content;

public abstract class LetterDecorator extends Letter<Content> {

	protected Letter<? extends Content> letter;

	public LetterDecorator(Letter<? extends Content> letter) {
		super(letter.content(), letter.sender(), letter.receiver());
		this.letter = letter;
	}

	public String toString() {
		return description() + super.toString() + "whose content is " + letter.toString();
	}

	public abstract String description();
}
