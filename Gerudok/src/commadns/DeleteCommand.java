package commadns;

import java.util.ArrayList;

import model.elements.SlotDevice;
import view.PageView;

public class DeleteCommand extends Command {
	
	private SlotDevice slotDevice;
	private PageView pageView;
	private ArrayList<SlotDevice> selectedSlots = new ArrayList<>();
	
	public DeleteCommand(SlotDevice slotDevice, PageView pageView) {
		super();

	}

	@Override
	public void doCommand() {

		int n = selectedSlots.size();
		for(int i = n-1;i>=0;i--) {
			SlotDevice slot = selectedSlots.get(i);
			pageView.getPage().removeElements(slot);
		}
		
	}

	@Override
	public void undoCommand() {

		int n = selectedSlots.size();
		for(int i = n-1;i>=0;i--) {
			SlotDevice slot = selectedSlots.get(i);
			pageView.getPage().removeElements(slot);
			pageView.getPage().addElements(slot);
		}
		
	}

}
