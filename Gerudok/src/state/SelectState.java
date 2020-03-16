package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import model.elements.SlotDevice;
import view.PageView;

public class SelectState extends State {

	private PageView page;
	Rectangle2D rectangle = new Rectangle2D.Double();
	private boolean selectElement;

	public SelectState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent event) {

		SlotDevice selectedSlot = null;
		
		if(!event.isControlDown()) {
			page.getPage().getSelectedSlots().clear();
		}

		for (SlotDevice slotDevice : page.getPage().getSlotDevices()) {
			if (slotDevice.getSlotPainter().elementAtPosition(event.getPoint()) && event.isShiftDown()) {

				page.getPage().setSelectSlot(slotDevice);

				page.getPage().getSelectedSlots().add(slotDevice);

				return;
			} else if (slotDevice.getSlotPainter().elementAtPosition(event.getPoint())) {
				page.getPage().setSelectSlot(slotDevice);

				page.getPage().getSelectedSlots().add(slotDevice);
				return;
			}

		}
		page.getPage().setSelectSlot(null);
		page.getPage().getSelectedSlots().clear();
	}

	@Override
	public void mouseDragged(MouseEvent event) {

		Point mousePos = event.getPoint();

		double height = mousePos.getY() - page.getLastPosition().getY();
		double width = mousePos.getX() - page.getLastPosition().getX();
		 if ((width > 0) && (height < 0)) {
			rectangle.setRect(page.getLastPosition().getX(), mousePos.getY(), Math.abs(width), Math.abs(height));
		} else if ((width < 0) && (height >= 0)) {
			rectangle.setRect(mousePos.getX(), page.getLastPosition().getY(), Math.abs(width), Math.abs(height));
		}else if ((width < 0) && (height < 0)) {
			rectangle.setRect(mousePos.getX(), mousePos.getY(), Math.abs(width), Math.abs(height));
		}  else {
			rectangle.setRect(page.getLastPosition().getX(), page.getLastPosition().getY(), Math.abs(width),
					Math.abs(height));
		}
		page.setRectangle(rectangle);
		page.getPage().selectAllElements(rectangle);

		page.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		page.setRectangle(new Rectangle2D.Double(0, 0, 0, 0));
		page.repaint();
		page.startSelectState();

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
