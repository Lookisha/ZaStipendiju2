import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
public class MyPanel extends JPanel implements Konstante,ActionListener,MouseInputListener,KeyListener {
    int brzina = 1000;
    int steps = 0;
    Timer timer;
    boolean proslo = false;
    int[][] data; //ova se ispisuje
    int[][] data2; //ova samo služi u računanju

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        data = new int[192][108];
        data2 = new int[192][108];
        for(int i = 0; i < 192; i++) {
            for(int j = 0; j < 108; j++) {
                data[i][j] = 0; //0 znači da nema života, a 1 znači da ima života
                
            }
        }
        /*data[15][15] = 1;
        data[16][16] = 1;
        data[16][17] = 1;
        data[15][17] = 1;
        data[14][17] = 1;
        data[5][32] = 1;*/

        //data[50][30] = 1;
        //data[51][30] = 1;
        //data[49][30] = 1;
        //data[50][31] = 1;
        //data[50][29] = 1;

        data[80][50] = 1;
        data[79][50] = 1;
        data[78][50] = 1;
        data[77][49] = 1;
        data[75][50] = 1;
        data[74][50] = 1;
        data[75][48] = 1;
        this.addMouseListener(this);
        this.addKeyListener(this);

        timer = new Timer(brzina, this);
    }
    public void paint(Graphics g) {
        pozadina(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(250,240,31));
        for(int i = 0; i < 192; i++) {
            for(int j = 0; j < 108; j++) {
                if(data[i][j] == 1) {
                    g2D.fillRect(i*JEDINICA_X, j*JEDINICA_Y, JEDINICA_X, JEDINICA_Y);
                }
                else if(data[i][j] == 0) {

                }
            }
        }
        brzina(g,brzina);
        steps(g,steps);
        kontrole(g);
    }

    public void pozadina(Graphics g) {
        long zebra = 0;
        Graphics2D g2D = (Graphics2D) g;
        for(int i = 0; i < 192; i++) {
            for(int j = 0; j < 109; j++) { //gleda se od 0 - 49, ne gleda se j = 50. j mora biti neparan!
                if(zebra % 2 == 0) {
                    g2D.setPaint(new Color(100,100,100));
                }
                else if(zebra % 2 == 1) {
                    g2D.setPaint(new Color(150,150,150));
                }
                zebra++;
                g2D.fillRect(i*JEDINICA_X, j*JEDINICA_Y, JEDINICA_X, JEDINICA_Y);
            }
        }
    }

    public void brzina(Graphics g, int brzina) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(57, 255, 20));
        g2D.setFont(new Font("MV Boli",Font.BOLD,32));
        g2D.drawString("Brzina = "+brzina+" ms",1600,50);
    }
    public void kontrole(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(176, 38, 255));
        g2D.setFont(new Font("MV Boli",Font.ROMAN_BASELINE,30));
        g2D.drawString("P = PAUSE | S = START | R = RESTART | UP = -10ms | DOWN = +10ms", 0, 1000);
    }
    public void steps(Graphics g, int steps) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(57, 255, 20));
        g2D.setFont(new Font("MV Boli",Font.BOLD,32));
        g2D.drawString("Steps: "+steps,1600,100);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer) {
            for(int i = 0; i < 192; i++) {
                for(int j = 0; j < 108; j++) {
                    if(data[i][j] == 1 && stanicaSama(data,i,j) == true) {
                        data2[i][j] = 0;
                    }
                    else if(data[i][j] == 1 && stanicaPrenapucena(data,i,j) == true) {
                        data2[i][j] = 0;
                    }
                    else if(data[i][j] == 1 && stanicaNeutralna(data,i,j) == true) {
                        data2[i][j] = 1;
                    }
                    else if(data[i][j] == 0 && stanicaTriSusjeda(data,i,j) == true) {
                        data2[i][j] = 1;
                    }
                }
            }

            for(int i = 0; i < 192; i++) {
                for(int j = 0; j < 108; j++) {

                    data[i][j] = data2[i][j];

                }
            }
   
        }
        steps++;
        repaint();
    }

    public boolean stanicaSama(int[][] data, int i, int j) {
        int x = brojacZivih(data,i,j);
        boolean rezultat;
        if(x == 0 || x == 1) {
            rezultat = true;
        }
        else {
            rezultat = false;
        }
        return rezultat;
    }
    public boolean stanicaPrenapucena(int[][] data, int i, int j) {
        int x = brojacZivih(data,i,j);
        boolean rezultat;
        if(x >= 4) {
            rezultat = true;
        }
        else {
            rezultat = false;
        }
        return rezultat;

    }
    public boolean stanicaNeutralna(int[][] data, int i, int j) {
        int x = brojacZivih(data,i,j);
        boolean rezultat;
        if(x == 2 || x == 3) {
            rezultat = true;
        }
        else {
            rezultat = false;
        }
        return rezultat;

    }
    public boolean stanicaTriSusjeda(int[][] data, int i, int j) {
        int x = brojacZivih(data,i,j);
        boolean rezultat;
        if(x == 3) {
            rezultat = true;
        }
        else {
            rezultat = false;
        }
        return rezultat;

    }


    public int brojacZivih(int[][] data, int i, int j) {
        int counter = 0;

        if(i > 1 && j > 1 && i < 191 && j < 107) {
            if(data[i+1][j] == 1) { //1
                counter++;
            }
            if(data[i-1][j] == 1) { //2
                counter++;
            }
            if(data[i][j+1] == 1) { //3
                counter++;
            }
            if(data[i][j-1] == 1) { //4
                counter++;
            }
            if(data[i+1][j+1] == 1) { //5
                counter++;
            }
            if(data[i+1][j-1] == 1) { //6
                counter++;
            }
            if(data[i-1][j+1] == 1) { //7
                counter++;
            }
            if(data[i-1][j-1] == 1) { //8
                counter++;
            }
        }
        else {
            counter = 0;
        }
        return counter;
    }

    public int brojacMrtvih(int[][] data, int i, int j) {
        int counter = 0;

        if(i > 1 && j > 1 && i < 191 && j < 107) {
            if(data[i+1][j] == 0) { //1
                counter++;
            }
            if(data[i-1][j] == 0) { //2
                counter++;
            }
            if(data[i][j+1] == 0) { //3
                counter++;
            }
            if(data[i][j-1] == 0) { //4
                counter++;
            }
            if(data[i+1][j+1] == 0) { //5
                counter++;
            }
            if(data[i+1][j-1] == 0) { //6
                counter++;
            }
            if(data[i-1][j+1] == 0) { //7
                counter++;
            }
            if(data[i-1][j-1] == 0) { //8
                counter++;
            }
        }
        else {
            counter = 0;
        }
        return counter;
    }



    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override //miš
    public void mousePressed(MouseEvent e) {
        int xx = e.getX();
        int yy = e.getY();

        xx = xx / 10;
        yy = yy / 10;
        if(data[xx][yy] == 1) {
            data[xx][yy] = 0;
        }
        else {
            data[xx][yy] = 1;
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}




    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'p') {
            timer.stop();
        }
        if(e.getKeyChar() == 's') {
            timer.start();
        }
        if(e.getKeyChar() == 'r') {
            timer.stop();
            steps = 0;
            for(int i = 0; i < 192; i++) {
                for(int j = 0; j < 108; j++) {
                    data[i][j] = 0;
                }
            }
            for(int i = 0; i < 192; i++) {
                for(int j = 0; j < 108; j++) {
                    data2[i][j] = 0;
                }
            }
            brzina = 1000;
            timer = new Timer(brzina, this);
            repaint();
        }
        if(e.getKeyCode() == 38) { //gore
            if (brzina > 10) {
                brzina -= 10;
            }
            timer.stop();
            timer = new Timer(brzina, this);
            repaint();
        }
        if(e.getKeyCode() == 40) { //dole
            brzina += 10;
            timer.stop();
            timer = new Timer(brzina, this);
            repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }


}