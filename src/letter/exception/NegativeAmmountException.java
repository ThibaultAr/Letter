package letter.exception;

public class NegativeAmmountException extends RuntimeException {

	private static final long serialVersionUID = 8420872100896038430L;

	public NegativeAmmountException() {
		super();
	}

	public NegativeAmmountException(String message) {
		super(message);
	}
}
