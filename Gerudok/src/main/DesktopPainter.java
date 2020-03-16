package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Painter;

public class DesktopPainter implements Painter<JComponent> {
    private Image image;

    public DesktopPainter() {
        try {
        	 image = ImageIO.read(new URL("https://cdn6.f-cdn.com/contestentries/1301217/27758306/5acbd1448d2c3_thumb900.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics2D g, JComponent object, int width, int height) {
        g.drawImage(image, 0, 0, width, height, null);
    }
}
