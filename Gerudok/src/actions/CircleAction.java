package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;
import view.PageView;

public class CircleAction extends AbstractActionIcon {

	public CircleAction(Dimension d) {

		putValue(SMALL_ICON, iconGetter("/slotToolBar/circle.jpg", d));
		putValue(NAME, ("Circle"));
		putValue(SHORT_DESCRIPTION, ("Circle"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startCircleState();
		}
		catch(NullPointerException event){
			JOptionPane.showMessageDialog(null, "Select the page", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
