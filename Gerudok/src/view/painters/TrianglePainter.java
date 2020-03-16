package view.painters;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import model.elements.Slot;
import model.elements.TriangleElement;

public class TrianglePainter extends Painter {

	private TriangleElement triangle;

	public TrianglePainter(Slot slotElement) {
		super(slotElement);

		triangle = (TriangleElement) slotElement;
		draw();
	}

	@Override
	public void draw() {
		shape = new GeneralPath();

		((GeneralPath) shape).moveTo(triangle.getPoint().x,
				triangle.getPoint().y + triangle.getDimension().height);
		((GeneralPath) shape).lineTo(triangle.getPoint().x + triangle.getDimension().width,
				triangle.getPoint().y + triangle.getDimension().height);
		((GeneralPath) shape).lineTo(triangle.getPoint().x + triangle.getDimension().width / 2,
				triangle.getPoint().y);
		((GeneralPath) shape).closePath();

		oldShape = shape;

		Point point = new Point(triangle.getPoint().x + triangle.getDimension().width / 2,
				triangle.getPoint().y + triangle.getDimension().height / 2);
		AffineTransform af = AffineTransform.getRotateInstance(triangle.getAngle(), point.x, point.y);
		shape = af.createTransformedShape(shape);

	}

}
