package view;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

import events.ProjectEvent;
import events.ProjectEvent.ProjectEventType;
import events.WorkspaceEvent;
import events.WorkspaceEvent.WorkspaceEventType;
import gui.MainFrame;
import model.Document;
import model.Page;
import model.Project;
import model.Workspace;

public class WorkspaceView extends JDesktopPane implements Observer {

	private ProjectView projView = null;
	private PageView pageView = null;
	private Page page = null;
	private Workspace workspace;

	public WorkspaceView() {
		super();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		WorkspaceEvent eventObject = (WorkspaceEvent) arg1;
		Project project = eventObject.getProject();

		if (eventObject.getType() == WorkspaceEventType.ADD_PROJECT) {

			ProjectView projectView = new ProjectView(project);
			setProjView(projectView);
			projectView.setVisible(true);
			project.addObserver(projectView);

			ArrayList<Document> documents = eventObject.getProject().getDocuments();
			for (Document document : documents) {

				project.notifyObservers(new ProjectEvent(ProjectEventType.ADD_DOCUMENT, document));
			}

		} else if (eventObject.getType() == WorkspaceEventType.REMOVE_PROJECT) {

			for (JInternalFrame frame : getAllFrames()) {
				ProjectView projectView = (ProjectView) frame;
				if (projectView.getProject().equals(eventObject.getProject())) {
					try {
						projectView.setClosed(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else if (eventObject.getType() == WorkspaceEventType.OPEN_PROJECT) {

			ProjectView projectView = new ProjectView(project);
			add(projectView);
			projectView.setVisible(true);
			project.addObserver(projectView);

			for (Document document : project.getDocuments()) {
				DocumentView documentView = new DocumentView(document);
				projectView.addDocumentView(documentView);
				document.addObserver(documentView);
				for (Page page : document.getPages()) {
					PageView pageView = new PageView(documentView, page);
					documentView.addPageView(pageView);
					page.addObserver(pageView);
					documentView.validate();

				}
			}

		}

		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Page getPage() {
		return page;
	}

	public void removeSelectedTab() {
		projView.removeSelectedTab();
	}

	public void removeAllTabs() {
		projView.removeAllTabs();
	}

	public ProjectView getProjView() {
		return projView;
	}

	public void setProjView(ProjectView projView) {
		this.projView = projView;
		add(projView);
	}

	public PageView getPageView() {
		return pageView;
	}

	public void setPageView(PageView pageView) {
		this.pageView = pageView;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
		workspace.addObserver(this);
	}
}
