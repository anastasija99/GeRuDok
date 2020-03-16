package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.WorkspaceView;

public class CloseAllAction extends AbstractActionIcon {

	public CloseAllAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		putValue(SMALL_ICON, iconGetter("/menu/deleteAllTabs.png", d));
		putValue(NAME, ("Close All"));
		putValue(SHORT_DESCRIPTION, ("Close All"));
		setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WorkspaceView workSpaceView = MainFrame.getInstance().getWorkspaceView();

		for (JInternalFrame frame : workSpaceView.getAllFrames()) {
			if (frame.isSelected()) {
				frame.removeAll();
				frame.updateUI();
				return;
			}
		}

	}

}
