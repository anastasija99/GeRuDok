package tree.view;

import actions.DeleteNode;
import actions.DisplayProject;
import actions.RenameNode;
import actions.manager.AbstractActionIcon;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class TreePopUp extends JPopupMenu {

	private JMenuItem Rename;
	private JMenuItem Open;
	private JMenuItem Delete;

	public TreePopUp() {
		createItems();
		addItems();
	}

	private void createItems() {
		this.Rename = new JMenuItem("Rename");
		this.Rename.addActionListener(new RenameNode(AbstractActionIcon.small));

		this.Delete = new JMenuItem("Delete");
		this.Delete.addActionListener(new DeleteNode(AbstractActionIcon.small));

		this.Open = new JMenuItem("Display");
		this.Open.addActionListener(new DisplayProject());
	}

	private void addItems() {
		add(this.Rename);
		addSeparator();
		add(this.Delete);
		addSeparator();
		add(this.Open);
	}

}
