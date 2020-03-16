package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import view.painters.TrianglePainter;

public class TriangleElement extends SlotDevice {

	public TriangleElement(Paint paint, Stroke stroke, Dimension dimension, Point position) {
		super(paint, stroke, dimension, position, 0.0);
		slotPainter = new TrianglePainter(this);

	}

	public TriangleElement(TriangleElement triangle) {
		super(triangle);
		slotPainter = new TrianglePainter(this);
	}

	public static SlotDevice create(Point point) {
		Paint fill = new Color(0, 35, 255);
		return new TriangleElement(fill, new BasicStroke(2f), new Dimension(60, 60), point);
	}

}
