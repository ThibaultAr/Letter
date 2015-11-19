package letter;

import content.Text;
import entity.Inhabitant;

/**
 * An AknowledgmentOfReceipt is a specific SimpleLetter which allows the sender to know that his letter has arrived  
 *
 */
public class AknowledgmentOfReceipt extends SimpleLetter {

	public AknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver,
			Letter<?> letter) {
		this(
				new Text("aknowledgment of receipt for a "
						+ letter.description()), sender, receiver);
	}

	private AknowledgmentOfReceipt(Text content, Inhabitant sender,
			Inhabitant receiver) {
		super(content, sender, receiver);
	}

	public String description() {
		return "an aknowledgment of receipt which is " + super.description();
	}
}
