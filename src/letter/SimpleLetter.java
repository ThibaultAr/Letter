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

	public void doOnReceive() {
		// nothing to do here
	}
}
