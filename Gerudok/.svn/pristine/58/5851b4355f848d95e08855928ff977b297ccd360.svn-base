package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import model.Document;
import view.ProjectView;

public class CloseAction extends AbstractActionIcon {

	public CloseAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		putValue(SMALL_ICON, iconGetter("/menu/deleteTab.png", d));
		putValue(NAME, ("Close"));
		putValue(SHORT_DESCRIPTION, ("Close"));
		setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selectedComponent = MainFrame.getInstance().getTree().getLastSelectedPathComponent();

		if (selectedComponent instanceof Document) {

			ProjectView projectView = MainFrame.getInstance().getWorkspaceView().getProjView();
			JTabbedPane pane = projectView.getTabbedPane();
			int tabIdx = pane.getSelectedIndex();

			if (tabIdx != -1) {
				pane.remove(tabIdx);
			}
		}

	}

}
