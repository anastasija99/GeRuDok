package model.elements;

import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.Serializable;

import commadns.CommandManager;
import view.ImageEditor;
import view.TextEditor;
import view.painters.ElementPainter;
import view.painters.SlotView;

public abstract class Slot implements Serializable {

	protected Paint paint;
	protected SlotView slotPainter;
	transient private CommandManager commandManager;
	protected String name;
	protected SerializableStroke stroke;
	private ImageEditor elementImageContent;
	private TextEditor elementTextContent;
	
	

	public abstract Slot clone();

	protected ElementType type;
	protected String content;

	protected ElementPainter elementPainter;

	public SlotView getSlotPainter() {
		return slotPainter;
	}

	public Slot(Paint paint, Stroke stroke) {
		super();
		this.paint = paint;
		setStroke(stroke);
		this.type = ElementType.NONE;

	}
	
	public TextEditor getElementTextContent() {
		return elementTextContent;
	}
	public ImageEditor getElementImageContent() {
		return elementImageContent;
	}
	public void setElementImageContent(ImageEditor elementImageContent) {
		this.elementImageContent = elementImageContent;
	}
	public void setElementTextContent(TextEditor elementTextContent) {
		this.elementTextContent = elementTextContent;
	}

	public ElementType getType() {
		return type;
	}

	public void setType(ElementType type) {
		this.type = type;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Slot(Slot sl) {
		super();
		this.paint = sl.getPaint();
		this.stroke = sl.getStroke();
		this.name = sl.getName();
		this.slotPainter = sl.getSlotPainter();
	}

	public SerializableStroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = new SerializableStroke(stroke);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public void setSlotPainter(SlotView slotPainter) {
		this.slotPainter = slotPainter;
	}

	public CommandManager getCommandManager() {
		if (commandManager == null)
			commandManager = new CommandManager();

		return commandManager;
	}

	private class SerializableStroke implements Stroke, Serializable {

		Stroke stroke;

		public SerializableStroke(Stroke s) {
			stroke = s;
		}

		private void writeObject(java.io.ObjectOutputStream out) throws IOException {
			if (stroke instanceof BasicStroke) {
				BasicStroke s = (BasicStroke) stroke;
				out.writeFloat(s.getLineWidth());
				out.writeInt(s.getEndCap());
				out.writeInt(s.getLineJoin());
				out.writeFloat(s.getMiterLimit());
				out.writeObject(s.getDashArray());
				out.writeFloat(s.getDashPhase());
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
			stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(), in.readFloat(),
					(float[]) in.readObject(), in.readFloat());
		}

		public Shape createStrokedShape(Shape p) {
			return stroke.createStrokedShape(p);
		}

	}

}
