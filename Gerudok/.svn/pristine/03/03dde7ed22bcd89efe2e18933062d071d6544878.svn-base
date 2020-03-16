package gui;

import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import actions.manager.ActionManager;
import state.StateManager;

public class SlotToolbarGerudok extends JToolBar {



	public SlotToolbarGerudok() {
		super(SwingConstants.VERTICAL);
		

		add(ActionManager.getInstance().getCircleAction());
		add(ActionManager.getInstance().getRectangleAction());
		add(ActionManager.getInstance().getTriangleAction());
		

		addSeparator();

		add(ActionManager.getInstance().getResizeAction());
		add(ActionManager.getInstance().getSelectAction());
		add(ActionManager.getInstance().getRotateAction());
		add(ActionManager.getInstance().getMoveAction());
		add(ActionManager.getInstance().getDeleteSlotAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getCutAction());
		add(ActionManager.getInstance().getCopyAction());
		add(ActionManager.getInstance().getPasteAction());
		add(ActionManager.getInstance().getSelectObjectAction());
		add(ActionManager.getInstance().getContentAction());

		setFloatable(true);
		setBackground(new Color(255,255,255));

	}

	
}
