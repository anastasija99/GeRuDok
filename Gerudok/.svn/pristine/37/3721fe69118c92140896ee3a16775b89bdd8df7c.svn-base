package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import gui.MainFrame;
import model.Page;

public class PagePanel implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(e)) {
			MainFrame.getInstance().getPanel().removeAll();
			MainFrame.getInstance().getPanel().revalidate();
			MainFrame.getInstance().getPanel().repaint();
			Object selected = e.getSource();

			if (selected instanceof PageView) {
				Page page = ((PageView) selected).getPage();
				PageView pageView = new PageView(null, page);

				MainFrame.getInstance().getPanel().add(pageView, BorderLayout.CENTER);

			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
