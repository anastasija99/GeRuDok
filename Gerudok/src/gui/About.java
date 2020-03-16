package gui;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class About extends JDialog {

	public About(JFrame parent) {
		super(parent, "Tim 203_17", true);
		setSize(500, 270);

		setLocationRelativeTo(parent);

		setLayout(new GridLayout(1, 2, 20, 20));

		JLabel lblPodaciNikola = new JLabel("Nikola Paunovic 57/18RN");
		ImageIcon imageNikola = new ImageIcon("images/nikola1.jpg");
		Image resizedImageNikola = imageNikola.getImage().getScaledInstance(200, 200, 1);
		JLabel lblNikola = new JLabel(new ImageIcon(resizedImageNikola));
		lblNikola.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblPodaciNikola.setAlignmentX(CENTER_ALIGNMENT);
		Box boxNikola = Box.createVerticalBox();
		boxNikola.add(lblPodaciNikola);
		boxNikola.add(lblNikola);

		JLabel lblPodaciNikola2 = new JLabel("Anastasija Radonjic RN68/19");
		ImageIcon imageNikola2 = new ImageIcon("images/anastasija1.jpg");
		Image resizedImageNikola2 = imageNikola2.getImage().getScaledInstance(200, 200, 1);
		JLabel lblNikola2 = new JLabel(new ImageIcon(resizedImageNikola2));
		lblNikola2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblPodaciNikola2.setAlignmentX(CENTER_ALIGNMENT);
		Box boxNikola2 = Box.createVerticalBox();
		boxNikola2.add(lblPodaciNikola2);
		boxNikola2.add(lblNikola2);

		add(boxNikola2);

		add(boxNikola);
		setLocationRelativeTo(parent);
	}
}
