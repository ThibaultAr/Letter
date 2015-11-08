package letter;

import letter.exception.EmptyTextException;
import content.Text;
import entity.Inhabitant;

public class SimpleLetter extends Letter<Text> {

	public SimpleLetter(Text content, Inhabitant sender, Inhabitant receiver) throws Exception {
		super(content, sender, receiver);
	}

	@Override
	public void doOnReceive() {
		//TODO 
	}

	@Override
	public void verifyContent(Text content) throws EmptyTextException {
		if(content.empty())
			throw new EmptyTextException("You can't send a Empty letter");
	}

}
