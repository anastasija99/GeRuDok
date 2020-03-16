package filters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class WorkspaceFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".ws"));
	}

	@Override
	public String getDescription() {
		return "GeRuDok Workspace (*.ws)";
	}

}
