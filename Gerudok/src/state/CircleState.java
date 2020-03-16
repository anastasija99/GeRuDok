package state;

import model.Page;
import model.elements.CircleElement;
import view.PageView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import commadns.AddCommand;

public class CircleState extends State {

	private PageView page;

	public CircleState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == MouseEvent.BUTTON1) {

			page.getPage().getCommandManager().addCommand(new AddCommand(page.getPage(),
					page.getPage().getPageSelectionModel(), event.getPoint(), PageView.CIRCLE));
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
