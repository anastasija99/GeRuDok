package actions;

import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import model.elements.SlotDevice;
import view.DocumentView;
import view.ImageEditor;

public class ImagesAction extends AbstractActionIcon {

	public ImagesAction() {
		putValue(NAME, "Add image");
		putValue(SHORT_DESCRIPTION, "Add Image");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		SlotDevice slot = ((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane()
				.getSelectedComponent()).getPageInFocus().getPage().getSelectSlot();
		ImageEditor imgEditor = new ImageEditor(MainFrame.getInstance(), slot.getName(), enabled, slot);
		imgEditor.setVisible(true);

	}

}
