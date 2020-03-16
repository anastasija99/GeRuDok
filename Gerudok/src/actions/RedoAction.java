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

public class RedoAction extends AbstractActionIcon implements Serializable {
	
	private SlotDevice slot;

	public RedoAction(SlotDevice slot, Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/menu/undo.png", d));
		putValue(NAME, ("Undo"));
		putValue(SHORT_DESCRIPTION, ("Redo"));

		this.slot = slot;
	}

	public RedoAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/menu/redo.png", d));
		putValue(NAME, ("Undo"));
		putValue(SHORT_DESCRIPTION, ("Redo"));

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Page p = ((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane()
				.getSelectedComponent()).getPageInFocus().getPage();
		p.getCommandManager().doCommand();
		
	}

}
