package tree.view;

import model.Document;
import model.Page;
import model.Project;
import model.elements.Slot;
import view.DocumentView;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.EventObject;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;

import errorHandling.ErrorHandler;

public class TreeEditor extends DefaultTreeCellEditor implements ActionListener, TreeCellEditor {

	private Object polje = null;
	private JTextField edit = null;

	public TreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4,
			int arg5) {

		polje = arg1;
		edit = new JTextField(arg1.toString());
		edit.addActionListener(this);
		return edit;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Empty", "Error", JOptionPane.ERROR_MESSAGE);
			tree.clearSelection(); 

			return;
		}
		
		String newName = e.getActionCommand();

		if (polje instanceof Project) {
			Project project = (Project) polje;

			project.setName(newName);

		}
		if (polje instanceof Document) {
			Document document = (Document) polje;

			document.setName(newName);
		}
		if (polje instanceof Page) {
			Page page = (Page) polje;

			page.setName(newName);

		}
		try {
			tree.stopEditing();
			tree.setInvokesStopCellEditing(true);
		} catch (Exception e1) {
		}
	}
}