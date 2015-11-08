package letter.exception;

public class EmptyTextException extends Exception {

	private static final long serialVersionUID = -4729309182054610832L;

	public EmptyTextException(){
		super();
	}

	public EmptyTextException(String message) {
		super(message);
	}
}
