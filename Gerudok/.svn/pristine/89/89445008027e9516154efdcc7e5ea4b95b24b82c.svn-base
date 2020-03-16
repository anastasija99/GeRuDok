package state;

import model.Page;
import model.elements.RectangleElement;
import view.PageView;

import java.awt.*;
import java.awt.event.MouseEvent;

import commadns.AddCommand;

public class RectangleState extends State {

	private PageView page;

	public RectangleState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {

			page.getPage().getCommandManager().addCommand(new AddCommand(page.getPage(),
					page.getPage().getPageSelectionModel(), e.getPoint(), PageView.RECTANGLE));
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
