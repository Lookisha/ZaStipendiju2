import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements KonstanteZaFrame,ActionListener{
    
    DekripcijaFrame dekripcijaFrame;
    EnkripcijaFrame enkripcijaFrame;
    AsciiFrame asciiFrame;
    ProstiBrojeviFrame prostiBrojeviFrame;
    BruteForceFrame bruteForceFrame;

    JButton buttonOpcijaLeft;
    JButton buttonOpcijaRight;
    JButton buttonOpcijaDown;
    JButton buttonOpcijaDownLeft;
    JButton buttonOpcijaDownRight;

    JLabel labelUpute;
    JLabel LabelUputeProduzenaRuka1;
    JLabel LabelUputeProduzenaRuka2;

    JTextField ja;
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- MAIN");
        this.setSize(new Dimension(FRAME_WIDTH+100,FRAME_HEIGHT+100));
        this.setLayout(null);
        this.getContentPane().setBackground(colorB);
        this.setVisible(true);

        LabelUputeProduzenaRuka1 = new JLabel();
        LabelUputeProduzenaRuka1.setFont(new Font("MV Boli",Font.ITALIC,19));
        LabelUputeProduzenaRuka1.setBounds(100,10,FRAME_WIDTH-100,50);
        LabelUputeProduzenaRuka1.setText("(Lijevo) za ENKRIPCIJU ili (Desno) za DEKRIPCIJU");
        LabelUputeProduzenaRuka1.setForeground(color3);
        LabelUputeProduzenaRuka1.setBackground(color4);
        LabelUputeProduzenaRuka1.setVisible(true);
        LabelUputeProduzenaRuka1.setOpaque(true);

        LabelUputeProduzenaRuka2 = new JLabel();
        LabelUputeProduzenaRuka2.setFont(new Font("MV Boli",Font.ITALIC,20));
        LabelUputeProduzenaRuka2.setBounds(100,50,FRAME_WIDTH-100,50);
        LabelUputeProduzenaRuka2.setText("RSA sustava enkripcije i dekripcije.");
        LabelUputeProduzenaRuka2.setForeground(color3);
        LabelUputeProduzenaRuka2.setBackground(color4);
        LabelUputeProduzenaRuka2.setVisible(true);
        LabelUputeProduzenaRuka2.setOpaque(true);

        this.add(LabelUputeProduzenaRuka1);
        this.add(LabelUputeProduzenaRuka2);
        dugmad();

        ja = new JTextField();
        ja.setBorder(null);
        ja.setFont(new Font("MV Boli",Font.ITALIC,20));
        ja.setBounds(250,405,200,30);
        ja.setBackground(colorB);
        ja.setForeground(colorJa);
        ja.setEditable(false);
        ja.setVisible(true);
        ja.setOpaque(true);
        ja.setText("Napravio: Lookisha");
        this.add(ja);
    }

    public void dugmad() {

        buttonOpcijaLeft = new JButton();
        buttonOpcijaLeft.setBackground(color1);
        buttonOpcijaLeft.setFont(new Font("MV Boli",Font.BOLD,32));
        buttonOpcijaLeft.setForeground(color2);
        buttonOpcijaLeft.setText("Enkripcija");
        buttonOpcijaLeft.setBounds(100, 100+35, 200, 200);
        buttonOpcijaLeft.addActionListener(this);
        buttonOpcijaLeft.setFocusable(false);
        this.add(buttonOpcijaLeft);

        buttonOpcijaRight = new JButton();
        buttonOpcijaRight.setBackground(color1);
        buttonOpcijaRight.setFont(new Font("MV Boli",Font.BOLD,32));
        buttonOpcijaRight.setForeground(color2);
        buttonOpcijaRight.setText("Dekripcija");
        buttonOpcijaRight.setBounds(400, 100+35, 200, 200);
        buttonOpcijaRight.addActionListener(this);
        buttonOpcijaRight.setFocusable(false);
        this.add(buttonOpcijaRight);

        buttonOpcijaDown = new JButton();
        buttonOpcijaDown.setBackground(color1);
        buttonOpcijaDown.setFont(new Font("MV Boli",Font.BOLD,32));
        buttonOpcijaDown.setForeground(color2);
        buttonOpcijaDown.setText("ASCII");
        buttonOpcijaDown.setBounds(250, 100+35+200+100, 200, 200);
        buttonOpcijaDown.addActionListener(this);
        buttonOpcijaDown.setFocusable(false);
        this.add(buttonOpcijaDown);

        buttonOpcijaDownLeft = new JButton();
        buttonOpcijaDownLeft.setBackground(color1);
        buttonOpcijaDownLeft.setFont(new Font("MV Boli",Font.BOLD,16));
        buttonOpcijaDownLeft.setForeground(color2);
        buttonOpcijaDownLeft.setText("Prosti");
        buttonOpcijaDownLeft.setBounds(15, 550, 100, 100);
        buttonOpcijaDownLeft.addActionListener(this);
        buttonOpcijaDownLeft.setFocusable(false);
        this.add(buttonOpcijaDownLeft);

        buttonOpcijaDownRight = new JButton();
        buttonOpcijaDownRight.setBackground(color1);
        buttonOpcijaDownRight.setFont(new Font("MV Boli",Font.BOLD,11));
        buttonOpcijaDownRight.setForeground(color2);
        buttonOpcijaDownRight.setText("Brute-force");
        buttonOpcijaDownRight.setBounds(575, 550, 100, 100);
        buttonOpcijaDownRight.addActionListener(this);
        buttonOpcijaDownRight.setFocusable(false);
        this.add(buttonOpcijaDownRight);

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonOpcijaLeft) {
            new EnkripcijaFrame();
        }

        if(e.getSource() == buttonOpcijaRight) {
            new DekripcijaFrame();
        }
        if(e.getSource() == buttonOpcijaDown) {
            new AsciiFrame();
        }
        if(e.getSource() == buttonOpcijaDownLeft) {
            new ProstiBrojeviFrame();
        }
        if(e.getSource() == buttonOpcijaDownRight) {
            new BruteForceFrame();
        }
    }
}