package factory;

import model.Document;
import model.Project;
import model.Workspace;

public class FabricGen {

	public static NodeFactory generateFacotry(Object o) {
		if (o instanceof Workspace)
			return new ProjectFactory();
		if (o instanceof Project)
			return new DocumentFactory();
		if (o instanceof Document)
			return new PageFactory();
		return null;

	}

}
