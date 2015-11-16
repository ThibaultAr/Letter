package letter;

import content.Money;
import content.Text;
import displayer.Displayer;
import entity.City;
import entity.Inhabitant;

public class PostMain {

	public static void main(String args[]){
		City city = new City("city");
		Inhabitant sender = new Inhabitant("sender",city);
		Inhabitant receiver = new Inhabitant("receiver", city);
		
		Text textContent = new Text("bonjour");
		Letter<Text> simpleLetter = new SimpleLetter(textContent, sender, receiver);
		Letter<?> urgentLetter = new UrgentLetter(simpleLetter);
		Letter<?> registeredLetter = new RegisteredLetter(simpleLetter);
		Letter<?> urgentContainsRegistered = new UrgentLetter(registeredLetter);
		Letter<?> promissoryNote = new PromissoryNote(new Money(128), sender, receiver);
		
		city.sendLetter(urgentLetter);
		
		Displayer.getDisplayer().display("\n\n");
		
		city.sendLetter(promissoryNote);
		city.sendLetter(urgentContainsRegistered);
		
		Displayer.getDisplayer().display("\n\n");
		
		city.distributeLetter();

		Displayer.getDisplayer().display("\n\n");

		city.distributeLetter();
		
	}
}
