package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import gui.MainFrame;
import model.Document;
import model.Project;

public class ShareDocument extends JDialog {

	private JLabel label;
	private JPanel panel;
	private ButtonGroup select;

	public ShareDocument(JFrame parent, ArrayList<Document> document) {
		super(parent, "Documents");

		setSize(300, 300);
		setLocationRelativeTo(parent);

		panel = new JPanel();

		select = new ButtonGroup();
		JButton btnSelect = new JButton("Select");

		DefaultListModel projectsList = new DefaultListModel();
		Project project = (Project) document.get(0).getParent();
		for (Project projects : MainFrame.getInstance().getWorkspaceModel().getProjects()) {
			if (projects.equals(project))
				continue;
			projectsList.addElement(projects);
		}
		JList listProj = new JList(projectsList);
		add(listProj, BorderLayout.CENTER);
		add(btnSelect, BorderLayout.NORTH);

	}

	public enum ShareDoc {
		SHARE, DELETE

	}

}
