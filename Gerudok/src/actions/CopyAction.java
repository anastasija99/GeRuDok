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

public class CopyAction extends AbstractActionIcon implements Serializable {

	private SlotDevice slot;

	public CopyAction(SlotDevice slot, Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/copy.png", d));
		putValue(NAME, ("Copy"));
		putValue(SHORT_DESCRIPTION, ("Copy"));

		this.slot = slot;
	}

	public CopyAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/slotToolBar/copy.png", d));
		putValue(NAME, ("Copy"));
		putValue(SHORT_DESCRIPTION, ("Copy"));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<SlotDevice> slotDevices = ((DocumentView) MainFrame.getInstance().getWorkspaceView().getProjView()
				.getTabbedPane().getSelectedComponent()).getPageInFocus().getPage().getSelectedSlots();
	
		if (!slotDevices.isEmpty()) {
			PageSlotSelection slot = new PageSlotSelection(slotDevices);
			MainFrame.getInstance().getClipboard().setContents(slot, MainFrame.getInstance());
		}

	}

}
