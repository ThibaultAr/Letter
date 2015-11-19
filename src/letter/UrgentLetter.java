package letter;

import content.Content;

/**
 * An UrgentLetter can contain every letter except an UrgentLetter.
 * Its cost is double. 
 *
 */
public class UrgentLetter extends LetterDecorator {

	private UrgentLetter(Letter<? extends Content> letter) {
		super(letter);
		cost = letter.cost() * 2;
	}

	public String description() {
		return "an urgent " + super.description();
	}

	/**
	 * Creates an UrgentLetter only if the letter contained isn't an UrgentLetter.
	 * This method replace the constructor
	 * @param letter
	 * @return an UrgentLetter
	 */
	public static UrgentLetter createLetter(Letter<? extends Content> letter) {
		if (letter instanceof UrgentLetter)
			throw new IllegalArgumentException();
		return new UrgentLetter(letter);
	}

}
