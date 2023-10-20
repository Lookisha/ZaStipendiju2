import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigInteger;

public class BruteForceFrame extends JFrame implements KonstanteZaFrame,ActionListener {

    JTextField text_N;

    JButton buttonSve;
    JButton buttonDrugaMetoda;

    private BigInteger N;
    //private BigInteger p;
    //private BigInteger q;

    private boolean isRunning = false;

    JTextField display1;
    static JTextField display1_5;
    static JTextField display_p;
    static JTextField display_q;

    BigInteger s = new BigInteger("0");
    double postotak = 0.00;

    JLabel upute;

    BruteForceFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RSA Rivest-Shamir-Adleman --- BRUTE - FORCE");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.getContentPane().setBackground(colorB);
        this.setLayout(null);
        this.setVisible(true);

        dugmad();
        display();
        poljaZaTekst();
    }
    public void poljaZaTekst() {

        text_N = new JTextField();

        text_N.setFont(new Font("Mv Boli",Font.PLAIN, 32));

        text_N.setBounds(50, 50, 400, 50);

        text_N.setText("(N)");

        this.add(text_N);

    }
    public void dugmad() {
        buttonSve = new JButton("brute-force");
        buttonSve.setFont(new Font("MV Boli",Font.BOLD,22));
        buttonSve.setFocusable(false);
        buttonSve.setBounds(50,125,200,75);
        buttonSve.setBackground(color3);
        buttonSve.setForeground(colorBlack);
        buttonSve.addActionListener(this);

        buttonDrugaMetoda = new JButton("Optimiz. B-F");
        buttonDrugaMetoda.setFont(new Font("MV Boli",Font.BOLD,22));
        buttonDrugaMetoda.setFocusable(false);
        buttonDrugaMetoda.setBounds(300,125,200,75);
        buttonDrugaMetoda.setBackground(color3);
        buttonDrugaMetoda.setForeground(colorBlack);
        buttonDrugaMetoda.addActionListener(this);


        this.add(buttonSve);
        this.add(buttonDrugaMetoda);

    }
    public void display() {
        upute = new JLabel();
        upute.setFont(new Font("MV Boli",Font.PLAIN,15));
        upute.setBorder(null);
        upute.setBounds(10,FRAME_HEIGHT-80,FRAME_WIDTH,50);
        upute.setText("POSTOTAK <%> ne pokazuje kada ce program zavrsiti, nego napredak B-F");
        upute.setBackground(colorB);
        upute.setForeground(colorBlack);
        upute.setVisible(true);
        upute.setOpaque(true);

        display1 = new JTextField(); //stanje
        display1.setFont(new Font("MV Boli",Font.PLAIN,18));
        display1.setBorder(null);
        display1.setEditable(false);
        display1.setBounds(50,250,200,50);
        display1.setText("isRunning = "+isRunning);
        display1.setBackground(colorB);
        display1.setForeground(colorBlack);
        display1.setVisible(true);
        display1.setOpaque(true);

        display1_5 = new JTextField(); //postotak
        display1_5.setFont(new Font("MV Boli",Font.PLAIN,17));
        display1_5.setBorder(null);
        display1_5.setEditable(false);
        display1_5.setBounds(50,300,400,50);
        display1_5.setText("N = "+ s +"  |  "+postotak+"%");
        display1_5.setBackground(colorB);
        display1_5.setForeground(colorBlack);
        display1_5.setVisible(true);
        display1_5.setOpaque(true);

        display_p = new JTextField(); //prvi prosti broj
        display_p.setFont(new Font("MV Boli",Font.PLAIN,17));
        display_p.setBorder(null);
        display_p.setEditable(false);
        display_p.setBounds(50,350,400,50);
        display_p.setText("<p> ");
        display_p.setBackground(colorB);
        display_p.setForeground(colorGreenNjezna);
        display_p.setVisible(true);
        display_p.setOpaque(true);

        display_q = new JTextField(); //drugi prosti broj
        display_q.setFont(new Font("MV Boli",Font.PLAIN,17));
        display_q.setBorder(null);
        display_q.setEditable(false);
        display_q.setBounds(50,400,400,50);
        display_q.setText("<q> ");
        display_q.setBackground(colorB);
        display_q.setForeground(colorGreenNjezna2);
        display_q.setVisible(true);
        display_q.setOpaque(true);

        this.add(upute);
        this.add(display1);
        this.add(display1_5);
        this.add(display_p);
        this.add(display_q);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonSve) {

            try {
                isRunning = true;
                display1.setText("isRunning = "+isRunning);
                buttonSve.setBackground(color5);
                display_p.setText("<p> ");
                display_q.setText("<q> ");

                N = new BigInteger(""+text_N.getText().toString());
                ProstiBrojevi prostiBrojevi = new ProstiBrojevi("ovoNikadaNecesPogoditi", N, BigInteger.ZERO);
                Thread mojaZica = new Thread(prostiBrojevi);
                mojaZica.start();

                
            } 
            catch (Exception ex) {
                buttonSve.setBackground(color3);
                display1.setText("Nesto ne valja");
                display1_5.setText("Provjeri format broja");
            }

        }
        if(e.getSource() == buttonDrugaMetoda) {
            try {
                isRunning = true;
                display1.setText("isRunning = "+isRunning);
                buttonDrugaMetoda.setBackground(color5);
                display_p.setText("<p> ");
                display_q.setText("<q> ");

                N = new BigInteger(""+text_N.getText().toString());
                ProstiBrojevi prostiBrojevi = new ProstiBrojevi("ovoNikadaNecesPogoditi2", N, BigInteger.ZERO);
                Thread mojaZica = new Thread(prostiBrojevi);
                mojaZica.start();


            } 
            catch (Exception ex) {
                buttonDrugaMetoda.setBackground(color3);
                display1.setText("Nesto ne valja");
                display1_5.setText("Provjeri format broja");
            }

        }
    }
}
