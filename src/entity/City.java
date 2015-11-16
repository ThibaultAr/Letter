package entity;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;
import content.Content;
import displayer.Displayer;

/**
 * The city is define by it name and contains multiples inhabitants, a post box with letters in it
 * The class allows us to add inhabitant to the city and send/distribute a letter
 */

public class City {
	protected String name;
	protected List<Inhabitant> inhabitants;

	/**
	 * This postbox is used to distribute the letters
	 */
	protected List<Letter<? extends Content>> postbox;
	/**
	 * This box is used to receive letters when they're sent
	 */
	private List<Letter<? extends Content>> box;
	

	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
		postbox = new ArrayList<Letter<? extends Content>>();
		box = new ArrayList<Letter<? extends Content>>();
	}

	public void addInhabitant(Inhabitant inhabitant)
			throws IllegalArgumentException {
		if (inhabitant == null)
			throw new IllegalArgumentException();
		inhabitants.add(inhabitant);
	}

	public void sendLetter(Letter<? extends Content> letter) {
		box.add(letter);
		Displayer.getDisplayer().display(
				"-> " + letter.sender().name() + " mails " + letter.description() + "to  "
						+ letter.receiver().name() + " for a cost of " + letter.cost()
						+ " euro\n");
		letter.sender().debit(letter.cost());
	}
	/*
	 * Distribution of letters from postbox of the city to each recipient
	 */
	public void distributeLetter() {
		postbox.addAll(box);
		box.removeAll(box);
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
	
	public List<Letter<? extends Content>> box() {
		return box;
	}
	/**
	 * To the state bank accounts from each one the residents in the city
	 */
	public void getAccountCityState() {
		for (Inhabitant hab : v) {
			System.out.println("Bank account of Mr " + hab.getName() + " : "
					+ hab.getBalance());
		}
	}

	/**
	 * Make the state the contents of the postbox displaying the sender the
	 * receiver the type of letter
	 */
	public void getpostBoxState() {

		System.out.println("############## POST BOX ##############");
		List<Letter<?>> bag = new ArrayList<Letter<?>>(postbox);
		int index = 1;
		for (Letter<?> l : bag) {
			System.out.println("Lettre N°" + index + " : Lettre ["
					+ l.getClass() + "] of " + l.getSender().getName()
					+ " is destined for " + l.getReceiver().getName());
			index = index + 1;
		}
		System.out.println("######################################");
	}

	public int getNbHab() {
		int nb = 0;
		for (@SuppressWarnings("unused")
		Inhabitant hab : v) {
			nb = nb + 1;
		}
		return nb;
	}

	public int getNbLetters() {
		int nb = 0;
		for (@SuppressWarnings({ "rawtypes", "unused" })
		Letter l : postbox) {
			nb = nb + 1;
		}
		return nb;

	}



	public String getName() {
		return name;
	}

}
