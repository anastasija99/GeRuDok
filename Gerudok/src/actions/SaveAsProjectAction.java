package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import actions.manager.AbstractActionIcon;
import filters.ProjectFileFilter;
import gui.MainFrame;
import model.Project;

@SuppressWarnings("serial")
public class SaveAsProjectAction extends AbstractActionIcon {

	public SaveAsProjectAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, iconGetter("/toolbar/save.png", d));
		putValue(NAME, ("SaveAs"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFileFilter());

		Project project = (Project) MainFrame.getInstance().getTree().getLastSelectedPathComponent();

		File projectFile = project.getProjectFile();

		if (project.getProjectFile() == null) {
			if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
				projectFile = jfc.getSelectedFile();

			} else {
				return;
			}

		}

		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setProjectFile(projectFile);
			project.setChanged(false);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}
}
