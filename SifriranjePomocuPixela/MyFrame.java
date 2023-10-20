import javax.swing.*;
import javax.imageio.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class MyFrame extends JFrame{
    MyPanel panel;
    MyFrame() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyPanel();
        this.add(panel);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        panel.setFocusable(true);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scrshtActionPerformed();
    }
    public void scrshtActionPerformed() {                                             
        BufferedImage screenshotImage = new BufferedImage(
                this.getBounds().width, this.getBounds().height,
                BufferedImage.TYPE_INT_RGB);
        this.paint(screenshotImage.getGraphics());
        try {
            ImageIO.write(screenshotImage, "png", new File("screenShot.png" ));
        } catch (IOException ex) {
            System.err.println("ImageIsuues");
        }
    }
}
