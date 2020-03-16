package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import filters.WorkspaceFileFilter;
import gui.MainFrame;
import model.Workspace;

public class SaveWorkspaceAction extends AbstractActionIcon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaveWorkspaceAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/toolbar/save.png", d));
		putValue(NAME, ("SaveWs"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfChooser = new JFileChooser();
		jfChooser.setFileFilter(new WorkspaceFileFilter());

		Workspace workspace = (Workspace) MainFrame.getInstance().getTree().getModel().getRoot();

		File wFile;

		if (jfChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
			wFile = jfChooser.getSelectedFile();
		} else
			return;

		saveWorkspace(wFile, workspace);
	}

	public void saveWorkspace(File f, Workspace w) {
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath()));
			os.writeObject(w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
