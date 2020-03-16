package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import gui.MainFrame;
import model.PageSlotSelection;
import model.elements.SlotDevice;
import view.DocumentView;

public class CutAction extends AbstractActionIcon implements Serializable {

	private SlotDevice slot;

	public CutAction(SlotDevice slot, Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/cut.png", d));
		putValue(NAME, ("Cut"));
		putValue(SHORT_DESCRIPTION, ("Cut"));

		this.slot = slot;
	}

	public CutAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/cut.png", d));
		putValue(NAME, ("Cut"));
		putValue(SHORT_DESCRIPTION, ("Cut"));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<SlotDevice> slotDevices = ((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView()
				.getTabbedPane().getSelectedComponent()).getPageInFocus().getPage().getSelectedSlots();

		if (!slotDevices.isEmpty()) {
			PageSlotSelection content = new PageSlotSelection(slotDevices);
			MainFrame.getInstance().getClipboard().setContents(content, MainFrame.getInstance());

			((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane()
					.getSelectedComponent()).getPageInFocus().getPage().getSlotDevices().removeAll(slotDevices);

			((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane()
					.getSelectedComponent()).getPageInFocus().getPage().getSelectedSlots().removeAll(slotDevices);

			((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView().getTabbedPane()
					.getSelectedComponent()).getPageInFocus().repaint();

		}

	}

}
