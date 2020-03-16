package tree.view;

import model.Page;
import model.Project;
import model.Document;
import model.Workspace;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class TreeCellRendered extends DefaultTreeCellRenderer {

	protected ImageIcon iconGetter(String iconPath) {
		final Dimension size = new Dimension(16, 16);

		String PATH = "images/tree/";

		ImageIcon i = new ImageIcon(new ImageIcon(PATH + iconPath).getImage().getScaledInstance(size.height, size.width,
				Image.SCALE_SMOOTH));
		return i;
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof Workspace) {
			ImageIcon icon = iconGetter("treeworkspace.png");
			if (icon != null)
				setIcon(icon);
		} else if (value instanceof Document) {
			Document doc = (Document) value;
			TreePath path = tree.getPathForRow(row);

			if (path != null) {
				Object[] objs = path.getPath();
				if (doc.isShared() && !doc.getParent().equals(objs[1])) {
					ImageIcon icon = new ImageIcon(new ImageIcon("images/tree/" + "importeddoc.png").getImage()
							.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
					if (icon != null)
						setIcon(icon);
				} else if (doc.isShared() && doc.getParent().equals(objs[1])) {
					ImageIcon icon = new ImageIcon(new ImageIcon("images/tree/" + "shareddoc.png").getImage()
							.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
					if (icon != null)
						setIcon(icon);
				} else {
					ImageIcon icon = new ImageIcon(new ImageIcon("images/tree/" + "treedoc.png").getImage()
							.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
					if (icon != null)
						setIcon(icon);
				}
			} else {
				ImageIcon icon = iconGetter("treedoc.png");
				if (icon != null)
					setIcon(icon);
			}

		} else if (value instanceof Project) {
			ImageIcon icon = iconGetter("treeproj.png");
			if (icon != null)
				setIcon(icon);

		} else if (value instanceof Page) {
			ImageIcon icon = iconGetter("treepage.png");
			if (icon != null)
				setIcon(icon);
		}

		return this;
	}

}
