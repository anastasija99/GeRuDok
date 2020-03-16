package errorHandling;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import gui.MainFrame;


public class ErrorHandlerView extends JOptionPane implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		showMessageDialog(MainFrame.getInstance(), arg, "Error", JOptionPane.ERROR_MESSAGE);

		
	}

}
