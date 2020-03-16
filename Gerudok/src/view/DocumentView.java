package view;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import events.DocumentEvent;
import events.DocumentEvent.DocumentEventType;
import gui.MainFrame;
import model.Document;

public class DocumentView extends JScrollPane implements Observer {

	private String name;
	private Document document;
	private DocumentPanel panel;
	private PageView focusPageView = null;
	private PagePanel focusPagePanel = null;
	private ArrayList<PageView> pageViews;

	
	

	public DocumentView(Document document) {
		super();
		this.document = document;
		this.name = document.getName();
		this.panel = new DocumentPanel();
		this.pageViews = new ArrayList<>();
		
		
		setViewportView(this.panel);
		

	}

	public ProjectView getProjectView() {
		return (ProjectView) getParent().getParent().getParent().getParent().getParent();
	}

	public DocumentPanel getDocumentPanel() {
		return this.panel;
	}

	public Document getDocument() {
		return this.document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<PageView> getPageViews() {
		return pageViews;
	}

	public void addPageView(PageView view) {
		pageViews.add(view);
		panel.add(view);
		panel.validate();
	}
	


	public void removePageView(PageView view) {
		pageViews.remove(view);
		panel.remove(view);
		panel.validate();
	}

	public void setPageInFocus(PageView fp, MouseEvent event) {
		for (PageView pw : pageViews) {
			System.out.println(pw.getPage().getName());
		}

		this.focusPageView = fp;

	}
	
	public void setPagePanelInFocus(PagePanel fp, MouseEvent event) {
		for (PageView pw : pageViews) {
			System.out.println(pw.getPage().getName());
		}

		this.focusPagePanel = fp;

	}
	

	public PageView getPageInFocus() {
		return focusPageView;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == null)
			return;

		DocumentEvent eventObject =  (DocumentEvent) arg;

		if (eventObject.getType() == DocumentEventType.ADD_PAGE) {

			PageView pageView = new PageView(this, eventObject.getPage());
			addPageView(pageView);
			eventObject.getPage().addObserver(pageView);
			validate();

		}
		else if (eventObject.getType() == DocumentEventType.REMOVE_PAGE) {

			ArrayList<PageView> toRemove = new ArrayList<PageView>();

			for (PageView view : pageViews) {
				if (view.getPage().equals(eventObject.getPage()))
					toRemove.add(view);
			}

			for (PageView view : toRemove) {
				removePageView(view);
			}

			validate();

		} else if (eventObject.getType() == DocumentEventType.RENAME_DOCUMENT) {
			this.name = document.getName();
			this.setName(name);
		}

		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}
	



}
