package state;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import enums.Handle;

public abstract class State implements Serializable {

	protected Graphics graphics = null;
	protected Handle handle;

	public abstract void mousePressed(MouseEvent event);

	public abstract void mouseDragged(MouseEvent event);

	public abstract void mouseReleased(MouseEvent event);

	public abstract void mouseMoved(MouseEvent event);

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	public void setHandle(Handle handle) {
		this.handle = handle;
	}

}
