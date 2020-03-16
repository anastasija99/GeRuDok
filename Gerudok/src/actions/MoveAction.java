package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class MoveAction extends AbstractActionIcon {
	
	public MoveAction(Dimension d) {
		putValue(SMALL_ICON, iconGetter("/slotToolBar/move.png", d));
		putValue(NAME, "Move");
		putValue(SHORT_DESCRIPTION, "Move an object");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
		.getPageInFocus().startMoveState();
		
	}

}
