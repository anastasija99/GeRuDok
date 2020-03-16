package tree.listener;

import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import actions.manager.ActionManager;
import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;
import view.DocumentView;
import view.PageView;
import view.ProjectView;

public class JTreeController implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {

		TreePath path = e.getPath();

		Object selectedComponent = path.getLastPathComponent();

		if (selectedComponent instanceof Workspace) {

			ActionManager.getInstance().getSave().setEnabled(true);
			ActionManager.getInstance().getSaveas().setEnabled(true);

			ActionManager.getInstance().getDeletenode().setEnabled(false);

		} else if (selectedComponent instanceof Project) {
			Project project = (Project) selectedComponent;

			setProjectViewInFront(project);

			ActionManager.getInstance().getSave().setEnabled(true);
			ActionManager.getInstance().getSaveas().setEnabled(true);

			ActionManager.getInstance().getDeletenode().setEnabled(true);

		} else if (selectedComponent instanceof Document) {

			Document document = (Document) selectedComponent;
			Project project = null;
			if (document.isShared()) {
				Object[] pathElements = path.getPath();
				ArrayList<Project> projects = new ArrayList<Project>();
				projects.addAll(document.getAllParents());
				projects.add((Project) document.getParent());
				Object obj = pathElements[pathElements.length - 2];
				for (Project p : projects) {
					if (obj.equals(p)) {
						project = p;
					}
				}
			} else {
				project = (Project) document.getParent();
			}

			ProjectView projectView = setProjectViewInFront(project);
			setDocumentViewInFront(document, projectView);

			ActionManager.getInstance().getSave().setEnabled(true);
			ActionManager.getInstance().getSaveas().setEnabled(false);

			ActionManager.getInstance().getDeletenode().setEnabled(true);

		} else if (selectedComponent instanceof Page) {

			Page page = (Page) selectedComponent;
			Document document = (Document) page.getParent();
			Project project = null;
			if (document.isShared()) {
				Object[] pathElements = path.getPath();
				ArrayList<Project> projects = new ArrayList<Project>();
				projects.addAll(document.getAllParents());
				projects.add((Project) document.getParent());
				Object obj = pathElements[pathElements.length - 3];
				for (Project p : projects) {
					if (obj.equals(p)) {
						project = p;
					}
				}

			} else {
				project = (Project) document.getParent();
			}

			ProjectView projectView = setProjectViewInFront(project);
			DocumentView documentView = setDocumentViewInFront(document, projectView);
			setPageViewInFront(page, documentView);

			ActionManager.getInstance().getSave().setEnabled(true);
			ActionManager.getInstance().getSaveas().setEnabled(false);

			ActionManager.getInstance().getDeletenode().setEnabled(true);

		}
	}

	private PageView setPageViewInFront(Page page, DocumentView documentView) {
		for (PageView pageView : documentView.getPageViews()) {
			if (pageView.getPage().equals(page)) {
				pageView.scrollRectToVisible(pageView.getBounds());
				return pageView;
			}
		}
		return null;
	}

	private DocumentView setDocumentViewInFront(Document document, ProjectView projectView) {
		JTabbedPane tabbedPane = projectView.getTabbedPane();
		int tabCount = tabbedPane.getTabCount();
		for (int i = 0; i < tabCount; i++) {
			DocumentView documentView = (DocumentView) tabbedPane.getComponentAt(i);
			if (document.equals(documentView.getDocument())) {
				tabbedPane.setSelectedComponent(documentView);
				return documentView;
			}
		}
		return null;
	}

	private ProjectView setProjectViewInFront(Project project) {
		JInternalFrame[] projectViews = MainFrame.getInstance().getWorkspaceView().getAllFrames();
		for (JInternalFrame frame : projectViews) {
			Project p = ((ProjectView) frame).getProject();
			if (p.equals(project)) {
				try {
					((ProjectView) frame).setSelectedFromTree(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				return (ProjectView) frame;
			}
		}
		return null;
	}

}