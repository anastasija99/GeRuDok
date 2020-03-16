package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.MainFrame;
import model.elements.Slot;

public class ImageEditor extends JDialog {

	private ContentMenu menu;
	private JButton importImage;
	private JLabel label;
	private JPanel panel;

	public ImageEditor(Frame parent, String title, boolean modal, Slot slot) {
		menu = new ContentMenu();
		setSize(new Dimension(300, 300));
		setJMenuBar(menu);
		this.setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		panel = new JPanel();
		label = new JLabel();
		label.setPreferredSize(new Dimension(80, 80));
		importImage = new JButton("Import Image");
		importImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int i = jfc.showSaveDialog(null);
				if (i == JFileChooser.APPROVE_OPTION) {
					File select = jfc.getSelectedFile();
					String path = select.getAbsolutePath();
					label.setIcon(resize(path));
				}
			}
		});

		panel.setLayout(new BorderLayout());
		panel.add(importImage, BorderLayout.NORTH);
		panel.add(label, BorderLayout.CENTER);

		this.add(panel, BorderLayout.CENTER);

	}

	public JPanel getPanel() {
		return panel;
	}

	public ImageIcon resize(String path) {

		Image img = new ImageIcon(path).getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
		return new ImageIcon(newImg);
	}
}