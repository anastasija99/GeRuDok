package commadns;

import java.io.Serializable;

public abstract class Command implements Serializable {

	public abstract void doCommand();

	public abstract void undoCommand();
}
