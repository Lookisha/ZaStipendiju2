
import java.awt.*;
import javax.swing.*;

public class FrameSlika extends JFrame implements KonstanteZaFrame {

    FrameSlika() {
        ImageIcon icon = new ImageIcon("ASCII.png");
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setBounds(0,0,icon.getImage().getWidth(null),icon.getImage().getHeight(null));
        label.setOpaque(true);
        label.setVisible(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- ASCII / SLIKA");
        this.setSize(new Dimension(icon.getImage().getWidth(null),icon.getImage().getHeight(null)+40));
        this.setLayout(null);
        this.setVisible(true);

        this.add(label);

        //https://exceljet.net/sites/default/files/styles/original_with_watermark/public/images/term/ascii%20codes%20128.png?itok=v4t_m6YH
    }
}