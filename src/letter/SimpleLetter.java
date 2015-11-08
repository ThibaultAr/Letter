package letter;

import content.Text;
import entity.Inhabitant;

public class SimpleLetter extends Letter<Text> {

	public SimpleLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public void doOnReceive() {
		
	}

}
