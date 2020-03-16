package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class ResizeAction extends AbstractActionIcon {

	public ResizeAction(Dimension d) {
		putValue(SMALL_ICON, iconGetter("/slotToolBar/resize.png", d));
		putValue(NAME, "Resize");
		putValue(SHORT_DESCRIPTION, "Resize an object");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startResizeState();
	}

}
