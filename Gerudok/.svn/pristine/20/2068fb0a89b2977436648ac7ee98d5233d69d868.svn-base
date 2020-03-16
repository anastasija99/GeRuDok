package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import view.DocumentView;

public class TriangleAction extends AbstractActionIcon {

	public TriangleAction(Dimension d) {

		putValue(SMALL_ICON, iconGetter("/slotToolBar/triangle.jpg", d));
		putValue(NAME, ("Triangle"));
		putValue(SHORT_DESCRIPTION, ("Triangle"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startTriangleState();
		
	}
	catch(NullPointerException event){
		JOptionPane.showMessageDialog(null, "Select the page", "Error", JOptionPane.ERROR_MESSAGE);
	}

	}

}
