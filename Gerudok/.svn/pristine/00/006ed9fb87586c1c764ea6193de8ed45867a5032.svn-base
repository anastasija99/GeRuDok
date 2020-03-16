package view.painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;
import java.util.Observer;

import javax.swing.JPanel;

import model.elements.Slot;

public abstract class SlotView extends JPanel implements Observer, Serializable {

	protected Shape shape;
	protected Shape oldShape;
	
	

	public SlotView(Slot slotElement) {
		super();
	}

	public abstract void paint(Slot slotElement, Graphics2D g);

	public abstract boolean elementAtPosition(Point pos);

	public abstract void draw();

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getOldShape() {
		return oldShape;
	}

	public void setOldShape(Shape oldShape) {
		this.oldShape = oldShape;
	}
}
