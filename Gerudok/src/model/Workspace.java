package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import add.IObservable;
import events.UpdateEvent;
import events.WorkspaceEvent;
import events.WorkspaceEvent.WorkspaceEventType;
import gui.MainFrame;

public class Workspace extends Observable implements IObservable, MutableTreeNode, Serializable, INodeManager {
	private static final long serialVersionUID = 1L;
	private String name = "Workspace";
	private ArrayList<Project> projects = new ArrayList<Project>();
	private boolean workSpaceModified;
	private File workSpaceFile;
	private transient boolean changed;
	private static Workspace instance = null;
	private boolean workspaceModified;

	private Workspace() {
		super();
		projects = new ArrayList<Project>();
		changed = false;
	}

	public void openProject(Project project) {
		project.setParent(this);
		projects.add(project);
		project.setProjectModified(false);

		notifyObservers(new WorkspaceEvent(WorkspaceEventType.OPEN_PROJECT, project));
	}

	public void addProject(Project project) {
		project.setParent(this);
		projects.add(project);
		if (project.getName() == null)
			project.setName("Project - " + projects.size());
		if (project.getProjectFile() == null) {
			project.setProjectModified(true);
		}

		notifyObservers(new WorkspaceEvent(WorkspaceEventType.ADD_PROJECT, project));
	}

	public void setWorkSpaceModified(boolean workSpaceModified) {
		this.workSpaceModified = workSpaceModified;
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public void deleteProject(Project project) {
		projects.remove(project);

		notifyObservers(new WorkspaceEvent(WorkspaceEventType.REMOVE_PROJECT, project));
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public void updatePerformed(UpdateEvent e) {
		setChanged(true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<Project> children() {
		return (Enumeration<Project>) projects;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return projects.get(arg0);
	}

	@Override
	public int getChildCount() {
		return projects.size();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return projects.indexOf(arg0);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return this.projects.size() == 0;
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
		// TODO Auto-generated method stub

	}

	public static Workspace getInstance() {
		if (instance == null) {
			instance = new Workspace();
		}
		return instance;
	}

	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}

	@Override
	public void add(MutableTreeNode child) {
		addProject((Project) child);
	}

	@Override
	public void addNode(TreeNode newTreeNode) {

	}

	@Override
	public void removeNode(TreeNode nodeToRemove) {
		Project project = (Project) nodeToRemove;
		projects.remove(project);
		notifyObservers(new WorkspaceEvent(WorkspaceEventType.REMOVE_PROJECT, project));
	}

	public boolean isWorkspaceModified() {
		return workspaceModified;
	}

	public void setWorkspaceModified(boolean workspaceModified) {
		this.workspaceModified = workspaceModified;
	}

	public void addProjectView() {
		for (Project p : projects) {
			this.notifyObservers(new WorkspaceEvent(WorkspaceEventType.ADD_PROJECT, p));
			p.generateView();
		}
	}

	public File getWorkSpaceFile() {
		return workSpaceFile;
	}

	public void setWorkSpaceFile(File workSpaceFile) {
		this.workSpaceFile = workSpaceFile;
	}

}
