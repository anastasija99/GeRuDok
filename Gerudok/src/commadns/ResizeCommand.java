package commadns;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import enums.Draw;
import events.PageEvent.PageEventType;
import model.Page;
import model.elements.SlotDevice;

public class ResizeCommand extends Command {
	private Page page;
	private SlotDevice selectSlot;
	private ArrayList<SlotDevice> slots = new ArrayList<>();
	private Dimension oldDimension;
	private Point oldPoint;
	private ArrayList<Dimension> oldArrayDim = new ArrayList<>();
	private ArrayList<Point> oldArrayPoint = new ArrayList<>();
	private Dimension newDimension;
	private Point newPoint;

	public ResizeCommand(Page page, SlotDevice selectSlot, Dimension oldDimension, Dimension newDim, Point oldPoint,
			Point newPoint, ArrayList<SlotDevice> slots, ArrayList<Dimension> oldArrayDimension, ArrayList<Point> oldArrayPoint) {
		super();
		this.page = page;
		for (SlotDevice s : page.getSlotDevices()) {
			if (s.equals(selectSlot)) {
				this.selectSlot = s;
				break;
			}
		}

		for (SlotDevice slot : slots) {
			for (SlotDevice sd : page.getSlotDevices()) {
				if (sd.equals(slot)) {
					this.slots.add(sd);
					break;
				}
			}
		}
		this.oldPoint = oldPoint;
		this.oldDimension = oldDimension;
		for (Point p : oldArrayPoint) {
			this.oldArrayPoint.add(p);
		}
		for (Dimension dim : oldArrayDimension) {
			this.oldArrayDim.add(dim);
		}
		
		this.newPoint = newPoint;
		this.newDimension = newDim;
		
	}

	@Override
	public void undoCommand() {

		selectSlot.setDimension(oldDimension);
		selectSlot.setPosition(oldPoint);
		selectSlot.getSlotPainter().draw();

		for (int i = 0; i < slots.size(); i++) {
			if (slots.get(i).equals(selectSlot))
				continue;
			System.out.println(slots.get(i).getName());
			slots.get(i).setDimension(oldArrayDim.get(i));
			System.out.println(oldArrayDim.get(i));
			slots.get(i).setPosition(oldArrayPoint.get(i));
			System.out.println(oldArrayPoint.get(i));
			slots.get(i).getSlotPainter().draw();
		}

		page.notifyObservers(Draw.DRAW);
	}

	@Override
	public void doCommand() {
		selectSlot.setDimension(newDimension);
		selectSlot.setPosition(newPoint);
		selectSlot.getSlotPainter().draw();
		for (int i = 0; i < slots.size(); i++) {
			if (slots.get(i) != selectSlot) {
				slots.get(i).setDimension(new Dimension(oldArrayDim.get(i).width + newDimension.width - oldDimension.width,
						oldArrayDim.get(i).height + newDimension.height - oldDimension.height));
				slots.get(i).setPosition(new Point(oldArrayPoint.get(i).x + newPoint.x - oldPoint.x,
						oldArrayPoint.get(i).y + newPoint.y - oldPoint.y));
				slots.get(i).getSlotPainter().draw();
			}
		}
		page.notifyObservers(Draw.DRAW);
	}

}
