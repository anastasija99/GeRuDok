package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import actions.manager.AbstractActionIcon;
import add.IObservable;
import factory.FabricGen;
import factory.NodeFactory;
import gui.MainFrame;

public class NewAction extends AbstractActionIcon {

	public NewAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(SMALL_ICON, iconGetter("/toolbar/addpage.png", d));
		putValue(NAME, ("New"));
		putValue(SHORT_DESCRIPTION, ("New"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTree tree = MainFrame.getInstance().getTree();
		TreePath path = tree.getSelectionPath();
		Object selectedComponent = path.getLastPathComponent();
		NodeFactory nodeFactory = FabricGen.generateFacotry(selectedComponent);
		try {
		MutableTreeNode node = nodeFactory.deliverNode((MutableTreeNode) selectedComponent);
		((IObservable) selectedComponent).add(node);
		}
		catch(NullPointerException event){
			JOptionPane.showMessageDialog(null, "Not valid node", "Error", JOptionPane.ERROR_MESSAGE);
		}

		MainFrame.getInstance().getTree().updateUI();
		MainFrame.getInstance().getTree().expandPath(MainFrame.getInstance().getTree().getSelectionPath());
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

}
