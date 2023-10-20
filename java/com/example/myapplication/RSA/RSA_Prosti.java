package com.example.myapplication.RSA;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class RSA_Prosti extends Thread{
    
    private String nazivDatoteke;
    private BigInteger pocetakk;
    private BigInteger krajj;
    public boolean gotovo;

    public BigInteger brojac = new BigInteger("0");
    Double postotak;

    RSA_Prosti(String nazivDatoteke, BigInteger pocetak, BigInteger kraj) {
        this.pocetakk = pocetak;
        this.krajj = kraj;
        this.nazivDatoteke = nazivDatoteke;
    }

    /*public BigInteger getRandomProstBroj() { //bespotrebno
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
                    writer.append(",");
                }
                if(pocetakk.equals(krajj)) {
                    System.out.println(1);
                    break;
                }
                pocetakk = pocetakk.add(BigInteger.ONE);
                if(System.nanoTime()%1000000 == 0) {
                    System.out.println(pocetakk);
                    postotak = (brojac.doubleValue() / razlika.doubleValue()) * 100;
                }
            }
            writer.close();
            postotak = 100.00;
            brojac = razlika;
            //ProstiBrojeviFrame.display1_5.setText("N = "+ brojac +"  |  "+postotak+"%");
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
        BigInteger TWO = new BigInteger("2");

        while(true) {
            if(broj.equals(BigInteger.ONE) || broj.equals(TWO)) { //maknuti po potrebi
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
        BigInteger razlika = new BigInteger(""+N.sqrt());
        double postotak2 = 0.00;
        while(true) {
            if(N.mod(q).equals(BigInteger.ZERO)) {
                break;
            }
            if(N.sqrt().equals(q.add(BigInteger.ONE))) {
                q = BigInteger.ONE;
                break;
            }
            if(System.nanoTime()%100000000 == 0) {
                postotak2 = (q.doubleValue() / razlika.doubleValue()) * 100;
                //BruteForceFrame.display1_5.setText("N = "+ q +"  |  "+postotak2+"%");
            }
            q = q.add(BigInteger.ONE);
        }
        postotak2 = (q.doubleValue() / razlika.doubleValue()) * 100;
        //BruteForceFrame.display1_5.setText("N = "+ q +"  |  "+postotak2+"%");
        //BruteForceFrame.display_p.setText("<p> "+N.divide(q));
        //BruteForceFrame.display_q.setText("<q> "+q);
    }
    public void rastaviNaProsteOptimizacija(BigInteger N) {
        BigInteger p = new BigInteger(""+N.sqrt().subtract(BigInteger.ONE));
        //BigInteger q = new BigInteger("0"); uz pomoć N i p njega sam racunas
        BigInteger razlika = new BigInteger(""+N.subtract(N.sqrt()));
        BigInteger brojac2 = new BigInteger("0");
        double postotak2 = 0.00;
        
        while(true) {
            if(N.mod(p).equals(BigInteger.ZERO)) {
                break;
            }

            if(System.nanoTime()%100000000 == 0) {
                postotak2 = (brojac2.doubleValue() / razlika.doubleValue()) * 100;
                //BruteForceFrame.display1_5.setText("N = "+ brojac2 +"  |  "+postotak2+"%");
            }
            brojac2 = brojac2.add(BigInteger.ONE);
            p = p.add(BigInteger.ONE);
        }
        postotak2 = (brojac2.doubleValue() / razlika.doubleValue()) * 100;
        //BruteForceFrame.display1_5.setText("N = "+ brojac2 +"  |  "+postotak2+"%");
        //BruteForceFrame.display_p.setText("<p> "+p);
        //BruteForceFrame.display_q.setText("<q> "+N.divide(p));
    }

    @Override
    public void run() {
        if(nazivDatoteke.equals("ovoNikadaNecesPogoditi")) {
            rastaviNaProste(pocetakk);
        }
        else if(nazivDatoteke.equals("ovoNikadaNecesPogoditi2")) {
            rastaviNaProsteOptimizacija(pocetakk);
        }
        else {
            getProstInterval();
        }
    }

*/
}