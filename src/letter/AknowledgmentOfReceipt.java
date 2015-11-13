package letter;

import content.Text;
import entity.Inhabitant;

public class AknowledgmentOfReceipt extends SimpleLetter{

	public AknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver, Letter<?> letter){
		this(new Text("aknowledgment of receipt for a " + letter.toString()), sender, receiver);
	}

	private AknowledgmentOfReceipt(Text content, Inhabitant sender,	Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	public String toString(){
		return "an aknowledgment of receipt which is "+super.toString();
	}
}
