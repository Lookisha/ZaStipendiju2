package Osnove;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyPanel extends JPanel implements Konstante,KeyListener,ActionListener {

    public int brojac = 0;
    public boolean running = true;
    public double[] playerPosition = {0, 0, 0};
    Timer timer;
    int brzinaTimer = 17; //60 fps

    boolean w = false;
    boolean s = false;
    boolean a = false;
    boolean d = false;
    boolean up = false;
    boolean down = false;

    int blockPosX= 0;
    int blockPosY= 0;
    int blockPosZ= 0;
    int brojacBlokovi = 0;


    int[] relativneKoordinate = {0,0,0};

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.addKeyListener(this);

    }
    public void paint(Graphics g) {
        //pozadina + ostalo;
        mainPozadina(g);

        //objekti
        World world = new World();
        if(brojacBlokovi < 200) {
            blockPosX = world.blockData[brojacBlokovi][0];
            blockPosY = world.blockData[brojacBlokovi][1];
            blockPosZ = world.blockData[brojacBlokovi][2];
            brojacBlokovi++;
            kockaLinije(blockPosX,blockPosY,blockPosZ,g);
    
            brojacBlokovi++;
        }
        if(brojacBlokovi >= 200) {
            brojacBlokovi = 0;
        }
        brojac++;
        repaint();
    }
    public void mainPozadina(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(100,100,100));
        g2D.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        timer = new Timer(brzinaTimer, this);
        timer.start();
    }
    public void kockaLinije(int x, int y, int z, Graphics g) {
        System.out.println(x);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setPaint(new Color(190,98,200));

        PointConstructor pointConstructor = new PointConstructor(relativneKoordinate,playerPosition);
        //kocka ima 8 točaka prema tome slijedi 8 različitih funkcija
        
        if(isPodrucjeKriticno(playerPosition) == false) {
            g2D.drawLine((int)pointConstructor.A.getX(), (int)pointConstructor.A.getY(), (int)pointConstructor.B.getX(), (int)pointConstructor.B.getY()); //error
            g2D.drawLine((int)pointConstructor.B.getX(), (int)pointConstructor.B.getY(), (int)pointConstructor.C.getX(), (int)pointConstructor.C.getY());
            g2D.drawLine((int)pointConstructor.C.getX(), (int)pointConstructor.C.getY(), (int)pointConstructor.D.getX(), (int)pointConstructor.D.getY()); //error
            g2D.drawLine((int)pointConstructor.D.getX(), (int)pointConstructor.D.getY(), (int)pointConstructor.A.getX(), (int)pointConstructor.A.getY());

            /*if(System.nanoTime() % 50000000 == 0) {
                System.out.println(pointConstructor.A.getX());
                System.out.println(pointConstructor.B.getX());
                System.out.println(pointConstructor.C.getX());
                System.out.println(pointConstructor.D.getX());
                System.out.println();
                System.out.println(pointConstructor.A.getY());
                System.out.println(pointConstructor.B.getY());
                System.out.println(pointConstructor.C.getY());
                System.out.println(pointConstructor.D.getY());
    
            }*/

            g2D.drawLine((int)pointConstructor.A.getX(), (int)pointConstructor.A.getY(), (int)pointConstructor.A1.getX(), (int)pointConstructor.A1.getY());
            g2D.drawLine((int)pointConstructor.B.getX(), (int)pointConstructor.B.getY(), (int)pointConstructor.B1.getX(), (int)pointConstructor.B1.getY());
            g2D.drawLine((int)pointConstructor.C.getX(), (int)pointConstructor.C.getY(), (int)pointConstructor.C1.getX(), (int)pointConstructor.C1.getY());
            g2D.drawLine((int)pointConstructor.D.getX(), (int)pointConstructor.D.getY(), (int)pointConstructor.D1.getX(), (int)pointConstructor.D1.getY());
            
            g2D.drawLine((int)pointConstructor.A1.getX(), (int)pointConstructor.A1.getY(), (int)pointConstructor.B1.getX(), (int)pointConstructor.B1.getY());
            g2D.drawLine((int)pointConstructor.B1.getX(), (int)pointConstructor.B1.getY(), (int)pointConstructor.C1.getX(), (int)pointConstructor.C1.getY());
            g2D.drawLine((int)pointConstructor.C1.getX(), (int)pointConstructor.C1.getY(), (int)pointConstructor.D1.getX(), (int)pointConstructor.D1.getY());
            g2D.drawLine((int)pointConstructor.D1.getX(), (int)pointConstructor.D1.getY(), (int)pointConstructor.A1.getX(), (int)pointConstructor.A1.getY());
        }

    }

    public void kockaFill(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        PointConstructor pointConstructor = new PointConstructor(relativneKoordinate,playerPosition);
        int[] x1 = {(int)pointConstructor.A.getX(),(int)pointConstructor.B.getX(),(int)pointConstructor.C.getX(),(int)pointConstructor.D.getX()};
        int[] y1 = {(int)pointConstructor.A.getY(),(int)pointConstructor.B.getY(),(int)pointConstructor.C.getY(),(int)pointConstructor.D.getY()};

        int[] x2 = {(int)pointConstructor.B.getX(),(int)pointConstructor.C.getX(),(int)pointConstructor.C1.getX(),(int)pointConstructor.B1.getX()};
        int[] y2 = {(int)pointConstructor.B.getY(),(int)pointConstructor.C.getY(),(int)pointConstructor.C1.getY(),(int)pointConstructor.B1.getY()};

        int[] x3 = {(int)pointConstructor.C.getX(),(int)pointConstructor.C1.getX(),(int)pointConstructor.D1.getX(),(int)pointConstructor.D.getX()};
        int[] y3 = {(int)pointConstructor.C.getY(),(int)pointConstructor.C1.getY(),(int)pointConstructor.D1.getY(),(int)pointConstructor.D.getY()};

        int[] x4 = {(int)pointConstructor.A.getX(),(int)pointConstructor.D.getX(),(int)pointConstructor.A1.getX(),(int)pointConstructor.D1.getX()};
        int[] y4 = {(int)pointConstructor.A.getY(),(int)pointConstructor.D.getY(),(int)pointConstructor.A1.getY(),(int)pointConstructor.D1.getY()};

        int[] x5 = {(int)pointConstructor.A.getX(),(int)pointConstructor.B.getX(),(int)pointConstructor.B1.getX(),(int)pointConstructor.A1.getX()};
        int[] y5 = {(int)pointConstructor.A.getY(),(int)pointConstructor.B.getY(),(int)pointConstructor.B1.getY(),(int)pointConstructor.A1.getY()};

        int[] x6 = {(int)pointConstructor.A1.getX(),(int)pointConstructor.B1.getX(),(int)pointConstructor.C1.getX(),(int)pointConstructor.D1.getX()};
        int[] y6 = {(int)pointConstructor.A1.getY(),(int)pointConstructor.B1.getY(),(int)pointConstructor.C1.getY(),(int)pointConstructor.D1.getY()};
        if(isPodrucjeKriticno(playerPosition) == false) {
            g2D.setStroke(new BasicStroke(0));
            g2D.setPaint(new Color(61,157,196));

            g2D.fillPolygon(x1,y1,4);
            g2D.fillPolygon(x2,y2,4);
            g2D.fillPolygon(x3,y3,4);
            g2D.fillPolygon(x4,y4,4);
            g2D.fillPolygon(x5,y5,4);
            g2D.fillPolygon(x6,y6,4);
            //kockaLinije(g);
        }

        //g2D.fillPolygon(x,y,4);
    }

    public boolean isPodrucjeKriticno(double[] playerPosition) {
        boolean odgovor = false;
        PointConstructor pointConstructor = new PointConstructor(relativneKoordinate,playerPosition);

        if(pointConstructor.A.getX() < 0 && pointConstructor.A.getY() < 0) {
            odgovor = true;
        }
        if(pointConstructor.D.getX() < 0 && pointConstructor.D.getY() < 0) {
            odgovor = true;
        }
        if(pointConstructor.A1.getX() < 0 && pointConstructor.A1.getY() < 0) {
            odgovor = true;
        }
        if(pointConstructor.D1.getX() < 0 && pointConstructor.D1.getY() < 0) {
            odgovor = true;
        }
    
        return odgovor;

    }


    public void kockicaDEBUGGING(/*Graphics g*/) {
        //Graphics2D g2D = (Graphics2D) g;

        PointConstructor pointConstructor = new PointConstructor(relativneKoordinate,playerPosition);
        //kocka ima 8 točaka prema tome slijedi 8 različitih funkcija
        //System.out.println((int)pointConstructor.A.getX());
        //g2D.drawLine(pointConstructor.A.getX(), pointConstructor.A.getY(), pointConstructor.B.getX(), pointConstructor.B.getY());


        
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(w == true) {
            playerPosition[2] = playerPosition[2] - PLAYER_SPEED;
            repaint();
        }
        if(s == true) {
            playerPosition[2] = playerPosition[2] + PLAYER_SPEED;
            repaint();
        }
        if(a == true) {
            playerPosition[0] = playerPosition[0] - PLAYER_SPEED;
            repaint();
        }
        if(d == true) {
            playerPosition[0] = playerPosition[0] + PLAYER_SPEED;
            repaint();
        }

        if(up == true) {
            playerPosition[1] = playerPosition[1] + PLAYER_SPEED;
            repaint();
        }
        if(down == true) {
            playerPosition[1] = playerPosition[1] - PLAYER_SPEED;
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            w = true;
        }
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            s = true;
        }
        if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
            a = true;
        }
        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            d = true;
        }

        if(e.getKeyChar() == ' ' || e.getKeyChar() == ' ') {
            up = true;
        }
        if(e.getKeyCode() == 16) {
            down = true;
        }


        if(e.getKeyChar() == 'h' || e.getKeyChar() == 'H') {
            System.out.println(playerPosition[0]);
            System.out.println(playerPosition[1]);
            System.out.println(playerPosition[2]);
        }

        if(e.getKeyCode() == 38) {
            playerPosition[2] = playerPosition[2] - PLAYER_SPEED/10;
        }
        if(e.getKeyCode() == 40) {
            playerPosition[2] = playerPosition[2] + PLAYER_SPEED/10;
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
            w = false;
        }
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            s = false;
        }
        if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
            a = false;
        }
        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            d = false;
        }

        if(e.getKeyChar() == ' ' || e.getKeyChar() == ' ') {
            up = false;
        }
        if(e.getKeyCode() == 16) {
            down = false;
        }
    }
}
