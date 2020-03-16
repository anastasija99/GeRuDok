package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import view.PageView;
import view.painters.CirclePainter;

public class CircleElement extends SlotDevice {
	
	private PageView page;

	public CircleElement(Paint paint, Stroke stroke, Dimension dimension, Point position) {
		super(paint, stroke, dimension, position, 0.0);
		slotPainter = new CirclePainter(this);
	}

	public CircleElement(CircleElement circle) {
		super(circle);
		slotPainter = new CirclePainter(this);
	}
	
	public static SlotDevice create(Point point) {
		Paint fill = new Color(255,0, 20);
		return new CircleElement(fill, new BasicStroke(2f), new Dimension(70,70), point);
	}
	
	
}
