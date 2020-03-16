package commadns;

import java.awt.Point;

import model.Page;
import model.PageSlotSelection;
import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.elements.SlotDevice;
import model.elements.TriangleElement;
import view.PageView;

public class AddCommand extends Command {
	
	
	private Page page;
	private SlotDevice slot;
	int deviceType;
	 private Point lastPosition;
	 private PageSlotSelection pageSelection;

	public AddCommand(Page page, PageSlotSelection pageSelectionModel, Point lastPosition, int deviceType) {
		this.page = page;
		this.lastPosition = lastPosition;
		this.pageSelection = pageSelectionModel;
		this.deviceType = deviceType;
	}

	@Override
	public void doCommand() {
		
		if(slot == null)
			if(deviceType == PageView.CIRCLE) {
				slot = CircleElement.create(lastPosition);
			}
			else if(deviceType == PageView.RECTANGLE) {
				slot = RectangleElement.create(lastPosition);
			}
			else {
				slot = TriangleElement.create(lastPosition);
			}
		page.getSelectedSlots().clear();
		page.setSelectSlot(null);
		page.addElements(slot);
		
	}

	@Override
	public void undoCommand() {
		page.getSelectedSlots().clear();
		page.setSelectSlot(null);
		page.removeElements(slot);
		
	}

}
