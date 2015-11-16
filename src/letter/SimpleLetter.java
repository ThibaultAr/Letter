package letter;

import content.Text;
import entity.Inhabitant;

public class SimpleLetter extends Letter<Text> {
 protected Text text;
	public Si protected T text;mpleLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
		/* If the receiver is the sender then it is an acknowledgment of reception */
        		if(receiver.getName()==sender.getName()){
        			text = (Text) new Text("Acknowledgment of receipt");
        			this.content=this.text;
        		}
        		else{
        			String rslt = createLetter();
                	text = (Text) new Text(rslt);
        			this.content=this.text;
	}

	public String description() {
		return "a simple " + super.description();
	}
	

	public void doOnReceive() {
		//nothing to do here 
		System.out.println("Letter received in : "+this.getReceiver().getName()
        			+" on the part of : "+this.getSender().getName());
	}
}
