package commadns;

import java.io.Serializable;
import java.util.ArrayList;

import gui.MainFrame;

public class CommandManager implements Serializable {

	private ArrayList<Command> commands = new ArrayList<Command>();
	private int numberOfCommands = 0;
	
	public CommandManager() {
		commands = new ArrayList<>();
	}
	
	public void addCommand(Command command) {
		while(numberOfCommands < commands.size())
			commands.remove(numberOfCommands);
		
		commands.add(command);
		doCommand();
	}

	public void doCommand() {
		if (numberOfCommands < commands.size()) {
			commands.get(numberOfCommands++).doCommand();
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		if (numberOfCommands == commands.size())
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		}
	

	public void undoCommand() {
		if (numberOfCommands > 0) {
			commands.get(--numberOfCommands).undoCommand();
			MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
		}
		if (numberOfCommands == 0)
			MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
	}
}
