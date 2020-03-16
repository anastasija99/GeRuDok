package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import model.Page;
import model.elements.SlotDevice;
import view.DocumentView;

public class UndoAction extends AbstractActionIcon implements Serializable {

	private SlotDevice slot;

	public UndoAction(SlotDevice slot, Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/menu/undo.png", d));
		putValue(NAME, ("Undo"));
		putValue(SHORT_DESCRIPTION, ("Undo"));

		this.slot = slot;
	}

	public UndoAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/menu/undo.png", d));
		putValue(NAME, ("Undo"));
		putValue(SHORT_DESCRIPTION, ("Undo"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Page p = ((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane()
				.getSelectedComponent()).getPageInFocus().getPage();
		p.getCommandManager().undoCommand();

	}

}
