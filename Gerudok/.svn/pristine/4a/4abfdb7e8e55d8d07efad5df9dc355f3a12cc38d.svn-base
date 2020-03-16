package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import javax.swing.JTree;
import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import actions.manager.ActionManager;
import gui.MainFrame;
import model.Document;
import model.Project;

@SuppressWarnings("serial")
public class SaveProjectAction extends AbstractActionIcon {

	public SaveProjectAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/menu/save.png", d));
		putValue(NAME, ("Save"));
		putValue(SHORT_DESCRIPTION, ("Save"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		Object selectedComponent = tree.getLastSelectedPathComponent();

		if (selectedComponent instanceof Project) {
			Project project = (Project) selectedComponent;
			File projectFile = project.getProjectFile();

			// Ukoliko fajl nije prethodno snimljen, poziva se Save As
			if (projectFile == null) {
				ActionManager.getInstance().getSaveas().actionPerformed(e);
				return;
			}
			if (!project.isProjectModified())
				return;

			for (Document doc : project.getDocuments()) {
				File documentFile = doc.getDocumentFile();

				if (documentFile == null) {
					documentFile = new File(projectFile.getParent() + "\\" + doc.getName() + ".doc");
					doc.setDocumentFile(documentFile);
				}

				if (!documentFile.getName().equals(doc.getName() + ".doc")) {
					try {
						Files.deleteIfExists(documentFile.toPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					doc.setDocumentFile(new File(projectFile.getParent() + "\\" + doc.getName() + ".doc"));
				}

				ObjectOutputStream os;
				try {
					os = new ObjectOutputStream(new FileOutputStream(doc.getDocumentFile()));
					os.writeObject(doc);

					os.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			project.setProjectModified(false);
		}
	}
}
