package errorHandling;

public class BadInputException extends Exception{

	 public BadInputException(String errorMessage) {
	        super("Pogresan unos :"+errorMessage);
	    }
	
}
