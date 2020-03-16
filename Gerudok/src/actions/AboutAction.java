package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import actions.manager.AbstractActionIcon;
import gui.About;
import gui.MainFrame;

@SuppressWarnings("serial")
public class AboutAction extends AbstractActionIcon {

	public AboutAction(Dimension d) {

		putValue(SMALL_ICON, iconGetter("/toolbar/about.png", d));
		putValue(NAME, ("About"));
		putValue(SHORT_DESCRIPTION, "About");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		About dialog = new About(MainFrame.getInstance());
		dialog.setVisible(true);
	}

}
