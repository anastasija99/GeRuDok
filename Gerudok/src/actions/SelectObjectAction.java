package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class SelectObjectAction extends AbstractActionIcon {

	public SelectObjectAction(Dimension d) {

		putValue(SMALL_ICON, iconGetter("/slotToolBar/selectObject.png", d));
		putValue(NAME, ("Select an object"));
		putValue(SHORT_DESCRIPTION, ("Select an object"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startSelectObjectState();
	}

}
