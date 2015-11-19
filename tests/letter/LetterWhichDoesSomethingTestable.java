package letter;

import content.Text;
import entity.Inhabitant;

public class LetterWhichDoesSomethingTestable extends Letter<Text> {
	protected boolean somethingHasBeenDone;

	public LetterWhichDoesSomethingTestable(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
		somethingHasBeenDone = false;
	}

	public void doOnReceive() {
		somethingHasBeenDone = true;
	}

	public boolean somethingHasBeenDone() {
		return somethingHasBeenDone;
	}

}
