package view.painters;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import model.elements.RectangleElement;
import model.elements.Slot;

public class RectanglePainter extends Painter {
	private RectangleElement rectangle;

	public RectanglePainter(Slot slotElement) {
		super(slotElement);

		rectangle = (RectangleElement) slotElement;
		draw();
	}

	@Override
	public void draw() {
		shape = new Rectangle2D.Double(rectangle.getPoint().getX(),
				rectangle.getPoint().getY(),
				rectangle.getDimension().getWidth(),
				rectangle.getDimension().getHeight());

		oldShape = shape;

		Point point = new Point(rectangle.getPoint().x + rectangle.getDimension().width / 2,
				rectangle.getPoint().y + rectangle.getDimension().height / 2);
		AffineTransform af = AffineTransform.getRotateInstance(rectangle.getAngle(), point.x, point.y);
		shape = af.createTransformedShape(shape);
	}
}