package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import actions.manager.AbstractActionIcon;
import filters.ProjectFileFilter;
import gui.MainFrame;
import model.Project;
import model.Workspace;

@SuppressWarnings("serial")
public class OpenProjectAction extends AbstractActionIcon {

	public OpenProjectAction(Dimension d) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(SMALL_ICON, iconGetter("/toolbar/openproj.png", d));
		putValue(NAME, ("Open"));
		putValue(SHORT_DESCRIPTION, ("Open"));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFileFilter());

		if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				Project p = null;
				try {
					p = (Project) os.readObject();
				} catch (Exception e) {
					e.printStackTrace();
				}

				((Workspace) MainFrame.getInstance().getTree().getModel().getRoot()).addProject(p);
				p.generateView();

				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
