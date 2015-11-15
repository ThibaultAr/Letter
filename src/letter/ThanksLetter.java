package letter;

import content.Text;
import entity.Inhabitant;

public class ThanksLetter extends SimpleLetter {

	public ThanksLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		this(new Text("thanks for " + letter.toString()), sender, receiver);
	}

	private ThanksLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	public String toString() {
		return "a thanks letter which is " + super.toString();
	}
}
