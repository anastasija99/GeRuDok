package factory;

import javax.swing.tree.MutableTreeNode;

import model.Document;
import model.Project;

public class DocumentFactory extends NodeFactory {

	@Override
	public MutableTreeNode createNode(MutableTreeNode parent) {
		return new Document((Project) parent, "");
	}

}
