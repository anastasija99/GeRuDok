package gui;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import actions.manager.ActionManager;

public class MenuBar extends JMenuBar {

	private JMenu file;
	private JMenu newSlot;
	private JMenu edit;
	private JMenu help;

	public MenuBar() {
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		newSlot = new JMenu("NewSlot");
		ImageIcon iconas = new ImageIcon("images/menu/addslot.png");
		newSlot.setIcon(iconas);

		newSlot.add(ActionManager.getInstance().getCircleAction());
		newSlot.add(ActionManager.getInstance().getTriangleAction());
		newSlot.add(ActionManager.getInstance().getRectangleAction());

		file.add(ActionManager.getInstance().getOpenproject());

		file.addSeparator();

		file.add(ActionManager.getInstance().getSave());
		file.add(ActionManager.getInstance().getSaveas());
		file.addSeparator();

		file.addSeparator();
		file.add(newSlot);

		file.addSeparator();
		file.add(ActionManager.getInstance().getQuitaction());

		edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);

		edit.addSeparator();
		edit.add(ActionManager.getInstance().getDeletenode());
		edit.add(ActionManager.getInstance().getUndoAction());

		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		help.add(ActionManager.getInstance().getAbout());

		add(file);
		add(edit);
		add(help);
	}

}