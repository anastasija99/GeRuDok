package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import errorHandling.ErrorHandler;
import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;

public class DeleteNode extends AbstractActionIcon {

	public DeleteNode(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		putValue(SMALL_ICON, iconGetter("/menu/delete.png", d));
		putValue(NAME, ("Delete"));
		putValue(SHORT_DESCRIPTION, ("Delete"));
		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();
		Object[] path = tree.getSelectionPath().getPath();

		if (tree.getLastSelectedPathComponent() == null)
			ErrorHandler.getInstance().NothingChosenException("brisanje");

		if (((selectedComponent instanceof Workspace)) || (selectedComponent == null)) {
			ErrorHandler.getInstance().NotEraseableException("Workspace");
			return;

		} else if (selectedComponent instanceof Project) {

			Project project = (Project) selectedComponent;
			Workspace parent = (Workspace) project.getParent();
			// try {
			if (!project.getDocuments().isEmpty()) {
				// ShareDialog pDig = new ShareDialog(MainFrame.getInstance(),
				// project.getDocuments(), Share.DELETE);
				// pDig.setVisible(true);
			}
			parent.deleteProject(project);
			// } catch (Exception e2) {
			parent.removeNode(project);
			// }

			parent.removeNode(project);

		} else if (selectedComponent instanceof Document) {

			Document document = (Document) selectedComponent;
			Project project = (Project) path[1];
			project.deleteDocument(document);

		} else if (selectedComponent instanceof Page) {

			Page page = (Page) selectedComponent;
			Document parent = (Document) page.getParent();
			parent.deletePage(page);

		}

	}

}
