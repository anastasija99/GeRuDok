package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;

import actions.manager.AbstractActionIcon;
import enums.Share;
import gui.MainFrame;
import model.Document;
import view.ShareDocument;
import view.ShareDocument.ShareDoc;

public class ShareDocumentsAction extends AbstractActionIcon {

	public ShareDocumentsAction() {
		putValue(NAME, "Share");
		putValue(SHORT_DESCRIPTION, "Share documents");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Document> documents = new ArrayList<>();
			
		TreePath tree[] = MainFrame.getInstance().getTree().getSelectionPaths();
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		
		if(tree ==null) {
			JOptionPane.showMessageDialog(null, "Select document", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if(!(o instanceof Document)) {
			JOptionPane.showMessageDialog(null, "Select document", "Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
		for (TreePath tPath : tree) {
			int j = 0;
			while (j < tPath.getPathCount()) {
				if (tPath.getPathComponent(j) instanceof Document) {
					documents.add((Document) tPath.getPathComponent(j));
				}
				j++;
			}
		}
		}
		catch (NullPointerException event) {
			JOptionPane.showMessageDialog(null, "Select document", "Error", JOptionPane.ERROR_MESSAGE);
		}
	
		ShareDocument pDialog = new ShareDocument(MainFrame.getInstance(), documents);
		pDialog.setVisible(true);

	}

}
