package view;

import events.ProjectEvent;
import events.ProjectEvent.ProjectEventType;
import gui.MainFrame;
import model.Document;
import model.Project;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ProjectView extends JInternalFrame implements Observer {

	private static int xStart = 20;
	private static int yStart = 20;
	private static int x = xStart;
	private static int y = yStart;

	private Project project;
	private JTabbedPane tabbedPane;

	private ArrayList<DocumentView> documentsView;

	public ProjectView(Project project) {

		super(project.getName(), true, true, true, true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		this.project = project;
		this.project.addObserver(this);
		documentsView = new ArrayList<>();
		Dimension d = MainFrame.getInstance().getSize();
		this.setSize(d.width / 2, 2 * d.height / 3);

		ImageIcon image = new ImageIcon("images/tree/treeproj.png");
		setFrameIcon(new ImageIcon(image.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));

		tabbedPane = new JTabbedPane();
		add(tabbedPane);

		tabbedPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() instanceof JTabbedPane) {
					JTabbedPane source = (JTabbedPane) e.getSource();

					if (source.getTabCount() == 0)
						return;

					DocumentView view = (DocumentView) source.getSelectedComponent();
					Document document = (Document) view.getDocument();

					DefaultTreeModel m = (DefaultTreeModel) MainFrame.getInstance().getTree().getModel();
					TreeNode[] n = m.getPathToRoot(document);

					n[1] = ProjectView.this.project;

					MainFrame.getInstance().getTree().scrollPathToVisible(new TreePath(n));
					MainFrame.getInstance().getTree().setSelectionPath(new TreePath(n));
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setLocation(x, y);
		int maxY = MainFrame.getInstance().getHeight();

		// Promena pozicije projekta kada se napravi novi

		if (d.height / 2 + y + 20 < maxY) {
			y += 40;
			x += 40;
		} else {
			xStart += 40;
			y = yStart;
			x = xStart + 40;
		}

	}

	public WorkspaceView removeSelectedTab() {
		tabbedPane.remove(tabbedPane.getSelectedComponent());
		revalidate();
		repaint();
		return null;
	}

	public void removeAllTabs() {
		tabbedPane.removeAll();
		revalidate();
		repaint();

	}

	public Project getProject() {
		return project;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void addDocumentView(DocumentView docView) {
		documentsView.add(docView);
		tabbedPane.add(docView);
	}

	public void removeDocumentView(DocumentView docView) {
		documentsView.remove(docView);
		tabbedPane.remove(docView);
	}

	@Override
	public void update(Observable o, Object arg) {
		ProjectEvent eventObject = (ProjectEvent) arg;
		Document document = eventObject.getDocument();

		if (eventObject.getType() == ProjectEventType.ADD_DOCUMENT) {

			DocumentView docView = new DocumentView(document);
			addDocumentView(docView);
			document.addObserver(docView);

		} else if (eventObject.getType() == ProjectEventType.REMOVE_DOCUMENT) {

			ArrayList<DocumentView> toRemove = new ArrayList<DocumentView>();
			int totalTabs = tabbedPane.getTabCount();
			for (int i = 0; i < totalTabs; i++) {
				DocumentView docView = (DocumentView) tabbedPane.getComponentAt(i);
				if (docView.getDocument().equals(document)) {
					toRemove.add(docView);
				}
			}

			for (DocumentView docView : toRemove)
				removeDocumentView(docView);

		} else if (eventObject.getType() == ProjectEventType.RENAME_PROJECT) {
			this.title = project.getName();
			this.setName(title);
		}

		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	public void setSelectedFromTree(boolean selected) throws PropertyVetoException {
		super.setSelected(selected);
	}

	@Override
	public void setSelected(boolean selected) throws PropertyVetoException {
		// TODO Auto-generated method stub
		super.setSelected(selected);

		if (selected == true && project.getChildCount() == 0) {
			DefaultTreeModel m = (DefaultTreeModel) MainFrame.getInstance().getTree().getModel();
			TreeNode[] n = m.getPathToRoot(project);

			MainFrame.getInstance().getTree().scrollPathToVisible(new TreePath(n));
			MainFrame.getInstance().getTree().setSelectionPath(new TreePath(n));
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		}
	}

	public ArrayList<DocumentView> getDocumentsView() {
		return documentsView;
	}

}
