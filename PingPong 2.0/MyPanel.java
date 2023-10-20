import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class MyPanel extends JPanel implements Konstante,ActionListener,KeyListener {

    boolean upLeft = false;
    boolean downLeft = false;
    boolean upRight = false;
    boolean downRight = false;

    int Y_LEFT = 200;
    int Y_RIGHT = 200;
    int BRZINA_LOPTA_X = -10;
    int BRZINA_LOPTA_Y = 3;
    int X_LOPTA = LABEL_WIDTH/2 -LOPTA_WIDTH/2;
    int Y_LOPTA = LABEL_HEIGHT/2 - LOPTA_HEIGHT/2;
    boolean kretanjeLoptice = true;

    int scoreLeft = 0;
    int scoreRight = 0;
    int scoreUkupno = 0;

    int brojacZaPomoc = 1;

    boolean isReflected1 = true;
    boolean isReflected2 = true;

    boolean proslo = false;
    int brojac = 0; //za do while

    int brzinaTimer = 1500;

    Timer timer;

    MyPanel() {

        this.setPreferredSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        this.addKeyListener(this);

        timer = new Timer(brzinaTimer,this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(50,50,50));
        g2D.fillRect(0,0,LABEL_WIDTH,LABEL_HEIGHT);

        reketi(g,50,Y_LEFT); // y je jedini promjenjiv
        reketi(g,700 - REKET_WIDTH,Y_RIGHT);
        lopta(g,X_LOPTA,Y_LOPTA);
        score(g,scoreLeft,scoreRight);

        if(help(brojacZaPomoc) == false) {
            help(g);
        }
        if(help(brojacZaPomoc) == true) {
            kontrole(g);
            pause();
        }
    }

    public void reketi(Graphics g, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(255, 68, 204));
        g2D.fillRect(x, y, REKET_WIDTH, REKET_HEIGHT);
    }

    public void lopta(Graphics g, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(255, 68, 204));
        g2D.fillOval(x,y,LOPTA_WIDTH,LOPTA_HEIGHT);
    }

    public void score(Graphics g, int scoreLeft, int scoreRight) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(255, 68, 204));
        g2D.setFont(new Font("MV Boli",Font.BOLD,32));
        g2D.drawString(""+scoreLeft,0,32);
        g2D.drawString(""+scoreRight,LABEL_WIDTH-50,32);
        g2D.drawString(""+scoreUkupno,LABEL_WIDTH/2-25, LABEL_HEIGHT-32);
    }
    public void serviranje(Graphics g, boolean isWinnerLeft) {
        int x;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(255, 68, 204));
        if(isWinnerLeft == true) {
            Random random = new Random();
            x = random.nextInt(2);
            if(x == 0) { //gore
                g2D.drawLine(X_LOPTA+LOPTA_HEIGHT/2,Y_LOPTA+LOPTA_HEIGHT/2,0,0);

                if(BRZINA_LOPTA_X > 0) {
                    BRZINA_LOPTA_X *= -1;
                }
                if(BRZINA_LOPTA_Y > 0) {
                    BRZINA_LOPTA_Y *= -1;
                }
            }
            if(x == 1) { //dole
                g2D.drawLine(X_LOPTA+LOPTA_HEIGHT/2,Y_LOPTA+LOPTA_HEIGHT/2, 0,LABEL_HEIGHT);

                if(BRZINA_LOPTA_X > 0) {
                    BRZINA_LOPTA_X *= -1;
                }
                if(BRZINA_LOPTA_Y < 0) {
                    BRZINA_LOPTA_Y *= -1;
                }
            }
        }
        else if(isWinnerLeft == false) {

        }
    }
    public void help(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(255, 68, 204));
        g2D.setFont(new Font("MV Boli",Font.BOLD,20));
        g2D.drawString("(H) za HELP", 0, LABEL_HEIGHT-5);
    }
    public void kontrole(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(255, 68, 204));
        g2D.setFont(new Font("MV Boli",Font.BOLD,32));
        g2D.drawString("*KONTROLE*",0,LABEL_HEIGHT-32-32-32-32-32-32-5);
        g2D.setFont(new Font("MV Boli",Font.CENTER_BASELINE,32));
        g2D.setColor(new Color(77,77,255));
        g2D.drawString("IGRAC 1. -> (W) | (S)",0,LABEL_HEIGHT-32-32-32-32-32-5);
        g2D.drawString("IGRAC 2. -> (UP) | (DOWN)",0,LABEL_HEIGHT-32-32-32-32-5);
        g2D.drawString("PAUSE -> (P), UNPAUSE -> (U)",0,LABEL_HEIGHT-32-32-32-5);
        g2D.drawString("RESTART -> (R)",0,LABEL_HEIGHT-32-32-5);
        g2D.drawString("(beta) promjena brzine : (x) (y)",0,LABEL_HEIGHT-32-5);
        g2D.setFont(new Font("MV Boli",Font.BOLD,32));
        g2D.setPaint(new Color(31, 255, 15));
        g2D.drawString("POVRATAK -> (H)",0,LABEL_HEIGHT-5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        brzinaTimer = 10;
        timer = new Timer(brzinaTimer, this);
        timer.start();
        if(upLeft == true) {
            if(Y_LEFT - BRZINA_LEFT < 0) {
                Y_LEFT = 0;
                repaint();
            }
            else {
                Y_LEFT = Y_LEFT - BRZINA_LEFT;
                repaint();
            }
        }
        if(downLeft == true) {
            if(Y_LEFT + BRZINA_LEFT > LABEL_HEIGHT - REKET_HEIGHT) {
                Y_LEFT = LABEL_HEIGHT - REKET_HEIGHT;
                repaint();
            }
            else {
                Y_LEFT = Y_LEFT + BRZINA_LEFT;
                repaint();
            }
        } 
        if(upRight == true) {
            if(Y_RIGHT - BRZINA_RIGHT < 0) {
                Y_RIGHT = 0;
                repaint();
            }
            else {
                Y_RIGHT = Y_RIGHT - BRZINA_RIGHT;
                repaint();
            }
        }
        if(downRight == true) {
            if(Y_RIGHT + BRZINA_RIGHT > LABEL_HEIGHT - REKET_HEIGHT) {
                Y_RIGHT = LABEL_HEIGHT - REKET_HEIGHT;
                repaint();
            }
            else {
                Y_RIGHT = Y_RIGHT + BRZINA_RIGHT;
                repaint();
            }
        }

        //kretanje loptice
        if(X_LOPTA < 0) {
            resetiraj();
            scoreRight++;
        }
        if(X_LOPTA > LABEL_WIDTH - LOPTA_WIDTH) {
            resetiraj();
            scoreLeft++;
        }
        if(Y_LOPTA < 0) {
            BRZINA_LOPTA_Y *= -1;
        }
        if(Y_LOPTA > LABEL_HEIGHT - LOPTA_HEIGHT) {
            BRZINA_LOPTA_Y *= -1;
        }

        if(isThrowBack(X_LOPTA,Y_LOPTA,Y_LEFT,Y_RIGHT) == 1) {
            BRZINA_LOPTA_X *= -1;
            if(isReflected1 == true) {
                scoreUkupno++;
            }
            isReflected2 = true;
            isReflected1 = false;
        }
        if(isThrowBack(X_LOPTA,Y_LOPTA,Y_LEFT,Y_RIGHT) == 2) {
            BRZINA_LOPTA_X *= -1;
            if(isReflected2 == true) {
                scoreUkupno++;
            }
            isReflected1 = true;
            isReflected2 = false;
        }
        
        X_LOPTA = X_LOPTA + BRZINA_LOPTA_X;
        Y_LOPTA = Y_LOPTA + BRZINA_LOPTA_Y;

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38: {
                upRight = true;
            }
            break;
            case 40: {
                downRight = true;
            }
            break;
            case 87: {
                upLeft = true;
            }
            break;
            case 83: {
                downLeft = true;
            }    
        }

        switch (e.getKeyChar()) {
            case 'p': pause(); 
                break;
            case 'u': start();
                break;
            case 'x': brzinaX();
                break;
            case 'y': brzinaY();
                break;
            case 'r': restart();
                break;
            case 'h': brojacZaPomoc++; System.out.println(brojacZaPomoc); start(); repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38: {
                upRight = false;
            }
            break;
            case 40: {
                downRight = false;
            }
            break;
            case 87: {
                upLeft = false;
            }
            break;
            case 83: {
                downLeft = false;
            }    
        }
    }

    public void resetiraj() {
        scoreUkupno = 0;
        X_LOPTA = LABEL_WIDTH/2 -LOPTA_WIDTH/2;
        Y_LOPTA = LABEL_HEIGHT/2 - LOPTA_HEIGHT/2;
        BRZINA_LOPTA_X = -10;
        BRZINA_LOPTA_Y = 3;
        Y_LEFT = 200;
        Y_RIGHT = 200;
        brzinaTimer = 1500;
        timer.stop();
        timer = new Timer(brzinaTimer, this);
        timer.start();
    }
    public int isThrowBack(int X_LOPTA, int Y_LOPTA, int Y_LEFT, int Y_RIGHT) { //vraća više vrijednosti x u ovisnosti o slučaju:
                                                                                                         //(1) = lijeva strana, (2) = desna strana
        int x = 0;
        //lijevi
        if(X_LOPTA > 50 && X_LOPTA < 50 + REKET_WIDTH && Y_LOPTA < Y_LEFT + REKET_HEIGHT && Y_LOPTA + LOPTA_HEIGHT > Y_LEFT) {
            x = 1;
        }
        if(X_LOPTA > LABEL_WIDTH - 50 - REKET_WIDTH - LOPTA_WIDTH && X_LOPTA < LABEL_WIDTH - 50 - LOPTA_WIDTH && Y_LOPTA < Y_RIGHT + REKET_HEIGHT && Y_LOPTA + LOPTA_HEIGHT > Y_RIGHT) {
            x = 2;
        }
        return x;
    }
    //kontrole


    public void pause() {
        timer.stop();
    }
    public void start() {
        timer.start();
    }
    public void brzinaX() {
        if(BRZINA_LOPTA_X < 0) {
            BRZINA_LOPTA_X = BRZINA_LOPTA_X - 1;
        }
        else {
            BRZINA_LOPTA_X++;
        }
        
        System.out.println(BRZINA_LOPTA_X);
    }
    public void brzinaY() {
        BRZINA_LOPTA_Y++;
    }
    public void restart() {
        BRZINA_LOPTA_X = -15;
        BRZINA_LOPTA_Y = 5;
        scoreLeft = 0;
        scoreRight = 0;
        scoreUkupno = 0;
        repaint();
        resetiraj();
    }
    public boolean help(int brojac) {
        boolean x = false;
        if(brojac % 2 == 0) {
            x = true;
        }
        else if (brojac % 2 == 1) {
            x = false;
        }
        return x;
    }
}