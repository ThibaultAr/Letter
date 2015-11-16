package entity;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;
import content.Content;
import displayer.Displayer;

public class City {
	protected String name;
	protected List<Inhabitant> inhabitants;
	protected List<Letter<? extends Content>> postbox;

	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
		postbox = new ArrayList<Letter<? extends Content>>();
	}

	public void addInhabitant(Inhabitant inhabitant)
			throws IllegalArgumentException {
		if (inhabitant == null)
			throw new IllegalArgumentException();
		inhabitants.add(inhabitant);
	}

	public void sendLetter(Letter<? extends Content> letter) {
		postbox.add(letter);
		Displayer.getDisplayer().display(
				"-> " + letter.sender().name() + " mails " + letter.description() + "to  "
						+ letter.receiver().name() + " for a cost of " + letter.cost()
						+ " euro\n");
		letter.sender().debit(letter.cost());
	}

	public void distributeLetter() {
		for (Letter<? extends Content> letter : postbox) {
			letter.doOnReceive();
			Displayer.getDisplayer().display(
					"<- " + letter.receiver().name() + " receives "
							+ letter.description() + "from "
							+ letter.sender().name() + "\n");
		}
		postbox.removeAll(postbox);
	}

	public List<Inhabitant> inhabitants() {
		return inhabitants;
	}

	public List<Letter<? extends Content>> postbox() {
		return postbox;
	}

}
