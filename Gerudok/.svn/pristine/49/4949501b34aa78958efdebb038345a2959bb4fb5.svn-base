package actions;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;

import actions.manager.AbstractActionIcon;
import filters.WorkspaceFileFilter;
import gui.MainFrame;
import model.Workspace;

public class SwitchWorkspaceAction extends AbstractActionIcon {

	public SwitchWorkspaceAction() {
		putValue(NAME, "Switch");
		putValue(SHORT_DESCRIPTION, "Switch workspace");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new WorkspaceFileFilter());

		if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
			try {

				ObjectInputStream obs = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				Workspace workspace = null;
				try {
					workspace = (Workspace) obs.readObject();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				MainFrame.getInstance().getTree().setModel(new DefaultTreeModel(workspace));
				MainFrame.getInstance().getWorkspaceView().setWorkspace(workspace);

				workspace.addProjectView();
				
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				//MainFrame.getInstance().repaint();

			} catch (Exception event) {
				// TODO: handle exception
			}
		}
	}

}
