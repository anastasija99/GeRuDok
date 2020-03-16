package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import add.IObservable;
import events.DocumentEvent;
import events.DocumentEvent.DocumentEventType;
import gui.MainFrame;

public class Document extends Observable implements IObservable, MutableTreeNode, Serializable, Observer, INodeManager {

	private Project parent = null;
	private String name = null;
	private ArrayList<Page> allPages = new ArrayList<Page>();
	private File documentFile = null;
	private boolean shared = false;
	private ArrayList<Project> allParents = new ArrayList<Project>();
	private boolean documentModified;
	private ArrayList<Project> projects;

	public Document(Project parent, String string) {
		super();
		setParent(parent);

	}

	public boolean isdocumentModified() {
		return documentModified;
	}

	public void setDocumentModified(boolean documentModified) {
		this.documentModified = documentModified;
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	public ArrayList<Project> getAllParents() {
		return allParents;
	}

	public void addParent(Project newParent) {
		this.allParents.add(newParent);
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public File getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(File documentFile) {
		this.documentFile = documentFile;
	}

	public ArrayList<Page> getPages() {
		return this.allPages;
	}

	private Object readResolve() {
		addObserver(parent);
		return this;
	}

	public void addPage(Page page) {
		allPages.add(page);
		if (page.getName() == null)
			page.setName("Page - " + allPages.size());

		// modifikacija dokumenta
		notifyObservers(new DocumentEvent(DocumentEventType.ADD_PAGE, page));
	}
	
	public void addPage2(Page page) {
		allPages.add(page);
		if (page.getName() == null)
			page.setName("Page - " + allPages.size());

		// modifikacija dokumenta
		notifyObservers(new DocumentEvent(DocumentEventType.ADD_PAGE2, page));
	}

	public void deletePage(Page page) {
		allPages.remove(page);

		// modifikacija dokumenta
		notifyObservers(new DocumentEvent(DocumentEventType.REMOVE_PAGE, page));
	}

	public void setName(String name) {
		this.name = name;

		// modifikacija projekta
		notifyObservers(new DocumentEvent(DocumentEventType.RENAME_DOCUMENT, null));
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return name + "(" + allPages.size() + ")";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<Page> children() {
		return (Enumeration<Page>) allPages;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return allPages.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return allPages.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return allPages.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return this.allPages.size() == 0;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!this.documentModified) {
			this.setDocumentModified(true);
		}
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(MutableTreeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserObject(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(MutableTreeNode newParent) {

		this.parent = (Project) newParent;

	}

	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}

	@Override
	public void addNode(TreeNode newTreeNode) {

	}

	@Override
	public void removeNode(TreeNode nodeToRemove) {
		Page page = (Page) nodeToRemove;
		allPages.remove(page);
		notifyObservers(new DocumentEvent(DocumentEventType.REMOVE_PAGE, page));
		// parent.setChanged(true);
	}

	@Override
	public void add(MutableTreeNode child) {
		addPage((Page) child);

	}

	public void generatePages() {
		for (Page p : allPages) {
			this.notifyObservers(new DocumentEvent(DocumentEventType.ADD_PAGE, p));

		}
	}
	
	public void generatePages2() {
		for (Page p : allPages) {
			this.notifyObservers(new DocumentEvent(DocumentEventType.ADD_PAGE2, p));

		}
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
}
