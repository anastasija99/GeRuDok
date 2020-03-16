package state;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Page;
import model.elements.Slot;
import model.elements.SlotDevice;
import view.ImageEditor;
import view.PageView;
import view.TextEditor;

public class ContentState extends State {

	private PageView page;

	public ContentState(PageView pageView) {
		this.page = pageView;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		for (SlotDevice slotDevice : page.getPage().getSlotDevices()) {
			if (slotDevice.getSlotPainter().elementAtPosition(e.getPoint()) && e.isShiftDown()) {

				page.getPage().setSelectSlot(slotDevice);

				page.getPage().getSelectedSlots().add(slotDevice);

				return;
			} else if (slotDevice.getSlotPainter().elementAtPosition(e.getPoint())) {
				if (slotDevice.getSlotPainter().getShape().contains(e.getPoint())) {
					if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
						SlotDevice element = page.getPage().getSelectSlot();

						if (element.getElementTextContent() == null || element.getElementImageContent() == null) {

							String[] options = { "Image", "Text" };
							int answer = JOptionPane.showOptionDialog(null, "Choose your content", " ",
									JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
							if (answer == JOptionPane.NO_OPTION) {
								if (element.getElementTextContent() == null) {
									element.setElementTextContent(new TextEditor(null, null, false, slotDevice));
									element.getElementTextContent().setVisible(true);
								} else {
									element.getElementTextContent().setVisible(true);
								}
							}
							if (answer == JOptionPane.YES_OPTION) {
								if (element.getElementImageContent() == null) {
									element.setElementImageContent(new ImageEditor(null, null, false, slotDevice));
									element.getElementImageContent().setVisible(true);
								} else {
									element.getElementImageContent().setVisible(true);
								}
							}

						} else {
							String[] options = { "Image", "Text" };
							int answer = JOptionPane.showOptionDialog(null, "Choose your content", " ",
									JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
							if (answer == JOptionPane.YES_OPTION)
								element.getElementTextContent().setVisible(true);
							if (answer == JOptionPane.NO_OPTION)
								element.getElementImageContent().setVisible(true);
						}
					}

				}
				page.getPage().setSelectSlot(slotDevice);

				page.getPage().getSelectedSlots().add(slotDevice);
				return;
			}

		}

		page.getPage().setSelectSlot(null);
		page.getPage().getSelectedSlots().clear();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub

	}

}
