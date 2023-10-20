import javax.swing.*;
public class MyFrame extends JFrame{

    MyPanel panel;
    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game of Life 1.0");
        panel = new MyPanel();
        this.add(panel);
        this.pack();
        this.setVisible(true);
        panel.setFocusable(true);
    }
}
