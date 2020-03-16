package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class SlotDevice extends Slot implements Serializable {

	protected double angle;
	protected Dimension dimension;
	protected Point point;

	public SlotDevice(Paint paint, Stroke stroke, Dimension dimension, Point position, double angle) {
		super(paint, stroke);
		this.angle = angle;
		this.dimension = dimension;
		this.point = position;
	}

	public SlotDevice(SlotDevice device) {
		super(device);
		this.dimension = device.getDimension();
		this.point = device.getPoint();
		this.angle = device.getAngle();
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Point getPoint() {
		return point;
	}

	public void setPosition(Point position) {
		this.point = position;
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public Slot clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
