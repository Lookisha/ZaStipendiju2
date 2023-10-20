
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigInteger;

public class AsciiFrame extends JFrame implements KonstanteZaFrame,ActionListener {

    JTextField text_slovo;
    JTextField text_broj;

    JTextField display1;
    JTextField display2;

    JLabel upute;

    JButton buttonSlovo;
    JButton buttonBroj;
    JButton buttonSlika;

    String slovo;
    BigInteger broj;

    AsciiFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- ASCII");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.getContentPane().setBackground(colorB);
        this.setLayout(null);
        this.setVisible(true);

        tekst();
        display();
        dugmad();
    }

    public void tekst() {
        text_slovo = new JTextField();
        text_broj = new JTextField();

        text_slovo.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_broj.setFont(new Font("Mv Boli",Font.PLAIN, 32));

        text_slovo.setBounds(20, 50, 400, 50);
        text_broj.setBounds(20, 300, 400, 50);

        text_slovo.setText("(String -> ASCII)");
        text_broj.setText("(ASCII -> String)");

        this.add(text_slovo);
        this.add(text_broj);
    }
    public void display() {
        upute = new JLabel();
        upute.setFont(new Font("MV Boli",Font.PLAIN,15));
        upute.setBorder(null);
        upute.setBounds(10,FRAME_HEIGHT-80,FRAME_WIDTH,50);
        upute.setText("<NAPOMENA> Sva VELIKA slova pretvaraju se u mala zbog jednostavnosti!");
        upute.setBackground(colorB);
        upute.setForeground(colorBlack);
        upute.setVisible(true);
        upute.setOpaque(true);

        display1 = new JTextField();
        display1.setFont(new Font("MV Boli",Font.PLAIN,25));
        display1.setBorder(null);
        display1.setEditable(false);
        display1.setBounds(20,125,400,50);
        display1.setText("<ASCII> ");
        display1.setBackground(colorB);
        display1.setForeground(colorBlack);
        display1.setVisible(true);
        display1.setOpaque(true);

        display2 = new JTextField();
        display2.setFont(new Font("MV Boli",Font.PLAIN,25));
        display2.setBorder(null);
        display2.setEditable(false);
        display2.setBounds(20,375,400,50);
        display2.setText("<String> ");
        display2.setBackground(colorB);
        display2.setForeground(colorBlack);
        display2.setVisible(true);
        display2.setOpaque(true);

        this.add(display1);
        this.add(display2);
        this.add(upute);
    }
    public void dugmad() {

        buttonSlovo = new JButton("DO IT");
        buttonSlovo.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonSlovo.setFocusable(false);
        buttonSlovo.setBounds(440,50,125,50);
        buttonSlovo.setBackground(color3);
        buttonSlovo.setForeground(colorBlack);
        buttonSlovo.addActionListener(this);

        buttonBroj = new JButton("JUST DO IT");
        buttonBroj.setFont(new Font("MV Boli",Font.BOLD,13));
        buttonBroj.setFocusable(false);
        buttonBroj.setBounds(440,300,125,50);
        buttonBroj.setBackground(color3);
        buttonBroj.setForeground(colorBlack);
        buttonBroj.addActionListener(this);

        buttonSlika = new JButton(".png");
        buttonSlika.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonSlika.setFocusable(false);
        buttonSlika.setBounds(465,400,100,100);
        buttonSlika.setBackground(colorCoolWhite);
        buttonSlika.setForeground(colorJa);
        buttonSlika.addActionListener(this);

        
        this.add(buttonSlika);
        this.add(buttonBroj);
        this.add(buttonSlovo);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonSlovo) {
            try {
                slovo = text_slovo.getText().toString();
                ASCII ascii = new ASCII();
                display1.setText(""+ascii.stringInNumber(slovo));
            } 
            catch (Exception e) {
                display1.setText("Nesto ne valja");
            }
            
        }
        if(event.getSource() == buttonBroj) {
            try {
                broj = new BigInteger(""+text_broj.getText().toString());
                ASCII ascii = new ASCII();
                display2.setText(""+ascii.numberInString(broj));
            } 
            catch (Exception e) {
                display2.setText("Nesto ne valja");
            }

        }
        if(event.getSource() == buttonSlika) {
            new FrameSlika();

        }
    }

}
