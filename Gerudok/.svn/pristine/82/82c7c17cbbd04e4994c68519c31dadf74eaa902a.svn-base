package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;

@SuppressWarnings("serial")
public class QuitAction extends AbstractActionIcon {

	public QuitAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		putValue(NAME, ("Quit"));
		putValue(SHORT_DESCRIPTION, ("Quit"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
	}

}
