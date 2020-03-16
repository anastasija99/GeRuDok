package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import commadns.ResizeCommand;
import enums.Handle;
import model.elements.SlotDevice;
import view.PageView;

public class ResizeState extends State {

	private PageView page;
	private SlotDevice selectedSlot = null;
	private Dimension oldDimension = new Dimension(0, 0);
	private Dimension newDimension = new Dimension(0, 0);
	private Point oldPoint = new Point(0, 0);
	private Point newPoint = new Point(0, 0);
	private ArrayList<Dimension> oldSlotsDimension = new ArrayList<>();
	private ArrayList<Point> oldSlotsPoint = new ArrayList<>();

	public ResizeState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent event) {

		oldSlotsDimension.clear();
		oldSlotsPoint.clear();
		for (SlotDevice slot : page.getPage().getSelectedSlots()) {
			oldSlotsDimension.add(slot.getDimension());
			oldSlotsPoint.add(slot.getPoint());
		}
		for (SlotDevice slotDevice : page.getPage().getSlotDevices()) {
			if (slotDevice.getSlotPainter().elementAtPosition(event.getPoint())) {
				selectedSlot = slotDevice;
				page.getPage().setSelectSlot(slotDevice);
				newDimension = oldDimension = selectedSlot.getDimension();
				newPoint = oldPoint = selectedSlot.getPoint();
				if (!page.getPage().getSelectedSlots().contains(slotDevice)) {
					page.getPage().getSelectedSlots().add(slotDevice);
					oldSlotsPoint.add(slotDevice.getPoint());
				}
				return;
			}
		}
		page.getPage().setSelectSlot(null);
		page.getPage().getSelectedSlots().clear();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		selectedSlot = page.getPage().getSelectSlot();
		if (handle == null) {
			return;
		}
		update(handle, event.getPoint(), selectedSlot);
	}

	public void update(Handle handle, Point p, SlotDevice selectSlot) {
		page.getPage().getSlotDevices().remove(selectSlot);
		switch (handle) {
		case North:
			newPoint = new Point(oldPoint.x, p.y);
			newDimension = new Dimension(oldDimension.width, (oldPoint.y - p.y) + oldDimension.height);
			break;
		case NorthWest:
			newPoint = p;
			newDimension = new Dimension(oldPoint.x - p.x + oldDimension.width,
					(oldPoint.y - p.y) + oldDimension.height);
			break;
		case NorthEast:
			newPoint = new Point(oldPoint.x, p.y);
			newDimension = new Dimension((p.x - oldPoint.x), (oldPoint.y - p.y) + oldDimension.height);
			break;
		case South:
			newPoint = oldPoint;
			newDimension = new Dimension(oldDimension.width, p.y - oldPoint.y);
			break;
		case SouthWest:
			newPoint = new Point(p.x, oldPoint.y);
			newDimension = new Dimension(oldPoint.x - p.x + oldDimension.width, p.y - oldPoint.y);
			break;
		case SouthEast:
			newPoint = oldPoint;
			newDimension = new Dimension((p.x - oldPoint.x), p.y - oldPoint.y);
			break;
		case East:
			newPoint = oldPoint;
			newDimension = new Dimension((p.x - oldPoint.x), oldDimension.height);
			break;
		case West:
			newPoint = new Point(p.x, oldPoint.y);
			newDimension = new Dimension(oldPoint.x - p.x + oldDimension.width, oldDimension.height);
			break;
		}
		if (selectedSlot == null)
			return;

		int i = 0;
		for (SlotDevice slot : page.getPage().getSelectedSlots()) {
			if (!(slot == selectSlot)) {
				slot.setDimension(
						new Dimension(oldSlotsDimension.get(i).width + newDimension.width - oldDimension.width,
								oldSlotsDimension.get(i).height + newDimension.height - oldDimension.height));
				slot.setPosition(new Point(oldSlotsPoint.get(i).x + newPoint.x - oldPoint.x,
						oldSlotsPoint.get(i).y + newPoint.y - oldPoint.y));
				slot.getSlotPainter().draw();
			}
			i++;
		}

		selectSlot.setDimension(newDimension);
		selectSlot.setPosition(newPoint);
		selectSlot.getSlotPainter().draw();
		page.getPage().getSlotDevices().add(selectSlot);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (newPoint == oldPoint && newDimension == oldDimension)
			return;
		if (selectedSlot == null)
			return;
		page.getPage().getCommandManager().addCommand(new ResizeCommand(page.getPage(), selectedSlot, oldDimension,
				newDimension, oldPoint, newPoint, page.getPage().getSelectedSlots(), oldSlotsDimension, oldSlotsPoint));

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
