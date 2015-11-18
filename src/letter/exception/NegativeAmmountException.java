package letter.exception;

public class NegativeAmmountException extends RuntimeException {

	/*
	 * Class version, it is used to check if the server and the client have the
	 * same version of this class
	 */
	private static final long serialVersionUID = 8420872100896038430L;

	public NegativeAmmountException() {
		super();
	}

	public NegativeAmmountException(String message) {
		super(message);
	}
}
