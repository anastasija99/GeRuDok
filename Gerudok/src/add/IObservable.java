package add;

import javax.swing.tree.MutableTreeNode;
import java.io.Serializable;

public interface IObservable extends Serializable {

	void add(MutableTreeNode child);

}
