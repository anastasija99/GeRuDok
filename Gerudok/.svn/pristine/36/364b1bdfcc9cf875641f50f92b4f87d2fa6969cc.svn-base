package commadns;

import java.awt.Point;
import java.util.ArrayList;

import events.PageEvent.PageEventType;
import model.Page;
import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.elements.Slot;
import model.elements.SlotDevice;
import model.elements.TriangleElement;

public class MoveCommand extends Command {

	private Page page;
	private ArrayList<SlotDevice> slots = new ArrayList<>();
	private ArrayList<Point> lastPos;
	private ArrayList<Point> currPos;
	private Slot currElement;
	int d, g;

	public MoveCommand(Page page, int d, int g, ArrayList<Point> currPos) {
		super();
		this.page = page;
		this.d = d;
		this.g = g;

		for (SlotDevice sd1 : page.getSelectedSlots()) {
			for (SlotDevice sd2 : page.getSlotDevices()) {
				if (sd1.equals(sd2)) {
					this.slots.add(sd2);
				}
			}
		}

	}

	@Override
	public void doCommand() {

		int n = slots.size();
		for (int i = 0; i < n; i++) {
			SlotDevice slot = slots.get(i);

			page.removeElements(slot);

			SlotDevice element = null;

			Point newPoint = new Point(slot.getPoint().x + d, slot.getPoint().y + g);

			slot.setPosition(newPoint);

			if (slot instanceof RectangleElement) {
				element = RectangleElement.create(newPoint);
			}
			if (slot instanceof CircleElement) {
				element = CircleElement.create(newPoint);
			}
			if (slot instanceof TriangleElement) {
				element = TriangleElement.create(newPoint);
			}

			page.notifyObservers(PageEventType.DRAW);
			page.addElements(element);
			slots.set(i, element);
		}

		/*
		 * Slot element = page.getSelectedSlots().get(page.getElement(currElement));
		 * page.getSelectedSlots().clear(); ((SlotDevice) element).setPosition(currPos);
		 * element.getSlotPainter().draw(); page.addObserver((Observer) element);
		 */
	}

	@Override
	public void undoCommand() {
		int n = slots.size();
		for (int i = 0; i < n; i++) {
			SlotDevice slot = slots.get(i);

			page.removeElements(slot);

			SlotDevice element = null;

			Point newPoint = new Point(slot.getPoint().x - d, slot.getPoint().y - g);

			slot.setPosition(newPoint);

			if (slot instanceof RectangleElement) {
				element = RectangleElement.create(newPoint);
			}
			if (slot instanceof CircleElement) {
				element = CircleElement.create(newPoint);
			}
			if (slot instanceof TriangleElement) {
				element = TriangleElement.create(newPoint);
			}
			page.notifyObservers(PageEventType.DRAW);
			page.addElements(element);
			slots.set(i, element);
		}

		/*
		 * Slot element = page.getSelectedSlots().get(page.getElement(currElement));
		 * page.getSelectedSlots().clear(); ((SlotDevice) element).setPosition(lastPos);
		 * element.getSlotPainter().draw(); page.addObserver((Observer) element);
		 */
	}

}
