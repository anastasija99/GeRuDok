package errorHandling;

public class NotEraseableException extends Exception {

	public NotEraseableException(String errMessage) {
		super("Ne mozete obrisati : "+errMessage);
	}
}
