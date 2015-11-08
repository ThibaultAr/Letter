package content;

public class Text implements Content {
	protected String text;
	
	public Text() {
		text = "";
	}
	
	public Text(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
