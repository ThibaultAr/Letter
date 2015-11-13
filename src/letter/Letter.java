package letter;

import content.Content;
import displayer.Displayer;
import entity.Inhabitant;

public abstract class Letter<C extends Content> implements Content {
	protected int cost;
	protected C content;
	protected Inhabitant sender;
	protected Inhabitant receiver;

	public Letter(C content, Inhabitant sender, Inhabitant receiver) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		cost = 1;
	}

	public int cost() {
		return cost;
	}

	public C content() {
		return content;
	}

	public String toString(){
		return "letter ";
	}

	public void doOnReceive(){
		Displayer.getDisplayer().display("<- "+receiver.name()+" receives "+toString()+ "from "+sender.name()+"\n");
	}
	
	public void doOnSending(){
		Displayer.getDisplayer().display("-> "+sender.name()+" mails "+toString()+ "to  "+receiver.name()+" for a cost of "+cost()+" euro\n");
		sender.debit(cost());
	}
}
