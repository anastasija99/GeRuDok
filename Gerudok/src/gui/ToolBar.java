package gui;

import javax.swing.JToolBar;

import actions.manager.ActionManager;

public class ToolBar extends JToolBar {

	public ToolBar() {
		super(JToolBar.HORIZONTAL);
		setFloatable(false);

		add(ActionManager.getInstance().getNewAction());

		addSeparator();

		add(ActionManager.getInstance().getDeletenode());

		add(ActionManager.getInstance().getRenamenode());

		addSeparator();

		add(ActionManager.getInstance().getOpenproject());

		add(ActionManager.getInstance().getSaveas());

		addSeparator();

		add(ActionManager.getInstance().getCloseAction());

		add(ActionManager.getInstance().getCloseAllAction());

		add(ActionManager.getInstance().getSwitchWs());

		add(ActionManager.getInstance().getSaveWsAction());

		addSeparator();
		
		add(ActionManager.getInstance().getUndoAction());
		add(ActionManager.getInstance().getRedoAction());
		add(ActionManager.getInstance().getShareDocuments());
		
		addSeparator();
		
		add(ActionManager.getInstance().getAbout());

	}
}
