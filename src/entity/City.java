package entity;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;
import content.Content;
import displayer.Displayer;

/**
 * The city is define by it name and contains multiples inhabitants, a post box
 * with letters in it The class allows us to add inhabitant to the city and
 * send/distribute a letter
 */

public class City {
	protected String name;
	protected List<Inhabitant> inhabitants;
	/**
	 * This bag is used to distribute the letters
	 */
	protected List<Letter<? extends Content>> bag;
	/**
	 * This postbox is used to receive letters when they're sent
	 */
	private List<Letter<? extends Content>> postbox;

	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
		bag = new ArrayList<Letter<? extends Content>>();
		postbox = new ArrayList<Letter<? extends Content>>();
	}

	public void addInhabitant(Inhabitant inhabitant) throws IllegalArgumentException {
		if (inhabitant == null)
			throw new IllegalArgumentException();
		inhabitants.add(inhabitant);
	}

	public void sendLetter(Letter<? extends Content> letter) {
		postbox.add(letter);
		Displayer.getDisplayer()
				.display("-> " + letter.sender().name() + " mails " 
						+ letter.description() + "to  "
						+ letter.receiver().name() + " for a cost of " + letter.cost() + " euro"
						+ ((letter.cost() > 1) ? "s\n" : "\n"));
		letter.sender().debit(letter.cost());
	}

	public void distributeLetter() {
		bag.addAll(postbox);
		postbox.removeAll(postbox);
		for (Letter<? extends Content> letter : bag) {
			letter.doOnReceive();
			Displayer.getDisplayer().display("<- " + letter.receiver().name() + " receives " 
					+ letter.description()
					+ "from " + letter.sender().name() + "\n");
		}
		bag.removeAll(bag);
	}

	public List<Inhabitant> inhabitants() {
		return inhabitants;
	}

	public List<Letter<? extends Content>> bag() {
		return bag;
	}

	public List<Letter<? extends Content>> postbox() {
		return postbox;
	}

	public String name() {
		return name;
	}

}
