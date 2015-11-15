package letter;

import content.Text;
import entity.Inhabitant;

public class SimpleLetter extends Letter<Text> {

	public SimpleLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	public String toString() {
		return "a simple " + super.toString() + "whose content is " + content.toString();
	}
}
