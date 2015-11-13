package content;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextTest {

	@Test
	public void testConstruct() {
		Text text = new Text();
		assertTrue(text.empty());
	}

	@Test
	public void nonEmptyTextShouldReturnNonEmptyString() {
		Text text = new Text("Bonjour c'est bien");
		assertFalse(text.text().isEmpty());
		assertEquals("Bonjour c'est bien", text.text());
	}
}
