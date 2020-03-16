package filters;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjectFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".gpro"));
	}

	@Override
	public String getDescription() {
		return "Gerudok Project Files (*.gpro)";
	}

}
