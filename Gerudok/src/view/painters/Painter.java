package view.painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.Observable;

import model.elements.Slot;

public class Painter extends SlotView {

	protected Shape shape;

	public Painter(Slot slotElement) {
		super(slotElement);
	}

	@Override
	public void update(Observable o, Object arg) {

	}

	@Override
	public void paint(Slot slotElement, Graphics2D g) {

		g.setPaint(Color.BLACK);
		g.setStroke(slotElement.getStroke());
		g.draw(getShape());
		g.setPaint(slotElement.getPaint());
		g.fill(getShape());

	}

	@Override
	public boolean elementAtPosition(Point pos) {
		return getShape().contains(pos);
	}

	@Override
	public void draw() {

	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
