package filters;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class DocumentFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".doc"));
	}

	@Override
	public String getDescription() {
		return "Gerudok Document Files (*.doc)";
	}

}
