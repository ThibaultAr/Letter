package entity;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;
import content.Content;

public class City {
	protected String name;
	protected List<Inhabitant> inhabitants;
	protected List<Letter<? extends Content>> postbox;

	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
		postbox = new ArrayList<Letter<? extends Content>>();
	}

	public void addInhabitant(Inhabitant inhabitant) throws IllegalArgumentException {
		if (inhabitant == null)
			throw new IllegalArgumentException();
		inhabitants.add(inhabitant);
	}

	public void sendLetter(Letter<? extends Content> letter) {
		postbox.add(letter);
		letter.doOnSending();
	}

	public void distributeLetter() {
		for (Letter<? extends Content> letter : postbox) {
			letter.doOnReceive();
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
