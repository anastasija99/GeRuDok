package factory;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import model.Project;
import model.Workspace;

public class ProjectFactory extends NodeFactory {

	@Override
	public MutableTreeNode createNode(MutableTreeNode parent) {
	
		return new Project((Workspace)parent, "Project");
	}

}
