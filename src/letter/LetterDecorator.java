package letter;

import content.Content;

public abstract class LetterDecorator extends Letter<Content> {

	protected Letter<? extends Content> letter;

	public LetterDecorator(Letter<? extends Content> letter) {
		super(letter.content(), letter.sender(), letter.receiver());
		this.letter = letter;
	}

	public void doOnReceive() {
		this.letter.doOnReceive();
	}
	
	@Override
	public String description() {
		return "letter whose content is " + letter.description();
	}

	public Letter<? extends Content> letter() {
		return letter;
	}

}
