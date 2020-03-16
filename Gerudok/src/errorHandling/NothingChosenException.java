package errorHandling;

public class NothingChosenException extends Exception{
	

	 public NothingChosenException(String errorMessage) {
	        super("Nista niste izabrali za : "+errorMessage);
	    }
}
