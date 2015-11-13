package letter;

import content.Content;
import entity.Inhabitant;

public abstract class Letter<C extends Content> {
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

	public Inhabitant sender() {
		return sender;
	}

	public Inhabitant receiver() {
		return receiver;
	}
}
