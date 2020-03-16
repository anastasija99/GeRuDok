package factory;

import javax.swing.tree.MutableTreeNode;

import model.Document;
import model.Page;

public class PageFactory extends NodeFactory {

	@Override
	public MutableTreeNode createNode(MutableTreeNode parent) {

		return new Page((Document) parent, "Page");

	}
}
