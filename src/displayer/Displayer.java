package displayer;

/**
 * Displayer is in charge of the display, he has a unique instance
 * @author arloing
 *
 */
public class Displayer {

	static protected Displayer displayer = null;

	private Displayer() {

	}

	public static Displayer getDisplayer() {
		if (displayer == null)
			displayer = new Displayer();
		return displayer;
	}

	public void display(String message) {
		System.out.print(message);
	}
}
