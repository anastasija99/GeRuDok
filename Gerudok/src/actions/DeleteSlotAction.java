package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class DeleteSlotAction extends AbstractActionIcon {

	public DeleteSlotAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/deleteSlot.png", d));
		putValue(NAME, ("Delete selected slot"));
		putValue(SHORT_DESCRIPTION, ("Delete selected slot"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startDeleteState();

	}

}
