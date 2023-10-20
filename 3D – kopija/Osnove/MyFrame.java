package Osnove;

import javax.swing.*;
//import java.awt.*;
class MyFrame extends JFrame{

    MyPanel panel;
    long x = 0;
    long y = 0;
    MyFrame() throws InterruptedException {
        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 250);
        this.setVisible(true);
        this.add(panel);
        this.pack();
        panel.setFocusable(true);

        while(panel.running == true) { //može se isto napraviti pomoću timer taska
            if(System.nanoTime() % 1000000000 == 0) {
                this.setTitle("3D Engine | FPS = "+FPS_Function(panel.brojac));
            }
        }
    }

    public String FPS_Function(int brojac) {
        String fpsString = null;
        double fps = 0;

        y = System.nanoTime();
        fps = brojac / (Math.abs(y-x)/Math.pow(10, 9));
        x = y;
        fpsString = String.valueOf((int)fps);

        panel.brojac = 0;

        return fpsString;
    }
}
