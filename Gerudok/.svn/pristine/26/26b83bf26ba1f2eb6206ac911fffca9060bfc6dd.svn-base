package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import model.elements.Slot;
import model.elements.SlotDevice;
import view.PageView;

public class MoveState extends State {

	private PageView page;

	// private Point2D start = null;
	private Point lastPos = null;
	private Point currPos = null;
	private Slot element = null;

	public MoveState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (SlotDevice slotDevice : page.getPage().getSlotDevices()) {
			if (slotDevice.getSlotPainter().getShape().contains(e.getPoint())) {
				currPos = e.getPoint();
				return;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		Dimension newDim = new Dimension((int) (e.getPoint().getX() - currPos.getX()),
				(int) (e.getPoint().getY() - currPos.getY()));

		element = page.getPage().getSelectSlot();
		for (SlotDevice slot : page.getPage().getSelectedSlots()) {

			Point pos = new Point((int) slot.getPoint().getX() + newDim.width,
					(int) slot.getPoint().getY() + newDim.height);
			slot.setPosition(pos);

		}
		for (SlotDevice slot : page.getPage().getSelectedSlots())
			slot.getSlotPainter().draw();
		currPos = e.getPoint();
		page.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}
}