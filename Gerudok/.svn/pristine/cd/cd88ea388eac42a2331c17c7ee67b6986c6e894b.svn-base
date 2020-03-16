package actions;

import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import model.elements.SlotDevice;
import view.DocumentView;
import view.TextEditor;

public class TextAction extends AbstractActionIcon {

	public TextAction() {
		putValue(NAME, "Add Text");
		putValue(SHORT_DESCRIPTION, "Add Text");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane().getSelectedComponent())
				.getPageInFocus().startContentState();

	}

}
