import java.math.BigInteger;

public class BazaDesetAnaliza extends Thread implements Konstante {
    
    public void getIntervalMogucihProstih(int poc, int kraj) {
        int broj = 0;
        for(int index = poc; index <= kraj; index++) {
            broj = index*9+7;
            if(isBrojProst(broj)) {
                System.out.print((index+1)+",");
            }
        }

    }
    public void popravi_L() {
        boolean isEverythingOK = false;
        for(int i = 0; i < k.length; i++) {

        }
        if(isEverythingOK) {
            System.out.println("isEverythingOK");
        }

    }

    public boolean isBrojProst(int broj) {
        boolean rezultat = false;
        int index = 2;

        while(true) {
            if(broj == 1 || broj == 2) { //maknuti po potrebi
                rezultat = true;
                break;
            }

            if(broj%index == 0) {
                rezultat = false;
                break;
            }
            else if((int)Math.sqrt(broj) == index ) {
                rezultat = true;
                break;
            }
            index++;
        }
        return rezultat;
    }
}
