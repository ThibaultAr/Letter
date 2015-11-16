package letter;

import content.Text;
import entity.Inhabitant;

public class ThanksLetter extends SimpleLetter {

	public ThanksLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		this(new Text("thanks for " + letter.description()), sender, receiver);
	}

	private ThanksLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	public String description() {
		return "a thanks letter which is " + super.description();
	}
}
