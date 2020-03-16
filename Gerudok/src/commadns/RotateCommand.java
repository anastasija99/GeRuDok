package commadns;

import java.util.ArrayList;

import model.Page;
import model.elements.SlotDevice;

public class RotateCommand extends Command {

	private Page page;
	private SlotDevice selectSlot;
	private ArrayList<SlotDevice> slots = new ArrayList<>();
	private double oldAngle;
	private double newAngle;

	public RotateCommand(Page page, SlotDevice selSlot, ArrayList<SlotDevice> slots, double oldAngle, double newAngle) {
		super();

	}

	@Override
	public void undoCommand() {

	}

	@Override
	public void doCommand() {

	}

}
