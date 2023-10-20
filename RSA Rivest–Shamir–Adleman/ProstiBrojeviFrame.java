import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.math.BigInteger;

public class ProstiBrojeviFrame extends JFrame implements KonstanteZaFrame,ActionListener {

    JTextField text_dok;
    JTextField text_pocetak;
    JTextField text_kraj;
    JTextField text_p;

    JButton buttonLeft;
    JButton buttonRight;

    private BigInteger p;
    private BigInteger pocetak;
    private BigInteger kraj;

    private BigInteger s = new BigInteger("0");
    private double postotak = 0.00;

    public static JTextField display1;
    public static JTextField display1_5;
    public JTextField display2;
    JLabel upute;

    Boolean isSleeping = true;

    ProstiBrojeviFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- PROSTI");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.getContentPane().setBackground(colorB);
        this.setLayout(null);
        this.setVisible(true);

        poljaZaTekst();
        display();
        dugmad();
    }
    public void poljaZaTekst() {
        text_dok = new JTextField();
        text_pocetak = new JTextField();
        text_kraj = new JTextField();
        text_p = new JTextField();

        text_dok.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_pocetak.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_kraj.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_p.setFont(new Font("Mv Boli",Font.PLAIN, 32));

        text_dok.setBounds(50, 50, 200, 50);
        text_pocetak.setBounds(50, 150, 200, 50);
        text_kraj.setBounds(50, 250, 200, 50);
        text_p.setBounds(300, 50, 200, 50);

        text_dok.setText("(Ime Dokumeta.txt)");
        text_pocetak.setText("(pocetak)");
        text_kraj.setText("(kraj)");
        text_p.setText("(p)");

        this.add(text_dok);
        this.add(text_pocetak);
        this.add(text_kraj);
        this.add(text_p);

    }
    public void display() {
        upute = new JLabel(); //prazno
        upute.setFont(new Font("MV Boli",Font.PLAIN,15));
        upute.setBorder(null);
        upute.setBounds(10,FRAME_HEIGHT-80,FRAME_WIDTH,50);
        upute.setText("");
        upute.setBackground(colorB);
        upute.setForeground(colorBlack);
        upute.setVisible(true);
        upute.setOpaque(true);

        display1 = new JTextField();
        display1.setFont(new Font("MV Boli",Font.PLAIN,18));
        display1.setBorder(null);
        display1.setEditable(false);
        display1.setBounds(50,400,200,50);
        display1.setText("Stanje mirovanja: "+isSleeping);
        display1.setBackground(colorB);
        display1.setForeground(colorBlack);
        display1.setVisible(true);
        display1.setOpaque(true);

        display1_5 = new JTextField(); 
        display1_5.setFont(new Font("MV Boli",Font.PLAIN,17));
        display1_5.setBorder(null);
        display1_5.setEditable(false);
        display1_5.setBounds(50,450,500,50);
        display1_5.setText("N = "+ s +"  |  "+postotak+"%");
        display1_5.setBackground(colorB);
        display1_5.setForeground(colorBlack);
        display1_5.setVisible(true);
        display1_5.setOpaque(true);

        display2 = new JTextField();
        display2.setFont(new Font("MV Boli",Font.PLAIN,25));
        display2.setBorder(null);
        display2.setEditable(false);
        display2.setBounds(300,250,200,50);
        display2.setText("<VALJANOST> ");
        display2.setBackground(colorB);
        display2.setForeground(colorBlack);
        display2.setVisible(true);
        display2.setOpaque(true);

        this.add(upute);
        this.add(display2);
        this.add(display1);
        this.add(display1_5);
    }

    public void dugmad() {
        buttonLeft = new JButton("ISPISI");
        buttonLeft.setFont(new Font("MV Boli",Font.BOLD,22));
        buttonLeft.setFocusable(false);
        buttonLeft.setBounds(50,325,200,75);
        buttonLeft.setBackground(colorPlavaCute);
        buttonLeft.setForeground(colorBlack);
        buttonLeft.addActionListener(this);
        buttonLeft.setBorder(BorderFactory.createLineBorder(colorBlack));

        buttonRight = new JButton("isBrojProst");
        buttonRight.setFont(new Font("MV Boli",Font.BOLD,22));
        buttonRight.setFocusable(false);
        buttonRight.setBounds(300,150,200,75);
        buttonRight.setBackground(colorPlavaCute);
        buttonRight.setForeground(colorBlack);
        buttonRight.addActionListener(this);
        buttonRight.setBorder(BorderFactory.createLineBorder(colorBlack));

        this.add(buttonLeft);
        this.add(buttonRight);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonLeft) {
            try {
                isSleeping = false;
                display1.setText("Stanje mirovanja: "+isSleeping);
                
                pocetak = new BigInteger(""+text_pocetak.getText().toString());
                kraj = new BigInteger(""+text_kraj.getText().toString());

                System.out.println("p "+pocetak);
                System.out.println("k "+kraj);
    
                ProstiBrojevi prostiBrojevi = new ProstiBrojevi(text_dok.getText().toString(),pocetak,kraj);
                
                Thread thread2 = new Thread(prostiBrojevi);
                thread2.start(); //
                /*try {
                    thread2.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }*/
            } 
            catch (Exception ex) {
                display1.setText("Nesto ne valja ):");
                display1_5.setText("Provjeri unesene vrijednosti");
            }
            
        }
        if(e.getSource() == buttonRight) {

            try {
                p = new BigInteger(""+text_p.getText().toString());

                BigInteger random1 = new BigInteger("0");
                BigInteger random2 = new BigInteger("0");
    
                ProstiBrojevi prostiBrojevi2 = new ProstiBrojevi("random1",random2,random1);
    
                if(prostiBrojevi2.isBrojProst(p)) {
                    display2.setForeground(color5);
                }
                else {
                    display2.setForeground(color3);
                }
    
                display2.setText(""+prostiBrojevi2.isBrojProst(p));
            } catch (Exception ex) {
                display2.setText("Nesto ne valja ):");
            }
        }
    }
}