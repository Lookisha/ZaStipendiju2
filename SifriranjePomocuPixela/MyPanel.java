import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Konstante,KeyListener,ActionListener {

    String tekst = "";
    String naslov = "screenshot";
    String slika = "screenshot1.png"; // za probu
    int[] tekstBroj;
    int[] pixelsBrojevi;
    Graphics gx;

    boolean proslo;
    boolean isOpenScreenOpen = true;
    boolean prosloJednom = false; //za save
    int slikaOdabrana = -1; //0-9 vrijednosti
    boolean isTipkeOtkljucane = false;
    int brojac = 0;
    int brojacScreenshot = 0;


    boolean opcijaLijevo = false;
    boolean opcijaDesno = false;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.addKeyListener(this);


    }

    public void paint(Graphics g) {

        if(opcijaLijevo == true) {
            try {
                dekripcija(g);
            } catch (IOException e) {
                e.printStackTrace();
            }
            isOpenScreenOpen = false;
        }
        else if (opcijaDesno == true) {
            enkripcija(g);
            isOpenScreenOpen = false;
        }
        else if(isOpenScreenOpen == true) {
            openScreen(g);
        }
    }

    public void openScreen(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(254,253,150));
        g2D.fillRect(0,0,PANEL_WIDTH,PANEL_HEIGHT);
        g2D.setPaint(new Color(130,73,151));
        g2D.setFont(new Font("MV Boli",Font.BOLD,28));
        g2D.drawString("(E) -> enkripcija / (D) -> dekripcija",0,PANEL_HEIGHT-30-5);
        g2D.drawString("(S) -> SAVE (max 10 slika) / (P) -> POVRATAK",0,PANEL_HEIGHT-5);
    }

    public void pozadina(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        StringBuffer sb = new StringBuffer(tekst);

        for(int i = 0; i < PANEL_WIDTH; i+=PIXEL) {
            for(int j = 0; j < PANEL_HEIGHT; j+=PIXEL) {
                if((i + j) % 2 == 0) {
                    g2D.setPaint(new Color(255,255,255));
                    g2D.fillRect(i, j, PIXEL, PIXEL);
                    try {
                        Thread.sleep(0);
                        repaint();
                        if(brojac < sb.length()) {
                            bojanjePixela(g,i,j);                        
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else if((i + j) % 2 == 1) {
                    g2D.setPaint(new Color(150,150,150));
                    g2D.fillRect(i, j, PIXEL, PIXEL);
                    try {
                        Thread.sleep(0);
                        repaint();
                        if(brojac < sb.length()) {
                            bojanjePixela(g,i,j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    
    public void bojanjePixela(Graphics g, int x, int y) { //x,y = i,j u petlji iznad

        Graphics2D g2D = (Graphics2D) g;
        if(tekstBroj[brojac] == -1) { //nepoznato
            g2D.setPaint(new Color(0,0,10));
            g2D.fillRect(x, y, PIXEL, PIXEL);
        }
        else if(tekstBroj[brojac] == -2) { //razmak
            g2D.setPaint(new Color(242,230,233));
            g2D.fillRect(x, y, PIXEL, PIXEL);
        }
        else if(tekstBroj[brojac] == -3) { //novi red
            g2D.setPaint(new Color(95,47,122));
            g2D.fillRect(x, y, PIXEL, PIXEL);
        }
        else { //poznata engleska abeceda
            g2D.setPaint(new Color(red[tekstBroj[brojac]],green[tekstBroj[brojac]],blue[tekstBroj[brojac]]));
            g2D.fillRect(x, y, PIXEL, PIXEL);
        }
        brojac++;
        repaint();
    }

    public void dekripcijaTekst(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(250,193,138));
        g2D.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g2D.setFont(new Font("MV Boli", Font.BOLD, 30));
        g2D.setPaint(new Color(130,73,151));
        g2D.drawString("BETA",0,PANEL_HEIGHT);
        g2D.drawString("(0-9) -> odaberi sliku koju zelis: "+ slikaOdabrana, 10, PANEL_HEIGHT/2);

    }
    
    public void dataAnaliza() {
        StringBuffer sb = new StringBuffer(tekst);
        try {
            FileReader reader = new FileReader("ZaSifrirati.txt");
            int data = reader.read();
            while(data != -1) {
                tekst = sb.append((char)data).toString();
                data = reader.read();
            }
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dataPretvorbaInt() {
        tekst = tekst.toLowerCase();
        StringBuffer sb = new StringBuffer(tekst);
        tekstBroj = new int[sb.length()];
        for(int i = 0; i < sb.length(); i++) {
            for(int j = 0; j < 26; j++) {
                if (proslo == false && j == 25) {
                    if(tekst.charAt(i) == ' ') {
                        tekstBroj[i] = -2;
                    }
                    else if(tekst.charAt(i) == '\n') {
                        tekstBroj[i] = -3;
                    }
                    else {
                        tekstBroj[i] = -1;  
                    }
                }
                if(tekst.charAt(i) == abeceda[j]) {
                    tekstBroj[i] = j;
                    proslo = true;
                }
            }
            proslo = false;
        }
        for(int i = 0; i < sb.length(); i++) {
        }
    }

    public void slikaAnaliza() throws IOException {
        pixelsBrojevi = new int[100000];
        File slikaZaAnalizu = new File(slika);
        BufferedImage image = ImageIO.read(slikaZaAnalizu);
        int counter = 0;
        boolean b1 = false;

        for(int i = 1; i < PANEL_WIDTH; i+=PIXEL) {
            for(int j = 1; j < PANEL_HEIGHT; j+=PIXEL) {

                pixelsBrojevi[counter] = image.getRGB(i, j);
                counter ++;
                //System.out.print((pixelsBrojevi[(counter-1)])+" ");
            }
        }

        FileWriter writer = new FileWriter("deSifrirano.txt");
        char znakTrenutni = '.';
        for(int i = 0; i < counter; i++) {
            for(int j = 0; j < 26; j++) {
                if(pixelsBrojevi[i] == cudno[j] && b1 == false) {
                    //System.out.print(abeceda[j]);
                    znakTrenutni = abeceda[j];
                    b1 = true;
                } 
                if(pixelsBrojevi[i] == -858391 && b1 == false) { //razmak
                    //System.out.print(" ");
                    znakTrenutni = ' ';
                    b1 = true;
                }
                if(pixelsBrojevi[i] == -16777206 && b1 == false && pixelsBrojevi[i+1] != -10539142) { // ?
                    //System.out.print("?");
                    znakTrenutni = '?';
                    b1 = true;
                }
                if(pixelsBrojevi[i] == -10539142 && b1 == false) { //novi red
                    //System.out.print("\n");
                    znakTrenutni = '\n';
                    b1 = true;
                }
                if(j == 25) {
                    b1 = false;
                    try {
                        writer.write(znakTrenutni);
                        if(i == (counter - 1)) {
                            writer.close();
                        }
                        znakTrenutni = ' ';
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void odaberiSliku() {
        StringBuffer sb = new StringBuffer(slika);

        slika = sb.delete(10,15).toString();
        slika = sb.append(slikaOdabrana).toString();
        slika = sb.append(".png").toString();


        //System.out.println(slika);

    }

    public void screenshot() {   
        try {
            FileReader readerx = new FileReader("Data.txt");
            brojacScreenshot = readerx.read();
            readerx.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("Data.txt");

            if(brojacScreenshot == 58) {
                brojacScreenshot = 48;
            }
            writer.write(brojacScreenshot+1);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer(naslov);
        if(prosloJednom == true) {
            naslov = sb.delete(10, 15).toString();
        }
        naslov = sb.append((char)brojacScreenshot).toString();
        naslov = sb.append(".png").toString();
        prosloJednom = true;
        System.out.println(naslov);

        BufferedImage screenshotImage = new BufferedImage(
                this.getBounds().width, this.getBounds().height,
                BufferedImage.TYPE_INT_RGB);
        this.paint(screenshotImage.getGraphics());
        try {
            ImageIO.write(screenshotImage, "png", new File(naslov));
        } catch (IOException ex) {
            System.err.println("ImageIsuues");
        }
    }


    public void enkripcija(Graphics g) {
        isTipkeOtkljucane = true;
        dataAnaliza();
        dataPretvorbaInt();
        pozadina(g);
        
    }
    public void dekripcija (Graphics g) throws IOException {
        isTipkeOtkljucane = true;
        dekripcijaTekst(g);
        repaint();
        if(slikaOdabrana != -1) {
            odaberiSliku();
            slikaAnaliza();
            //isTipkeOtkljucane = false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            screenshot();
        }
        if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
            opcijaDesno = false;
            opcijaLijevo = true;
            repaint();
        }
        if(e.getKeyChar() == 'e' || e.getKeyChar() == 'E') {
            opcijaLijevo = false;
            opcijaDesno = true;
            repaint();
        }
        if(e.getKeyChar() == 'p' || e.getKeyChar() == 'P') {
            isOpenScreenOpen = true;
            opcijaDesno = false;
            opcijaLijevo = false;
            isTipkeOtkljucane = true;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == '1' && isTipkeOtkljucane == true) {
            slikaOdabrana = 1;

        }
        if(e.getKeyChar() == '2' && isTipkeOtkljucane == true) {
            slikaOdabrana = 2; 
        }
        if(e.getKeyChar() == '3' && isTipkeOtkljucane == true) {
            slikaOdabrana = 3;
        }
        if(e.getKeyChar() == '4' && isTipkeOtkljucane == true) {
            slikaOdabrana = 4;
        }
        if(e.getKeyChar() == '5' && isTipkeOtkljucane == true) {
            slikaOdabrana = 5;
        }
        if(e.getKeyChar() == '6' && isTipkeOtkljucane == true) {
            slikaOdabrana = 6;
        }
        if(e.getKeyChar() == '7' && isTipkeOtkljucane == true) {
            slikaOdabrana = 7;
        }
        if(e.getKeyChar() == '8' && isTipkeOtkljucane == true) {
            slikaOdabrana = 8;
        }
        if(e.getKeyChar() == '9' && isTipkeOtkljucane == true) {
            slikaOdabrana = 9;
        }
        if(e.getKeyChar() == '0' && isTipkeOtkljucane == true) {
            slikaOdabrana = 0;
        }

    }
}
