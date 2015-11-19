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

	public PostMain() {
		this.city = new City("Lille");
		Displayer.getDisplayer().display("Creating " + city.name() + " city\n");
		Displayer.getDisplayer().display("Creating " + PostMain.INHABITANT_NUMBER + " inhabitants\n");
		for (int i = 0; i < PostMain.INHABITANT_NUMBER; i++)
			inhabitants[i] = new Inhabitant("inhabitant-" + i, city, 5000);

	}

	/**
	 * Returns a random {@link Inhabitant} into those of the city.
	 */
	public Inhabitant randomInhabitant() {
		Random rand = new Random();
		int alea = rand.nextInt(PostMain.INHABITANT_NUMBER);
		return inhabitants[alea];
	}

	/**
	 * Returns a random letter chosen between {@link SimpleLetter} and
	 * {@link PromissoryNote}.
	 */
	private Letter<? extends Content> simpleOrPromissoryNoteLetter() {
		Random rand = new Random();
		int randLetter = rand.nextInt() % 2;

		if (randLetter == 0)
			return new SimpleLetter(new Text("bla bla"), randomInhabitant(), randomInhabitant());
		return new PromissoryNote(new Money(Math.abs(rand.nextInt() % 1000)), randomInhabitant(), randomInhabitant());
	}

	/**
	 * Cover (or not) the letter with the {@link RegisteredLetter} option.
	 * 
	 * @param letter
	 * @return Letter<?> a letter covered with {@link RegisteredLetter} option
	 *         or not
	 */
	private Letter<?> registeredOption(Letter<? extends Content> letter) {
		Random rand = new Random();
		int randOption = rand.nextInt() % 2;

		if (randOption == 0)
			return RegisteredLetter.createLetter(letter);
		return letter;
	}

	/**
	 * Cover (or not) the letter with the {@link UrgentLetter} option.
	 * 
	 * @param letter
	 * @return Letter<?> a letter covered with {@link UrgentLetter} option or
	 *         not
	 */
	private Letter<?> urgentOption(Letter<?> letter) {
		Random rand = new Random();
		int randOption = rand.nextInt() % 2;

		if (randOption == 0)
			return UrgentLetter.createLetter(letter);
		return letter;
	}

	/**
	 * Returns a random {@link Letter} with options (or not).
	 * 
	 * @return Letter<?> a random {@link Letter}.
	 */
	public Letter<?> randLetter() {
		Letter<?> letter = simpleOrPromissoryNoteLetter();
		letter = registeredOption(letter);
		letter = urgentOption(letter);

		return letter;
	}

	public static void main(String[] args) {
		PostMain post = new PostMain();
		Displayer.getDisplayer().display("Mailing letters for " + PostMain.DAYS_NUMBER + " days\n");
		int currentDay = 0;

		while (currentDay < PostMain.DAYS_NUMBER) {
			Displayer.getDisplayer()
					.display("********************************************\nDay " 
							+ (currentDay + 1) + "\n");
			
			Random rand = new Random();
			int randNumberOfLetters = PostMain.MIN_LETTERS_PER_DAY
					+ rand.nextInt(PostMain.MAX_LETTERS_PER_DAY - PostMain.MIN_LETTERS_PER_DAY);

			post.city.distributeLetter();
			for (int i = 0; i < randNumberOfLetters; i++) {
				Letter<?> letter = post.randLetter();
				post.city.sendLetter(letter);
			}

			currentDay++;
		}

		while (!post.city.postbox().isEmpty()) {
			Displayer.getDisplayer()
					.display("********************************************\nDay " 
							+ (currentDay + 1) + "\n");
			post.city.distributeLetter();
			currentDay++;
		}

	}

}
