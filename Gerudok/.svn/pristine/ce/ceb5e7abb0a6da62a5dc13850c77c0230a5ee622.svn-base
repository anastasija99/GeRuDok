package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class SelectionAction extends AbstractActionIcon {
	
	
	public SelectionAction(Dimension d) {
		putValue(SMALL_ICON, iconGetter("/slotToolBar/select.png", d));
		putValue(NAME, "Select");
		putValue(SHORT_DESCRIPTION, "Select object");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
		.getPageInFocus().startSelectState();
		
	}

}
