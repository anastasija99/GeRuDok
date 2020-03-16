package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Painter;
import javax.swing.UIManager;

import gui.MainFrame;

public class GerudokMain {

	public static void main(String[] args) {
		 try {

		        for (UIManager.LookAndFeelInfo laf : UIManager
		                .getInstalledLookAndFeels()) {
		            if ("Nimbus".equals(laf.getName())) {
		                UIManager.setLookAndFeel(laf.getClassName());
		                UIManager.getLookAndFeelDefaults().put(
		                        "DesktopPane[Enabled].backgroundPainter",
		                        new DesktopPainter());
		            }
		        }
		    } 
		 catch (Exception e) {
		        e.printStackTrace();
		    }
		 
		 

		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.setVisible(true);
		
	}

}
