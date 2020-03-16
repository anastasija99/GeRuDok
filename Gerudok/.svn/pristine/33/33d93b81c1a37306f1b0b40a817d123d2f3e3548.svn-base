package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class RectangleAction extends AbstractActionIcon {

	public RectangleAction(Dimension d) {

		putValue(SMALL_ICON, iconGetter("/slotToolBar/rectangle.jpg", d));
		putValue(NAME, ("Rectangle"));
		putValue(SHORT_DESCRIPTION, ("Rectangle"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startRectangleState();
		}
		catch(NullPointerException event){
			JOptionPane.showMessageDialog(null, "Select the page", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
