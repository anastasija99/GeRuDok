package state;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import commadns.RotateCommand;
import model.elements.SlotDevice;
import view.PageView;

public class RotateState extends State {

	private PageView page;
	private SlotDevice selectedSlot = null;
	private double ang;
	private double oldAngle = 0.0;

	public RotateState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent event) {

		for (SlotDevice slotDevice : page.getPage().getSlotDevices()) {
			if (slotDevice.getSlotPainter().elementAtPosition(event.getPoint())) {
				selectedSlot = slotDevice;
				page.getPage().setSelectSlot(slotDevice);

				if (!page.getPage().getSelectedSlots().contains(slotDevice)) {
					page.getPage().getSelectedSlots().add(slotDevice);
					oldAngle = ang = slotDevice.getAngle();

				}

				return;
			}
		}
		page.getPage().setSelectSlot(null);
		page.getPage().getSelectedSlots().clear();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		Point pos = event.getPoint();
		if (page.getPage().getSelectSlot() != null) {
			Point center = new Point(
					page.getPage().getSelectSlot().getPoint().x
							+ page.getPage().getSelectSlot().getDimension().width / 2,
					page.getPage().getSelectSlot().getPoint().y
							+ page.getPage().getSelectSlot().getDimension().height / 2);
			Shape slotShape = page.getPage().getSelectSlot().getSlotPainter().getOldShape();
			ang = getAngle(center, pos);
			AffineTransform af = AffineTransform.getRotateInstance(ang, center.x, center.y);

			page.getPage().getSelectSlot().setAngle(ang);
			page.getPage().getSelectSlot().getSlotPainter().setShape(af.createTransformedShape(slotShape));

			for (SlotDevice slot : page.getPage().getSelectedSlots()) {
				if (slot != page.getPage().getSelectSlot()) {
					Point slotCenter = new Point(slot.getPoint().x + slot.getDimension().width / 2,
							slot.getPoint().y + slot.getDimension().height / 2);
					Shape slotShape2 = slot.getSlotPainter().getOldShape();

					af = AffineTransform.getRotateInstance(ang, slotCenter.x, slotCenter.y);

					slot.setAngle(ang);
					slot.getSlotPainter().setShape(af.createTransformedShape(slotShape2));

				}

				page.repaint();

			}

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		page.getPage().getCommandManager().addCommand(
				new RotateCommand(page.getPage(), selectedSlot, page.getPage().getSelectedSlots(), oldAngle, ang));

	}

	private double getAngle(Point slotCenter, Point mousePoint) {
		return Math.atan2(mousePoint.y - slotCenter.y, mousePoint.x - slotCenter.x);
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
