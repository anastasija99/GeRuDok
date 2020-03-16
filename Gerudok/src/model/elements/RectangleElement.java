package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import view.painters.RectanglePainter;

public class RectangleElement extends SlotDevice {

	public RectangleElement(Paint paint, Stroke stroke, Dimension dimension, Point position) {
		super(paint, stroke,  dimension, position, 0.0);
		slotPainter = new RectanglePainter(this);
	}

	public RectangleElement(RectangleElement rectangleElement) {
		super(rectangleElement);
		slotPainter = new RectanglePainter(this);
	}

	public static SlotDevice create(Point point) {
		Paint fill = new Color(255, 255, 255);
		return new RectangleElement(fill, new BasicStroke(2f), new Dimension(80, 40),point);
	}

}
