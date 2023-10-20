import java.math.BigInteger;

public class Enkripcija {
    private BigInteger C; // kriptirana poruka u ascii
    private BigInteger D; // dekriptirana poruka u ascii
    //private BigInteger p; // prosti broj, PRIVATNO, VEĆI!
    //private BigInteger q; // prosti broj, PRIVATNO, MANJI!
    private BigInteger N; // p * q, JAVNO
    private int e; // e i (p-1)*(q-1) - ne djeljivo JAVNO
    public int[] velicineBlokova;
    public int brojPonavljanja;
    BigInteger DESET = new BigInteger("10");

    Enkripcija(BigInteger D,int e,BigInteger N) {
        this.D = D;
        this.e = e;
        this.N = N;
    }

    public BigInteger enkriptiraj() {
        int LENGHT = getBlockLenght(N) - 1; //odnosi se na duljinu bloka
        int LENGHT_D = getBlockLenght(D); //odnosi se na duljinu poruke za enkipciju
        String STRING_D = D.toString();
        String c = "";
        BigInteger C_prijenos = new BigInteger("0");
        boolean proslo = false;
        //BigInteger LENGHT_BIGINTEGER = new BigInteger(""+LENGHT);

        brojPonavljanja = LENGHT_D/LENGHT;

        if(LENGHT_D % LENGHT != 0) {
            brojPonavljanja++;
            proslo = true;
        }
        velicineBlokova = new int[brojPonavljanja];
        for(int i = 0; i < brojPonavljanja; i++) {
            String coolIme = "";
            if(proslo == true && i == brojPonavljanja-1) {
                coolIme = STRING_D.substring(LENGHT*i);
            }
            else {
                coolIme = STRING_D.substring(i*LENGHT, i*LENGHT+LENGHT);
            }
            BigInteger zaCoolIme = new BigInteger(""+coolIme);
            C_prijenos = zaCoolIme.pow(e).mod(N);
            //System.out.println(C_prijenos);
            c = c + C_prijenos.toString();
            //C = D.pow(e).mod(N);
            velicineBlokova[i] = getBlockLenght(C_prijenos);
            System.out.println(velicineBlokova[i]);
        }
        
        C = new BigInteger(""+c);
        return C;
    }
    public String enkriptirajMain() {
        String rezultat = "";
        BigInteger enkriptirano = new BigInteger(""+enkriptiraj());
        rezultat = enkriptirano.toString();
        rezultat = rezultat + '$';
        for(int i = 0; i < brojPonavljanja; i++) {
            rezultat = rezultat + velicineBlokova[i];
            rezultat = rezultat + '$';
        }
        return rezultat;
    }

    public int getBlockLenght(BigInteger broj) {
        String rez = broj.toString();
        new StringBuffer(rez);
        return rez.length();
    }
}