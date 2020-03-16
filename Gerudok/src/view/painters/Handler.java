package view.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

import enums.Handle;
import model.elements.SlotDevice;

public class Handler {

	private SlotDevice selectedSlot;
	private Graphics2D graph2D;
	private static final int handleSize = 10;

	public Handler() {

	}

	public Graphics2D getG2d() {
		return graph2D;
	}

	public void setG2d(Graphics2D g2d) {
		this.graph2D = g2d;
	}

	public void paintHandles() {
		if (graph2D == null) {
			return;
		}
		graph2D.setStroke(
				new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1f, new float[] { 3f, 6f }, 0));
		graph2D.setPaint(Color.BLUE);
		graph2D.drawRect((int) selectedSlot.getPoint().getX(), (int) selectedSlot.getPoint().getY(),
				(int) selectedSlot.getDimension().getWidth(), (int) selectedSlot.getDimension().getHeight());
		for (Handle h : Handle.values()) {
			paintSelectionHandle(graph2D, getHandlePoint(selectedSlot.getPoint(), selectedSlot.getDimension(), h));
		}
		selectedSlot.getSlotPainter().paint(selectedSlot, graph2D);

	}

	private void paintSelectionHandle(Graphics2D g2, Point2D position) {
		g2.fill(new Rectangle((int) position.getX() - handleSize / 2, (int) position.getY() - handleSize / 2, handleSize, handleSize));
	}

	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition) {
		double x = 0, y = 0;

		// koordinate

		// Ako su gornji hendlovi
		if (handlePosition == Handle.NorthWest || handlePosition == Handle.North
				|| handlePosition == Handle.NorthEast) {
			y = topLeft.getY();
		}
		// Ako su centralni po y osi
		if (handlePosition == Handle.East || handlePosition == Handle.West) {
			y = topLeft.getY() + size.getHeight() / 2;
		}
		// Ako su donji
		if (handlePosition == Handle.SouthWest || handlePosition == Handle.South
				|| handlePosition == Handle.SouthEast) {
			y = topLeft.getY() + size.getHeight();
		}

		// x koordinate

		// Ako su levi
		if (handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest) {
			x = topLeft.getX();
		}
		// ako su centralni po x osi
		if (handlePosition == Handle.North || handlePosition == Handle.South) {
			x = topLeft.getX() + size.getWidth() / 2;
		}
		// ako su desni
		if (handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast) {
			x = topLeft.getX() + size.getWidth();
		}

		return new Point2D.Double(x, y);
	}

	public Cursor setMouseCursor(Point2D point) {

		Handle handle = getPointOfHandle(selectedSlot, point);
		Cursor cursor = null;

		if (handle != null) {

			switch (handle) {
			case North:
				cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
				break;
			case South:
				cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
				break;
			case East:
				cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
				break;
			case West:
				cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
				break;
			case SouthEast:
				cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
				break;
			case NorthWest:
				cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
				break;
			case SouthWest:
				cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
				break;
			case NorthEast:
				cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
				break;
			}

		}
		return cursor;
	}

	public Handle getPointOfHandle(SlotDevice element, Point2D point) {
		for (Handle h : Handle.values()) {
			if (isPointInHandle(element, point, h)) {
				return h;
			}
		}
		return null;
	}

	private boolean isPointInHandle(SlotDevice element, Point2D point, Handle handle) {
		if (element instanceof SlotDevice) {
			SlotDevice device = (SlotDevice) element;
			Point2D handleCenter = getHandlePoint(device.getPoint(), device.getDimension(), handle);
			return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize) &&
					(Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize) );
		} else
			return false;
	}

	public SlotDevice getSelectedSlot() {
		return selectedSlot;
	}

	public void setSelectedSlot(SlotDevice selectedSlot) {
		this.selectedSlot = selectedSlot;
	}

}
