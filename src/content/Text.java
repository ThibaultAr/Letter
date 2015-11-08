package content;

public class Text implements Content {
	protected String text = "";

	public Text(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public boolean empty() {
		return (text=="");
	}
}
