package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import commadns.DeleteCommand;
import model.elements.Slot;
import model.elements.SlotDevice;
import view.PageView;
import view.painters.SlotView;

public class DeleteState extends State {

	private PageView page;
	private SlotDevice slot = null;

	public DeleteState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent event) {
		ArrayList<SlotDevice> slotDevices = page.getPage().getSelectedSlots();
		if (slotDevices.isEmpty())
			return;

		page.getPage().getSlotDevices().removeAll(slotDevices);
		page.getPage().getSelectedSlots().clear();
		page.getPage().setSelectSlot(null);
		page.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (slot != null || !page.getPage().getSelectedSlots().isEmpty())
			page.getPage().getCommandManager().addCommand(new DeleteCommand(slot, page));

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
