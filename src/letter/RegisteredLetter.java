package letter;

import content.Content;
import entity.Inhabitant;

public class RegisteredLetter extends Letter<Letter<? extends Content>> {

	public RegisteredLetter(Letter<?> content, Inhabitant sender,
			Inhabitant receiver) {
		super(content, sender, receiver);
		cost += 15;
	}

	public String toString() {
		return "a registered letter which is " + super.toString();
	}
	
	public void doOnReceive(){
		super.doOnReceive();
		//new AcknoledgmentOfReceipt(receiver,sender,this);
		//TODO : send the new AcknOR
	}
}
