package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class NewWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		JFrame frame = (JFrame) e.getComponent();

		int code = JOptionPane.showConfirmDialog(frame, "Do you want to open an old Workspace?", "Opening",
				JOptionPane.YES_NO_OPTION);

		if (code == JOptionPane.YES_OPTION) {

			MainFrame.getInstance().getActionManager().getSwitchWs().actionPerformed(null);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		} else if (code == JOptionPane.NO_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame) e.getComponent();

		int code = JOptionPane.showConfirmDialog(frame, "Do you want to save your Workspace first?", "Closing",
				JOptionPane.YES_NO_CANCEL_OPTION);

		if (code == JOptionPane.YES_OPTION) {

			MainFrame.getInstance().getActionManager().getSaveWsAction().actionPerformed(null);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

		else if (code == JOptionPane.NO_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

		else {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
