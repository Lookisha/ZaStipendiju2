import java.io.FileWriter;
import java.io.IOException;
//import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class ProstiBrojevi extends Thread{
    
    private String nazivDatoteke;
    private BigInteger pocetakk;
    private BigInteger krajj;

    public boolean gotovo;
    public BigInteger brojac = new BigInteger("0");
    Double postotak;

    ProstiBrojevi(String nazivDatoteke, BigInteger pocetak, BigInteger kraj) {
        this.pocetakk = pocetak;
        this.krajj = kraj;
        this.nazivDatoteke = nazivDatoteke;
    }

    public BigInteger getRandomProstBroj() { //bespotrebno
        BigInteger rezultat;
        long random;

        Random radnom = new Random();
        random = radnom.nextLong((long)Math.pow(10, 2));
        System.out.println(random);
        rezultat = BigInteger.probablePrime(100, radnom);

        return rezultat;
    }


    public void getProstInterval() { //pocetak mora biti veci od 3

        BigInteger razlika = new BigInteger(""+krajj.subtract(pocetakk));
        try {
            FileWriter writer = new FileWriter(nazivDatoteke);
            while(true) {
                brojac = brojac.add(BigInteger.ONE);
                if(isBrojProst(pocetakk)) {
                    writer.append(pocetakk.toString());
                    writer.append("\n");
                }
                if(pocetakk.equals(krajj)) {
                    System.out.println(1);
                    break;
                }
                pocetakk = pocetakk.add(BigInteger.ONE);
            }
            writer.close();
            postotak = 100.00;
            brojac = razlika;
        }
        catch (IOException e) {
            System.out.println("Something is wrong ):");
            e.printStackTrace();
        }
    }

    public boolean isBrojProst(BigInteger broj) {
        boolean rezultat = false;
        BigInteger index = new BigInteger("2");
        BigInteger provjera = new BigInteger("1000000");

        while(true) {
            if(broj.equals(BigInteger.ONE) || broj.equals(BigInteger.TWO)) { //maknuti po potrebi
                rezultat = true;
                break;
            }

            if(broj.mod(index).equals(BigInteger.ZERO)) {
                rezultat = false;
                break;
            }
            else if(broj.sqrt().equals(index)) {
                rezultat = true;
                break;
            }
            index = index.add(BigInteger.ONE);
            if(index.mod(provjera).equals(BigInteger.ZERO)) { //maknuti po potrebi
                System.out.println(index);
            }
        }
        return rezultat;
    }
    public void rastaviNaProste(BigInteger N) {
        BigInteger q = new BigInteger("2"); // q < p
        //BigInteger p = new BigInteger("0"); uz pomoć N i q njega sam racunas
        while(true) {
            if(N.mod(q).equals(BigInteger.ZERO)) {
                break;
            }
            q = q.add(BigInteger.ONE);
        }
    }

    @Override
    public void run() {
        if(nazivDatoteke.equals("ovoNikadaNecesPogoditi")) {
            rastaviNaProste(pocetakk);
        }
        else {
            getProstInterval();
        }
    }
}
