package com.example.myapplication.Supstitucijska;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Random;

public class SupstitucijskaSifra {
    
    private String tekstData;
    private int brojNula;
    ArrayList<Character> simboli = new ArrayList<>(); //default abeceda
    ArrayList<Character> sifrat = new ArrayList<>(); //abeceda sifrirana
    ArrayList<Character> nule = new ArrayList<>(); //random simboli koji se umeću
    ArrayList<Character> simbolZaRijec = new ArrayList<>(); //arraylist simbola za rijeci
    ArrayList<String> rijec = new ArrayList<>(); //arraylist riječi

    public SupstitucijskaSifra(ArrayList<Character> sifrat, ArrayList<Character> nule, int brojNula, ArrayList<Character> simbolZaRijec,
                               ArrayList<String> rijec, String tekstData) { //sifrat = modificirana abeceda, nule = nule, simbolzaRijec = simboli za rijec, rijec rijeci
        
        this.sifrat = sifrat;
        this.nule = nule;
        this.brojNula = brojNula;
        this.simbolZaRijec = simbolZaRijec;
        this.rijec = rijec;
        this.tekstData = tekstData;

        simboli.add('a');
        simboli.add('b');
        simboli.add('c');
        simboli.add('d');
        simboli.add('e');
        simboli.add('f');
        simboli.add('g');
        simboli.add('h');
        simboli.add('i');
        simboli.add('j');
        simboli.add('k');
        simboli.add('l');
        simboli.add('m');
        simboli.add('n');
        simboli.add('o');
        simboli.add('p');
        simboli.add('q');
        simboli.add('r');
        simboli.add('s');
        simboli.add('t');
        simboli.add('u');
        simboli.add('v');
        simboli.add('w');
        simboli.add('x');
        simboli.add('y');
        simboli.add('z');

    }
    
    public boolean provjeraValjanosti() {

        for(int i = 0; i < rijec.size(); i++) {
            rijec.set(i, rijec.get(i).toLowerCase());
        }

        tekstData = tekstData.toLowerCase();

        if(sifrat.size() != simboli.size()) return false;
        if(simbolZaRijec.size() != rijec.size()) return false; 

        for(int i = 0; i < sifrat.size(); i++) {
            for(int j = i + 1; j < sifrat.size(); j++) {
                if(sifrat.get(i) == sifrat.get(j)) {
                   return false;
                }
            }
        }
        int counter = 0;
        for(int i = 0; i < sifrat.size(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(sifrat.get(i) == simboli.get(j)) counter++;
            }
        }
        if(counter != sifrat.size()) return false;

        for(int i = 0; i < nule.size(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(nule.get(i) == simboli.get(j) || nule.get(i).toString() == simboli.get(j).toString().toUpperCase()) {
                    return false;
                }
            }
        }

        for(int i = 0; i < simbolZaRijec.size(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(simbolZaRijec.get(i) == simboli.get(j) || simbolZaRijec.get(i).toString() == simboli.get(j).toString().toUpperCase()) {
                    return false;
                }
            }
        }

        for(int i = 0; i < rijec.size(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(rijec.get(i) == simboli.get(j).toString() || rijec.get(i) == simboli.get(j).toString().toUpperCase()) {
                    return false;
                }
            }
        }
        return true;
    }
    public String kriptiraj() {
        //if(!provjeraValjanosti()) return "ERROR";
        String sifrirano = "";

        sifrirano = kriptirajStadijPrvi(tekstData);
        sifrirano = kriptirajStadijDrugi(sifrirano);
        sifrirano = kriptirajStadijTreci(sifrirano);


        return sifrirano;
    }
    public String dekriptiraj() {
        //if(!provjeraValjanosti()) return "ERROR";
        String desifrirano = "";

        desifrirano = dekriptirajStadijPrvi(tekstData);
        desifrirano = dekriptirajStadijDrugi(desifrirano);
        desifrirano = dekriptirajStadijTreci(desifrirano);

        return desifrirano;
    }

    //enkripcija
    public String kriptirajStadijPrvi(String tekst) {
        String sifrirano = tekst;
        String rijecString = "";
        String simbolString = "";
        int counter = 0;

        for(int i = 0; i < rijec.size(); i++) {

            rijecString = rijec.get(i);
            simbolString = simbolZaRijec.get(i).toString();
            StringBuffer sb = new StringBuffer(sifrirano);

            for(int j = 0; j < sifrirano.length()-rijecString.length()+1; j++) {
                for(int k = 0; k < rijecString.length(); k++) {
                    if(rijecString.charAt(k) == sifrirano.charAt(j + k)) {
                        counter++;
                    }
                }
                if(counter == rijecString.length()) {
                    sifrirano = sb.replace(j, j + rijecString.length(), simbolString).toString();
                    sb = new StringBuffer(sifrirano);
                }
                counter = 0;
            }
            
        }
        return sifrirano;
    }
    public String kriptirajStadijDrugi(String tekst) {
        String sifrirano = "";
        boolean proslo = false;
        for(int i = 0; i < tekst.length(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(tekst.charAt(i) == simboli.get(j)) {
                    sifrirano = sifrirano + sifrat.get(simboli.indexOf(tekst.charAt(i)));
                    proslo = true;
                }
            }
            if(!proslo) {
                sifrirano = sifrirano + tekst.charAt(i);
            }
            proslo = false;
        }
        return sifrirano;
    }

    public String kriptirajStadijTreci(String tekst) {
        String sifrirano = tekst;
        StringBuffer sb = new StringBuffer(tekst);
        int counter = brojNula;

        while(true) {
            if(counter == 0) break;
            Random random = new Random();
            int rBroj = random.nextInt(tekst.length());
            int rBroj2 = random.nextInt(nule.size());
            sb = sb.insert(rBroj, nule.get(rBroj2));
            counter--;
        }

        sifrirano = sb.toString();
        return sifrirano;
    }

    //dekripcija
    public String dekriptirajStadijPrvi(String tekst) {
        String desifrirano = "";
        boolean proslo = false;
        for(int i = 0; i < tekst.length(); i++) {
            for(int j = 0; j < nule.size(); j++) {
                if(nule.get(j) == tekst.charAt(i)) {
                    proslo = true;
                }
            }
            if(!proslo) desifrirano = desifrirano + tekst.charAt(i);
            proslo = false;
        }
        return desifrirano;
    }
    public String dekriptirajStadijDrugi(String tekst) {
        String desifrirano = "";
        boolean proslo = false;
        for(int i = 0; i < tekst.length(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(tekst.charAt(i) == simboli.get(j)) {
                    desifrirano = desifrirano + simboli.get(sifrat.indexOf(tekst.charAt(i)));
                    proslo = true;
                }
            }
            if(!proslo) {
                desifrirano = desifrirano + tekst.charAt(i);
            }
            proslo = false;
        }
        return desifrirano;
    }
    @SuppressLint("SuspiciousIndentation")
    public String dekriptirajStadijTreci(String tekst) {
        String desifrirano = "";
        boolean proslo = false;

        for(int j = 0; j < tekst.length(); j++) {
            for(int i = 0; i < rijec.size(); i++) {
                if(tekst.charAt(j) == simbolZaRijec.get(i)) {
                    desifrirano = desifrirano + rijec.get(i);
                    proslo = true;
                }
            }
            if(!proslo)
            desifrirano = desifrirano + tekst.charAt(j);
            proslo = false;
        }

        System.out.println(desifrirano);
        return desifrirano;
    }


}