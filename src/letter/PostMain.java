package letter;

import java.util.Random;

import content.Content;
import content.Money;
import content.Text;
import displayer.Displayer;
import entity.City;
import entity.Inhabitant;

public class PostMain {

	private static final int INHABITANT_NUMBER = 100;
	private static final int DAYS_NUMBER = 6;
	private static final int MIN_LETTERS_PER_DAY = 2;
	private static final int MAX_LETTERS_PER_DAY = 10;

	protected Inhabitant inhabitants[] = new Inhabitant[INHABITANT_NUMBER];
	protected City city;
	static protected PostMain simulation = null;
	
	public PostMain() {
		this.city = new City("Lille");
		Displayer.getDisplayer().display("Creating " + city.name() + " city\n");
		Displayer.getDisplayer().display(
				"Creating " + PostMain.INHABITANT_NUMBER + " inhabitants\n");
		for (int i = 0; i < PostMain.INHABITANT_NUMBER; i++)
			inhabitants[i] = new Inhabitant("inhabitant-" + i, city, 5000);
		
	}
	
	public static PostMain simulation(){
		if(PostMain.simulation == null)
			PostMain.simulation = new PostMain();
		return simulation;
	}

	public Inhabitant aleatInhabitant() {
		Random rand = new Random();
		int alea = rand.nextInt(PostMain.INHABITANT_NUMBER);
		return inhabitants[alea];
	}

	private Letter<? extends Content> simpleOrPromissoryNoteLetter() {
		Random rand = new Random();
		int randLetter = rand.nextInt() % 2;

		if (randLetter == 0)
			return new SimpleLetter(new Text("bla bla"), aleatInhabitant(),
					aleatInhabitant());
		return new PromissoryNote(new Money(Math.abs(rand.nextInt()%1000)), aleatInhabitant(),
				aleatInhabitant());
	}

	private Letter<?> registeredOption(Letter<? extends Content> letter) {
		Random rand = new Random();
		int randOption = rand.nextInt() % 2;

		if (randOption == 0)
			return RegisteredLetter.createLetter(letter);
		return letter;
	}

	private Letter<?> urgentOption(Letter<?> letter) {
		Random rand = new Random();
		int randOption = rand.nextInt() % 2;

		if (randOption == 0)
			return UrgentLetter.createLetter(letter);
		return letter;
	}

	public Letter<?> aleatLetter() {
		Letter<?> letter = simpleOrPromissoryNoteLetter();
		letter = registeredOption(letter);
		letter = urgentOption(letter);

		return letter;
	}

	public static void main(String[] args) {
		PostMain post = new PostMain();
		Displayer.getDisplayer().display(
				"Mailing letters for " + PostMain.DAYS_NUMBER + " days\n");
		int currentDay = 0;

		do {
			Displayer.getDisplayer().display(
					"********************************************\nDay "
							+ (currentDay+1) + "\n");
			Random rand = new Random();
			int randNumberOfLetters = PostMain.MIN_LETTERS_PER_DAY
					+ rand.nextInt(PostMain.MAX_LETTERS_PER_DAY
							- PostMain.MIN_LETTERS_PER_DAY);

			for (int i = 0; i < randNumberOfLetters; i++) {
				Letter<?> letter = post.aleatLetter();
				post.city.sendLetter(letter);
			}
			
			post.city.distributeLetter();
			currentDay++;
		} while (!(post.city.postbox().isEmpty()) && (currentDay <= 6));
	}

}
