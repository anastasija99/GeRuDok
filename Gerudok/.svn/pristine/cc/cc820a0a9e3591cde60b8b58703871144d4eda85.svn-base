package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;

import gui.MainFrame;
import model.Project;
import view.ProjectView;
import view.WorkspaceView;

public class DisplayProject extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selectedComponent = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (selectedComponent instanceof Project) {
			Project project = (Project) selectedComponent;

			WorkspaceView workspaceView = MainFrame.getInstance().getWorkspaceView();
			for (JInternalFrame frame : workspaceView.getAllFrames()) {
				if (((ProjectView) frame).getProject().equals(project))
					frame.setVisible(true);
			}
		}
	}
}
