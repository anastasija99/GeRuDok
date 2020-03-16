package view.painters;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import model.elements.CircleElement;
import model.elements.Slot;

public class CirclePainter extends Painter {

	private CircleElement circle;

	public CirclePainter(Slot slotElement) {
		super(slotElement);

		circle = (CircleElement) slotElement;

		draw();
	}

	@Override
	public void draw() {
		shape = new Ellipse2D.Double(circle.getPoint().getX(),
				circle.getPoint().getY(), 
				circle.getDimension().getWidth(), 
				circle.getDimension().getHeight());

		oldShape = shape;

		Point point = new Point(circle.getPoint().x + circle.getDimension().width / 2,
				circle.getPoint().y + circle.getDimension().height / 2);
		AffineTransform af = AffineTransform.getRotateInstance(circle.getAngle(), point.x, point.y);
		shape = af.createTransformedShape(shape);
	}

}
