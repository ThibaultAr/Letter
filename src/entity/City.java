package entity;

import java.util.ArrayList;
import java.util.List;

import content.Content;
import letter.Letter;

public class City {
	protected String name;
	protected List<Inhabitant> inhabitants;
	protected List<Letter<Content>> postbox;
	
	public City(String name) {
		this.name = name;
		inhabitants = new ArrayList<Inhabitant>();
		postbox = new ArrayList<Letter<Content>>();
	}
	
	public void addInhabitant(Inhabitant inhabitant) throws IllegalArgumentException {
		if (inhabitant == null)
			throw new IllegalArgumentException();
		inhabitants.add(inhabitant);
	}
	
	public void sendLetter() {
		// TODO 
	}
	
	public void distributeLetter() {
		// TODO
	}
}
