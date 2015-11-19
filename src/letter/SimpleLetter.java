package letter;

import content.Text;
import entity.Inhabitant;

public class SimpleLetter extends Letter<Text> {

	public SimpleLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	public String description() {
		return "a simple " + super.description();
	}

	/**
	 * For a simpleLetter there's nothing to do when it's received.
	 */
	public void doOnReceive() {

	}
}
