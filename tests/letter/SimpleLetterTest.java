package letter;

import content.Text;

public class SimpleLetterTest extends LetterTest<Text> {

	public Letter<Text> createLetter() {
		return (Letter<Text>) new SimpleLetter(new Text("Bonjour"), null, null);
	}
}
