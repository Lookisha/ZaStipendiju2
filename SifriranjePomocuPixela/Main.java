import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        new MyFrame();
        MyPanel panel = new MyPanel();
        panel.dataAnaliza();
        panel.dataPretvorbaInt();
        //panel.screenshot();
        /*for(int i = 0; i < 26; i++) {
            Random random = new Random();
            System.out.print(","+random.nextInt(255));
        }*/
        try {
            panel.slikaAnaliza();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}