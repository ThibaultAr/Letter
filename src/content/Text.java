package content;

public class Text implements Content {
	protected String text;

	public Text(String text) {
		this.text = text;
	}

	public Text() {
		text = "";
	}

	public String text() {
		return text;
	}

	public boolean empty() {
		return (text == "");
	}

	public String toString() {
		return "a text content (" + text + ") ";
	}
}
