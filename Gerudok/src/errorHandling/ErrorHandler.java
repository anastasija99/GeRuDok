package errorHandling;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;




 public class ErrorHandler extends Observable{
	
	private ArrayList <Observable> observers = new ArrayList<>();
	boolean changed = false;
	private static ErrorHandler instance = null;
	
	public static ErrorHandler getInstance() {
		if(instance == null) instance = new ErrorHandler();
		return instance;	
	}
	
	
	public void CantAddNewException() {
		setChanged();
		
		notifyObservers("Ne mozete dodati nista na stranicu");
	}
	
	public void NothingChosenException(String errMsg) {
		setChanged();
		notifyObservers("Nije selektovano nista za " + errMsg);
	}
	
	public void NotEraseableException(String errMsg) {
		setChanged();
		notifyObservers("Nemoguce je obrisati " + errMsg);
	}
	
	public void BadInputException(String errMsg) {
		setChanged();
		notifyObservers("Pogresan unos " + errMsg);
	}
	
	public void CantRenameException(String errMsg) {
		setChanged();
		notifyObservers("Ne mozete preimenovati " + errMsg);
	}
	
	
	public void addObserver(Observable o) {
			observers.add(o);
			//System.out.println(o);
	}

	public void deleteObserver(Observable o) {
		observers.remove(o);
		
	}

	@Override
	public boolean hasChanged() {
		return changed;
	}

	@Override
	public void setChanged() {
		changed = true;
	}

	@Override
	public void clearChanged() {
		changed = false;
	}



}
