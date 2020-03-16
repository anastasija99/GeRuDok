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
import events.ProjectEvent;
import events.ProjectEvent.ProjectEventType;
import events.UpdateEvent;
import events.UpdateListener;
import gui.MainFrame;

public class Project extends Observable
		implements IObservable, UpdateListener, MutableTreeNode, Serializable, Observer, INodeManager {

	private Workspace parent;
	private String name = null;
	private ArrayList<Document> documents = new ArrayList<Document>();
	private File projectFile;
	private boolean projectModified;
	private transient boolean changed;

	public Project(Workspace parent, String name) {
		super();
		this.parent = parent;
		this.name = name;
		documents = new ArrayList<Document>();
		this.addObserver(this);
		projectFile = null;
	}

	public void setParent(Workspace parent) {
		this.parent = parent;
	}

	public ArrayList<Document> getDocuments() {
		return this.documents;
	}

	public boolean isProjectModified() {
		return projectModified;
	}

	public void setProjectModified(boolean projectModified) {
		this.projectModified = projectModified;
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	public File getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}

	public void importDocument(Document document) {
		documents.add(document);

		// dogodila se modifikacija projekta
		notifyObservers(new ProjectEvent(ProjectEventType.IMPORT_DOCUMENT, document));
	}

	public void addDocument(Document document) {
		documents.add(document);
		if (document.getName() == null)
			document.setName("Document - " + documents.size());

		// dogodila se modifikacija projekta
		notifyObservers(new ProjectEvent(ProjectEventType.ADD_DOCUMENT, document));

		if (!document.getPages().isEmpty()) {
			for (Page p : document.getPages()) {
				document.notifyObservers(new ProjectEvent(ProjectEventType.ADD_DOCUMENT, p));
			}
		}

		Workspace ws = (Workspace) this.getParent();
		ws.updatePerformed(null);
		updatePerformed(null);
	}

	public void deleteDocument(Document document) {
		documents.remove(document);

		if (document.getParent().equals(this)) {
			for (Object p : document.getAllParents().toArray()) {
				((Project) p).deleteDocument(document);
			}
		} else {
			document.getAllParents().remove(this);

			if (document.getAllParents().isEmpty()) {
				document.setShared(false);
			}
		}

		// dogodila se modifikacija projekta
		notifyObservers(new ProjectEvent(ProjectEventType.REMOVE_DOCUMENT, document));
	}

	public void setName(String name) {

		this.name = name;
		Document document = null;

		// dogodila se modifikacija projekta
		notifyObservers(new ProjectEvent(ProjectEventType.RENAME_PROJECT, document));
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		String indicator = projectModified ? "*" : "";
		return indicator + name + "(" + documents.size() + ")";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<Document> children() {
		return (Enumeration<Document>) documents;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return documents.get(arg0);
	}

	@Override
	public int getChildCount() {
		return documents.size();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return documents.indexOf(arg0);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return this.documents.size() == 0;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!this.projectModified) {
			this.setProjectModified(true);
		}
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		this.projectModified = true;
		this.documents.add(index, (Document) child);
	}

	@Override
	public void remove(int index) {
		this.projectModified = true;
		this.documents.remove(index);
	}

	@Override
	public void remove(MutableTreeNode node) {
		this.projectModified = true;
		this.documents.remove(node);
	}

	@Override
	public void setUserObject(Object object) {
	}

	@Override
	public void removeFromParent() {
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		this.parent = (Workspace) newParent;
	}

	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}

	@Override
	public void updatePerformed(UpdateEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(MutableTreeNode child) {
		addDocument((Document) child);
	}

	@Override
	public void addNode(TreeNode newTreeNode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNode(TreeNode nodeToRemove) {
		Document document = (Document) nodeToRemove;
		documents.remove(document);
		notifyObservers(new ProjectEvent(ProjectEventType.REMOVE_DOCUMENT, document));
		// setChanged(true);
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public void generateView() {
		for (Document d : documents) {
			this.notifyObservers(new ProjectEvent(ProjectEventType.ADD_DOCUMENT, d));
			d.generatePages();
		}
	}

	public void addToChild(MutableTreeNode node) {
		Document document = (Document) node;
		documents.add(document);
	}
	
	
	
}
