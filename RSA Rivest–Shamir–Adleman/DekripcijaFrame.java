import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigInteger;

public class DekripcijaFrame extends JFrame implements KonstanteZaFrame,ActionListener {

    JTextField text_C;
    JTextField text_p;
    JTextField text_q;
    JTextField text_e;

    JButton buttonSve;

    //private BigInteger C;
    private BigInteger p;
    private BigInteger q;
    private int e;

    JTextField display1;
    JTextField display1_5;

    DekripcijaFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- DEKRIPCIJA");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.getContentPane().setBackground(colorB);
        this.setLayout(null);
        this.setVisible(true);

        tekst();
        display();
        dugmad();

    }
    public void tekst() {

        text_C = new JTextField();
        text_p = new JTextField();
        text_q = new JTextField();
        text_e = new JTextField();

        text_C.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_p.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_q.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_e.setFont(new Font("Mv Boli",Font.PLAIN, 32));

        text_C.setBounds(50, 50, 200, 50);
        text_p.setBounds(50, 125, 200, 50);
        text_q.setBounds(50, 200, 200, 50);
        text_e.setBounds(50, 275, 200, 50);

        text_C.setText("(C)");
        text_p.setText("(p)");
        text_q.setText("(q)");
        text_e.setText("(e)");

        this.add(text_C);
        this.add(text_p);
        this.add(text_q);
        this.add(text_e);

    }

    public void display() {
        JTextField upute = new JTextField(); // nije trenutno u upotrebi
        upute.setFont(new Font("MV Boli",Font.PLAIN,18));
        upute.setBorder(null);
        upute.setEditable(false);
        upute.setBounds(300,50,200,50);
        upute.setText("> Dekriptirati je moguce samo odgovarajuci skup brojeva* <");
        upute.setBackground(colorB);
        upute.setForeground(color3);
        upute.setVisible(true);
        upute.setOpaque(true);

        JLabel upute2 = new JLabel();
        upute2.setFont(new Font("MV Boli",Font.PLAIN,15));
        upute2.setBorder(null);
        upute2.setBounds(10,FRAME_HEIGHT-80,FRAME_WIDTH,50);
        upute2.setText("U prvo polje kucaj </dokument> ako zelis dekriptirati poruku u .txt fileu");
        upute2.setBackground(colorB);
        upute2.setForeground(colorBlack);
        upute2.setVisible(true);
        upute2.setOpaque(true);

        display1 = new JTextField();
        display1.setFont(new Font("MV Boli",Font.PLAIN,18));
        display1.setBorder(null);
        display1.setEditable(false);
        display1.setBounds(50,450,200,50);
        display1.setText("<D ASCII> ");
        display1.setBackground(colorB);
        display1.setForeground(colorBlack);
        display1.setVisible(true);
        display1.setOpaque(true);

        display1_5 = new JTextField();
        display1_5.setFont(new Font("MV Boli",Font.PLAIN,17));
        display1_5.setBorder(null);
        display1_5.setEditable(false);
        display1_5.setBounds(50,500,200,25);
        display1_5.setText("<DEF> ");
        display1_5.setBackground(colorB);
        display1_5.setForeground(colorBlack);
        display1_5.setVisible(true);
        display1_5.setOpaque(true);

        this.add(display1);
        this.add(display1_5);
        this.add(upute);
        this.add(upute2);
    }

    public void dugmad() {
        buttonSve = new JButton("DEKRIPTIRAJ");
        buttonSve.setFont(new Font("MV Boli",Font.BOLD,22));
        buttonSve.setFocusable(false);
        buttonSve.setBounds(50,350,200,75);
        buttonSve.setBackground(color3);
        buttonSve.setForeground(colorBlack);
        buttonSve.addActionListener(this);

        this.add(buttonSve);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonSve) {
            String String_C = text_C.getText();
            //try {
                if(String_C.equals("/dokument") || String_C.equals("dokument")) {
                    zapisi();
                    display1.setText("<<Dekrip. u dokumentu:");
                    display1_5.setText("Dekriptirano.txt");
                    buttonSve.setBackground(color5);
                }
                else {
                    String CC = text_C.getText();
                    p = new BigInteger(""+text_p.getText());
                    q = new BigInteger(""+text_q.getText());
                    BigInteger prenositelj = new BigInteger(""+text_e.getText());
                    e = prenositelj.intValue();
                    
                    Dekripcija dekripcija = new Dekripcija(CC, p, q, e);
                    display1.setText(""+dekripcija.dekriptiraj().toString());
                    display1_5.setText("<ASCII>");
        
                    buttonSve.setBackground(color5);
                }
            //} 
            /*catch (Exception e) {
                display1.setText("Nesto ne valja");
                display1_5.setText("Provjeri format brojeva");
                buttonSve.setBackground(color3);
            }*/
        }
    }
    public void zapisi() {
        
    }
}