import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class EnkripcijaFrame extends JFrame implements KonstanteZaFrame,ActionListener {

    JTextField text_D;
    JTextField text_e;
    JTextField text_N;

    JButton button_pq;
    JButton buttonSve;

    JTextField display1;
    JTextField display1_5;
    JTextField display2;

    JLabel upute;

    private BigInteger D;
    private String String_D;
    private int e;
    private BigInteger ee; //sluzi samo da se String pretoči u int e
    private BigInteger N;

    JTextField text_p;
    JTextField text_q;
    private BigInteger p;
    private BigInteger q;

    boolean showMultiple = false;
    boolean showEncriptedCode = false;
    boolean showEncriptedMessage = false;

    EnkripcijaFrame() { 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- ENKRIPCIJA");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.getContentPane().setBackground(colorB);
        this.setLayout(null);
        this.setVisible(true);

        poljaZaTekst();
        dugmad();
        display();
    }

    public void poljaZaTekst() {
        text_D = new JTextField();
        text_e = new JTextField();
        text_N = new JTextField();
        text_p = new JTextField();
        text_q = new JTextField();

        text_D.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_e.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_N.setFont(new Font("Mv Boli",Font.PLAIN, 32));
        text_p.setFont(new Font("Mv Boli",Font.PLAIN, 25));
        text_q.setFont(new Font("Mv Boli",Font.PLAIN, 25));

        text_D.setBounds(50, 50, 200, 50);
        text_e.setBounds(50, 150, 200, 50);
        text_N.setBounds(50, 250, 200, 50);
        text_p.setBounds(300, 50, 200, 50);
        text_q.setBounds(300, 150, 200, 50);

        text_D.setText("(D)");
        text_e.setText("(e)");
        text_N.setText("(N)");
        text_p.setText("(p)");
        text_q.setText("(q)");

        this.add(text_D);
        this.add(text_e);
        this.add(text_N);
        this.add(text_p);
        this.add(text_q);

    }
    public void dugmad() {
        buttonSve = new JButton("ENKRIPTIRAJ");
        buttonSve.setFont(new Font("MV Boli",Font.BOLD,22));
        buttonSve.setFocusable(false);
        buttonSve.setBounds(50,325,200,75);
        buttonSve.setBackground(color3);
        buttonSve.setForeground(colorBlack);
        buttonSve.addActionListener(this);

        button_pq = new JButton("(p * q)");
        button_pq.setFont(new Font("MV Boli",Font.BOLD,22));
        button_pq.setFocusable(false);
        button_pq.setBounds(300,250,200,75);
        button_pq.setBackground(color3);
        button_pq.setForeground(colorBlack);
        button_pq.addActionListener(this);


        this.add(buttonSve);
        this.add(button_pq);

    }
    public void display() {
        upute = new JLabel();
        upute.setFont(new Font("MV Boli",Font.PLAIN,15));
        upute.setBorder(null);
        upute.setBounds(10,FRAME_HEIGHT-80,FRAME_WIDTH,50);
        upute.setText("U prvo polje kucaj </dokument> ako zelis enkriptirati poruku u .txt fileu");
        upute.setBackground(colorB);
        upute.setForeground(colorBlack);
        upute.setVisible(true);
        upute.setOpaque(true);

        display1 = new JTextField();
        display1.setFont(new Font("MV Boli",Font.PLAIN,18));
        display1.setBorder(null);
        display1.setEditable(false);
        display1.setBounds(50,400,200,50);
        display1.setText("<E ASCII> ");
        display1.setBackground(colorB);
        display1.setForeground(colorBlack);
        display1.setVisible(true);
        display1.setOpaque(true);

        display1_5 = new JTextField();
        display1_5.setFont(new Font("MV Boli",Font.PLAIN,17));
        display1_5.setBorder(null);
        display1_5.setEditable(false);
        display1_5.setBounds(50,450,200,50);
        display1_5.setText("<E> ");
        display1_5.setBackground(colorB);
        display1_5.setForeground(colorBlack);
        display1_5.setVisible(true);
        display1_5.setOpaque(true);

        display2 = new JTextField();
        display2.setFont(new Font("MV Boli",Font.PLAIN,18));
        display2.setBorder(null);
        display2.setEditable(false);
        display2.setBounds(300,325,200,50);
        display2.setText("<N> ");
        display2.setBackground(colorB);
        display2.setForeground(colorBlack);
        display2.setVisible(true);
        display2.setOpaque(true);

        this.add(upute);
        this.add(display2);
        this.add(display1);
        this.add(display1_5);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonSve) {
            //try {
                String_D = text_D.getText().toString();
                if(String_D.equals("/dokument") || String_D.equals("dokument")) {
                    System.out.println(1);
                    zapisi();
                    System.out.println(2);
                    display1.setText("Enkrip. u dokumentu:");
                    display1_5.setText("Enkriptirano.txt");
                    buttonSve.setBackground(color5);
                }

                else {
                    ee = new BigInteger(""+text_e.getText());
                    e = ee.intValue();
                    N = new BigInteger(""+text_N.getText());
                    D = new BigInteger(""+String_D);
                    Enkripcija enkripcija = new Enkripcija(D, e, N);
                    String DD = enkripcija.enkriptirajMain();

                    display1.setText("(E ASCII) "+DD); //ASCII broj
                    display1_5.setText("(E) "+DD); //slova
                    buttonSve.setBackground(color5);
                }
            /* } 
            catch (Exception e) {
                display1.setText("Nesto ne valja");
                display1_5.setText("Provjeri format brojeva");
                buttonSve.setBackground(color3);
            }*/
        }

        if(event.getSource() == button_pq) {
            try {
                p = new BigInteger(""+text_p.getText());
                q = new BigInteger(""+text_q.getText());
                p.multiply(q);
                button_pq.setBackground(color5);
                display2.setText("(N) "+p.multiply(q));
            }
            catch (Exception Ex) {
                button_pq.setBackground(color3);
                display2.setText("Unesi brojeve normalno");
            }
        }
    }
    public void zapisi() {
        String_D = "";
        StringBuffer sb = new StringBuffer(String_D);
        try {
            FileReader reader = new FileReader("Dekriptirano.txt");
            int data = 0;
            data = reader.read();
            do {
                sb.append((char)data);
                data = reader.read();
                
            } while(data != -1);
            reader.close();
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }

        ee = new BigInteger(""+text_e.getText());
        e = ee.intValue();
        N = new BigInteger(""+text_N.getText());
        System.out.println(sb);
        D = new BigInteger(""+sb);

        Enkripcija enkripcija = new Enkripcija(D, e, N);
        String DD = enkripcija.enkriptirajMain();
        try {
            FileWriter writer = new FileWriter("Enkriptirano.txt");
            writer.write(DD);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}