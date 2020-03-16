package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import model.elements.SlotDevice;
import view.DocumentView;

public class PasteAction extends AbstractActionIcon implements Serializable {

	private SlotDevice slot;

	public PasteAction(SlotDevice slot, Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/paste.png", d));
		putValue(NAME, ("Paste"));
		putValue(SHORT_DESCRIPTION, ("Paste"));

		this.slot = slot;
	}

	public PasteAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/paste.png", d));
		putValue(NAME, ("Paste"));
		putValue(SHORT_DESCRIPTION, ("Paste"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().paste();
		MainFrame.getInstance().getTree().updateUI();

	}

}
