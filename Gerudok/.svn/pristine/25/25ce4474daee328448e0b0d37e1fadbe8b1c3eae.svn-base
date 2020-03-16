package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import actions.manager.AbstractActionIcon;
import errorHandling.ErrorHandler;
import gui.MainFrame;
import model.Workspace;

public class RenameNode extends AbstractActionIcon {

	public RenameNode(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(SMALL_ICON, iconGetter("/toolbar/rename.png", d));
		putValue(NAME, ("Open"));
		putValue(SHORT_DESCRIPTION, ("Open"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		TreePath path = tree.getSelectionPath();

		if (selectedComponent instanceof Workspace) {
			ErrorHandler.getInstance().CantRenameException("Workspace");
			return;
		}

		if (path != null) {
			tree.startEditingAtPath(path);
		}
	}
}