package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class RotateAction extends AbstractActionIcon {

	public RotateAction(Dimension d) {
		putValue(SMALL_ICON, iconGetter("/slotToolBar/rotate.png", d));
		putValue(NAME, "Rotate");
		putValue(SHORT_DESCRIPTION, "Rotate an object");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startRotateState();
	}

}
