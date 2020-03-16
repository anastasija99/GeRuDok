package state;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseEvent;

import commadns.AddCommand;
import model.elements.TriangleElement;
import view.PageView;

public class TriangleState extends State {

	private PageView page;

	public TriangleState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent event) {

		if (event.getButton() == MouseEvent.BUTTON1) {

			page.getPage().getCommandManager().addCommand(new AddCommand(page.getPage(),
					page.getPage().getPageSelectionModel(), event.getPoint(), PageView.TRIANGLE));
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
