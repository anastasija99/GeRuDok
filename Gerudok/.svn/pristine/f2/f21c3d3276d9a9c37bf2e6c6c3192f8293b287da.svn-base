package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

import model.elements.Slot;

public class TextEditor extends JDialog {

	private Slot slot;
	private JTextPane text;
	JButton sizeUp;
	JButton sizeDown;

	public TextEditor(Frame parent, String title, boolean modal, Slot slot) {
		super(parent, title, modal);

		this.slot = slot;
		this.text = new JTextPane();
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);
		setLocationRelativeTo(parent);

		// Proverava da li postoji tekst
		if (slot.getContent() != null)
			text.setText(slot.getContent());

		JToolBar toolbar = new JToolBar();
		generateTools(toolbar);

		this.add(toolbar, BorderLayout.NORTH);
		this.add(text, BorderLayout.CENTER);
	}

	private void generateTools(JToolBar toolbar) {

		Icon icon = new ImageIcon("images/menu/save.png");
		JButton save = new JButton(icon);

		icon = new ImageIcon("images/menu/bold.png");
		JButton bold = new JButton(icon);

		icon = new ImageIcon("images/menu/italic.png");
		JButton italic = new JButton(icon);

		icon = new ImageIcon("images/menu/underline.png");
		JButton underline = new JButton(icon);

		bold.addActionListener(new StyledEditorKit.BoldAction());
		underline.addActionListener(new StyledEditorKit.UnderlineAction());
		italic.addActionListener(new StyledEditorKit.ItalicAction());

		toolbar.add(bold);
		toolbar.add(italic);
		toolbar.add(underline);
		toolbar.addSeparator();
		toolbar.add(save);

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				slot.setContent((text.getText()));
			}
		});

	}

}
